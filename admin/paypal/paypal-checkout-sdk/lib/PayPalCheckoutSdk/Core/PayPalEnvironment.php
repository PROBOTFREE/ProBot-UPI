<?php

namespace PayPalCheckoutSdk\Core;

use PayPalHttp\Environment;

include_once($_SERVER['DOCUMENT_ROOT'].'/vendor/paypal/paypalhttp/lib/PayPalHttp/Environment.php');


abstract class PayPalEnvironment implements Environment
{
    private $clientId;
    private $clientSecret;

    public function __construct($clientId, $clientSecret)
    {
         
        $this->clientId = $clientId;
        $this->clientSecret = $clientSecret;
    }

    public function authorizationString()
    {
        return base64_encode($this->clientId . ":" . $this->clientSecret);
    }
}

