<?php namespace PayPalCheckoutSdk\Core;
error_reporting(1);
ini_set("display_errors",1);

include_once($_SERVER['DOCUMENT_ROOT'].'/vendor/paypal/paypalhttp/lib/PayPalHttp/IOException.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/vendor/paypal/paypalhttp/lib/PayPalHttp/HttpClient.php');
include_once("AuthorizationInjector.php");
include_once("GzipInjector.php");
include_once("FPTIInstrumentationInjector.php");


use PayPalHttp\HttpClient;





class PayPalHttpClient extends HttpClient
{
    private $refreshToken;
    public $authInjector;

    public function __construct(PayPalEnvironment $environment, $refreshToken = NULL)
    {
       
        
        parent::__construct($environment);
        $this->refreshToken = $refreshToken;
        $this->authInjector = new AuthorizationInjector($this, $environment, $refreshToken);
        $this->addInjector($this->authInjector);
        $this->addInjector(new GzipInjector());
        $this->addInjector(new FPTIInstrumentationInjector());
    }

    public function userAgent()
    {
        return UserAgent::getValue();
    }
}

