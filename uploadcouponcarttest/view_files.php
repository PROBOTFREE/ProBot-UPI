<?php
session_start();

if (!isset($_SESSION['admin_logged_in']) || !isset($_SESSION['admin_id'])) {
    header('Location: index.php');
    exit;
}

include 'config.php';

// Fetch the admin ID from the session
$admin_id = (int) $_SESSION['admin_id'];

$message = "";

// Fetch admin details from DB
$stmt = $conn->prepare("SELECT * FROM admin WHERE id = ?");
$stmt->bind_param("i", $admin_id);
$stmt->execute();
$result = $stmt->get_result();
$admin = $result->fetch_assoc();
$stmt->close();

if (!$admin) {
    die("Admin not found.");
}

// Fetch all uploads
$files = [];
$result = $conn->query("SELECT * FROM files ORDER BY uploaded_at DESC");
while ($row = $result->fetch_assoc()) {
    $files[] = $row;
}


// Handle file delete
if (isset($_POST['delete_file']) && isset($_POST['delete_file_id'])) {
    // Optional: Double check admin here if needed
    if ($_SESSION['admin_logged_in']) {
        $file_id = (int)$_POST['delete_file_id'];

        // You can also add file unlink if you're storing physical files
        $stmt = $conn->prepare("DELETE FROM files WHERE id = ?");
        $stmt->bind_param("i", $file_id);
        $stmt->execute();
        $stmt->close();

        $_SESSION['customer_message'] = "<div class='success'>File deleted successfully.</div>";
        header("Location: " . $_SERVER['PHP_SELF']);
        exit;
    }
}

?>

<!DOCTYPE html>
<html>
<head>
    <title>Uploaded files</title>
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

.table-wrapper {
    overflow-x: auto;
    width: 100%;
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
        <h2>Uploaded files</h2>
        <div class="table-wrapper">
        <?php if (!empty($files)) : ?>
    <table>
        <tr>
            <th>ID</th>
            <th>Filename</th>
            <th>Version</th>
            <th>Changelog</th>
            <th>Uploaded At</th>
            <th>Action</th>
        </tr>
        <?php foreach ($files as $file) : ?>
            <tr>
                <td><?= $file['id'] ?></td>
                <td><?= htmlspecialchars($file['filename']) ?></td>
                <td><?= htmlspecialchars($file['version']) ?></td>
                <td><?= nl2br(htmlspecialchars($file['changelog'])) ?></td>
                <td><?= $file['uploaded_at'] ?></td>
                <td>
                    <form method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this file?');">
                        <input type="hidden" name="delete_file_id" value="<?= $file['id'] ?>">
                        <input type="submit" name="delete_file" value="Delete" style="background:#dc3545;color:white;padding:6px 10px;border:none;border-radius:4px;cursor:pointer;">
                    </form>
                </td>
            </tr>
        <?php endforeach; ?>
    </table>
<?php else : ?>
    <p style="text-align:center;">No files uploaded yet.</p>
<?php endif; ?>
</div>
    </div>
</body>
</html>
