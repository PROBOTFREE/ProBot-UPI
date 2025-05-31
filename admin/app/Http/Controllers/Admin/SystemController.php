<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Artisan;

class SystemController extends Controller
{
    public function systemInfo()
    {
        $laravelVersion = app()->version();
        $timeZone       = config('app.timezone');
        $pageTitle      = 'Application Information';
        return view('admin.system.info', compact('pageTitle', 'laravelVersion', 'timeZone'));
    }

    public function optimize()
    {
        $pageTitle = 'Clear System Cache';
        return view('admin.system.optimize', compact('pageTitle'));
    }

    public function optimizeClear()
    {
        Artisan::call('optimize:clear');
        $notify[] = ['success', 'Cache cleared successfully'];
        return back()->withNotify($notify);
    }

    public function systemServerInfo()
    {
        $currentPHP    = phpversion();
        $pageTitle     = 'Server Information';
        $serverDetails = $_SERVER;
        return view('admin.system.server', compact('pageTitle', 'currentPHP', 'serverDetails'));
    }
}
