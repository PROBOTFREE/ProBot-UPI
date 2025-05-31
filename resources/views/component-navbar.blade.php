		@extends("layouts.app")
		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Components</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Navbars</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="ms-auto">
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary">Settings</button>
                                <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
                                    <a class="dropdown-item" href="javascript:;">Another action</a>
                                    <a class="dropdown-item" href="javascript:;">Something else here</a>
                                    <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end breadcrumb-->
                    <div class="card">
                        <div class="card-body">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
                                <div class="container-fluid">	<a class="navbar-brand" href="#">Navbar</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#"><i class='bx bx-home-alt me-1'></i>Home</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-user me-1'></i>About</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-category-alt me-1'></i>Features</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-microphone me-1'></i>Contact</a>
                                            </li>
                                            <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    Dropdown
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <form class="d-flex nav-search">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Some" />
                                                <button class="btn" type="submit"><i class='bx bx-search'></i>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded">
                                <div class="container-fluid">	<a class="navbar-brand" href="#">Navbar</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent2" aria-controls="navbarSupportedContent2" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#"><i class='bx bx-home-alt me-1'></i>Home</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-user me-1'></i>About</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-category-alt me-1'></i>Features</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-microphone me-1'></i>Contact</a>
                                            </li>
                                            <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    Dropdown
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <form class="d-flex">
                                            <button class="btn btn-light px-4" type="submit"><i class='bx bx-cart'></i> Buy Now</button>
                                        </form>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-danger rounded">
                                <div class="container-fluid">	<a class="navbar-brand" href="#">Navbar</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent3" aria-controls="navbarSupportedContent3" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent3">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#"><i class='bx bx-home-alt me-1'></i>Home</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-user me-1'></i>About</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-category-alt me-1'></i>Features</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-microphone me-1'></i>Contact</a>
                                            </li>
                                            <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    Dropdown
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <form class="d-flex">
                                            <button class="btn btn-dark me-3 radius-30 px-4" type="submit"><i class='bx bx-lock'></i> Login</button>
                                            <button class="btn btn-light radius-30 px-4" type="submit"><i class='bx bx-user'></i> Register</button>
                                        </form>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-success rounded">
                                <div class="container-fluid">	<a class="navbar-brand" href="#">Navbar</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent4" aria-controls="navbarSupportedContent4" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent4">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#"><i class='bx bx-home-alt me-1'></i>Home</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-user me-1'></i>About</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-category-alt me-1'></i>Features</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-microphone me-1'></i>Contact</a>
                                            </li>
                                            <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    Dropdown
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bxl-facebook-square font-22 text-white'></i></a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bxl-twitter font-22 text-white'></i></a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bxl-linkedin-square font-22 text-white'></i></a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bxl-youtube font-22 text-white'></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-secondary rounded">
                                <div class="container-fluid">	<a class="navbar-brand" href="#">Navbar</a>
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent5" aria-controls="navbarSupportedContent5" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent5">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#"><i class='bx bx-home-alt me-1'></i>Home</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-user me-1'></i>About</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-category-alt me-1'></i>Features</a>
                                            </li>
                                            <li class="nav-item"> <a class="nav-link" href="#"><i class='bx bx-microphone me-1'></i>Contact</a>
                                            </li>
                                            <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    Dropdown
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <form class="d-flex">
                                            <button class="btn btn-dark me-3 radius-30 px-4" type="submit"><i class='bx bx-lock'></i> Login</button>
                                            <button class="btn btn-light radius-30 px-4" type="submit"><i class='bx bx-calendar-event'></i> Start For Free</button>
                                        </form>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
		@endsection
