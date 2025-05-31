
<?php
// Define the base directory constant
define('BASE_DIR', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the BASE_DIR constant
include BASE_DIR . 'pages/dbFunctions.php';
include BASE_DIR . 'pages/dbInfo.php';


// Connect to your database
$host = 'localhost';
$dbname = DB_NAME;
$username = DB_USERNAME;
$password = DB_PASSWORD;

$pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Function to sanitize the short URL parameter to prevent SQL injection
function sanitizeShortUrl($shortUrl) {
    // Only allow alphanumeric characters and some special characters like - and _
    return preg_replace("/[^a-zA-Z0-9-_]/", "", $shortUrl);
}

// Function to sanitize the short URL parameter to prevent XSS attacks
function sanitizeForXSS($string) {
    // Convert special characters to HTML entities
    return htmlspecialchars($string, ENT_QUOTES, 'UTF-8');
}

// If a short URL is provided, redirect to the corresponding long URL
if (isset($_GET['short'])) {
    $shortUrl = sanitizeShortUrl($_GET['short']);
    $shortUrl = sanitizeForXSS($shortUrl); // Sanitize for XSS after SQL injection prevention
    $stmt = $pdo->prepare("SELECT long_url, url_clicks FROM short_urls WHERE short_url = ?");
    $stmt->execute([$shortUrl]);
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
    if ($row) {
        $longUrl = $row['long_url'];
        
        // Increment the url_clicks count
        $urlClicks = $row['url_clicks'] + 1;
        $updateStmt = $pdo->prepare("UPDATE short_urls SET url_clicks = ? WHERE short_url = ?");
        $updateStmt->execute([$urlClicks, $shortUrl]);
        
        // Redirect to the long URL
        echo "<script>window.location.replace('$longUrl');</script>";
        exit();
    } else {
        echo "Short URL not found";
        exit();
    }
}

?>
