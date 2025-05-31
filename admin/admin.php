<?php
// Ensure $panel and $admin are initialized
$panel = isset($panel) ? $panel : [];  // If $panel is not set, initialize it as an empty array
$admin = isset($admin) ? $admin : [];  // If $admin is not set, initialize it as an empty array

// Combine the suspended and frozen conditions into one block
if( in_array($panel["panel_status"] ?? "", ["suspended", "frozen"]) ):
    include 'app/views/frozen.twig';
    exit();
endif;

// Ensure the admin access check
if( isset($admin["access"]["admin_access"]) && $admin["access"]["admin_access"] && $_SESSION["msmbilisim_adminlogin"] && $admin["client_type"] == 2 ):
    
    // Set default route[1] to "index" if it isn't already set
    if( !isset($route[1]) || !route(1) ){
        $route[1] = "index";
    }

    // Check if the controller file exists, else default to "index"
    if( !file_exists(admin_controller(route(1))) ){
        $route[1] = "index";
    }

    // Require the appropriate admin controller
    require admin_controller(route(1));
else:
    // If no admin access, redirect to the login route
    $route[1] = "login";
    require admin_controller(route(1));
endif;
