<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;
use Laramin\Utility\Onumoti;

class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    public $activeTemplate;

    public function __construct()
    {
        $this->activeTemplate = activeTemplate();

        $className = get_called_class();
        Onumoti::mySite($this,$className);
    }
}
