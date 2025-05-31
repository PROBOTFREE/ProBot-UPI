<?php
include 'config.php';

// === INPUTS ===
$panel_id = $_GET['panel_id'] ?? '';
$file = $_GET['file'] ?? '';

header('Content-Type: application/json');

if (empty($panel_id)) {
    http_response_code(400);
    echo json_encode(["status" => "error", "message" => "'panel_id' parameter is required."]);
    exit;
}

if (empty($file)) {
    http_response_code(400);
    echo json_encode(["status" => "error", "message" => "'file' parameter is required."]);
    exit;
}

$filename = basename($file);// Grab the domain from the custom header
$domain = $_SERVER['HTTP_X_DOMAIN'] ?? '';

if (empty($domain)) {
    http_response_code(403);
    echo json_encode(['error' => 'Missing domain']);
    exit;
}
function getClientIP() {
    if (!empty($_SERVER['HTTP_CF_CONNECTING_IP'])) {
        return $_SERVER['HTTP_CF_CONNECTING_IP'];
    } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
        return explode(',', $_SERVER['HTTP_X_FORWARDED_FOR'])[0];
    } else {
        return $_SERVER['REMOTE_ADDR'];
    }
}

if (!$panel_id || strlen($panel_id) < 16) {
    http_response_code(403);
    echo json_encode(["status" => "error", "message" => "Invalid panel ID format."]);
    exit;
}

// === Query customer based on decoded token (Using Prepared Statement) ===
$stmt = $conn->prepare("SELECT * FROM customers WHERE panel_id = ? AND status = 'active'");
$stmt->bind_param("s", $panel_id);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows === 0) {
    http_response_code(403);
    echo json_encode(["status" => "error", "message" => "Unauthorized or inactive customer."]);
    exit;
}

$customer = $result->fetch_assoc();
$stmt->close();

// === Ensure the decoded panel_id matches the stored raw token ===
if ($panel_id !== $customer['panel_id']) {
    http_response_code(403);
 

   echo json_encode(["status" => "error", "message" => "Invalid panel ID."]);
    exit;
}



// Check expiry
if ($customer['expiry_date'] && strtotime($customer['expiry_date']) < time()) {
    http_response_code(403);
    echo json_encode(["error" => "License expired"]);
    exit;
}

// === IP Check ===
$client_ip = getClientIP();
if (!empty($customer['allowed_ip']) && $customer['allowed_ip'] !== $client_ip) {
    http_response_code(403);
    echo json_encode(["status" => "error", "message" => "Access denied. IP mismatch."]);
    exit;
}

// === File Exists Check ===
$filepath = __DIR__ . "/uploads/" . $filename;
if (!file_exists($filepath)) {
    http_response_code(404);
    echo json_encode(["status" => "error", "message" => "File not found."]);
    exit;
}

// === Proceed with file download ===
header('Content-Description: File Transfer');
header('Content-Type: application/octet-stream');
header('Content-Disposition: attachment; filename="' . $filename . '"');
header('Content-Length: ' . filesize($filepath));
readfile($filepath);
exit;
?>
