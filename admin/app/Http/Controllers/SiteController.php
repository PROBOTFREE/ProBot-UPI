<?php

namespace App\Http\Controllers;

use App\Models\AdminNotification;
use App\Models\DeviceToken;
use App\Models\Frontend;
use App\Models\GatewayCurrency;
use App\Models\Language;
use App\Models\Page;
use App\Models\Plan;
use App\Models\Subscriber;
use App\Models\SupportMessage;
use App\Models\SupportTicket;
use App\Models\TimeSetting;
use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Cookie;
use Illuminate\Support\Facades\Validator;

class SiteController extends Controller
{
    public function index()
    {
        $reference = @$_GET['reference'];
        if ($reference) {
            session()->put('reference', $reference);
        }
        $pageTitle = 'Home';
        $sections  = Page::where('tempname', $this->activeTemplate)->where('slug', '/')->first();
        return view($this->activeTemplate . 'home', compact('pageTitle', 'sections'));
    }

    public function pages($slug)
    {
        $page      = Page::where('tempname', $this->activeTemplate)->where('slug', $slug)->firstOrFail();
        $pageTitle = $page->name;
        $sections  = $page->secs;
        return view($this->activeTemplate . 'pages', compact('pageTitle', 'sections'));
    }

    public function contact()
    {
        $pageTitle = "Contact Us";
        return view($this->activeTemplate . 'contact', compact('pageTitle'));
    }

    public function contactSubmit(Request $request)
    {
        $this->validate($request, [
            'name'    => 'required',
            'email'   => 'required',
            'subject' => 'required|string|max:255',
            'message' => 'required',
        ]);

        if (!verifyCaptcha()) {
            $notify[] = ['error', 'Invalid captcha provided'];
            return back()->withNotify($notify);
        }

        $request->session()->regenerateToken();
        $random = getNumber();

        $ticket           = new SupportTicket();
        $ticket->user_id  = auth()->id() ?? 0;
        $ticket->name     = $request->name;
        $ticket->email    = $request->email;
        $ticket->priority = 2;

        $ticket->ticket     = $random;
        $ticket->subject    = $request->subject;
        $ticket->last_reply = Carbon::now();
        $ticket->status     = 0;
        $ticket->save();

        $adminNotification            = new AdminNotification();
        $adminNotification->user_id   = auth()->user() ? auth()->user()->id : 0;
        $adminNotification->title     = 'A new support ticket has opened ';
        $adminNotification->click_url = urlPath('admin.ticket.view', $ticket->id);
        $adminNotification->save();

        $message                    = new SupportMessage();
        $message->support_ticket_id = $ticket->id;
        $message->message           = $request->message;
        $message->save();

        $notify[] = ['success', 'Ticket created successfully!'];

        return to_route('ticket.view', [$ticket->ticket])->withNotify($notify);
    }

    public function policyPages($slug, $id)
    {
        $policy    = Frontend::where('id', $id)->where('template_name', activeTemplateName())->where('data_keys', 'policy_pages.element')->firstOrFail();
        $pageTitle = $policy->data_values->title;
        return view($this->activeTemplate . 'policy', compact('policy', 'pageTitle'));
    }

    public function changeLanguage($lang = null)
    {
        $language = Language::where('code', $lang)->first();
        if (!$language) {
            $lang = 'en';
        }

        session()->put('lang', $lang);
        return back();
    }

    public function blogs()
    {
        if (activeTemplateName() == 'invester') {
            abort(404);
        }
        $blogs     = Frontend::where('data_keys', 'blog.element')->where('template_name', activeTemplateName())->orderBy('id', 'desc')->paginate(getPaginate(9));
        $pageTitle = 'Blogs';
        $page      = Page::where('tempname', $this->activeTemplate)->where('slug', 'blogs')->first();
        $sections  = $page->secs;
        return view($this->activeTemplate . 'blogs', compact('blogs', 'pageTitle', 'sections'));
    }

    public function blogDetails($slug, $id)
    {
        if (activeTemplateName() == 'invester') {
            abort(404);
        }
        $pageTitle = 'Blog Details';
        $blog      = Frontend::where('id', $id)->where('template_name', activeTemplateName())->where('data_keys', 'blog.element')->firstOrFail();
        $blogs     = Frontend::where('id', '!=', $id)->where('template_name', activeTemplateName())->where('data_keys', 'blog.element')->latest()->limit(5)->get();

        $seoContents['keywords']           = $blog->meta_keywords ?? [];
        $seoContents['social_title']       = $blog->data_values->title;
        $seoContents['description']        = strLimit(strip_tags($blog->data_values->description), 150);
        $seoContents['social_description'] = strLimit(strip_tags($blog->data_values->description), 150);
        $seoContents['image']              = getImage('assets/images/frontend/blog/' . @$blog->data_values->image, '920x480');
        $seoContents['image_size']         = '920x480';

        return view($this->activeTemplate . 'blog_details', compact('blog', 'pageTitle', 'blogs', 'seoContents'));
    }

    public function subscribe(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'email' => 'required|email|unique:subscribers,email',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'code'    => 200,
                'status'  => 'error',
                'message' => $validator->errors()->all(),
            ]);
        }

        $subscribe        = new Subscriber();
        $subscribe->email = $request->email;
        $subscribe->save();

        $notify = 'Thank you, we will notice you our latest news';

        return response()->json([
            'code'    => 200,
            'status'  => 'success',
            'message' => $notify,
        ]);

    }

    public function plan()
    {
        $pageTitle       = "Investment Plan";
        $plans           = Plan::where('status', 1)->get();
        $sections        = Page::where('tempname', $this->activeTemplate)->where('slug', 'plans')->first();
        $layout          = 'frontend';
        $gatewayCurrency = null;
        $view            = 'plan';
        if (auth()->check()) {
            $layout          = 'master';
            $gatewayCurrency = GatewayCurrency::whereHas('method', function ($gate) {
                $gate->where('status', 1);
            })->with('method')->orderby('name')->get();
        }
        return view($this->activeTemplate . $view, compact('pageTitle', 'plans', 'sections', 'layout', 'gatewayCurrency'));
    }

    public function cookieAccept()
    {
        $general = gs();
        Cookie::queue('gdpr_cookie', $general->site_name, 43200);
        return back();
    }

    public function cookiePolicy()
    {
        $pageTitle = 'Cookie Policy';
        $cookie    = Frontend::where('data_keys', 'cookie.data')->first();
        return view($this->activeTemplate . 'cookie', compact('pageTitle', 'cookie'));
    }

    public function placeholderImage($size = null)
    {
        $imgWidth  = explode('x', $size)[0];
        $imgHeight = explode('x', $size)[1];
        $text      = $imgWidth . '×' . $imgHeight;
        $fontFile  = realpath('assets/font/RobotoMono-Regular.ttf');
        $fontSize  = round(($imgWidth - 50) / 8);
        if ($fontSize <= 9) {
            $fontSize = 9;
        }
        if ($imgHeight < 100 && $fontSize > 30) {
            $fontSize = 30;
        }

        $image     = imagecreatetruecolor($imgWidth, $imgHeight);
        $colorFill = imagecolorallocate($image, 100, 100, 100);
        $bgFill    = imagecolorallocate($image, 175, 175, 175);
        imagefill($image, 0, 0, $bgFill);
        $textBox    = imagettfbbox($fontSize, 0, $fontFile, $text);
        $textWidth  = abs($textBox[4] - $textBox[0]);
        $textHeight = abs($textBox[5] - $textBox[1]);
        $textX      = ($imgWidth - $textWidth) / 2;
        $textY      = ($imgHeight + $textHeight) / 2;
        header('Content-Type: image/jpeg');
        imagettftext($image, $fontSize, 0, $textX, $textY, $colorFill, $fontFile, $text);
        imagejpeg($image);
        imagedestroy($image);
    }

    public function maintenance()
    {
        $pageTitle = 'Maintenance Mode';
        $general   = gs();
        if ($general->maintenance_mode == 0) {
            return to_route('home');
        }
        $maintenance = Frontend::where('data_keys', 'maintenance.data')->first();
        return view($this->activeTemplate . 'maintenance', compact('pageTitle', 'maintenance'));
    }

    public function planCalculator(Request $request)
    {
        if ($request->planId == null) {
            return response(['errors' => 'Please Select a Plan!']);
        }
        $requestAmount = $request->investAmount;
        if ($requestAmount == null || 0 > $requestAmount) {
            return response(['errors' => 'Please Enter Invest Amount!']);
        }
        $general = gs();
        $plan    = Plan::where('id', $request->planId)->where('status', 1)->first();
        if (!$plan) {
            return response(['errors' => 'Invalid Plan!']);
        }

        if ($plan->fixed_amount == '0') {
            if ($requestAmount < $plan->minimum) {
                return response(['errors' => 'Minimum Invest ' . getAmount($plan->minimum) . ' ' . $general->cur_text]);
            }
            if ($requestAmount > $plan->maximum) {
                return response(['errors' => 'Maximum Invest ' . getAmount($plan->maximum) . ' ' . $general->cur_text]);
            }
        } else {
            if ($requestAmount != $plan->fixed_amount) {
                return response(['errors' => 'Fixed Invest amount ' . getAmount($plan->fixed_amount) . ' ' . $general->cur_text]);
            }
        }

        //start
        if ($plan->interest_type == 1) {
            $interestAmount = ($requestAmount * $plan->interest) / 100;
        } else {
            $interestAmount = $plan->interest;
        }

        $timeName = TimeSetting::where('time', $plan->time)->first();

        if ($plan->lifetime == 0) {
            $ret        = $plan->repeat_time;
            $total      = ($interestAmount * $plan->repeat_time) . ' ' . $general->cur_text;
            $totalMoney = $interestAmount * $plan->repeat_time;

            if ($plan->capital_back == 1) {
                $total .= '+Capital';
                $totalMoney += $request->investAmount;
            }

            $result['description'] = 'Return ' . showAmount($interestAmount) . ' ' . $general->cur_text . ' Every ' . $timeName->name . ' For ' . $ret . ' ' . $timeName->name . '. Total ' . $total;
            $result['totalMoney']  = $totalMoney;
            $result['netProfit']   = $totalMoney - $request->investAmount;
        } else {
            $result['description'] = 'Return ' . showAmount($interestAmount) . ' ' . $general->cur_text . ' Every ' . $timeName->name . ' For Lifetime';
        }

        return response($result);
    }


    public function getDeviceToken(Request $request){

        $validator = Validator::make($request->all(), [
            'token'=> 'required'
        ]);

        if($validator->fails()){
            return ['success'=>false, 'errors'=>$validator->errors()->all()];
        }

        $deviceToken = DeviceToken::where('token', $request->token)->first();

        if($deviceToken){
            return ['success'=>true, 'message'=>'Already exists'];
        }

        $deviceToken = new DeviceToken();
        $deviceToken->user_id = auth()->user()->id;
        $deviceToken->token = $request->token;
        $deviceToken->is_app = 0;
        $deviceToken->save();

        return ['success'=>true, 'message'=>'Token save successfully'];
    }

}
