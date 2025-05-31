<?php

namespace App\Notify;

interface Notifiable
{
	public function send();

	public function prevConfiguration();
}