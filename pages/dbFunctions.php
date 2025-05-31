<?php

// Define withdrawal fees
$withdrawalFeePercentage = 0.10; // 10%
$withdrawalFixedFee = 10; // ₹10

$cxrbankpayout=true;
$cxrupipayout=false;




$incatcapi="hi";





//2fa
// 30 second otp valid by cxr smm

// Function to encode data using Base32 encoding
function base32Encode($data) {
    $alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ234567';
    $dataSize = strlen($data);
    $result = '';
    $remainder = 0;
    $remainderSize = 0;

    for ($i = 0; $i < $dataSize; $i++) {
        $b = ord($data[$i]);
        $remainder = ($remainder << 8) | $b;
        $remainderSize += 8;
        while ($remainderSize > 4) {
            $remainderSize -= 5;
            $c = $remainder & (31 << $remainderSize);
            $c >>= $remainderSize;
            $result .= $alphabet[$c];
        }
    }

    if ($remainderSize > 0) {
        $remainder <<= (5 - $remainderSize);
        $result .= $alphabet[$remainder];
    }

    return $result;
}

function base32Decode($b32) {
    $alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ234567';
    $out = '';
    $dous = 0;
    $buffer = 0;

    for ($i = 0; $i < strlen($b32); $i++) {
        $x = strpos($alphabet, $b32[$i]);
        if ($x === false) break;
        $buffer = ($buffer << 5) | $x;
        $dous += 5;

        if ($dous >= 8) {
            $dous -= 8;
            $out .= chr(($buffer & (0xFF << $dous)) >> $dous);
        }
    }

    return $out;
}

function totp($key, $timeSlice = null) {
    if ($timeSlice === null) {
        $timeSlice = floor(time() / 30);
    }

    $secretkey = base32Decode($key);

    // Pack time into binary string
    $time = chr(0).chr(0).chr(0).chr(0).pack('N*', $timeSlice);
    // Hash it with users secret key
    $hm = hash_hmac('SHA1', $time, $secretkey, true);
    // Use last nibble of result as index/offset
    $offset = ord(substr($hm, -1)) & 0x0F;
    // grab 4 bytes of the result
    $hashpart = substr($hm, $offset, 4);

    // Unpack binary value
    $value = unpack('N', $hashpart);
    $value = $value[1];
    // Only 32 bits
    $value = $value & 0x7FFFFFFF;

    $modulo = pow(10, 6);
    return str_pad($value % $modulo, 6, '0', STR_PAD_LEFT);
}

//api Key

// Function to generate a Google-style API Key (39 characters)
function generateApiKey($length = 39) {
    $characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    $prefix = 'ShAu'; // Custom prefix
    $randomString = '';

    for ($i = 0; $i < $length - strlen($prefix) - 6; $i++) { // Adjusted loop
        $randomString .= $characters[random_int(0, strlen($characters) - 1)];
    }
    
    // Get last 6 digits from current time (ensures total length = 39)
    $lastSixDigits = substr(strval(time()), -6);

    return $prefix . $randomString . $lastSixDigits;
}

//secret key

function generateRandomSecretKey($length = 32)
{
    // Generate random bytes using CSPRNG
    $randomBytes = random_bytes($length);
    // Encode random bytes using Base64 encoding
    $key = base64_encode($randomBytes);
    // Remove any non-alphanumeric characters from the key
    $key = preg_replace('/[^a-zA-Z0-9]/', '', $key);
    // Truncate key to specified length
    $key = substr($key, 0, $length);
    return $key;
}


  // Function to generate a random instance_id
function generateRandomInstanceId($length = 16) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $randomString = 'I'; // Fixed 'I' as the first character

    // Generate a random string with the specified length - 7 (for the time part and additional digit)
    for ($i = 1; $i < $length - 6; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }

    // Get the current time in seconds since the epoch
    $currentTime = time();

    // Take the last 6 digits from the current time and append them to the random string
    $lastSixDigits = substr(strval($currentTime), -6);
    $randint = rand(100, 900);
    
    return $randomString . $randint . $lastSixDigits;
}

// Function to generate a random instance_secret
function generateRandomInstanceSecret($length = 32) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }
    return $randomString;
}


function isMobile() {
    return preg_match("/(android|avantgo|blackberry|bolt|boost|cricket|docomo|fone|hiptop|mini|mobi|palm|phone|pie|tablet|up\.browser|up\.link|webos|wos)/i", $_SERVER["HTTP_USER_AGENT"]);
}



// Function to generate a unique short URL
function generateShortUrl() {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $length = rand(3, 6); // Generate a random length between 3 and 6 characters
    $shortUrl = '';
    
    // Generate a random short URL of random length
    for ($i = 0; $i < $length; $i++) {
        $shortUrl .= $characters[rand(0, strlen($characters) - 1)];
    }
    
    return $shortUrl;
}


// Function to generate a random wallet txn id

function generateRandomWalletTxnID($length = 12) {
    $characters = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    $txn_id = '';
    $maxIndex = strlen($characters) - 1;

    for ($i = 0; $i < $length; $i++) {
        $randomIndex = mt_rand(0, $maxIndex);
        $txn_id .= $characters[$randomIndex];
    }

    // Append a timestamp (in seconds since the Unix epoch) to the ID
    $txn_id .= time();

    return $txn_id;
}

////////checksum for payout

// Function to generate a secure checksum
function generateChecksum($data, $secret_key) {
    // Sort the data by keys to ensure consistent order
    ksort($data);
    // Manually concatenate the data. Format each key-value pair as "key=value"
    // and join them using a pipe (|) as a separator.
    $dataString = implode('|', array_map(function ($key, $value) {
        return $key . '=' . $value;
    }, array_keys($data), $data));
    // Generate the checksum with HMAC SHA256
    return hash_hmac('sha256', $dataString, $secret_key);
}


function curlGet($url) {
    // Initialize cURL session
    $ch = curl_init();
    
    // Set cURL options
    curl_setopt($ch, CURLOPT_URL, $url); // Set the URL
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return the response as a string
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); // Disable SSL certificate verification (for testing)
    
    // Execute the cURL session and store the result in $response
    $response = curl_exec($ch);
    
    // Check for cURL errors
    if(curl_errno($ch)) {
        echo 'cURL error: ' . curl_error($ch);
    }
    
    // Close the cURL session
    curl_close($ch);
    
    // Return the response
    return $response;
}




function getXbyY($query) {
    
    $con = connect_database();
    $result = $con->query($query);

    for ($set = array(); 
    $row = $result->fetch_assoc(); 
    $set[] = $row);

    $con->close();
    return $set;
}

function setXbyY($query) {
    $con = connect_database();
    $result = $con->query($query); ////$result = $con->query($query) or die($query . " " . mysqli_error($con));
    $con->close();
    return $result;
}


###################################################################
//Start of function to get todays date
##################################################################

function todaysDate() {
    $tdate = date("Y-m-d", mktime(0, 0, 0, date("m"), date("d"), date("y")));
    $tdate = $tdate . " " . date('H:i:s');
    return $tdate;
}









####################################################################
// End of function to differentiate user_type
###############################################################
####################################################################
// Start of function to get status of user
###############################################################

function status($is_active) {
    if ($is_active == 1) {
        $status = "<span class='fa_approve' >Active</span>";
    } else {
        $status = "<span class='fa_reject' >Blocked</span>";
    }
    return $status;
}



###############################################################
// End of function to get status of user



###############################################################
//End of function to get username from userid
###############################################################
###############################################################
//Start of function to get username from userid
###############################################################


//*********** Encryption Function *********************
function encrypt($plainText, $key) {
    $secretKey = hextobin(md5($key));
    $initVector = pack("C*", 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f);
    $openMode = openssl_encrypt($plainText, 'AES-128-CBC', $secretKey, OPENSSL_RAW_DATA, $initVector);
    $encryptedText = bin2hex($openMode);
    return $encryptedText;
}


function sanitizeInput($input) {
    return $input;
}

//*********** Decryption Function *********************
function decrypt($encryptedText, $key) {
    $key = hextobin(md5($key));
    $initVector = pack("C*", 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f);
    $encryptedText = hextobin($encryptedText);
    $decryptedText = openssl_decrypt($encryptedText, 'AES-128-CBC', $key, OPENSSL_RAW_DATA, $initVector);
    return $decryptedText;
}



//generate merchant id

// Function to generate a merchant ID
function generateMerchantId($length) {
    $characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    $merchantId = 'M';

    for ($i = 1; $i < $length; $i++) {
        $merchantId .= $characters[rand(0, strlen($characters) - 1)];
    }
    $cxrmerchanttime = time();
    return $merchantId . $cxrmerchanttime;
}

function boltx_telegram_noti_bot($msg, $chat_id) {
    $bot_token = '7760086072:AAGshI4bRsIhggGrrw1d7PnaD9sa5Z0mqLo'; // Replace with your bot's token
    $server_url = "https://api.telegram.org/bot$bot_token/sendMessage";
    
    $data = [
        'chat_id' => $chat_id,
        'text' => $msg,
    ];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $server_url);
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    
    $result = curl_exec($ch);
    $error = curl_error($ch);
    curl_close($ch);
}

//################################################################




// Function to generate a random payout ID with time
function generateRandomPayoutID() {
    $characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    $random_part = '';
    $length = 5; // Length of the random part

    // Generate a random part of the ID
    for ($i = 0; $i < $length; $i++) {
        $random_part .= $characters[rand(0, strlen($characters) - 1)];
    }

    // Add current timestamp to the random part
    $payout_id = $random_part . time();

    return $payout_id;
}

/////logger by cxr


//log history
// Function to get user's IP address
function getUserIP() {
    // Check for shared internet/ISP IPv6 IP
    if (!empty($_SERVER['HTTP_CLIENT_IP']) && filter_var($_SERVER['HTTP_CLIENT_IP'], FILTER_VALIDATE_IP, FILTER_FLAG_IPV6)) {
        return $_SERVER['HTTP_CLIENT_IP'];
    }
    // Check for IPv6 address from proxy or load balancer
    elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR']) && filter_var($_SERVER['HTTP_X_FORWARDED_FOR'], FILTER_VALIDATE_IP, FILTER_FLAG_IPV6)) {
        return $_SERVER['HTTP_X_FORWARDED_FOR'];
    }
    // Check for public IPv6 address
    elseif (!empty($_SERVER['REMOTE_ADDR']) && filter_var($_SERVER['REMOTE_ADDR'], FILTER_VALIDATE_IP, FILTER_FLAG_IPV6)) {
        return $_SERVER['REMOTE_ADDR'];
    }
    // If no IPv6 address found, fallback to IPv4
    else {
        return $_SERVER['REMOTE_ADDR'];
    }
}


// Function to get device information
function getDeviceInformation() {
    $user_agent = $_SERVER['HTTP_USER_AGENT'];
    $device_info = "";

    $os_array = array(
        '/windows nt 10/i'      =>  'Windows 10',
        '/windows nt 6.3/i'     =>  'Windows 8.1',
        '/windows nt 6.2/i'     =>  'Windows 8',
        '/windows nt 6.1/i'     =>  'Windows 7',
        '/windows nt 6.0/i'     =>  'Windows Vista',
        '/windows nt 5.2/i'     =>  'Windows Server 2003/XP x64',
        '/windows nt 5.1/i'     =>  'Windows XP',
        '/windows xp/i'         =>  'Windows XP',
        '/windows nt 5.0/i'     =>  'Windows 2000',
        '/windows me/i'         =>  'Windows ME',
        '/win98/i'              =>  'Windows 98',
        '/win95/i'              =>  'Windows 95',
        '/win16/i'              =>  'Windows 3.11',
        '/macintosh|mac os x/i' =>  'Mac OS X',
        '/mac_powerpc/i'        =>  'Mac OS 9',
        '/linux/i'              =>  'Linux',
        '/ubuntu/i'             =>  'Ubuntu',
        '/iphone/i'             =>  'iPhone',
        '/ipod/i'               =>  'iPod',
        '/ipad/i'               =>  'iPad',
        '/android/i'            =>  'Android',
        '/blackberry/i'         =>  'BlackBerry',
        '/webos/i'              =>  'Mobile'
    );

    foreach ($os_array as $regex => $value) {
        if (preg_match($regex, $user_agent)) {
            $device_info .= "Operating System: " . $value . "; ";
        }
    }

    // Browser
    $browser_array = array(
        '/msie/i'      => 'Internet Explorer',
        '/firefox/i'   => 'Firefox',
        '/safari/i'    => 'Safari',
        '/chrome/i'    => 'Chrome',
        '/edge/i'      => 'Edge',
        '/opera/i'     => 'Opera',
        '/netscape/i'  => 'Netscape',
        '/maxthon/i'   => 'Maxthon',
        '/konqueror/i' => 'Konqueror',
        '/mobile/i'    => 'Handheld Browser'
    );

    foreach ($browser_array as $regex => $value) {
        if (preg_match($regex, $user_agent)) {
            $device_info .= "Browser: " . $value . "; ";
        }
    }

    return $device_info;
}

?>
