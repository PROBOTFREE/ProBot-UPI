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
                                    <li class="breadcrumb-item active" aria-current="page">Carousels</li>
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
                    <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Slides only</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/gallery/17.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/18.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/19.png" class="d-block w-100" alt="...">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">With controls</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/gallery/20.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/21.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/22.png" class="d-block w-100" alt="...">
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">With controls</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                        <ol class="carousel-indicators">
                                            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
                                            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
                                            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
                                        </ol>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/gallery/23.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/24.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/25.png" class="d-block w-100" alt="...">
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">With captions</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                                        <ol class="carousel-indicators">
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"></li>
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li>
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></li>
                                        </ol>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/gallery/26.png" class="d-block w-100" alt="...">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h5>First slide label</h5>
                                                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/27.png" class="d-block w-100" alt="...">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h5>Second slide label</h5>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/28.png" class="d-block w-100" alt="...">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h5>Third slide label</h5>
                                                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">With Crossfade</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/gallery/29.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/30.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/31.png" class="d-block w-100" alt="...">
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Individual Interval</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active" data-bs-interval="10000">
                                                <img src="assets/images/gallery/32.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item" data-bs-interval="2000">
                                                <img src="assets/images/gallery/33.png" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/gallery/34.png" class="d-block w-100" alt="...">
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="visually-hidden">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Dark Variant</h6>
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"></li>
                                    <li data-bs-target="#carouselExampleDark" data-bs-slide-to="1"></li>
                                    <li data-bs-target="#carouselExampleDark" data-bs-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active" data-bs-interval="10000">
                                        <img src="assets/images/gallery/26.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>First slide label</h5>
                                            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item" data-bs-interval="2000">
                                        <img src="assets/images/gallery/33.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Second slide label</h5>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="assets/images/gallery/22.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Third slide label</h5>
                                            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                                        </div>
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleDark" role="button" data-bs-slide="prev">	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleDark" role="button" data-bs-slide="next">	<span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection
