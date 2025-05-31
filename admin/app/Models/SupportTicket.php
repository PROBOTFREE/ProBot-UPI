<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Casts\Attribute;
use Illuminate\Database\Eloquent\Model;

class SupportTicket extends Model
{
    public function fullname(): Attribute
    {
        return new Attribute(
            get:fn () => $this->name,
        );
    }

    public function username(): Attribute
    {
        return new Attribute(
            get:fn () => $this->email,
        );
    }

    public function statusBadge(): Attribute
    {
        return new Attribute(
            get:fn () => $this->badgeData(),
        );
    }

    public function badgeData(){
        $html = '';
        if($this->status == 0){
            $html = '<span class="badge badge--success">'.trans("Open").'</span>';
        }
        elseif($this->status == 1){
            $html = '<span class="badge badge--primary">'.trans("Answered").'</span>';
        }

        elseif($this->status == 2){
            $html = '<span class="badge badge--warning">'.trans("Customer Reply").'</span>';
        }
        elseif($this->status == 3){
            $html = '<span class="badge badge--dark">'.trans("Closed").'</span>';
        }
        return $html;
    }

    public function user()
    {
        return $this->belongsTo(User::class);
    }

    public function supportMessage(){
        return $this->hasMany(SupportMessage::class);
    }

}
