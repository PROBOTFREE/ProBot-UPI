<?php
header("Content-Type: application/json");

include '../config.php'; // Database connection

if ($conn->connect_error) {
    http_response_code(500);
    echo json_encode(["error" => "Database connection failed"]);
    exit;
}

// Decode JSON input
$data = json_decode(file_get_contents("php://input"), true);

$license_key = $data["license_key"] ?? '';
$device_id = $data["device_id"] ?? '';

if (!$license_key || !$device_id) {
    http_response_code(400);
    echo json_encode(["error" => "Missing license_key or device_id"]);
    exit;
}

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

if (!$license_key || strlen($license_key) < 16) {
    http_response_code(403);
    echo json_encode(["status" => "error", "message" => "Invalid panel ID format."]);
    exit;
}

// Fetch license record
$stmt = $conn->prepare("SELECT * FROM customers WHERE panel_id = ?");
$stmt->bind_param("s", $license_key);
$stmt->execute();
$result = $stmt->get_result();
$customer = $result->fetch_assoc();

if (!$customer) {
    http_response_code(404);
    echo json_encode(["error" => "License not found"]);
    exit;
}

// === Ensure the decoded panel_id matches the stored raw token ===
if ($license_key !== $customer['panel_id']) {
    http_response_code(403);
   echo json_encode(["status" => "error", "message" => "Invalid license key."]);
    exit;
}

// === IP Check ===
$client_ip = getClientIP();
if (!empty($customer['allowed_ip']) && $customer['allowed_ip'] !== $client_ip) {
    http_response_code(403);
    echo json_encode(["status" => "error", "message" => "Access denied. IP mismatch."]);
    exit;
}

// Check expiry
if ($customer['expiry_date'] && strtotime($customer['expiry_date']) < time()) {
    http_response_code(403);
    echo json_encode(["error" => "License expired"]);
    exit;
}

// Decode devices list safely
$devices = $customer['devices'] ? json_decode($customer['devices'], true) : [];
if (!is_array($devices)) {
    $devices = [];
}

// Determine max devices (default to 1)
$max_devices = isset($customer['max_devices']) ? (int)$customer['max_devices'] : 1;

// Device handling
if (!in_array($device_id, $devices)) {
    if (count($devices) >= $max_devices) {
        http_response_code(403);
        echo json_encode(["error" => "Device limit reached"]);
        exit;
    }

    // Register device
    $devices[] = $device_id;
    $devices_json = json_encode($devices);

    $update = $conn->prepare("UPDATE customers SET devices = ? WHERE panel_id = ?");
    $update->bind_param("ss", $devices_json, $license_key);
    $update->execute();
}

// Final response
echo json_encode([
    "success" => true,
    "message" => "License validated",
    "expires" => $customer['expiry_date'],
    "registered_devices" => $devices
]);
