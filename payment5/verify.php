<?php
// Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Validate TransactionId - it should be set, not empty, and alphanumeric
    if (isset($_POST["TransactionId"]) && !empty($_POST["TransactionId"]) && ctype_alnum($_POST["TransactionId"])) {
        $byteTransactionId = $_POST["TransactionId"];
    } else {
        echo "Error: Invalid TransactionId.";
        exit;
    }

    // Validate redirect_url - it should be set, not empty, and a valid URL
    if (isset($_POST['redirect_url']) && !empty($_POST['redirect_url']) && filter_var($_POST['redirect_url'], FILTER_VALIDATE_URL)) {
        $cancelurl = $_POST['redirect_url'];
    } else {
        echo "Error: Invalid redirect URL.";
        exit;
    }

    // Proceed with your processing using $byteTransactionId and $cancelurl
    // For example, validating the transaction, updating database, etc.
} else {
    // Handle the error - the form was not submitted correctly
    echo "Error: try again later.";
    exit;
}
?>


<!DOCTYPE html>
<html>
<head>
    <title>UTR Number Form</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        /* Custom CSS for SweetAlert2 on mobile devices */
        @media (max-width: 768px) {
            .swal2-popup {
                font-size: 12px; /* Adjust font size */
                width: 90% !important; /* Adjust width to fit screen */
            }
            .swal2-title {
                font-size: 16px; /* Adjust title font size */
            }
            .swal2-content {
                font-size: 14px; /* Adjust content font size */
            }
            .swal2-button {
                font-size: 14px; /* Adjust button font size */
            }
        }
    </style>
</head>
<body>


<script>
document.addEventListener('DOMContentLoaded', function() {
    Swal.fire({
        title: 'Enter UTR Number',
        input: 'text',
        inputAttributes: {
            autocapitalize: 'off',
            oninput: "this.value = this.value.replace(/\\D/g, '').slice(0, 12);"
        },
        showCancelButton: true,
        confirmButtonText: 'Submit',
        showLoaderOnConfirm: true,
        preConfirm: (utr) => {
            let formData = new FormData();
            formData.append('utr', utr);
            formData.append('TransactionId', '<?php echo $byteTransactionId; ?>');

            return fetch('https://couponcart.in/order5/payment-status', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error(response.statusText);
                }
                return response.json();
            })
            .catch(error => {
                Swal.showValidationMessage(`Request failed: ${error}`);
            });
        },
        allowOutsideClick: () => !Swal.isLoading()
    }).then((result) => {
        if (result.isConfirmed && result.value && result.value.status === 'success') {
            Swal.fire({
                title: 'Payment Received Successfully!',
                icon: 'success'
            }).then(() => {
                window.location.href = result.value.redirect_url;
            });
        } else if (result.isConfirmed && result.value && result.value.status === 'pending') {
            Swal.fire({
                title: 'Payment Pending',
                text: 'Please wait, your transaction is still processing.',
                icon: 'warning'
            }).then(() => {
                window.location.href = result.value.redirect_url;
            });
        }else if (result.isConfirmed && result.value && result.value.status === 'invalid') {
            Swal.fire({
                title: 'Payment Pending',
                text: 'Please wait, your transaction is invalid.',
                icon: 'warning'
            }).then(() => {
                window.location.href = result.value.redirect_url;
            });    
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            // Redirect to the cancel URL when cancel button is clicked
            window.location.href = '<?php echo $cancelurl; ?>';
        }
    });
});
</script>

</body>
</html>
