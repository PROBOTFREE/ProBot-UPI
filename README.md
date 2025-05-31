# 🤖 ProBot UPI

**ProBot UPI** is a lightweight and secure UPI payment integration system designed for web projects. It allows seamless QR-based UPI payments using custom payment links and supports validation with Paytm, GPay, and PhonePe.

---

## 🚀 Features

- 💸 Instant UPI Payments via QR
- ✅ Supports GPay, PhonePe, Paytm
- 🔒 Token-based secure download validation (for paid/protected resources)
- 📱 Mobile optimized with app redirection
- 🧾 Custom UPI links + Amount & Note support
- 🎨 Clean UI with SweetAlert integration

---

## 📸 Screenshots

<img src="https://your-screenshot-link.com/homepage.png" width="400"/>
<img src="https://your-screenshot-link.com/payment.png" width="400"/>

---

## 📁 Installation & Setup

### ✅ Step 1: Edit the Database Functions File

1. **Locate the File**  
   Navigate to: /pages/dbFunctions.php

2. **Make the Changes**  
- Replace all instances of:
  - `couponcart.in` → `yourdomain.com`
  - `probot_tohost_bot` → your actual **Telegram bot username**

---

### ✅ Step 2: Add Your Telegram Bot API Key

1. **Get Your Token**  
Use [@BotFather](https://t.me/BotFather) on Telegram to create a bot and obtain its API token.

2. **Edit `dbFunctions.php`**  
- Go to **line 337** and update:
  ```php
  $bot_token = 'YOURTGBOT'; // Replace with your bot's token
  ```
  Replace `'YOURTGBOT'` with your actual bot token.

3. **Edit `tg.php`**  
- File path:
  ```
  /public_html/tg.php
  ```
- Also update `'YOURTGBOT'` with the same bot token.

---

### ✅ Step 3: Activate Your Telegram Bot

1. **Run Activation URL in Browser**  
Visit:
https://yourdomain.com/tg.php

yaml
Copy
Edit

2. **Done!**  
Your Telegram bot is now active and will start sending payment alerts to your configured group or user.

---

## 🔁 Cron Job Setup

Automate payment status fetching using cronjobs.

### ⚙️ For cPanel

Set **time interval to every 1 minute** for any one of the following:

wget --spider -O - https://yourdomain.com/crons/cron.php >/dev/null 2>&1

curl --silent https://yourdomain.com/crons/cron.php

wget -O /dev/null https://yourdomain.com/crons/cron.php >/dev/null 2>&1

### ⚙️ For Hostinger

Use this command with a 1-minute interval:

wget -O /dev/null https://yourdomain.com/crons/cron.php

### 💸 UPI Payment Handling
System auto-detects payments via linked UPI ID.

Accepts any amount (e.g., ₹1 and above).

Real-time checking based on current date transactions.

Best used for merchant QR-based payments (Google Pay, PhonePe, etc.).

### 🌐 Cron URLs to Add
Ensure the following endpoints are added to your cron scheduler:

https://yourdomain.com/crons/cron.php
https://yourdomain.com/crons/cron1.php
https://yourdomain.com/crons/cron2.php
https://yourdomain.com/crons/cron3.php
https://yourdomain.com/crons/cron4.php

🧪 Testing
Pay ₹1 or more to your merchant UPI ID.

Monitor your Telegram for instant alerts.

Ensure cron is running (you can check manually by visiting cron URLs).

🛡️ Security Tips
Keep your Telegram bot token private.

Do not expose dbFunctions.php or cron files directly.

Consider using .htaccess or server-side firewalls to limit access.

📜 License
This project is licensed under the MIT License. Feel free to use, modify, and distribute.

🤝 Contributing
Pull requests and issues are welcome!
Fork the project, make changes, and submit a PR.

👨‍💻 Developed by
Shauryan Singh
GitHub: @PROBOTFREE

