<?php

namespace App\Http\Middleware;

use Closure;

class AllowRegistration
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        if (gs()->registration == 0) {
            $notify[] = ['error', 'Registration is currently disabled'];
            return back()->withNotify($notify);
        }
        return $next($request);
    }
}
