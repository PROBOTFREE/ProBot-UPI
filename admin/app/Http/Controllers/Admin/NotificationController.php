<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\GeneralSetting;
use App\Models\NotificationTemplate;
use App\Notify\Sms;
use Illuminate\Http\Request;

class NotificationController extends Controller
{
    function global () {
        $pageTitle = 'Global Template for Notification';
        return view('admin.notification.global_template', compact('pageTitle'));
    }

    public function globalUpdate(Request $request)
    {
        $request->validate([
            'email_from'     => 'required|email|string|max:40',
            'sms_from'       => 'required|string|max:40',
            'email_template' => 'required',
            'firebase_template' => 'required',
            'sms_body'       => 'required',
        ]);

        $general                 = GeneralSetting::first();
        $general->email_from     = $request->email_from;
        $general->email_template = $request->email_template;
        $general->sms_from       = $request->sms_from;
        $general->sms_body       = $request->sms_body;
        $general->firebase_template = $request->firebase_template;
        $general->save();

        $notify[] = ['success', 'Global notification settings updated successfully'];
        return back()->withNotify($notify);
    }

    public function templates()
    {
        $pageTitle = 'Notification Templates';
        $templates = NotificationTemplate::orderBy('name')->get();
        return view('admin.notification.templates', compact('pageTitle', 'templates'));
    }

    public function templateEdit($id)
    {
        $template  = NotificationTemplate::findOrFail($id);
        $pageTitle = $template->name;
        return view('admin.notification.edit', compact('pageTitle', 'template'));
    }

    public function templateUpdate(Request $request, $id)
    {
        $request->validate([
            'subject'    => 'required|string|max:255',
            'email_body' => 'required',
            'sms_body'   => 'required',
            'firebase_body'   => 'required',
        ]);
        $template               = NotificationTemplate::findOrFail($id);
        $template->subj         = $request->subject;
        $template->email_body   = $request->email_body;
        $template->email_status = $request->email_status ? 1 : 0;
        $template->sms_body     = $request->sms_body;
        $template->sms_status   = $request->sms_status ? 1 : 0;
        $template->firebase_body = $request->firebase_body;
        $template->firebase_status = $request->firebase_status ? 1 : 0;
        $template->save();

        $notify[] = ['success', 'Notification template updated successfully'];
        return back()->withNotify($notify);
    }

    public function emailSetting()
    {
        $pageTitle = 'Email Notification Settings';
        return view('admin.notification.email_setting', compact('pageTitle'));
    }

    public function emailSettingUpdate(Request $request)
    {
        $request->validate([
            'email_method' => 'required|in:php,smtp,sendgrid,mailjet',
            'host'         => 'required_if:email_method,smtp',
            'port'         => 'required_if:email_method,smtp',
            'username'     => 'required_if:email_method,smtp',
            'password'     => 'required_if:email_method,smtp',
            'enc'          => 'required_if:email_method,smtp',
            'appkey'       => 'required_if:email_method,sendgrid',
            'public_key'   => 'required_if:email_method,mailjet',
            'secret_key'   => 'required_if:email_method,mailjet',
        ], [
            'host.required_if'       => ':attribute is required for SMTP configuration',
            'port.required_if'       => ':attribute is required for SMTP configuration',
            'username.required_if'   => ':attribute is required for SMTP configuration',
            'password.required_if'   => ':attribute is required for SMTP configuration',
            'enc.required_if'        => ':attribute is required for SMTP configuration',
            'appkey.required_if'     => ':attribute is required for SendGrid configuration',
            'public_key.required_if' => ':attribute is required for Mailjet configuration',
            'secret_key.required_if' => ':attribute is required for Mailjet configuration',
        ]);
        if ($request->email_method == 'php') {
            $data['name'] = 'php';
        } else if ($request->email_method == 'smtp') {
            $request->merge(['name' => 'smtp']);
            $data = $request->only('name', 'host', 'port', 'enc', 'username', 'password', 'driver');
        } else if ($request->email_method == 'sendgrid') {
            $request->merge(['name' => 'sendgrid']);
            $data = $request->only('name', 'appkey');
        } else if ($request->email_method == 'mailjet') {
            $request->merge(['name' => 'mailjet']);
            $data = $request->only('name', 'public_key', 'secret_key');
        }
        $general              = GeneralSetting::first();
        $general->mail_config = $data;
        $general->save();
        $notify[] = ['success', 'Email settings updated successfully'];
        return back()->withNotify($notify);
    }

    public function emailTest(Request $request)
    {
        $request->validate([
            'email' => 'required|email',
        ]);

        $general      = gs();
        $config       = $general->mail_config;
        $receiverName = explode('@', $request->email)[0];
        $subject      = strtoupper($config->name) . ' Configuration Success';
        $message      = 'Your email notification setting is configured successfully for ' . $general->site_name;

        if ($general->en) {
            $user = [
                'username' => $request->email,
                'email'    => $request->email,
                'fullname' => $receiverName,
            ];
            notify($user, 'DEFAULT', [
                'subject' => $subject,
                'message' => $message,
            ], ['email'],false);
        } else {
            $notify[] = ['info', 'Please enable from general settings'];
            $notify[] = ['error', 'Your email notification is disabled'];
            return back()->withNotify($notify);
        }

        if (session('mail_error')) {
            $notify[] = ['error', session('mail_error')];
        } else {
            $notify[] = ['success', 'Email sent to ' . $request->email . ' successfully'];
        }

        return back()->withNotify($notify);
    }

    public function smsSetting()
    {
        $pageTitle = 'SMS Notification Settings';
        return view('admin.notification.sms_setting', compact('pageTitle'));
    }

    public function smsSettingUpdate(Request $request)
    {
        $request->validate([
            'sms_method'             => 'required|in:clickatell,infobip,messageBird,nexmo,smsBroadcast,twilio,textMagic,custom',
            'clickatell_api_key'     => 'required_if:sms_method,clickatell',
            'message_bird_api_key'   => 'required_if:sms_method,messageBird',
            'nexmo_api_key'          => 'required_if:sms_method,nexmo',
            'nexmo_api_secret'       => 'required_if:sms_method,nexmo',
            'infobip_username'       => 'required_if:sms_method,infobip',
            'infobip_password'       => 'required_if:sms_method,infobip',
            'sms_broadcast_username' => 'required_if:sms_method,smsBroadcast',
            'sms_broadcast_password' => 'required_if:sms_method,smsBroadcast',
            'text_magic_username'    => 'required_if:sms_method,textMagic',
            'apiv2_key'              => 'required_if:sms_method,textMagic',
            'account_sid'            => 'required_if:sms_method,twilio',
            'auth_token'             => 'required_if:sms_method,twilio',
            'from'                   => 'required_if:sms_method,twilio',
            'custom_api_method'      => 'required_if:sms_method,custom|in:get,post',
            'custom_api_url'         => 'required_if:sms_method,custom',
        ]);

        $data = [
            'name'          => $request->sms_method,
            'clickatell'    => [
                'api_key' => $request->clickatell_api_key,
            ],
            'infobip'       => [
                'username' => $request->infobip_username,
                'password' => $request->infobip_password,
            ],
            'message_bird'  => [
                'api_key' => $request->message_bird_api_key,
            ],
            'nexmo'         => [
                'api_key'    => $request->nexmo_api_key,
                'api_secret' => $request->nexmo_api_secret,
            ],
            'sms_broadcast' => [
                'username' => $request->sms_broadcast_username,
                'password' => $request->sms_broadcast_password,
            ],
            'twilio'        => [
                'account_sid' => $request->account_sid,
                'auth_token'  => $request->auth_token,
                'from'        => $request->from,
            ],
            'text_magic'    => [
                'username'  => $request->text_magic_username,
                'apiv2_key' => $request->apiv2_key,
            ],
            'custom'        => [
                'method'  => $request->custom_api_method,
                'url'     => $request->custom_api_url,
                'headers' => [
                    'name'  => $request->custom_header_name ?? [],
                    'value' => $request->custom_header_value ?? [],
                ],
                'body'    => [
                    'name'  => $request->custom_body_name ?? [],
                    'value' => $request->custom_body_value ?? [],
                ],
            ],
        ];
        $general             = GeneralSetting::first();
        $general->sms_config = $data;
        $general->save();
        $notify[] = ['success', 'Sms settings updated successfully'];
        return back()->withNotify($notify);
    }

    public function smsTest(Request $request)
    {
        $request->validate(['mobile' => 'required']);
        $general = gs();
        if ($general->sn == 1) {
            $sendSms               = new Sms;
            $sendSms->mobile       = $request->mobile;
            $sendSms->receiverName = ' ';
            $sendSms->message      = 'Your sms notification setting is configured successfully for ' . $general->site_name;
            $sendSms->subject      = ' ';
            $sendSms->send();
        } else {
            $notify[] = ['info', 'Please enable from general settings'];
            $notify[] = ['error', 'Your sms notification is disabled'];
            return back()->withNotify($notify);
        }

        if (session('sms_error')) {
            $notify[] = ['error', session('sms_error')];
        } else {
            $notify[] = ['success', 'SMS sent to ' . $request->mobile . 'successfully'];
        }

        return back()->withNotify($notify);
    }



    public function pushSetting(){
        $pageTitle = 'Push Notification Settings';
        return view('admin.notification.push_setting', compact('pageTitle'));
    }

    public function pushSettingUpdate(Request $request){

        $request->validate([
            'apiKey' => 'required',
            'authDomain' => 'required',
            'projectId' => 'required',
            'storageBucket' => 'required',
            'messagingSenderId' => 'required',
            'appId' => 'required',
            'measurementId' => 'required',
            'serverKey' => 'required',
        ]);

        $data = [
            'apiKey' => $request->apiKey,
            'authDomain' => $request->authDomain,
            'projectId' => $request->projectId,
            'storageBucket' => $request->storageBucket,
            'messagingSenderId' => $request->messagingSenderId,
            'appId' => $request->appId,
            'measurementId' => $request->measurementId,
            'serverKey' => $request->serverKey,
        ];

        $general = gs();
        $general->firebase_config = $data;
        $general->save();

        try{
            $jsPath = 'assets/global/js/firebase/configs.js';
            $config = "var firebaseConfig = ".json_encode($general->firebase_config);
            file_put_contents($jsPath, $config);
        }catch(\Exception $e){
            $notify[] = ['error', $e->getMessage()];
            return back()->withNotify($notify);
        }

        $notify[] = ['success', 'Firebase settings updated successfully'];
        return back()->withNotify($notify);
    }

}
