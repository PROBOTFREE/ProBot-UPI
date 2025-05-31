<?php

namespace App\Models;

use App\Traits\Searchable;
use Illuminate\Database\Eloquent\Casts\Attribute;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Laravel\Sanctum\HasApiTokens;

class User extends Authenticatable
{
    use HasApiTokens, Searchable;

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token','ver_code',
    ];

    /**
     * The attributes that should be cast to native types.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
        'address' => 'object',
        'kyc_data' => 'object',
        'ver_code_send_at' => 'datetime'
    ];


    public function loginLogs()
    {
        return $this->hasMany(UserLogin::class);
    }

    public function transactions()
    {
        return $this->hasMany(Transaction::class)->orderBy('id','desc');
    }

    public function deposits()
    {
        return $this->hasMany(Deposit::class)->where('status','!=',0);
    }

    public function withdrawals()
    {
        return $this->hasMany(Withdrawal::class)->where('status','!=',0);
    }

    public function referrer()
    {
        return $this->belongsTo(User::class,'ref_by');
    }

    public function referrals()
    {
        return $this->hasMany(User::class,'ref_by');
    }

    public function allReferrals(){
        return $this->referrals()->with('referrer');
    }

    public function invests()
    {
        return $this->hasMany(Invest::class)->orderBy('id','desc');
    }

    public function fullname(): Attribute
    {
        return new Attribute(
            get: fn () => $this->firstname . ' ' . $this->lastname,
        );
    }

    // SCOPES
    public function scopeActive()
    {
        return $this->where('status', 1)->where('ev', '1')->where('sv', 1);
    }

    public function scopeBanned()
    {
        return $this->where('status', 0);
    }

    public function scopeEmailUnverified()
    {
        return $this->where('ev', 0);
    }

    public function scopeMobileUnverified()
    {
        return $this->where('sv', 0);
    }

    public function scopeKycUnverified()
    {
        return $this->where('kv', 0);
    }

    public function scopeKycPending()
    {
        return $this->where('kv', 2);
    }

    public function scopeEmailVerified()
    {
        return $this->where('ev', 1);
    }

    public function scopeMobileVerified()
    {
        return $this->where('sv', 1);
    }

    public function scopeWithBalance()
    {
        return $this->where(function($userWallet){
            $userWallet->where('deposit_wallet', '>' , 0)->orWhere('interest_wallet', '>', 0);
        });
    }

    public function deviceTokens(){
        return $this->hasMany(DeviceToken::class);
    }

}
