<?php

namespace App\Http\Controllers;

use App\Lib\HyipLab;
use App\Models\GeneralSetting;
use App\Models\Invest;
use App\Models\Transaction;
use Carbon\Carbon;

class CronController extends Controller
{
    public function cron()
    {
        $now                = Carbon::now();
        $general            = GeneralSetting::first();
        $general->last_cron = $now;
        $general->save();

        $day    = strtolower(date('D'));
        $offDay = (array) $general->off_day;
        if (array_key_exists($day, $offDay)) {
            echo "Holiday";
            exit;
        }

        $invests = Invest::where('status', 1)->where('next_time', '<=', $now)->orderBy('last_time')->take(100)->get();
        foreach ($invests as $invest) {
            $now  = $now;
            $next = HyipLab::nextWorkingDay($invest->plan->time);
            $user = $invest->user;

            $invest->return_rec_time += 1;
            $invest->paid += $invest->interest;
            $invest->should_pay -= $invest->period > 0 ? $invest->interest : 0;
            $invest->next_time = $next;
            $invest->last_time = $now;

            // Add Return Amount to user's Interest Balance
            $user->interest_wallet += $invest->interest;
            $user->save();

            $trx = getTrx();

            // Create The Transaction for Interest Back
            $transaction               = new Transaction();
            $transaction->user_id      = $user->id;
            $transaction->amount       = $invest->interest;
            $transaction->charge       = 0;
            $transaction->post_balance = $user->interest_wallet;
            $transaction->trx_type     = '+';
            $transaction->trx          = $trx;
            $transaction->remark       = 'interest';
            $transaction->wallet_type  = 'interest_wallet';
            $transaction->details      = showAmount($invest->interest) . ' ' . $general->cur_text . ' interest from ' . @$invest->plan->name;
            $transaction->save();

            // Give Referral Commission if Enabled
            if ($general->invest_commission == 1) {
                $commissionType = 'invest_return_commission';
                HyipLab::levelCommission($user, $invest->interest, $commissionType, $trx, $general);
            }

            // Complete the investment if user get full amount as plan
            if ($invest->return_rec_time >= $invest->period && $invest->period != -1) {
                $invest->status = 0; // Change Status so he do not get any more return

                // Give the capital back if plan says the same
                if ($invest->capital_status == 1) {
                    $capital = $invest->amount;
                    $user->interest_wallet += $capital;
                    $user->save();

                    $transaction               = new Transaction();
                    $transaction->user_id      = $user->id;
                    $transaction->amount       = $capital;
                    $transaction->charge       = 0;
                    $transaction->post_balance = $user->interest_wallet;
                    $transaction->trx_type     = '+';
                    $transaction->trx          = $trx;
                    $transaction->wallet_type  = 'interest_wallet';
                    $transaction->remark       = 'capital_return';
                    $transaction->details      = showAmount($capital) . ' ' . $general->cur_text . ' capital back from ' . @$invest->plan->name;
                    $transaction->save();
                }
            }

            $invest->save();

            notify($user, 'INTEREST', [
                'trx'          => $invest->trx,
                'amount'       => showAmount($invest->interest),
                'plan_name'    => @$invest->plan->name,
                'post_balance' => showAmount($user->interest_wallet),
            ]);
        }
    }
}
