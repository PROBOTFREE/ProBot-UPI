<?php
session_start();
if (!isset($_SESSION['admin_logged_in'])) {
    header('Location: index.php');
    exit;
}

include 'config.php';

$message = "";
$customer_message = "";

$customers = [];
$result = $conn->query("SELECT id, email, domain, allowed_ip, max_devices, expiry_date, status FROM customers ORDER BY id DESC");
if ($result && $result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $customers[] = $row;
    }
}


if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['version'])) {
    // === File Upload Section ===
    $version = $_POST['version'];
    $changelog = $_POST['changelog'];
    
    $targetDir = "uploads/";
    
    if (!is_dir($targetDir)) {
        mkdir($targetDir, 0755, true);
    }

    $originalName = basename($_FILES["file"]["name"]);
    $uniqueName = uniqid('update_', true) . '_' . $originalName;
    $targetFilePath = $targetDir . $uniqueName;
    
    // Check file size (limit to 20MB)
        if ($_FILES["file"]["size"] > 20 * 1024 * 1024) {
            $_SESSION['message'] = "<div class='error'>File too large. Max allowed size is 20MB.</div>";
            header("Location: upload.php"); // Adjust redirect path
            exit;
        }
        
    // Validate file type (ZIP only)
    $finfo = new finfo(FILEINFO_MIME_TYPE);
    $mimeType = $finfo->file($_FILES["file"]["tmp_name"]);
    $allowedTypes = ['application/zip', 'application/x-zip-compressed', 'application/octet-stream'];

     if (!in_array($mimeType, $allowedTypes)) {
        $_SESSION['message'] = "<div class='error'>Only valid ZIP files are allowed. Detected type: $mimeType</div>";
    } elseif (move_uploaded_file($_FILES["file"]["tmp_name"], $targetFilePath)) {
        $stmt = $conn->prepare("INSERT INTO files (filename, version, changelog) VALUES (?, ?, ?)");
        $stmt->bind_param("sss", $uniqueName, $version, $changelog);
        if ($stmt->execute()) {
            $_SESSION['message'] = "<div class='success'>File uploaded successfully!</div>";
        } else {
            $_SESSION['message'] = "<div class='error'>Database error: " . htmlspecialchars($conn->error) . "</div>";
        }
    } else {
        $_SESSION['message'] = "<div class='error'>Error uploading file.</div>";
    }

    // Redirect to prevent form resubmission
    header("Location: upload.php");
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['register_customer'])) {
    // === Customer Registration ===
    $email = trim($_POST['email']);
    $domain = trim($_POST['domain']);
    $allowed_ip = trim($_POST['allowed_ip'] ?? '');
    $max_devices = isset($_POST['max_devices']) && is_numeric($_POST['max_devices']) ? (int)$_POST['max_devices'] : 1;
// Expiry: use provided date, or default to tomorrow
$expiry_date = !empty($_POST['expiry_date']) 
    ? $_POST['expiry_date'] 
    : date('Y-m-d', strtotime('+1 day'));


    if (empty($email) || empty($domain)) {
        $_SESSION['customer_message'] = "<div class='error'>Please fill in all required fields.</div>";
    } else {
        $stmt = $conn->prepare("SELECT id FROM customers WHERE email = ? OR domain = ?");
        $stmt->bind_param("ss", $email, $domain);
        $stmt->execute();
        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            $_SESSION['customer_message'] = "<div class='error'>A customer with this email or domain already exists.</div>";
        } else {
            $raw_token = bin2hex(random_bytes(16));
            
            $status = 'active';

$stmt = $conn->prepare("INSERT INTO customers (email, panel_id, status, allowed_ip, domain, expiry_date, max_devices) VALUES (?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("ssssssi", $email, $raw_token, $status, $allowed_ip, $domain, $expiry_date, $max_devices);
            
            if ($stmt->execute()) {
                $_SESSION['success_token'] = $raw_token;
$_SESSION['customer_message'] = "Customer registered successfully!";

            } else {
                $_SESSION['customer_message'] = "<div class='error'>Error adding customer: " . htmlspecialchars($conn->error) . "</div>";
            }
        }

        $stmt->close();
    }

    // Redirect to prevent resubmission
    header("Location: upload.php");
    exit;
}


// Handle customer deletion
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['delete_id'], $_POST['delete_email'])) {
    
    $deleteId = (int) $_POST['delete_id'];
    $deleteEmail = $_POST['delete_email'];

    $stmt = $conn->prepare("DELETE FROM customers WHERE id = ? AND email = ?");
    $stmt->bind_param("is", $deleteId, $deleteEmail);

    if ($stmt->execute()) {
        $_SESSION['customer_message'] = "<div class='success'>Customer deleted successfully.</div>";
    } else {
        $_SESSION['customer_message'] = "<div class='error'>Error deleting customer: " . htmlspecialchars($conn->error) . "</div>";
    }

    $stmt->close();
    header("Location: upload.php");
    exit;
}



?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Update</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background: #f0f2f5;
      margin: 0;
      padding: 0;
    }

    .top-bar {
      background: #fff;
      padding: 15px 30px;
      box-shadow: 0 1px 5px rgba(0,0,0,0.1);
      display: flex;
      justify-content: space-between;
      align-items: center;
      font-size: 14px;
    }

    .top-bar a {
      color: #007bff;
      text-decoration: none;
    }

    .top-bar a:hover {
      text-decoration: underline;
    }

    .container {
      max-width: 700px;
      margin: 40px auto;
      background: #fff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.05);
    }

    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 20px;
    }

    form label {
      font-weight: 600;
      margin-top: 15px;
      display: block;
    }

    input[type="text"], input[type="email"], input[type="number"], input[type="date"], textarea, input[type="file"] {
      width: 100%;
      padding: 10px;
      margin-top: 6px;
      border: 1px solid #ccc;
      border-radius: 6px;
      box-sizing: border-box;
      font-size: 14px;
    }

    textarea {
      resize: vertical;
      min-height: 80px;
    }

    input[type="submit"] {
      margin-top: 20px;
      padding: 12px;
      width: 100%;
      background: #007bff;
      border: none;
      color: white;
      font-size: 16px;
      border-radius: 8px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background: #0056b3;
    }

    .success {
      color: green;
      margin-bottom: 20px;
      text-align: center;
    }

    .error {
      color: red;
      margin-bottom: 20px;
      text-align: center;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    table th, table td {
      padding: 12px;
      border-bottom: 1px solid #eee;
      text-align: left;
    }

    table th {
      background-color: #007bff;
      color: white;
    }

    table td a {
      text-decoration: none;
      color: #007bff;
      font-weight: 500;
    }

    table td a:hover {
      text-decoration: underline;
    }
    
    button.link-button:hover {
  text-decoration: underline;
}

    @media (max-width: 768px) {
      .container {
        margin: 20px;
        padding: 20px;
      }

      .top-bar {
        flex-direction: column;
        gap: 10px;
      }
    }
  </style>
</head>
<body>
    
    <div class="top-bar">
    <div>Logged in as <a href="edit_admin?id=<?= isset($_SESSION['admin_id']) ?>" style="font-weight: bold; color: #000000;"><?= htmlspecialchars($_SESSION['admin_username']) ?></a></div>
    <div><a href="logout.php">Logout</a></div>
  </div>
  
  <!-- Notification Style -->
<div id="notification" style="display:none; position:fixed; top:20px; right:20px; z-index:9999; padding:16px; border-radius:8px; font-size:15px; box-shadow:0 4px 10px rgba(0,0,0,0.1);"></div>

<!-- Token Modal -->
<div id="tokenModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.5); z-index:9998; justify-content:center; align-items:center;">
  <div style="background:#fff; padding:20px 30px; border-radius:10px; max-width:500px; width:90%; text-align:center; box-shadow:0 6px 12px rgba(0,0,0,0.15);">
    <h3 style="margin-bottom:10px;">License Token</h3>
    <input type="text" id="tokenField" readonly style="width:100%; padding:10px; border:1px solid #ccc; border-radius:6px; font-size:16px;">
    <button onclick="copyToken()" style="margin-top:12px; padding:8px 14px; background:#007bff; color:#fff; border:none; border-radius:6px; cursor:pointer;">Copy</button>
    <button onclick="closeTokenModal()" style="margin-top:12px; padding:8px 14px; background:#6c757d; color:#fff; border:none; border-radius:6px; cursor:pointer;">Close</button>
  </div>
</div>


    <div class="container">
        <h2>Upload New Update</h2>
        
        <form action="upload.php" method="post" enctype="multipart/form-data">
            <label>Version:</label>
            <input type="text" name="version" required>

            <label>Changelog:</label>
            <textarea name="changelog" required></textarea>

            <label>Choose File:</label>
            <input type="file" name="file" required>

            <input type="submit" value="Upload">
        </form>
        
        <div class="container" style="margin-top: 40px; text-align: center;">
    <a href="view_files.php" style="
        display: inline-block;
        padding: 12px 20px;
        background-color: #28a745;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        font-weight: 500;
    ">
        📁 View Uploaded Files
    </a>
</div>

        
    </div>
    
<div class="container" style="margin-top: 40px;">

    <h2>Register New Customer</h2>
    
    <form method="post" action="upload.php">
        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Domain:</label>
        <input type="text" name="domain" required>

        <label>Allowed IP (optional):</label>
        <input type="text" name="allowed_ip">
        
        <label>Max Devices (default: 1):</label>
        <input type="number" name="max_devices" min="1" value="1">
        
        <label>Expiry Date:</label>
        <input type="date" name="expiry_date" required>

        <input type="submit" name="register_customer" value="Register Customer">
    </form>
    </div>
    
    
    <?php
$result = $conn->query("SELECT * FROM customers ORDER BY id DESC");
if ($result->num_rows > 0): ?>
    <div class="container" style="margin-top: 40px;">
        <h2 style="text-align:center;">All Customers</h2>
        <div style="overflow-x:auto;">
            <table style="width:100%; border-collapse:collapse; margin-top:20px;">
                <thead>
                    <tr style="background:#007bff; color:#fff;">
                        <th style="padding:12px;">Email</th>
                        <th style="padding:12px;">Domain</th>
                        <th style="padding:12px;">Allowed IP</th>
                        <th style="padding:12px;">Max Devices</th>
                        <th style="padding:12px;">Expiry</th>
                        <th style="padding:12px;">Status</th>
                        <th style="padding:12px;">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <?php while($c = $result->fetch_assoc()): ?>
                    <tr style="border-bottom:1px solid #ddd;">
                        <td style="padding:12px;"><?= htmlspecialchars($c['email']) ?></td>
                        <td style="padding:12px;"><?= htmlspecialchars($c['domain']) ?></td>
                        <td style="padding:12px;"><?= htmlspecialchars($c['allowed_ip']) ?></td>
                        <td style="padding:12px; text-align:center;"><?= $c['max_devices'] ?? 1 ?></td>
                        <td style="padding:12px;"><?= $c['expiry_date'] ?></td>
                        <td style="padding:12px;"><?= ucfirst($c['status']) ?></td>
                        <td style="padding:12px; text-align:center;">
                            
                            <a href="edit_customer.php?email=<?= urlencode($c['email']) ?>&id=<?= $c['id'] ?>" style="color:#007bff; margin-right:10px;">Edit</a>
                            
                            <form method="post" action="upload.php" onsubmit="return confirm('Are you sure you want to delete this customer?');" style="display:inline;">
                                <input type="hidden" name="delete_id" value="<?= $c['id'] ?>">
                                <input type="hidden" name="delete_email" value="<?= htmlspecialchars($c['email']) ?>">
                                <button class="link-button" type="submit" style="color:#dc3545; background:none; border:none; cursor:pointer; padding:0; font:inherit; font-weight: 500;">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <?php endwhile; ?>
                </tbody>
            </table>
        </div>
    </div>
<?php endif; ?>



    
    
    <script>
function copyToken() {
    const tokenField = document.getElementById('tokenField');
    tokenField.select();
    tokenField.setSelectionRange(0, 99999); // For mobile devices
    document.execCommand('copy');

    alert('Token copied to clipboard!');
}
</script>


<script>
function showNotification(message, type = 'success') {
    const notif = document.getElementById('notification');
    notif.innerHTML = message;
    notif.style.display = 'block';
    notif.style.backgroundColor = type === 'success' ? '#d4edda' : '#f8d7da';
    notif.style.color = type === 'success' ? '#155724' : '#721c24';
    notif.style.border = '1px solid ' + (type === 'success' ? '#c3e6cb' : '#f5c6cb');

    setTimeout(() => {
        notif.style.display = 'none';
    }, 4000);
}

function showTokenModal(token) {
    document.getElementById('tokenField').value = token;
    document.getElementById('tokenModal').style.display = 'flex';
}

function closeTokenModal() {
    document.getElementById('tokenModal').style.display = 'none';
}

</script>

<?php if (isset($_SESSION['success_token'])): ?>
<script>
  showTokenModal("<?= $_SESSION['success_token'] ?>");
</script>
<?php unset($_SESSION['success_token']); ?>
<?php endif; ?>


<script>
<?php if (!empty($_SESSION['message'])): ?>
    showNotification(`<?= str_replace("`", "\\`", strip_tags($_SESSION['message'])) ?>`, <?= strpos($_SESSION['message'], 'error') !== false ? "'error'" : "'success'" ?>);
<?php unset($_SESSION['message']); endif; ?>

<?php if (!empty($_SESSION['customer_message'])): ?>
    showNotification(`<?= str_replace("`", "\\`", strip_tags($_SESSION['customer_message'])) ?>`, <?= strpos($_SESSION['customer_message'], 'error') !== false ? "'error'" : "'success'" ?>);
<?php unset($_SESSION['customer_message']); endif; ?>
</script>



</body>
</html>
