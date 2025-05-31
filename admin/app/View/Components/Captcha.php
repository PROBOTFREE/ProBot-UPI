<?php

namespace App\View\Components;

use Illuminate\View\Component;

class Captcha extends Component
{
    /**
     * Create a new component instance.
     *
     * @return void
     */

    public $path;

    public function __construct($path = null)
    {
        $this->path = $path;
    }

    /**
     * Get the view / contents that represent the component.
     *
     * @return \Illuminate\Contracts\View\View|\Closure|string
     */
    public function render()
    {
        if ($this->path) {
            return view($this->path.'.captcha');
        }
        return view('partials.captcha');
    }
}
