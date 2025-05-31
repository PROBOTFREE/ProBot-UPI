<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\TimeSetting;
use Illuminate\Http\Request;

class TimeSettingController extends Controller
{
    public function index()
    {
        $pageTitle = "Manage Time Settings";
        $times     = TimeSetting::orderBy('id')->get();
        return view('admin.time_setting.index', compact('pageTitle', 'times'));
    }

    public function store(Request $request)
    {
        $this->validation($request);
        $time = new TimeSetting();
        $this->submitData($time, $request);

        $notify[] = ['success', 'Time schedule added successfully'];
        return back()->withNotify($notify);
    }

    public function update(Request $request, $id)
    {
        $this->validation($request);
        $time = TimeSetting::findOrFail($id);
        $this->submitData($time, $request);

        $notify[] = ['success', 'Time schedule added successfully'];
        return back()->withNotify($notify);
    }

    public function submitData($time, $request)
    {
        $time->name = $request->name;
        $time->time = $request->time;
        $time->save();
    }

    public function validation($request)
    {
        $this->validate($request, [
            'name' => 'required',
            'time' => 'required|numeric|min:0',
        ]);
    }

    public function delete($id)
    {
        $time = TimeSetting::findOrFail($id);
        $time->delete();

        $notify[] = ['success', 'Time deleted successfully'];
        return back()->withNotify($notify);
    }
}
