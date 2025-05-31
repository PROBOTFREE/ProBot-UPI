<?php
session_start();
if (!isset($_SESSION['admin_logged_in'])) {
    header('Location: index.php');
    exit;
}
include 'config.php';

if (!isset($_GET['email'])) {
    die("No customer email provided.");
}

$id = (int)$_GET['id'];
$email = $_GET['email'];
$stmt = $conn->prepare("SELECT * FROM customers WHERE email = ? AND id = ?");
$stmt->bind_param("si", $email, $id);
$stmt->execute();
$result = $stmt->get_result();
$customer = $result->fetch_assoc();
$stmt->close();

if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    die("Invalid email format.");
}

if (!$customer) {
    die("Customer not found.");
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $domain = $_POST['domain'];
    $allowed_ip = $_POST['allowed_ip'];
    $max_devices = (int) $_POST['max_devices'];
    $expiry_date = $_POST['expiry_date'];
    $status = $_POST['status'];

    $stmt = $conn->prepare("UPDATE customers SET domain = ?, allowed_ip = ?, max_devices = ?, expiry_date = ?, status = ? WHERE email = ?");
    $stmt->bind_param("ssisss", $domain, $allowed_ip, $max_devices, $expiry_date, $status, $email);
    if ($stmt->execute()) {
        $_SESSION['customer_message'] = "<div class='success'>Customer updated successfully.</div>";
        header("Location: upload.php");
        exit;
    } else {
        echo "<div class='error'>Error updating customer: " . htmlspecialchars($conn->error) . "</div>";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <style>
        
        label {
            font-weight: bold; 
            display: block; 
            margin-top: 15px; 
            
        }
        input, select { 
            width: 100%; 
            padding: 10px; 
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 6px; 
            
        }
        input[type="submit"] {
            background: #007bff;
            color: white;
            margin-top: 20px;
            border: none; cursor: pointer; 
            
        }
        
        .back-link {
            text-align: center;
            margin-top: 20px;
        }

        .back-link a {
            color: #007bff;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
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
    <div>Logged in as <strong><?= htmlspecialchars($_SESSION['admin_username']) ?></strong></div>
    <div><a href="logout.php">Logout</a></div>
  </div>
    
    <div class="container">
        <h2>Edit Customer</h2>
        <form method="post">
            <label>Email:</label>
            <input type="email" value="<?= htmlspecialchars($customer['email']) ?>" disabled>

            <label>Domain:</label>
            <input type="text" name="domain" value="<?= htmlspecialchars($customer['domain']) ?>" required>

            <label>Allowed IP:</label>
            <input type="text" name="allowed_ip" value="<?= htmlspecialchars($customer['allowed_ip']) ?>">

            <label>Max Devices:</label>
            <input type="number" name="max_devices" value="<?= $customer['max_devices'] ?? 1 ?>" min="1">

            <label>Expiry Date:</label>
            <input type="date" name="expiry_date" value="<?= $customer['expiry_date'] ?>" required>

            <label>Status:</label>
            <select name="status">
                <option value="active" <?= $customer['status'] === 'active' ? 'selected' : '' ?>>Active</option>
                <option value="inactive" <?= $customer['status'] === 'inactive' ? 'selected' : '' ?>>Inactive</option>
            </select>

            <input type="submit" value="Update Customer">
            
            <div class="back-link">
                <a href="upload.php">&larr; Back to Dashboard</a>
            </div>
        </form>
    </div>
</body>
</html>
