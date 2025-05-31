<?php

namespace App\Models;

use App\Traits\ApiQuery;
use App\Traits\Searchable;
use Illuminate\Database\Eloquent\Model;

class Invest extends Model
{
    use Searchable, ApiQuery;

    protected $guarded = ['id'];

    public function plan()
    {
        return $this->hasOne(Plan::class, 'id', 'plan_id')->withDefault();
    }

    public function user()
    {
        return $this->hasOne(User::class, 'id', 'user_id')->withDefault();
    }

    public function scopeLastSevenDays()
    {
        return $this->where('created_at', '>=', now()->subDays(7));
    }

    public function scopeThisMonth()
    {
        return $this->where('created_at', '>=', now()->startOfMonth());
    }

    public function scopeThisYear()
    {
        return $this->where('created_at', '>=', now()->startOfYear());
    }
}
