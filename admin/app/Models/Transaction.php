<?php

namespace App\Models;

use App\Traits\ApiQuery;
use App\Traits\Searchable;
use Illuminate\Database\Eloquent\Model;

class Transaction extends Model
{
    use Searchable, ApiQuery;

    protected $guarded = ['id'];

    public function user()
    {
        return $this->belongsTo(User::class);
    }

}
