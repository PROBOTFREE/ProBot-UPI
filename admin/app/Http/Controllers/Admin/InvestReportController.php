<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\Invest;
use App\Models\Transaction;
use Carbon\Carbon;
use Illuminate\Http\Request;

class InvestReportController extends Controller
{
    public function dashboard()
    {
        $pageTitle = 'Investment Statistics';

        $widget['total_invest'] = Transaction::where('remark','invest')->sum('amount');
        $widget['invest_deposit_wallet'] = Transaction::where('wallet_type','deposit_wallet')->where('remark','invest')->sum('amount');
        $widget['invest_interest_wallet'] = Transaction::where('wallet_type','interest_wallet')->where('remark','invest')->sum('amount');

        $widget['profit_to_give'] = Invest::where('status', 1)->where('period', '>', 0)->sum('should_pay');
        $widget['profit_paid']    = Invest::where('status', 1)->where('period', '>', 0)->sum('paid');

        $investByPlans = Invest::where('paid','>',0)->selectRaw("SUM(paid) as amount, plan_id")->with('plan')->groupBy('plan_id')->orderBy('amount', 'desc')->get();
        $totalInvest = $investByPlans->sum('amount');

        $investByPlans = $investByPlans->mapWithKeys(function($invest){
            return [
                $invest->plan->name => (int)$invest->amount
            ];
        });
  
        $recentInvests = Invest::with('plan')->orderBy('id', 'desc')->limit(3)->get();
        $firstInvestYear = Invest::selectRaw("DATE_FORMAT(created_at, '%Y') as date")->first();

        return view('admin.investment.statistics',compact('pageTitle', 'widget', 'investByPlans', 'recentInvests', 'totalInvest', 'firstInvestYear'));
    }

    public function investStatistics(Request $request)
    {
        if ($request->time == 'year') {
            $time = now()->startOfYear();
            $prevTime = now()->startOfYear()->subYear();
        }elseif($request->time == 'month'){
            $time = now()->startOfMonth();
            $prevTime = now()->startOfMonth()->subMonth();
        }else{
            $time = now()->startOfWeek();
            $prevTime = now()->startOfWeek()->subWeek();
        }
        
        $invests = Invest::where('created_at', '>=', $time)->selectRaw("SUM(amount) as amount, DATE_FORMAT(created_at, '%Y-%m-%d') as date")->groupBy('date')->get();
        $totalInvest = $invests->sum('amount');
        
        $invests = $invests->mapWithKeys(function($invest){
            return [
                $invest->date => (int)$invest->amount
            ];
        });

        $prevInvest = Invest::where('created_at', '>=', $prevTime)->where('created_at','<',$time)->sum('amount');
        $investDiff = ($prevInvest ? $totalInvest/$prevInvest*100-100 : 0);
        if($investDiff > 0){
            $upDown = 'up';
        }else{
            $upDown = 'down';
        }
        $investDiff = abs($investDiff);
        return [
            'invests'=>$invests,
            'total_invest'=>$totalInvest,
            'invest_diff'=>round($investDiff,2),
            'up_down'=>$upDown
        ];
    }

    public function investStatisticsByPlan(Request $request)
    {
        if ($request->time == 'year') {
            $time = now()->startOfYear();
        }elseif($request->time == 'month'){
            $time = now()->startOfMonth();
        }elseif($request->time == 'week'){
            $time = now()->startOfWeek();
        }else{
            $time = Carbon::parse('0000-00-00 00:00:00');
        }

        $investChart = Invest::with('plan')->where('created_at','>=',$time)->groupBy('plan_id')->selectRaw("SUM(amount) as investAmount, plan_id")->orderBy('investAmount','desc');
        if ($request->invest_type == 'active') {
            $investChart = $investChart->where('status',1);
        }elseif($request->invest_type == 'closed'){
            $investChart = $investChart->where('status',0);
        }
        
        $investChart = $investChart->get();

        return [
            'invest_data'=>$investChart,
            'total_invest'=>$investChart->sum('investAmount'),
        ];
    }

    public function investInterestStatistics(Request $request)
    {
        if ($request->time == 'year') {
            $time = now()->startOfYear();
        }elseif($request->time == 'month'){
            $time = now()->startOfMonth();
        }elseif($request->time == 'week'){
            $time = now()->startOfWeek();
        }else{
            $time = Carbon::parse('0000-00-00 00:00:00');
        }

        $runningInvests = Invest::where('status',1)->where('created_at','>=',$time)->sum('amount');
        $expiredInvests = Invest::where('status',0)->where('created_at','>=',$time)->sum('amount');
        $interests      = Transaction::where('remark','interest')->where('created_at','>=',$time)->sum('amount');

        return [
            'running_invests'=>showAmount($runningInvests),
            'expired_invests'=>showAmount($expiredInvests),
            'interests'=>showAmount($interests),
        ];
    }

    public function investInterestChart(Request $request)
    {
        $invests = Invest::whereYear('created_at',$request->year)->whereMonth('created_at',$request->month)->selectRaw("SUM(amount) as amount, DATE_FORMAT(created_at, '%d') as date")->groupBy('date')->get();

        $investsDate = $invests->map(function($invest){
            return $invest->date;
        })->toArray();

        $interests = Transaction::whereYear('created_at',$request->year)->whereMonth('created_at',$request->month)->where('remark','interest')->selectRaw("SUM(amount) as amount, DATE_FORMAT(created_at, '%d') as date")->groupBy('date')->get();

        $interestsDate = $interests->map(function($interest){
            return $interest->date;
        })->toArray();

        $dataDates = array_unique(array_merge($investsDate,$interestsDate));
        $investsData = [];
        $interestsData = [];
        foreach ($dataDates as $date) {
            $investsData[] = @$invests->where('date',$date)->first()->amount ?? 0;
            $interestsData[] = @$interests->where('date',$date)->first()->amount ?? 0;
        }

        return [
            'keys'      => $dataDates,
            'invests'   => $investsData,
            'interests' => $interestsData,
        ];
    }
}  
