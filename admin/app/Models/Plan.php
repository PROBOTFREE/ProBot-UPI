<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Plan extends Model
{
    public function invests()
    {
        return $this->hasMany(Invest::class);
    }
}
