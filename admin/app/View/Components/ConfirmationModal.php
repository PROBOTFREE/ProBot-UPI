<?php

namespace App\View\Components;

use Illuminate\View\Component;

class ConfirmationModal extends Component
{
    public $closeBtn;
    public $submitBtn;
    
    
    /**
     * Create a new component instance.
     *
     * @return void
     */
    public function __construct($closeBtn = null, $submitBtn = null)
    {
        $this->closeBtn = $closeBtn;
        $this->submitBtn = $submitBtn;
    }

    /**
     * Get the view / contents that represent the component.
     *
     * @return \Illuminate\Contracts\View\View|\Closure|string
     */
    public function render()
    {
        return view('components.confirmation-modal');
    }
}
