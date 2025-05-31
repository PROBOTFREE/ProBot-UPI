<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\PromotionTool;
use App\Rules\FileTypeValidate;
use Illuminate\Http\Request;

class PromotionalToolController extends Controller
{
    public function index()
    {
        $tools     = PromotionTool::orderBy('id', 'desc')->paginate(getPaginate());
        $pageTitle = "Promotional Tools";
        return view('admin.promotion.tools', compact('pageTitle', 'tools'));
    }

    public function store(Request $request)
    {
        $this->validation($request);
        $promotion = new PromotionTool();
        $this->saveData($promotion, $request);
        $notify[] = ['success', 'Promotional banner added successfully'];
        return redirect()->back()->withNotify($notify);
    }

    public function update(Request $request, $id)
    {
        $this->validation($request);
        $promotion = PromotionTool::findOrFail($id);
        $this->saveData($promotion, $request);
        $notify[] = ['success', 'Promotional banner updated successfully'];
        return redirect()->back()->withNotify($notify);
    }

    public function remove($id)
    {
        $promotion = PromotionTool::findOrFail($id);
        $promotion->delete();
        fileManager()->removeFile(getFilePath('promotions') . '/' . $promotion->banner);
        $notify[] = ['success', 'Banner deleted successfully'];
        return redirect()->back()->withNotify($notify);
    }

    private function saveData($promotion, $request)
    {
        $image = $promotion->banner;
        if ($request->hasFile('image_input')) {
            try {
                $image = fileUploader($request->image_input, getFilePath('promotions'), null, $promotion->image);
            } catch (\Exception $exp) {
                $notify[] = ['error', 'Could not upload the Image.'];
                return back()->withNotify($notify);
            }
        }

        $promotion->name   = $request->name;
        $promotion->banner = $image;
        $promotion->save();
    }

    private function validation($request)
    {
        $request->validate([
            'name'        => 'required|string|max:100',
            'image_input' => ['nullable', 'image', new FileTypeValidate(['jpeg', 'jpg', 'png', 'gif'])],
        ]);
    }
}
