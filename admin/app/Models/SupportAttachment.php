<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class SupportAttachment extends Model
{
    public function supportMessage()
    {
        return $this->belongsTo(SupportMessage::class,'support_message_id');
    }
}
