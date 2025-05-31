<?php

namespace App\Lib;

use App\Models\AdminNotification;
use App\Models\Holiday;
use App\Models\Invest;
use App\Models\Referral;
use App\Models\TimeSetting;
use App\Models\Transaction;
use Carbon\Carbon;

class HyipLab
{
    /**
    * Instance of investor user
    *
    * @var object
    */
    private $user;

    /**
    * Plan which is purchasing
    *
    * @var object
    */
    private $plan;

    /**
    * General setting
    *
    * @var object
    */
    private $setting;

    /**
    * Set some properties
    *
    * @param object $user
    * @param object $plan
    * @return void
    */
    public function __construct($user, $plan)
    {
        $this->user = $user;
        $this->plan = $plan;
        $this->setting = gs();
    }

    /**
    * Invest process
    *
    * @param float $amount
    * @param string $wallet
    * @return void
    */
    public function invest($amount, $wallet){
        $plan = $this->plan;
        $user = $this->user;

        $user->$wallet -= $amount;
        $user->save();

        $trx                        = getTrx();
        $transaction                = new Transaction();
        $transaction->user_id       = $user->id;
        $transaction->amount        = $amount;
        $transaction->post_balance  = $user->$wallet;
        $transaction->charge        = 0;
        $transaction->trx_type      = '-';
        $transaction->details       = 'Invested on ' . $plan->name;
        $transaction->trx           = $trx;
        $transaction->wallet_type   = $wallet;
        $transaction->remark        = 'invest';
        $transaction->save();

        $timeName = TimeSetting::where('time', $plan->time)->first();

        //start
        if ($plan->interest_type == 1) {
            $interestAmount = ($amount * $plan->interest) / 100;
        } else {
            $interestAmount = $plan->interest;
        }

        $period = ($plan->lifetime == 1) ? -1 : $plan->repeat_time;

        $next = self::nextWorkingDay($plan->time);

        $shouldPay = -1;
        if ($period > 0) {
            $shouldPay = $interestAmount * $period;
        }

        $invest                 = new Invest();
        $invest->user_id        = $user->id;
        $invest->plan_id        = $plan->id;
        $invest->amount         = $amount;
        $invest->interest       = $interestAmount;
        $invest->period         = $period;
        $invest->time_name      = $timeName->name;
        $invest->hours          = $plan->time;
        $invest->next_time      = $next;
        $invest->should_pay     = $shouldPay;
        $invest->status         = 1;
        $invest->wallet_type    = $wallet;
        $invest->capital_status = $plan->capital_back;
        $invest->trx            = $trx;
        $invest->save();

        if ($this->setting->invest_commission == 1) {
            $commissionType = 'invest_commission';
            self::levelCommission($user, $amount, $commissionType, $trx, $this->setting);
        }

        notify($user, 'INVESTMENT', [
            'trx'          => $invest->trx,
            'amount'       => showAmount($amount),
            'plan_name'    => $plan->name,
            'interest_amount' => showAmount($interestAmount),
            'time' => $plan->lifetime == 1 ? 'lifetime' : $plan->repeat_time.' times',
            'time_name' => $plan->time_name,
            'wallet_type'  => keyToTitle($wallet), 
            'post_balance' => showAmount($user->$wallet),
        ]);


        $adminNotification = new AdminNotification();
        $adminNotification->user_id = $user->id;
        $adminNotification->title = $this->setting->cur_sym.showAmount($amount).' invested to '.$plan->name;
        $adminNotification->click_url = '#';
        $adminNotification->save();
    }

    /**
    * Get the next working day of the system
    *
    * @param integer $hours
    * @return string
    */
    public static function nextWorkingDay($hours)
    {
        $now = now();
        $setting = gs();
        while(0==0){
            $nextPossible = Carbon::parse($now)->addHours($hours)->toDateTimeString();

            if(!self::isHoliDay($nextPossible,$setting)){
                $next = $nextPossible;
                break;
            }
            $now = $now->addDay();
        }
        return $next;
    }


    /**
    * Check the date is holiday or not
    *
    * @param string $date
    * @param object $setting
    * @return string
    */
    public static function isHoliDay($date,$setting){
        $isHoliday = true;
        $dayName = strtolower(date('D',strtotime($date)));
        $holiday = Holiday::where('date',date('Y-m-d',strtotime($date)))->count();
        $offDay = (array)$setting->off_day;

        if(!array_key_exists($dayName, $offDay)){
            if($holiday == 0){
                $isHoliday = false;
            }
        }

        return $isHoliday;

    }

    /**
    * Give referral commission
    *
    * @param object $user
    * @param float $amount
    * @param string $commissionType
    * @param string $trx
    * @param object $setting
    * @return void
    */
    public static function levelCommission($user, $amount, $commissionType, $trx, $setting){
        $meUser = $user;
        $i = 1;
        $level = Referral::where('commission_type',$commissionType)->count();
        $transactions = [];
        while ($i <= $level) {
            $me = $meUser;
            $refer = $me->referrer;
            if ($refer == "") {
                break;
            }

            $commission = Referral::where('commission_type',$commissionType)->where('level', $i)->first();
            if (!$commission) {
                break;
            }

            $com = ($amount * $commission->percent) / 100;
            $refer->interest_wallet += $com;
            $refer->save();

            $transactions[] = [
                'user_id' => $refer->id,
                'amount' => $com,
                'post_balance' => $refer->interest_wallet,
                'charge' => 0,
                'trx_type' => '+',
                'details' => 'level '.$i.' Referral Commission From ' . $user->username,
                'trx' => $trx,
                'wallet_type' =>  'interest_wallet',
                'remark'=>'referral_commission',
                'created_at'=>now()
            ];

            if($commissionType == 'deposit_commission'){
                $comType = 'Deposit';
            }elseif($commissionType == 'interest_commission'){
                $comType = 'Interest';
            }else{
                $comType = 'Invest';
            }

            notify($refer, 'REFERRAL_COMMISSION', [
                'amount' => showAmount($com),
                'post_balance' => showAmount($refer->interest_wallet),
                'trx' => $trx,
                'level' => ordinal($i),
                'type' => $comType
            ]);

            $meUser = $refer;
            $i++;
        }

        if (!empty($transactions)) {
            Transaction::insert($transactions);
        }
    }
}
