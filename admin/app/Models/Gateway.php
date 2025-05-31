<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Gateway extends Model
{
    protected $casts = [
        'status' => 'boolean',
        'code' => 'string',
        'extra' => 'object',
        'input_form'=> 'object',
        'supported_currencies'=>'object'
    ];

    public function currencies()
    {
        return $this->hasMany(GatewayCurrency::class, 'method_code', 'code');
    }

    public function form()
    {
        return $this->belongsTo(Form::class);
    }

    public function singleCurrency()
    {
        return $this->hasOne(GatewayCurrency::class, 'method_code', 'code')->orderBy('id','desc');
    }

    public function scopeCrypto()
    {
        return $this->crypto == 1 ? 'crypto' : 'fiat';
    }

    public function scopeAutomatic()
    {
        return $this->where('code', '<', 1000);
    }

    public function scopeManual()
    {
        return $this->where('code', '>=', 1000);
    }
}
