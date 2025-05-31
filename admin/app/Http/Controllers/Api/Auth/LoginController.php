<?php

namespace App\Http\Controllers\Api\Auth;

use App\Http\Controllers\Controller;
use App\Models\UserLogin;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Validator;

class LoginController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Login Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles authenticating users for the application and
    | redirecting them to your home screen. The controller uses a trait
    | to conveniently provide its functionality to your applications.
    |
    */

    use AuthenticatesUsers;

    /**
     * Where to redirect users after login.
     *
     * @var string
     */

    protected $username;

    /**
     * Create a new controller instance.
     *
     * @return void
     */


    public function __construct()
    {
        parent::__construct();
        $this->username = $this->findUsername();
    }

    public function login(Request $request)
    {

        $validator = $this->validateLogin($request);

        if ($validator->fails()) {
            return response()->json([
                'remark'=>'validation_error',
                'status'=>'error',
                'message'=>['error'=>$validator->errors()->all()],
            ]);
        }

        $credentials = request([$this->username, 'password']);
        if(!Auth::attempt($credentials)){
            $response[] = 'Unauthorized user';
            return response()->json([
                'remark'=>'validation_error',
                'status'=>'error',
                'message'=>['error'=>$response],
            ]);
        }

        $user = $request->user();
        $tokenResult = $user->createToken('auth_token')->plainTextToken;
        $this->authenticated($request,$user);
        $response[] = 'Login Successful';
        return response()->json([
            'remark'=>'login_success',
            'status'=>'success',
            'message'=>['success'=>$response],
            'data'=>[
                'user' => auth()->user(),
                'access_token'=>$tokenResult,
                'token_type'=>'Bearer'
            ]
        ]);


    }

    public function findUsername()
    {
        $login = request()->input('username');

        $fieldType = filter_var($login, FILTER_VALIDATE_EMAIL) ? 'email' : 'username';
        request()->merge([$fieldType => $login]);
        return $fieldType;
    }

    public function username()
    {
        return $this->username;
    }

    protected function validateLogin(Request $request)
    {
        $validation_rule = [
            $this->username() => 'required|string',
            'password' => 'required|string',
        ];

        $validate = Validator::make($request->all(),$validation_rule);
        return $validate;

    }

    public function logout()
    {
        auth()->user()->tokens()->delete();

        $notify[] = 'Logout Successful';
        return response()->json([
            'remark'=>'logout',
            'status'=>'ok',
            'message'=>['success'=>$notify],
        ]);
    }

    public function authenticated(Request $request, $user)
    {
        $user->tv = $user->ts == 1 ? 0 : 1;
        $user->save();
        $ip = getRealIP();
        $exist = UserLogin::where('user_ip',$ip)->first();
        $userLogin = new UserLogin();
        if ($exist) {
            $userLogin->longitude =  $exist->longitude;
            $userLogin->latitude =  $exist->latitude;
            $userLogin->city =  $exist->city;
            $userLogin->country_code = $exist->country_code;
            $userLogin->country =  $exist->country;
        }else{
            $info = json_decode(json_encode(getIpInfo()), true);
            $userLogin->longitude =  @implode(',',$info['long']);
            $userLogin->latitude =  @implode(',',$info['lat']);
            $userLogin->city =  @implode(',',$info['city']);
            $userLogin->country_code = @implode(',',$info['code']);
            $userLogin->country =  @implode(',', $info['country']);
        }

        $userAgent = osBrowser();
        $userLogin->user_id = $user->id;
        $userLogin->user_ip =  $ip;

        $userLogin->browser = @$userAgent['browser'];
        $userLogin->os = @$userAgent['os_platform'];
        $userLogin->save();
    }


}