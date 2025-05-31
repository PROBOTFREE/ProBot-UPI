<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Frontend;
use App\Models\GeneralSetting;
use App\Models\Language;
use Illuminate\Http\Request;

class FrontendController extends Controller
{
    public function logoFavicon()
    {
        $data = [
            'logo'    => getFilePath('logoIcon') . '/logo.png',
            'favicon' => getFilePath('logoIcon') . '/favicon.png',
        ];
        return getResponse('logo_favicon', 'success', 'Logo & Favicon', $data);
    }

    public function language($code)
    {
        $language = Language::where('code', $code)->first();

        if (!$language) {
            return getResponse('not_found', 'error', ['Language not found']);
        }

        $languages = Language::get();

        $path        = base_path() . "/resources/lang/$code.json";
        $fileContent = file_get_contents($path);

        $data = [
            'languages' => $languages,
            'file'      => $fileContent,
        ];

        return getResponse('language', 'success', 'Language Details', $data);
    }

    public function generalSetting()
    {
        $general = GeneralSetting::first();
        return getResponse('general_setting', 'success', 'General setting data', ['general_setting' => $general]);
    }

    public function policy(Request $request)
    {
        $policy = Frontend::where('template_name', $request->template)->where('data_keys', 'policy_pages.element')->get();
        return getResponse('policy_page', 'success', 'Policy & Terms and condition page', ['policy' => $policy]);
    }
    
    public function faq(Request $request)
    {
        $faqs = Frontend::where('template_name', $request->template)->where('data_keys', 'faq.element')->get();
        return getResponse('faq', 'success', 'Faq List', ['faqs' => $faqs]);
    }

}
