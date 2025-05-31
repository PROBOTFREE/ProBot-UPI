<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class GeneralSetting extends Model
{
    protected $casts = [
        'mail_config' => 'object',
        'sms_config' => 'object',
        'off_day' => 'object',
        'firebase_config'=>'object',
        'global_shortcodes' => 'object'
    ];

    public function scopeSiteName($query, $pageTitle)
    {
        $pageTitle = empty($pageTitle) ? '' : ' - ' . $pageTitle;
        return $this->site_name . $pageTitle;
    }

    protected static function boot()
    {
        parent::boot();
        static::saved(function(){
            \Cache::forget('GeneralSetting');
        });
    }
}
