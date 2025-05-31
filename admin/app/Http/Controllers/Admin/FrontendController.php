<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Lib\CurlRequest;
use App\Lib\FileManager;
use App\Models\Frontend;
use App\Models\GeneralSetting;
use App\Rules\FileTypeValidate;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use Laramin\Utility\VugiChugi;

class FrontendController extends Controller
{

    public function templates()
    {
        $pageTitle = 'Templates';
        $temPaths  = array_filter(glob('core/resources/views/templates/*'), 'is_dir');
        foreach ($temPaths as $key => $temp) {
            $arr                      = explode('/', $temp);
            $tempname                 = end($arr);
            $templates[$key]['name']  = $tempname;
            $templates[$key]['image'] = asset($temp) . '/preview.jpg';
        }
        $extra_templates = json_decode(getTemplates(), true);
        return view('admin.frontend.templates', compact('pageTitle', 'templates', 'extra_templates'));

    }

    public function templatesActive(Request $request)
    {
        $general = GeneralSetting::first();
        $general->active_template = $request->name;
        $general->save();
        $notify[] = ['success', strtoupper($request->name) . ' template activated successfully'];
        return back()->withNotify($notify);
    }

    public function templateUpload(Request $request)
    {
        //Validation
        $request->validate([
            'template_purchase_code' => 'required',
            'envato_username'        => 'required',
            'email'                  => 'required|email',
            'file'                   => ['required', new FileTypeValidate(['zip'])],
        ]);

        if(!extension_loaded('zip')){
            $notify[]=['error','zip Extension is required to install the template'];
            return back()->withNotify($notify);
        }

        $location = 'core/temp';

        //Upload the zip file
        try {
            $fileName = fileUploader($request->file, $location);
        } catch (\Exception $e) {
            $notify[] = ['error', $e->getMessage()];
            return back()->withNotify($notify);
        }

        $rand    = Str::random(10);
        $dir     = base_path('temp/' . $rand);
        $extract = $this->extractZip(base_path('temp/' . $fileName), $dir);

        //get config file
        if (!file_exists($dir . '/config.json')) {
            $this->removeDir($dir);
            $notify[] = ['error', 'Config file not found'];
            return back()->withNotify($notify);
        }

        $getConfig = file_get_contents($dir . '/config.json');
        $config    = json_decode($getConfig);

        $temPaths = array_filter(glob('core/resources/views/templates/*'), 'is_dir');

        //Remove Zip file
        $this->removeFile($location . '/' . $fileName);

        if ($extract == false) {
            $this->removeDir($dir);
            $notify[] = ['error', 'Something went wrong to extract'];
            return back()->withNotify($notify);
        }

        foreach ($temPaths as $temp) {
            $arr      = explode('/', $temp);
            $tempname = end($arr);
            if ($tempname == $config->name) {
                $this->removeDir($dir);
                $notify[] = ['error', 'Template already exists'];
                return back()->withNotify($notify);
            }
        }

        if (!\Hash::check(systemDetails()['h_verifier'], $config->hash)) {
            $this->removeDir($dir);
            $notify[] = ['error', 'Template hash is invalid'];
            return back()->withNotify($notify);
        }

        $param['code']    = $request->template_purchase_code;
        $param['url']     = env("APP_URL");
        $param['user']    = $request->envato_username;
        $param['email']   = $request->email;
        $param['product'] = $config->name;
        $reqRoute         = VugiChugi::lcLabSbm();
        $response         = CurlRequest::curlPostContent($reqRoute, $param);
        $response         = json_decode($response);

        if ($response->error == 'error') {
            $this->removeDir($dir);
            $notify[] = ['error', $response->message];
            return back()->withNotify($notify);
        }

        $mainFile = $dir . '/Files/Files.zip';
        if (!file_exists($mainFile)) {
            $this->removeDir($dir);
            $notify[] = ['error', 'Main file not found'];
            return back()->withNotify($notify);
        }

        //move file
        $extract = $this->extractZip(base_path('temp/' . $rand . '/Files/Files.zip'), base_path('../'));
        if ($extract == false) {
            $notify[] = ['error', 'Something went wrong to extract'];
            return back()->withNotify($notify);
        }

        //Execute database
        if (file_exists($dir . '/database.sql')) {
            $sql = file_get_contents($dir . '/database.sql');
            DB::unprepared($sql);
        }

        $this->removeDir($dir);

        $notify[] = ['success', 'Template uploaded successfully'];
        return back()->withNotify($notify);
    }

    protected function extractZip($file, $extractTo)
    {
        $zip = new \ZipArchive;
        $res = $zip->open($file);
        if ($res != true) {
            return false;
        }
        $res = $zip->extractTo($extractTo);
        $zip->close();
        return true;
    }

    protected function removeFile($path)
    {
        $fileManager = new FileManager();
        $fileManager->removeFile($path);
    }

    protected function removeDir($location)
    {
        $fileManager = new FileManager();
        $fileManager->removeDirectory($location);
    }

    public function seoEdit()
    {
        $pageTitle = 'SEO Configuration';
        $seo       = Frontend::where('data_keys', 'seo.data')->first();
        if (!$seo) {
            $data_values = '{"keywords":[],"description":"","social_title":"","social_description":"","image":null}';
            $data_values = json_decode($data_values, true);

            $frontend              = new Frontend();
            $frontend->data_keys   = 'seo.data';
            $frontend->data_values = $data_values;
            $frontend->save();
        }
        return view('admin.frontend.seo', compact('pageTitle', 'seo'));
    }

    public function frontendSections($key)
    {
        $section = @getPageSections()->$key;
        if (!$section) {
            return abort(404);
        }

        $general = gs();

        $temPaths = array_filter(glob('core/resources/views/templates/*'), 'is_dir');
        $temPaths = array_diff($temPaths, ["core/resources/views/templates/$general->active_template"]);

        $templates = [];
        foreach ($temPaths as $tempKey => $temp) {
            $arr      = explode('/', $temp);
            $tempname = end($arr);
            $tempJson = json_decode(json_encode(getPageSections(false, "templates/$tempname/")), true);
            if (array_key_exists($key, $tempJson)) {
                $templates[$tempKey]['name'] = $tempname;
            }

        }

        $content   = Frontend::where('data_keys', $key . '.content')->where('template_name', $general->active_template)->orderBy('id', 'desc')->first();
        $elements  = Frontend::where('data_keys', $key . '.element')->where('template_name', $general->active_template)->orderBy('id')->orderBy('id', 'desc')->get();
        $pageTitle = $section->name;
        return view('admin.frontend.index', compact('section', 'content', 'elements', 'key', 'pageTitle', 'templates'));
    }

    public function frontendContent(Request $request, $key)
    {
        $purifier  = new \HTMLPurifier();
        $valInputs = $request->except('_token', 'image_input', 'key', 'status', 'type', 'id');
        foreach ($valInputs as $keyName => $input) {
            if (gettype($input) == 'array') {
                $inputContentValue[$keyName] = $input;
                continue;
            }
            $inputContentValue[$keyName] = $purifier->purify($input);
        }
        $type = $request->type;
        if (!$type) {
            abort(404);
        }
        $imgJson            = @getPageSections()->$key->$type->images;
        $validation_rule    = [];
        $validation_message = [];
        foreach ($request->except('_token', 'video') as $input_field => $val) {
            if ($input_field == 'has_image' && $imgJson) {
                foreach ($imgJson as $imgValKey => $imgJsonVal) {
                    $validation_rule['image_input.' . $imgValKey]               = ['nullable', 'image', new FileTypeValidate(['jpg', 'jpeg', 'png'])];
                    $validation_message['image_input.' . $imgValKey . '.image'] = keyToTitle($imgValKey) . ' must be an image';
                    $validation_message['image_input.' . $imgValKey . '.mimes'] = keyToTitle($imgValKey) . ' file type not supported';
                }
                continue;
            } elseif ($input_field == 'seo_image') {
                $validation_rule['image_input'] = ['nullable', 'image', new FileTypeValidate(['jpeg', 'jpg', 'png'])];
                continue;
            }
            $validation_rule[$input_field] = 'required';
        }
        $request->validate($validation_rule, $validation_message, ['image_input' => 'image']);
        if ($request->id) {
            $content = Frontend::findOrFail($request->id);
        } else {
            $content = Frontend::where('template_name', gs()->active_template)->where('data_keys', $key . '.' . $request->type)->first();
            if (!$content || $request->type == 'element') {
                $content            = new Frontend();
                $content->data_keys = $key . '.' . $request->type;
                $content->save();
            }
        }
        if ($type == 'data') {
            $inputContentValue['image'] = @$content->data_values->image;
            if ($request->hasFile('image_input')) {
                try {
                    $inputContentValue['image'] = fileUploader($request->image_input, getFilePath('seo'), getFileSize('seo'), @$content->data_values->image);
                } catch (\Exception $exp) {
                    $notify[] = ['error', 'Couldn\'t upload the image'];
                    return back()->withNotify($notify);
                }
            }
        } else {
            if ($imgJson) {
                foreach ($imgJson as $imgKey => $imgValue) {
                    $imgData = @$request->image_input[$imgKey];
                    if (is_file($imgData)) {
                        try {
                            $inputContentValue[$imgKey] = $this->storeImage($imgJson, $type, $key, $imgData, $imgKey, @$content->data_values->$imgKey);
                        } catch (\Exception $exp) {
                            $notify[] = ['error', 'Couldn\'t upload the image'];
                            return back()->withNotify($notify);
                        }
                    } else if (isset($content->data_values->$imgKey)) {
                        $inputContentValue[$imgKey] = $content->data_values->$imgKey;
                    }
                }
            }
        }
        $content->data_values = $inputContentValue;
        if ($content->data_keys != 'seo.data') {
            $content->template_name = gs()->active_template;
        }
        $content->save();
        $notify[] = ['success', 'Content updated successfully'];
        return back()->withNotify($notify);
    }

    public function frontendElement($key, $id = null)
    {
        $section = @getPageSections()->$key;
        if (!$section) {
            return abort(404);
        }

        unset($section->element->modal);
        $pageTitle = $section->name . ' Items';
        if ($id) {
            $data = Frontend::findOrFail($id);
            return view('admin.frontend.element', compact('section', 'key', 'pageTitle', 'data'));
        }
        return view('admin.frontend.element', compact('section', 'key', 'pageTitle'));
    }

    protected function storeImage($imgJson, $type, $key, $image, $imgKey, $old_image = null)
    {
        $path = 'assets/images/frontend/' . $key;
        if ($type == 'element' || $type == 'content') {
            $size = @$imgJson
                ->$imgKey->size;
            $thumb = @$imgJson
                ->$imgKey->thumb;
        } else {
            $path  = getFilePath($key);
            $size  = getFileSize($key);
            $thumb = @fileManager()->$key()->thumb;
        }
        return fileUploader($image, $path, $size, $old_image, $thumb);
    }

    public function remove($id)
    {
        $frontend = Frontend::findOrFail($id);
        $key      = explode('.', @$frontend->data_keys)[0];
        $type     = explode('.', @$frontend->data_keys)[1];
        if (@$type == 'element' || @$type == 'content') {
            $path    = 'assets/images/frontend/' . $key;
            $imgJson = @getPageSections()->$key->$type->images;
            if ($imgJson) {
                foreach ($imgJson as $imgKey => $imgValue) {
                    fileManager()->removeFile($path . '/' . @$frontend->data_values->$imgKey);
                    fileManager()->removeFile($path . '/thumb_' . @$frontend->data_values->$imgKey);
                }
            }
        }
        $frontend->delete();
        $notify[] = ['success', 'Content removed successfully'];
        return back()->withNotify($notify);
    }

    public function importContent(Request $request, $key)
    {

        $temPaths = array_filter(glob('core/resources/views/templates/*'), 'is_dir');
        foreach ($temPaths as $temp) {
            $arr         = explode('/', $temp);
            $tempname    = end($arr);
            $templates[] = $tempname;
        }

        $request->validate([
            'template_name' => 'required|in:' . implode(',', $templates),
        ]);

        $general = gs();

        $fromTemp = $request->template_name;
        $toTemp   = $general->active_template;

        $fromTempJson = json_decode(json_encode(getPageSections(false, "templates/$fromTemp/")), true);
        $toTempJson   = json_decode(json_encode(getPageSections()), true)[$key];

        if (!array_key_exists($key, $fromTempJson)) {
            $notify[] = ['error', 'Key doesn\'t exists'];
            return back()->withNotify($notify);
        }

        $dataContent = Frontend::where('data_keys', $key . '.content')->where('template_name', $fromTemp)->first();
        if ($dataContent) {
            $toContentData = [];
            if (@$toTempJson['content']) {
                foreach ($toTempJson['content'] as $toContentKey => $toContentValue) {

                    if ($toContentKey == 'images') {
                        foreach ($toContentValue as $imageKey => $imageValue) {
                            $toContentData[$imageKey] = '';
                        }
                    } else {
                        $toContentData[$toContentKey] = @$dataContent->data_values->$toContentKey;
                    }
                }

                $toFrontendContent = Frontend::where('template_name', $toTemp)->where('data_keys', $key . '.content')->first();
                if (!$toFrontendContent) {
                    $toFrontendContent = new Frontend();
                }
                $toFrontendContent->data_keys     = $key . '.content';
                $toFrontendContent->data_values   = $toContentData;
                $toFrontendContent->template_name = $toTemp;
                $toFrontendContent->save();
            }
        }

        if (@$toTempJson['element']) {
            $dataElement = Frontend::where('data_keys', $key . '.element')->where('template_name', $fromTemp)->get();
            Frontend::where('template_name', $toTemp)->where('data_keys', $key . '.element')->delete();

            foreach ($dataElement as $dataEl) {
                $toElementData = [];
                foreach ($toTempJson['element'] as $toElementKey => $toElementValue) {
                    if (in_array($toElementKey, ['modal'])) {
                        continue;
                    }
                    if ($toElementKey == 'images') {
                        foreach ($toElementValue as $imageKey => $imageValue) {
                            $toElementData[$imageKey] = '';
                        }
                    } else {
                        $toElementData[$toElementKey] = @$dataEl->data_values->$toElementKey;
                    }
                }
                $toFrontendElement                = new Frontend();
                $toFrontendElement->data_keys     = $key . '.element';
                $toFrontendElement->data_values   = $toElementData;
                $toFrontendElement->template_name = $toTemp;
                $toFrontendElement->save();
            }
        }

        $notify[] = ['success', 'Template updated successfully'];
        return back()->withNotify($notify);
    }

}
