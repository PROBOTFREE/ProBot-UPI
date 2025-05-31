<?php

use App\Lib\Captcha;
use App\Lib\ClientInfo;
use App\Lib\CurlRequest;
use App\Lib\FileManager;
use App\Lib\GoogleAuthenticator;
use App\Lib\Initials;
use App\Models\Extension;
use App\Models\Frontend;
use App\Models\GeneralSetting;
use App\Notify\Notify;
use Carbon\Carbon;
use Illuminate\Support\Facades\Cache;
use Illuminate\Support\Str;

function systemDetails()
{
    $system['name']          = 'hyiplab';
    $system['version']       = '3.2';
    $system['build_version'] = '4.3.6';
    $system['h_verifier']    = str_rot13('ivfre_ulvcyno');
    return $system;
}

function slug($string)
{
    return Illuminate\Support\Str::slug($string);
}

function verificationCode($length)
{
    if ($length == 0) {
        return 0;
    }

    $min = pow(10, $length - 1);
    $max = (int) ($min - 1) . '9';
    return random_int($min, $max);
}

function getNumber($length = 8)
{
    $characters       = '1234567890';
    $charactersLength = strlen($characters);
    $randomString     = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

function activeTemplate($asset = false)
{
    $template = activeTemplateName();
    if ($asset) {
        return 'assets/templates/' . $template . '/';
    }

    return 'templates.' . $template . '.';
}

function activeTemplateName()
{
    $general         = gs();
    $template        = $general->active_template;
    $sessionTemplate = session()->get('template');
    if (trim($sessionTemplate)) {
        $template = $sessionTemplate;
    }
    return $template;
}

function loadReCaptcha()
{
    return Captcha::reCaptcha();
}

function loadCustomCaptcha($width = '100%', $height = 46, $bgColor = '#003')
{
    return Captcha::customCaptcha($width, $height, $bgColor);
}

function verifyCaptcha()
{
    return Captcha::verify();
}

function loadExtension($key)
{
    $extension = Extension::where('act', $key)->where('status', 1)->first();
    return $extension ? $extension->generateScript() : '';
}

function getTrx($length = 12)
{
    $characters       = 'ABCDEFGHJKMNOPQRSTUVWXYZ123456789';
    $charactersLength = strlen($characters);
    $randomString     = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

function getAmount($amount, $length = 2)
{
    $amount = round($amount, $length);
    return $amount + 0;
}

function showAmount($amount, $decimal = 2, $separate = true, $exceptZeros = false)
{
    $separator = '';
    if ($separate) {
        $separator = ',';
    }
    $printAmount = number_format($amount, $decimal, '.', $separator);
    if ($exceptZeros) {
        $exp = explode('.', $printAmount);
        if ($exp[1] * 1 == 0) {
            $printAmount = $exp[0];
        } else {
            $printAmount = rtrim($printAmount, '0');
        }
    }
    return $printAmount;
}

function removeElement($array, $value)
{
    return array_diff($array, (is_array($value) ? $value : array($value)));
}

function cryptoQR($wallet)
{
    return "https://chart.googleapis.com/chart?chs=300x300&cht=qr&chl=$wallet&choe=UTF-8";
}

function keyToTitle($text)
{
    return ucfirst(preg_replace("/[^A-Za-z0-9 ]/", ' ', $text));
}

function titleToKey($text)
{
    return strtolower(str_replace(' ', '_', $text));
}

function strLimit($title = null, $length = 10)
{
    return Str::limit($title, $length);
}

function getIpInfo()
{
    $ipInfo = ClientInfo::ipInfo();
    return $ipInfo;
}

function osBrowser()
{
    $osBrowser = ClientInfo::osBrowser();
    return $osBrowser;
}

function getTemplates()
{
    $param['purchasecode'] = env("PURCHASECODE");
    $param['website']      = @$_SERVER['HTTP_HOST'] . @$_SERVER['REQUEST_URI'] . ' - ' . env("APP_URL");
    $url                   = 'https://license.viserlab.com/updates/templates/' . systemDetails()['name'];
    $response              = CurlRequest::curlPostContent($url, $param);
    if ($response) {
        return $response;
    } else {

        return null;
    }
}

function getPageSections($arr = false, $templateName = null)
{
    $jsonUrl  = resource_path('views/') . str_replace('.', '/', $templateName ?? activeTemplate()) . 'sections.json';
    $sections = json_decode(file_get_contents($jsonUrl));
    if ($arr) {
        $sections = json_decode(file_get_contents($jsonUrl), true);
        ksort($sections);
    }
    return $sections;
}

function getImage($image, $size = null)
{
    $clean = '';
    if (file_exists($image) && is_file($image)) {
        return asset($image) . $clean;
    }
    if ($size) {
        return route('placeholder.image', $size);
    }
    return asset('assets/images/default.png');
}

function notify($user, $templateName, $shortCodes = null, $sendVia = null, $createLog = true,$redirectUrl = null)
{
    $general          = gs();
    $globalShortCodes = [
        'site_name'       => $general->site_name,
        'site_currency'   => $general->cur_text,
        'currency_symbol' => $general->cur_sym,
    ];

    if (gettype($user) == 'array') {
        $user = (object) $user;
    }

    $shortCodes = array_merge($shortCodes ?? [], $globalShortCodes);

    $notify               = new Notify($sendVia);
    $notify->templateName = $templateName;
    $notify->shortCodes   = $shortCodes;
    $notify->user         = $user;
    $notify->createLog    = $createLog;
    $notify->redirectUrl = $redirectUrl;
    $notify->userColumn   = isset($user->id) ? $user->getForeignKey() : 'user_id';
    $notify->send();
}

function getColumnName($user)
{
    $array = explode("\\", get_class($user));
    return strtolower(end($array)) . '_id';
}

function getPaginate($paginate = 20)
{
    return $paginate;
}

function paginateLinks($data)
{
    return $data->appends(request()->all())->links();
}

function menuActive($routeName, $type = null, $param = null)
{
    if ($type == 3) {
        $class = 'side-menu--open';
    } elseif ($type == 2) {
        $class = 'sidebar-submenu__open';
    } else {
        $class = 'active';
    }

    if (is_array($routeName)) {
        foreach ($routeName as $key => $value) {
            if (request()->routeIs($value)) {
                return $class;
            }

        }
    } elseif (request()->routeIs($routeName)) {
        if ($param) {
            $routeParam = array_values(@request()->route()->parameters ?? []);
            if (strtolower(@$routeParam[0]) == strtolower($param)) {
                return $class;
            } else {
                return;
            }

        }
        return $class;
    }
}

function fileUploader($file, $location, $size = null, $old = null, $thumb = null)
{
    $fileManager        = new FileManager($file);
    $fileManager->path  = $location;
    $fileManager->size  = $size;
    $fileManager->old   = $old;
    $fileManager->thumb = $thumb;
    $fileManager->upload();
    return $fileManager->filename;
}

function fileManager()
{
    return new FileManager();
}

function getFilePath($key)
{
    return fileManager()->$key()->path;
}

function getFileSize($key)
{
    return fileManager()->$key()->size;
}

function getFileExt($key)
{
    return fileManager()->$key()->extensions;
}

function diffForHumans($date)
{
    $lang = session()->get('lang');
    Carbon::setlocale($lang);
    return Carbon::parse($date)->diffForHumans();
}

function showDateTime($date, $format = 'Y-m-d h:i A')
{
    $lang = session()->get('lang');
    Carbon::setlocale($lang);
    return Carbon::parse($date)->translatedFormat($format);
}

function getContent($dataKeys, $singleQuery = false, $limit = null, $orderById = false)
{
    if ($singleQuery) {
        $content = Frontend::where('template_name', activeTemplateName())->where('data_keys', $dataKeys)->orderBy('id', 'desc')->first();
    } else {
        $article = Frontend::where('template_name', activeTemplateName());
        $article->when($limit != null, function ($q) use ($limit) {
            return $q->limit($limit);
        });
        if ($orderById) {
            $content = $article->where('data_keys', $dataKeys)->orderBy('id')->get();
        } else {
            $content = $article->where('data_keys', $dataKeys)->orderBy('id', 'desc')->get();
        }
    }
    return $content;
}

function gatewayRedirectUrl($type = false)
{
    if ($type) {
        return 'user.deposit.history';
    } else {
        return 'user.deposit.index';
    }
}

function verifyG2fa($user, $code, $secret = null)
{
    $authenticator = new GoogleAuthenticator();
    if (!$secret) {
        $secret = $user->tsc;
    }
    $oneCode  = $authenticator->getCode($secret);
    $userCode = $code;
    if ($oneCode == $userCode) {
        $user->tv = 1;
        $user->save();
        return true;
    } else {
        return false;
    }
}

function urlPath($routeName, $routeParam = null)
{
    if ($routeParam == null) {
        $url = route($routeName);
    } else {
        $url = route($routeName, $routeParam);
    }
    $basePath = route('home');
    $path     = str_replace($basePath, '', $url);
    return $path;
}

function showMobileNumber($number)
{
    $length = strlen($number);
    return substr_replace($number, '***', 2, $length - 4);
}

function showEmailAddress($email)
{
    $endPosition = strpos($email, '@') - 1;
    return substr_replace($email, '***', 1, $endPosition);
}

function getRealIP()
{
    $ip = $_SERVER["REMOTE_ADDR"];
    //Deep detect ip
    if (filter_var(@$_SERVER['HTTP_FORWARDED'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_FORWARDED'];
    }
    if (filter_var(@$_SERVER['HTTP_FORWARDED_FOR'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_FORWARDED_FOR'];
    }
    if (filter_var(@$_SERVER['HTTP_X_FORWARDED_FOR'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_X_FORWARDED_FOR'];
    }
    if (filter_var(@$_SERVER['HTTP_CLIENT_IP'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_CLIENT_IP'];
    }
    if (filter_var(@$_SERVER['HTTP_X_REAL_IP'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_X_REAL_IP'];
    }
    if (filter_var(@$_SERVER['HTTP_CF_CONNECTING_IP'], FILTER_VALIDATE_IP)) {
        $ip = $_SERVER['HTTP_CF_CONNECTING_IP'];
    }
    if ($ip == '::1') {
        $ip = '127.0.0.1';
    }

    return $ip;
}

function appendQuery($key, $value)
{
    return request()->fullUrlWithQuery([$key => $value]);
}

function dateSort($a, $b)
{
    return strtotime($a) - strtotime($b);
}

function dateSorting($arr)
{
    usort($arr, "dateSort");
    return $arr;
}

function ordinal($number)
{
    $ends = array('th', 'st', 'nd', 'rd', 'th', 'th', 'th', 'th', 'th', 'th');
    if ((($number % 100) >= 11) && (($number % 100) <= 13)) {
        return $number . 'th';
    } else {
        return $number . $ends[$number % 10];
    }
}

function diffDatePercent($start, $end)
{
    $start = strtotime($start);
    $end   = strtotime($end);

    $diff = $end - $start;

    $current = time();
    $cdiff   = $current - $start;

    if ($cdiff > $diff) {
        $percentage = 1.0;
    } else if ($current < $start) {
        $percentage = 0.0;
    } else {
        $percentage = $cdiff / $diff;
    }

    return round($percentage * 100, 2);
}

function gs()
{
    $general = Cache::get('GeneralSetting');
    if (!$general) {
        $general = GeneralSetting::first();
        Cache::put('GeneralSetting', $general);
    }
    return $general;
}

function getInitials($name)
{
    return Initials::generate($name);
}

function queryBuild($key, $value)
{
    $queries = request()->query();
    if (@$queries['search']) {
        $route = route('user.transactions');
        unset($queries['search']);
    } else {
        $route = request()->getRequestUri();
    }
    if (count($queries) > 0) {
        $delimeter = '&';
    } else {
        $delimeter = '?';
    }
    if (request()->has($key)) {
        $url     = request()->getRequestUri();
        $pattern = "\?$key";
        $match   = preg_match("/$pattern/", $url);
        if ($match != 0) {
            return preg_replace('~(\?|&)' . $key . '[^&]*~', "\?$key=$value", $url);
        }
        $filteredURL = preg_replace('~(\?|&)' . $key . '[^&]*~', '', $url);
        return $filteredURL . $delimeter . "$key=$value";
    }
    return $route . $delimeter . "$key=$value";

}

function hexToHsl($hex)
{
    $red   = hexdec(substr($hex, 0, 2)) / 255;
    $green = hexdec(substr($hex, 2, 2)) / 255;
    $blue  = hexdec(substr($hex, 4, 2)) / 255;

    $cmin  = min($red, $green, $blue);
    $cmax  = max($red, $green, $blue);
    $delta = $cmax - $cmin;

    if ($delta === 0) {
        $hue = 0;
    } elseif ($cmax === $red) {
        $hue = (($green - $blue) / $delta) % 6;
    } elseif ($cmax === $green) {
        $hue = ($blue - $red) / $delta + 2;
    } else {
        $hue = ($red - $green) / $delta + 4;
    }

    $hue = round($hue * 60);
    if ($hue < 0) {
        $hue += 360;
    }

    $lightness  = (($cmax + $cmin) / 2) * 100;
    $saturation = $delta === 0 ? 0 : ($delta / (1 - abs(2 * $lightness - 1))) * 100;
    if ($saturation < 0) {
        $saturation += 100;
    }

    $lightness  = round($lightness);
    $saturation = round($saturation);

    return "hsl(${hue}, ${saturation}%, ${lightness}%)";
}

function getReferees($user, $maxLevel, $data = [], $depth = 1, $layer = 0)
{
    if ($user->allReferrals->count() > 0 && $maxLevel > 0) {
        foreach ($user->allReferrals as $under) {
            $i = 0;
            if ($i == 0) {
                $layer++;
            }
            $i++;

            $userData['id']       = $under->id;
            $userData['username'] = $under->username;
            $userData['level']    = $depth;
            $data[]               = $userData;
            if ($under->allReferrals->count() > 0 && $layer < $maxLevel) {
                $data = getReferees($under, $maxLevel, $data, $depth + 1, $layer);
            }
        }
    }
    return $data;
}

function getResponse($remark, $status, $message, $data = null)
{
    if (!$data) {
        return response()->json([
            'remark'  => $remark,
            'status'  => $status,
            'message' => [$status => $message],
        ]);
    }

    return response()->json([
        'remark'  => $remark,
        'status'  => $status,
        'message' => [$status => [$message]],
        'data'    => $data,
    ]);
}
