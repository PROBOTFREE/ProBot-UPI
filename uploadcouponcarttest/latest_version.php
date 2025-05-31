<?php
header("Access-Control-Allow-Origin: *"); // Allow requests from any origin (or restrict to specific domains)
header("Content-Type: application/json");
include 'config.php';

// Grab the domain from the custom header
$domain = $_SERVER['HTTP_X_DOMAIN'] ?? '';

if (empty($domain)) {
    http_response_code(403);
    echo json_encode(['error' => 'Missing domain']);
    exit;
}

// Check if referer domain exists in customers table
$stmt = $conn->prepare("SELECT * FROM customers WHERE domain = ?");
$stmt->bind_param("s", $domain);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows === 0) {
    http_response_code(403);
    echo json_encode(['error' => 'Access denied: Unauthorized domain.']);
    exit;
}

// Get the latest version info from the files table
$result = $conn->query("SELECT filename, version, changelog, uploaded_at FROM files ORDER BY uploaded_at DESC LIMIT 1");

if ($result && $result->num_rows > 0) {
    $file = $result->fetch_assoc();

    echo json_encode([
        'version'   => $file['version'],
        'filename'  => $file['filename'],
        'changelog' => $file['changelog'],
    ]);
} else {
    echo json_encode([
        'error' => 'No updates found'
    ]);
}
?>