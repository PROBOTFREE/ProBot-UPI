@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Applications</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Contact List</li>
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
                    <h6 class="mb-0 text-uppercase">Light Contact List</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-4">
                        <div class="col">
                            <div class="card radius-15">
                                <div class="card-body text-center">
                                    <div class="p-4 border radius-15">
                                        <img src="assets/images/avatars/avatar-1.png" width="110" height="110" class="rounded-circle shadow" alt="">
                                        <h5 class="mb-0 mt-5">Pauline I. Bird</h5>
                                        <p class="mb-3">Webdeveloper</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item bg-facebook text-white border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-twitter text-white border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-google text-white border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-linkedin text-white border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-outline-primary radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15">
                                <div class="card-body text-center">
                                    <div class="p-4 border radius-15">
                                        <img src="assets/images/avatars/avatar-2.png" width="110" height="110" class="rounded-circle shadow" alt="">
                                        <h5 class="mb-0 mt-5">Ralph L. Alva</h5>
                                        <p class="mb-3">UI Developer</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item bg-facebook text-white border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-twitter text-white border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-google text-white border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-linkedin text-white border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-outline-primary radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15">
                                <div class="card-body text-center">
                                    <div class="p-4 border radius-15">
                                        <img src="assets/images/avatars/avatar-3.png" width="110" height="110" class="rounded-circle shadow" alt="">
                                        <h5 class="mb-0 mt-5">John B. Roman</h5>
                                        <p class="mb-3">Graphic Designer</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item bg-facebook text-white border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-twitter text-white border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-google text-white border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-linkedin text-white border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-outline-primary radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15">
                                <div class="card-body text-center">
                                    <div class="p-4 border radius-15">
                                        <img src="assets/images/avatars/avatar-4.png" width="110" height="110" class="rounded-circle shadow" alt="">
                                        <h5 class="mb-0 mt-5">David O. Buckley</h5>
                                        <p class="mb-3">Android Developer</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item bg-facebook text-white border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-twitter text-white border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-google text-white border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item bg-linkedin text-white border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-outline-primary radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Color Contact List</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-4">
                        <div class="col">
                            <div class="card radius-15 bg-primary">
                                <div class="card-body text-center">
                                    <div class="p-4 radius-15">
                                        <img src="assets/images/avatars/avatar-9.png" width="110" height="110" class="rounded-circle shadow p-1 bg-white" alt="">
                                        <h5 class="mb-0 mt-5 text-white">Pauline I. Bird</h5>
                                        <p class="mb-3 text-white">Webdeveloper</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-white radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15 bg-danger">
                                <div class="card-body text-center">
                                    <div class="p-4 radius-15">
                                        <img src="assets/images/avatars/avatar-15.png" width="110" height="110" class="rounded-circle shadow p-1 bg-white" alt="">
                                        <h5 class="mb-0 mt-5 text-white">Pauline I. Bird</h5>
                                        <p class="mb-3 text-white">Webdeveloper</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-white radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15 bg-warning">
                                <div class="card-body text-center">
                                    <div class="p-4 radius-15">
                                        <img src="assets/images/avatars/avatar-7.png" width="110" height="110" class="rounded-circle shadow p-1 bg-white" alt="">
                                        <h5 class="mb-0 mt-5 text-dark">Pauline I. Bird</h5>
                                        <p class="mb-3 text-dark">Webdeveloper</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-white radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-15 bg-info">
                                <div class="card-body text-center">
                                    <div class="p-4 radius-15">
                                        <img src="assets/images/avatars/avatar-8.png" width="110" height="110" class="rounded-circle shadow p-1 bg-white" alt="">
                                        <h5 class="mb-0 mt-5 text-dark">Pauline I. Bird</h5>
                                        <p class="mb-3 text-dark">Webdeveloper</p>
                                        <div class="list-inline contacts-social mt-3 mb-3"> <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-facebook"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-twitter"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-google"></i></a>
                                            <a href="javascript:;" class="list-inline-item border-0"><i class="bx bxl-linkedin"></i></a>
                                        </div>
                                        <div class="d-grid"> <a href="#" class="btn btn-white radius-15">Contact Me</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection
