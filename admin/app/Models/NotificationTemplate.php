<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class NotificationTemplate extends Model
{
    protected $casts = [
        'shortcodes' => 'object'
    ];

}
