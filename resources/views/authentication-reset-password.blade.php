<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png" />
	<!-- loader-->
	<link href="assets/css/pace.min.css" rel="stylesheet" />
	<script src="assets/js/pace.min.js"></script>
	<!-- Bootstrap CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/bootstrap-extended.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
	<link href="assets/css/app.css" rel="stylesheet">
	<link href="assets/css/icons.css" rel="stylesheet">
	<title>Synadmin – Bootstrap5 Admin Template</title>
</head>

<body>
	<!-- wrapper -->
	<div class="wrapper">
		<div class="authentication-header"></div>
		 <div class="authentication-reset-password d-flex align-items-center justify-content-center">
			<div class="row">
				<div class="col-12 col-lg-10 mx-auto">
					<div class="card">
						<div class="row g-0">
							<div class="col-lg-5 border-end">
								<div class="card-body">
									<div class="p-5">
										<div class="text-start">
											<img src="assets/images/logo-img.png" width="180" alt="">
										</div>
										<h4 class="mt-5 font-weight-bold">Genrate New Password</h4>
										<p class="text-muted">We received your reset password request. Please enter your new password!</p>
										<div class="mb-3 mt-5">
											<label class="form-label">New Password</label>
											<input type="text" class="form-control" placeholder="Enter new password" />
										</div>
										<div class="mb-3">
											<label class="form-label">Confirm Password</label>
											<input type="text" class="form-control" placeholder="Confirm password" />
										</div>
										<div class="d-grid gap-2">
											<button type="button" class="btn btn-primary">Change Password</button> <a href="{{ url('authentication-signin') }}" class="btn btn-light"><i class='bx bx-arrow-back mr-1'></i>Back to Login</a>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<img src="assets/images/login-images/forgot-password-frent-img.jpg" class="card-img login-img h-100" alt="...">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end wrapper -->
</body>

</html>