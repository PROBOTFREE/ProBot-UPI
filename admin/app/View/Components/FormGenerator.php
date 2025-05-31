<?php

namespace App\View\Components;

use Illuminate\View\Component;

class FormGenerator extends Component
{
    /**
     * Create a new component instance.
     *
     * @return void
     */

    public $formClassName;

    public function __construct($formClassName = null)
    {
        $this->formClassName = $formClassName;
    }

    /**
     * Get the view / contents that represent the component.
     *
     * @return \Illuminate\Contracts\View\View|\Closure|string
     */
    public function render()
    {
        return view('components.form-generator');
    }
}
