<?php
session_start();
if (!isset($_SESSION['admin_logged_in'])) {
    header('Location: index.php');
    exit;
}
include 'config.php';

$message = "";

if (!isset($_GET['id'])) {
    die("No admin id provided.");
}

$id = (int)$_GET['id'];
$stmt = $conn->prepare("SELECT * FROM admin WHERE id = ?");
$stmt->bind_param("i", $id);
$stmt->execute();
$result = $stmt->get_result();
$admin = $result->fetch_assoc();
$stmt->close();

if (!$admin) {
    die("Admin not found.");
}

if ($_SESSION['admin_id'] != $admin['id']) {
    die("Cannot edit other admins.");
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $status = $_POST['status'];
    $old_password = $_POST['old_password'];
    $new_password = $_POST['new_password'];
    $confirm_password = $_POST['confirm_password'];

    $updatePassword = false;

    if (!empty($old_password) || !empty($new_password) || !empty($confirm_password)) {
        if (!password_verify($old_password, $admin['password'])) {
            $message = "<div class='error'>Old password is incorrect.</div>";
        } elseif ($new_password !== $confirm_password) {
            $message = "<div class='error'>New password and confirm password do not match.</div>";
        } else {
            $updatePassword = true;
        }
    }

    if (empty($message)) {
        if ($updatePassword) {
            $hashedPassword = password_hash($new_password, PASSWORD_BCRYPT);
            $stmt = $conn->prepare("UPDATE admin SET username = ?, password = ?, status = ? WHERE id = ?");
            $stmt->bind_param("sssi", $username, $hashedPassword, $status, $id);
        } else {
            $stmt = $conn->prepare("UPDATE admin SET username = ?, status = ? WHERE id = ?");
            $stmt->bind_param("ssi", $username, $status, $id);
        }

        if ($stmt->execute()) {
            $_SESSION['admin_message'] = "<div class='success'>Admin updated successfully.</div>";
            header("Location: upload.php");
            exit;
        } else {
            $message = "<div class='error'>Error updating admin: " . htmlspecialchars($conn->error) . "</div>";
        }
        $stmt->close();
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Settings</title>
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
    
    .switch {
  position: relative;
  display: inline-block;
  width: 40px;
  height: 20px;
  margin: 0;
}

.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  background-color: #ccc;
  border-radius: 34px;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 14px;
  width: 14px;
  left: 3px;
  bottom: 3px;
  background-color: white;
  transition: .4s;
  border-radius: 50%;
}

input:checked + .slider {
  background-color: #007bff;
}

input:checked + .slider:before {
  transform: translateX(20px);
}


    
    
  </style>
</head>
<body>
    
    <div class="top-bar">
    <div>Logged in as <strong><?= htmlspecialchars($_SESSION['admin_username']) ?></strong></div>
    <div><a href="logout.php">Logout</a></div>
  </div>
    
<div class="container">
        <h2>Edit Admin</h2>
        <?= $message ?>

    <form method="post">
        <label>Username:</label>
        <input type="text" name="username" value="<?= htmlspecialchars($admin['username']) ?>" required>

        <label>Status:</label>
        <select name="status">
            <option value="active" <?= $admin['status'] === 'active' ? 'selected' : '' ?>>Active</option>
            <option value="inactive" <?= $admin['status'] === 'inactive' ? 'selected' : '' ?>>Inactive</option>
        </select>

        <div style="display: flex; align-items: center; gap: 10px; margin-top: 15px;">
    <label for="togglePasswordFields" style="margin: 0;">Change Password:</label>
    <label class="switch small-toggle">
        <input type="checkbox" id="togglePasswordFields">
        <span class="slider round"></span>
    </label>
</div>

<div id="passwordFields" style="display: none; margin-top: 15px;">
    <label>Old Password:</label>
    <input type="password" name="old_password">

    <label>New Password:</label>
    <input type="password" name="new_password">

    <label>Confirm New Password:</label>
    <input type="password" name="confirm_password">
</div>


        <input type="submit" value="Update Admin">

        <div class="back-link">
            <a href="upload.php">&larr; Back to Dashboard</a>
        </div>
    </form>
</div>

<script>
    const toggle = document.getElementById("togglePasswordFields");
    const passwordSection = document.getElementById("passwordFields");

    toggle.addEventListener("change", function () {
        passwordSection.style.display = this.checked ? "block" : "none";
    });
</script>
</body>
</html>
