		@extends("layouts.app")
		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Pricing Tables</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Pricing Tables</li>
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
                    <!-- Section: Pricing table -->
                    <div class="pricing-table">
                        <h6 class="mb-0 text-uppercase">Basic Pricing Tables</h6>
                        <hr/>
                        <div class="row row-cols-1 row-cols-lg-3">
                            <!-- Free Tier -->
                            <div class="col">
                                <div class="card mb-5 mb-lg-0">
                                    <div class="card-header bg-danger py-3">
                                        <h5 class="card-title text-white text-uppercase text-center">Free</h5>
                                        <h6 class="card-price text-white text-center">$0<span class="term">/month</span></h6>
                                    </div>
                                    <div class="card-body">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item text-secondary"><i class='bx bx-x me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item text-secondary"><i class='bx bx-x me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item text-secondary"><i class='bx bx-x me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item text-secondary"><i class='bx bx-x me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-danger my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Plus Tier -->
                            <div class="col">
                                <div class="card mb-5 mb-lg-0">
                                    <div class="card-header bg-primary py-3">
                                        <h5 class="card-title text-white text-uppercase text-center">Plus</h5>
                                        <h6 class="card-price text-white text-center">$9<span class="term">/month</span></h6>
                                    </div>
                                    <div class="card-body">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item text-secondary"><i class='bx bx-x me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-primary my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Pro Tier -->
                            <div class="col">
                                <div class="card">
                                    <div class="card-header bg-warning py-3">
                                        <h5 class="card-title text-dark text-uppercase text-center">Pro</h5>
                                        <h6 class="card-price text-center">$49<span class="term">/month</span></h6>
                                    </div>
                                    <div class="card-body">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item"><i class='bx bx-check me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-warning my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end row-->
                        <h6 class="mb-0 text-uppercase">Color Pricing Tables</h6>
                        <hr/>
                        <div class="row row-cols-1 row-cols-lg-3">
                            <!-- Free Tier -->
                            <div class="col">
                                <div class="card mb-5 mb-lg-0 bg-info">
                                    <div class="card-body">
                                        <h5 class="card-title grey-text text-uppercase text-center">Free</h5>
                                        <h6 class="card-price text-center">$0<span class="term">/month</span></h6>
                                        <hr class="my-4">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item bg-transparent"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-x me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-x me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-x me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item bg-transparent"><i class='bx bx-x me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-white my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Plus Tier -->
                            <div class="col">
                                <div class="card mb-5 mb-lg-0 bg-success">
                                    <div class="card-body">
                                        <h5 class="card-title text-white text-uppercase text-center">Plus</h5>
                                        <h6 class="card-price text-white text-center">$9<span class="term">/month</span></h6>
                                        <hr class="my-4">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-x me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-white my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Pro Tier -->
                            <div class="col">
                                <div class="card bg-primary">
                                    <div class="card-body">
                                        <h5 class="card-title text-white text-uppercase text-center">Pro</h5>
                                        <h6 class="card-price text-white text-center">$49<span class="term">/month</span></h6>
                                        <hr class="my-4">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Single User</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>5GB Storage</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Unlimited Public Projects</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Community Access</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Unlimited Private Projects</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Dedicated Phone Support</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Free Subdomain</li>
                                            <li class="list-group-item bg-transparent text-white"><i class='bx bx-check me-2 font-18'></i>Monthly Status Reports</li>
                                        </ul>
                                        <div class="d-grid"> <a href="#" class="btn btn-white my-2 radius-30">Order Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end row-->
                    </div>
                    <!-- Section: Pricing table -->
                </div>
            </div>
		@endsection



