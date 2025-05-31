<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\Invest;
use App\Models\NotificationLog;
use App\Models\Transaction;
use App\Models\UserLogin;
use Illuminate\Http\Request;

class ReportController extends Controller
{
    public function transaction(Request $request)
    {
        $pageTitle    = 'Transaction Logs';
        $remarks      = Transaction::distinct('remark')->orderBy('remark')->get('remark');
        $transactions = Transaction::with('user')->orderBy('id', 'desc');
        $transactions = Transaction::searchable(['trx','user:username'])->filter(['trx_type','remark'])->dateFilter()->orderBy('id','desc')->with('user')->paginate(getPaginate());

        return view('admin.reports.transactions', compact('pageTitle', 'transactions', 'remarks'));
    }

    public function loginHistory(Request $request)
    {
        $pageTitle = 'User Login History';
        $loginLogs = UserLogin::orderBy('id','desc')->searchable(['user:username'])->with('user')->paginate(getPaginate());
        return view('admin.reports.logins', compact('pageTitle', 'loginLogs'));
    }

    public function loginIpHistory($ip)
    {
        $pageTitle = 'Login by - ' . $ip;
        $loginLogs = UserLogin::where('user_ip', $ip)->orderBy('id', 'desc')->with('user')->paginate(getPaginate());
        return view('admin.reports.logins', compact('pageTitle', 'loginLogs', 'ip'));
    }

    public function notificationHistory(Request $request)
    {
        $pageTitle = 'Notification History';
        $logs = NotificationLog::orderBy('id','desc')->searchable(['user:username'])->with('user')->paginate(getPaginate());
        return view('admin.reports.notification_history', compact('pageTitle', 'logs'));
    }

    public function emailDetails($id)
    {
        $pageTitle = 'Email Details';
        $email     = NotificationLog::findOrFail($id);
        return view('admin.reports.email_details', compact('pageTitle', 'email'));
    }

    public function investHistory(Request $request)
    {
        $pageTitle = 'Invest History';
        $invests   = Invest::with('plan', 'user');

        if ($request->search) {
            $invests = $invests->where(function ($invest) use ($request) {
                $invest->whereHas('user', function ($user) use ($request) {
                    $user->where('username', 'LIKE', "%$request->search%");
                })->orWhereHas('plan', function ($plan) use ($request) {
                    $plan->where('name', 'LIKE', "%$request->search%");
                });
            });
        }

        if ($request->type == 'lifetime') {
            $invests = $invests->where('period', -1);
        } elseif ($request->type == 'repeat') {
            $invests = $invests->where('period', '>', 0);
        }

        $invests = $invests->filter(['status'])->dateFilter();

        $allInvest         = clone $invests;
        $totalInvestCount  = $allInvest->count();
        $totalInvestAmount = $allInvest->sum('amount');
        $totalPaid         = $allInvest->sum('paid');
        $shouldPay         = $allInvest->where('period', '!=', -1)->sum('should_pay');

        $invests = $invests->orderBy('id', 'desc')->paginate(getPaginate());

        return view('admin.reports.invest_history', compact('pageTitle', 'invests', 'totalInvestCount', 'totalInvestAmount', 'totalPaid', 'shouldPay'));
    }

}
