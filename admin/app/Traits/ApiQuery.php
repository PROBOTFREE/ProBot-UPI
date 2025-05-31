<?php

namespace App\Traits;

trait ApiQuery
{
    public function scopeApiQuery($query)
    {
        $request = request();
        if ($request->take) {
            return $query->limit($request->take)->get();
        }
        if ($request->order_by) {
            $query->orderBy('id', $request->order_by);
        } else {
            $query->orderBy('id', 'desc');
        }
        if ($request->calc) {
            $calc = explode(':', $request->calc);
            if ($calc[0] == 'sum') {
                $calculation = $query->sum($calc[1]);
            } else {
                $calculation = $query->count();
            }
            return $calculation;
        }
        if ($request->pagination) {
            return $query->paginate(getPaginate($request->pagination));
        }
        return $query->paginate(getPaginate());
    }
}
