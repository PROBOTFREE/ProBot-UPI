<?php

namespace PayPalHttp;
include_once($_SERVER['DOCUMENT_ROOT'].'/vendor/paypal/paypalhttp/lib/PayPalHttp/IOException.php');

class HttpException extends IOException
{
    /**
     * @var statusCode
     */
    public $statusCode;

    public $headers;

    /**
     * @param string $response
     */
    public function __construct($message, $statusCode, $headers)
    {
        parent::__construct($message);
        $this->statusCode = $statusCode;
        $this->headers = $headers;
    }
}
