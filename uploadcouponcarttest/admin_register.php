<?php
include 'config.php'; // your DB connection
$error = '';
$success = '';

/*if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = trim($_POST['username'] ?? '');
    $password = trim($_POST['password'] ?? '');
    $confirm = trim($_POST['confirm'] ?? '');

    if (empty($username) || empty($password)) {
        $error = "Please fill in all fields.";
    } elseif ($password !== $confirm) {
        $error = "Passwords do not match.";
    } else {
        $hash = password_hash($password, PASSWORD_DEFAULT);

        // Check if username already exists
        $stmt = $conn->prepare("SELECT id FROM admin WHERE username = ?");
        $stmt->bind_param("s", $username);
        $stmt->execute();
        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            $error = "Username already exists.";
        } else {
            // Insert new admin
            $stmt = $conn->prepare("INSERT INTO admin (username, password) VALUES (?, ?)");
            $stmt->bind_param("ss", $username, $hash);
            if ($stmt->execute()) {
                $success = "Admin user created successfully.";
            } else {
                $error = "Error creating admin user.";
            }
        }
    }
}*/
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Admin</title>
    <style>
        body {
            background: #eef2f7;
            font-family: Arial, sans-serif;
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }

        .register-container {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 420px;
        }

        h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #4caf50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
        }

        button:hover {
            background: #45a049;
        }

        .error, .success {
            text-align: center;
            margin-bottom: 16px;
        }

        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Register Admin</h2>
        <?php if ($error): ?>
            <div class="error"><?= htmlspecialchars($error) ?></div>
        <?php elseif ($success): ?>
            <div class="success"><?= htmlspecialchars($success) ?></div>
        <?php endif; ?>
        <form method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="confirm" placeholder="Confirm Password" required>
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
