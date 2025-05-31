<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\Gateway;
use App\Models\GatewayCurrency;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class AutomaticGatewayController extends Controller
{
    public function index()
    {
        $pageTitle = 'Automatic Gateways';
        $gateways  = Gateway::automatic()->with('currencies')->get();
        return view('admin.gateways.automatic.list', compact('pageTitle', 'gateways'));
    }

    public function edit($alias)
    {
        $gateway   = Gateway::automatic()->with('currencies', 'currencies.method')->where('alias', $alias)->firstOrFail();
        $pageTitle = 'Update Gateway';

        $supportedCurrencies = collect($gateway->supported_currencies)->except($gateway->currencies->pluck('currency'));
        $parameters          = collect(json_decode($gateway->gateway_parameters));
        $globalParameters    = null;
        $hasCurrencies       = false;
        $currencyIndex       = 1;

        if ($gateway->currencies->count()) {
            $globalParameters = json_decode($gateway->currencies->first()->gateway_parameter);
            $hasCurrencies    = true;
        }

        return view('admin.gateways.automatic.edit', compact('pageTitle', 'gateway', 'supportedCurrencies', 'parameters', 'hasCurrencies', 'currencyIndex', 'globalParameters'));
    }

    public function update(Request $request, $code)
    {
        $gateway = Gateway::where('code', $code)->firstOrFail();
        $this->gatewayValidator($request)->validate();
        $this->gatewayCurrencyValidator($request, $gateway)->validate();

        $parameters = collect(json_decode($gateway->gateway_parameters));

        foreach ($parameters->where('global', true) as $key => $pram) {
            $parameters[$key]->value = $request->global[$key];
        }

        $gateway->alias              = $request->alias;
        $gateway->gateway_parameters = json_encode($parameters);
        $gateway->save();

        if ($request->has('currency')) {

            $gateway->currencies()->delete();

            foreach ($request->currency as $key => $currency) {
                $currencyIdentifier = $this->currencyIdentifier($currency['name'], $gateway->name . ' ' . $currency['currency']);

                $param = [];
                foreach ($parameters->where('global', true) as $pkey => $pram) {
                    $param[$pkey] = $pram->value;
                }

                foreach ($parameters->where('global', false) as $param_key => $param_value) {
                    $param[$param_key] = $currency['param'][$param_key];
                }

                $gatewayCurrency                    = new GatewayCurrency();
                $gatewayCurrency->name              = $currency['name'];
                $gatewayCurrency->gateway_alias     = $gateway->alias;
                $gatewayCurrency->currency          = $currency['currency'];
                $gatewayCurrency->min_amount        = $currency['min_amount'];
                $gatewayCurrency->max_amount        = $currency['max_amount'];
                $gatewayCurrency->fixed_charge      = $currency['fixed_charge'];
                $gatewayCurrency->percent_charge    = $currency['percent_charge'];
                $gatewayCurrency->rate              = $currency['rate'];
                $gatewayCurrency->symbol            = $currency['symbol'];
                $gatewayCurrency->method_code       = $code;
                $gatewayCurrency->gateway_parameter = json_encode($param);
                $gatewayCurrency->save();
            }
        }

        $notify[] = ['success', $gateway->name . ' updated successfully'];
        return to_route('admin.gateway.automatic.edit', $gateway->alias)->withNotify($notify);
    }

    public function remove($id)
    {
        $gatewayCurrency = GatewayCurrency::find($id);
        $gatewayCurrency->delete();
        $notify[] = ['success', 'Gateway currency removed successfully'];
        return back()->withNotify($notify);
    }

    public function activate($code)
    {
        $gateway         = Gateway::where('code', $code)->firstOrFail();
        $gateway->status = 1;
        $gateway->save();
        $notify[] = ['success', $gateway->name . ' enabled successfully'];
        return back()->withNotify($notify);
    }

    public function deactivate($code)
    {
        $gateway         = Gateway::where('code', $code)->firstOrFail();
        $gateway->status = 0;
        $gateway->save();
        $notify[] = ['success', $gateway->name . ' disabled successfully'];
        return back()->withNotify($notify);
    }

    public function gatewayValidator(Request $request)
    {
        $validationRule = [
            'alias' => 'required',
        ];
        $validator = Validator::make($request->all(), $validationRule);
        return $validator;
    }

    public function gatewayCurrencyValidator(Request $request, Gateway $gateway)
    {
        $customAttributes = [];
        $validationRule   = [];

        $paramList           = collect(json_decode($gateway->gateway_parameters));
        $supportedCurrencies = collect($gateway->supported_currencies)->flip()->implode(',');

        foreach ($paramList->where('global', true) as $key => $pram) {
            $validationRule['global.' . $key]   = 'required';
            $customAttributes['global.' . $key] = keyToTitle($key);
        }

        if ($request->has('currency')) {
            foreach ($request->currency as $key => $currency) {
                $validationRule['currency.' . $key . '.currency'] = 'required|string|in:' . $supportedCurrencies;
                $validationRule['currency.' . $key . '.symbol']   = 'required|max:3|string';

                $validationRule['currency.' . $key . '.name']           = 'required';
                $validationRule['currency.' . $key . '.min_amount']     = 'required|numeric|gt:0|lte:currency.' . $key . '.max_amount';
                $validationRule['currency.' . $key . '.max_amount']     = 'required|numeric|gt:0|gte:currency.' . $key . '.min_amount';
                $validationRule['currency.' . $key . '.fixed_charge']   = 'required|numeric|gte:0';
                $validationRule['currency.' . $key . '.percent_charge'] = 'required|numeric|gte:0|max:100';
                $validationRule['currency.' . $key . '.rate']           = 'required|numeric|gt:0';

                $supportedCurrencies = explode(',', $supportedCurrencies);

                $supportedCurrencies = collect(removeElement($supportedCurrencies, $currency['currency']))->implode(',');

                $currencyIdentifier = $this->currencyIdentifier($currency['name'], $gateway->name . ' ' . $currency['currency']);

                $customAttributes['currency.' . $key . '.name']           = $currencyIdentifier . ' name';
                $customAttributes['currency.' . $key . '.min_amount']     = $currencyIdentifier . ' ' . keyToTitle('min_amount');
                $customAttributes['currency.' . $key . '.max_amount']     = $currencyIdentifier . ' ' . keyToTitle('max_amount');
                $customAttributes['currency.' . $key . '.fixed_charge']   = $currencyIdentifier . ' ' . keyToTitle('fixed_charge');
                $customAttributes['currency.' . $key . '.percent_charge'] = $currencyIdentifier . ' ' . keyToTitle('percent_charge');
                $customAttributes['currency.' . $key . '.rate']           = $currencyIdentifier . ' ' . keyToTitle('rate');
                $customAttributes['currency.' . $key . '.currency']       = $currencyIdentifier . ' ' . keyToTitle('currency');
                $customAttributes['currency.' . $key . '.symbol']         = $currencyIdentifier . ' ' . keyToTitle('symbol');

                foreach ($paramList->where('global', false) as $param_key => $param_value) {
                    $validationRule['currency.' . $key . '.param.' . $param_key]   = 'required';
                    $customAttributes['currency.' . $key . '.param.' . $param_key] = $currencyIdentifier . ' ' . keyToTitle($param_value->title);
                }
            }
        }

        $validator = Validator::make($request->all(), $validationRule, $customAttributes);
        return $validator;
    }

    private function currencyIdentifier($name, $default = '')
    {
        return $name ?? $default;
    }

}
