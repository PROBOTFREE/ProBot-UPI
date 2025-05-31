<?php


// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');



$folderPath = 'temp_dir/';

// Function to check if a file name starts with a letter from A to Z
function startsWithLetter($filename) {
    return preg_match('/^[A-Za-z]/', basename($filename));
}

// Get all files in the folder
$files = glob($folderPath . '*');

$filesDeleted = false; // Variable to keep track of whether any files were deleted

// Loop through the files and remove those that start with a letter from A to Z or are zip files
foreach ($files as $file) {
    if (is_file($file) && (startsWithLetter($file) || pathinfo($file, PATHINFO_EXTENSION) === 'zip')) {
        // Use unlink to remove the file
        if (unlink($file)) {
            $filesDeleted = true; // Set the flag to true if any file is deleted
            //echo "Deleted file: " . basename($file) . "\n";
        }
    }
}

?>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

 <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
  <!--bootstrap css-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Material+Symbols+Rounded" rel="stylesheet">
  <!--main css-->
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
  <link href="sass/main.css" rel="stylesheet">
  <link href="sass/dark-theme.css" rel="stylesheet">
  <link href="sass/semi-dark.css" rel="stylesheet">
  <link href="sass/bordered-theme.css" rel="stylesheet">
  <link href="sass/responsive.css" rel="stylesheet">
  
  <!-- SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>



 <!--start main wrapper-->
  <main class="main-wrapper">
    <div class="main-content">
      <!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Plugin</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">SDK</li>
							</ol>
						</nav>
					</div>
				</div>
				<!--end breadcrumb-->
      
        <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-4">

<!--<div class="col">-->
<!--    <div class="card">-->
<!--        <div class="card-body">-->
<!--            <h5 class="card-title mb-4">Color Prediction SDK</h5>-->
<!--            <p class="card-text mb-4">Our Color Prediction SDK Kit  equips you to interact and  with our Qr Gateway API in your Color Prediction web applications smoothly.</p>-->
<!--            <a href="download?sdk=color_v" class="btn btn-primary w-100 raised">Download</a>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->

<!-- Trova Color prediction Kit -->
<!--<div class="col">-->
<!--    <div class="card">-->
<!--        <div class="card-body">-->
<!--            <h5 class="card-title mb-4">Trova Color Prediction SDK</h5>-->
<!--            <p class="card-text mb-4">The Trova Color Prediction SDK provides the resources to integrate our API into Trova web applications smoothly.</p>-->
<!--            <a href="download?sdk=trovacolor_v" class="btn btn-danger w-100 raised">Download</a>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->

<!-- WHMCS Kit -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">WHMCS SDK</h5>
            <p class="card-text mb-4">The WHMCS SDK provides essential tools to effortlessly connect our powerful API with your WHMCS panel, ensuring seamless.</p>
            <a href="download?sdk=whmcs" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- SMM PANEL Kit -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">SMM Panel SDK</h5>
            <p class="card-text mb-4">The SMM Panel SDK supplies essential resources to integrate our API with your SMM Panel platform seamlessly and efficiently.</p>
            <a href="download?sdk=smm" class="btn btn-warning w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Power Bank Kit -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Power Bank SDK</h5>
            <p class="card-text mb-4">The Power Bank SDK equips you with resources to integrate our API into your Power Bank web applications seamlessly.</p>
            <a href="download?sdk=powerbank_v" class="btn btn-danger w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- ALASMART Kit -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">AlasMart SDK</h5>
            <p class="card-text mb-4">The AlasMart SDK equips you with resources to integrate our API into your AlasMart Laravel web applications seamlessly.</p>
            <a href="download?sdk=alasmart" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- PHP SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">PHP SDK</h5>
            <p class="card-text mb-4">The PHP SDK provides powerful tools to easily interact with our API in your PHP-based web applications effortlessly.</p>
            <a href="download?sdk=php" class="btn btn-warning w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Android SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Android SDK</h5>
            <p class="card-text mb-4">The Android SDK allows seamless integration of our advanced services into your Android applications with ease.</p>
            <a href="download?sdk=android" class="btn btn-danger w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Java SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Java SDK</h5>
            <p class="card-text mb-4">The Java SDK provides powerful tools to easily integrate our API into your Java applications.</p>
            <a href="download?sdk=java" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Python SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Python SDK</h5>
            <p class="card-text mb-4">The Python SDK allows for seamless integration of our advanced features into your Python applications.</p>
            <a href="download?sdk=python" class="btn btn-warning w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- C# SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">C# SDK</h5>
            <p class="card-text mb-4">The C# SDK enhances your .NET projects by integrating our API seamlessly into your .NET applications.</p>
            <a href="download?sdk=csharp" class="btn btn-danger w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Ruby SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Ruby SDK</h5>
            <p class="card-text mb-4">The Ruby SDK allows easy integration of our API with your Ruby on Rails applications seamlessly.</p>
            <a href="download?sdk=ruby" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- JavaScript SDK -->
<!--<div class="col">-->
<!--    <div class="card">-->
<!--        <div class="card-body">-->
<!--            <h5 class="card-title mb-4">JavaScript SDK</h5>-->
<!--            <p class="card-text mb-4">The JavaScript SDK provides tools to build dynamic web applications effortlessly with our API integration.</p>-->
<!--            <a href="download?sdk=javascript" class="btn btn-warning w-100 raised">Download</a>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->

<!-- C++ SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">C++ SDK</h5>
            <p class="card-text mb-4">The C++ SDK leverages powerful C++ libraries for seamless integration of our API into your projects.</p>
            <a href="download?sdk=cpp" class="btn btn-danger w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Kotlin SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Kotlin SDK</h5>
            <p class="card-text mb-4">The Kotlin SDK boosts Android development by integrate our features into your Kotlin app.</p>
            <a href="download?sdk=kotlin" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- TypeScript SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">TypeScript SDK</h5>
            <p class="card-text mb-4">The TypeScript SDK builds robust web applications with seamless integration of our API and TypeScript.</p>
            <a href="download?sdk=typescript" class="btn btn-warning w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- WordPress SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">WordPress SDK</h5>
            <p class="card-text mb-4">The WordPress SDK enhances your site by seamlessly integrating our custom API with your WordPress applications.</p>
            <a href="download?sdk=wordpress" class="btn btn-danger w-100 raised">Download</a>
        </div>
    </div>
</div>

<!-- Swift SDK -->
<div class="col">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title mb-4">Swift SDK</h5>
            <p class="card-text mb-4">The Swift SDK integrates powerful new features into your iOS apps effortlessly for seamless and efficient user experiences.</p>
            <a href="download?sdk=swift" class="btn btn-success w-100 raised">Download</a>
        </div>
    </div>
</div>
 
          
        </div><!--end row-->

    </div>
  </main>

  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>
  


</body>

</html>