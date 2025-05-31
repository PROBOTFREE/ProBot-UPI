<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class AdminPasswordReset extends Model
{
    protected $table = "admin_password_resets";
    protected $guarded = ['id'];
    public $timestamps = false;
}
