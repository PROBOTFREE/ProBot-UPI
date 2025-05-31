		@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Widget</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Widgets</li>
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
                    <h6 class="mb-0 text-uppercase">Data Widgets</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
                        <div class="col">
                            <div class="card radius-10 ">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Users</p>
                                            <h5 class="mb-0">85,028</h5>
                                        </div>
                                        <div class="dropdown ms-auto">
                                            <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown">	<i class='bx bx-dots-horizontal-rounded font-22'></i>
                                            </div>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="javascript:;">Action</a>
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Another action</a>
                                                </li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Something else here</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="" id="w-chart1"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Page Views</p>
                                            <h5 class="mb-0">42,892</h5>
                                        </div>
                                        <div class="dropdown ms-auto">
                                            <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown">	<i class='bx bx-dots-horizontal-rounded font-22'></i>
                                            </div>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="javascript:;">Action</a>
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Another action</a>
                                                </li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Something else here</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="" id="w-chart2"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Avg. Session Duration</p>
                                            <h5 class="mb-0">00:03:20</h5>
                                        </div>
                                        <div class="dropdown ms-auto">
                                            <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown">	<i class='bx bx-dots-horizontal-rounded font-22'></i>
                                            </div>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="javascript:;">Action</a>
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Another action</a>
                                                </li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Something else here</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="" id="w-chart3"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Bounce Rate</p>
                                            <h5 class="mb-0">51.46%</h5>
                                        </div>
                                        <div class="dropdown ms-auto">
                                            <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown">	<i class='bx bx-dots-horizontal-rounded font-22'></i>
                                            </div>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="javascript:;">Action</a>
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Another action</a>
                                                </li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li><a class="dropdown-item" href="javascript:;">Something else here</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="" id="w-chart4"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Orders</p>
                                            <h5 class="mb-0">867</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-cart font-30'></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="" id="w-chart5"></div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Income</p>
                                            <h5 class="mb-0">$52,945</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-wallet font-30'></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="" id="w-chart6"></div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Users</p>
                                            <h5 class="mb-0">24.5K</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-bulb font-30'></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="" id="w-chart7"></div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Comments</p>
                                            <h5 class="mb-0">869</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-chat font-30'></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="" id="w-chart8"></div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Orders</p>
                                            <h5 class="mb-0">867</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-cart font-30'></i>
                                        </div>
                                    </div>
                                    <div class="progress radius-10 mt-4" style="height:4.5px;">
                                        <div class="progress-bar bg-primary" role="progressbar" style="width: 46%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Income</p>
                                            <h5 class="mb-0">$52,945</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-wallet font-30'></i>
                                        </div>
                                    </div>
                                    <div class="progress radius-10 mt-4" style="height:4.5px;">
                                        <div class="progress-bar bg-danger" role="progressbar" style="width: 72%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Total Users</p>
                                            <h5 class="mb-0">24.5K</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-bulb font-30'></i>
                                        </div>
                                    </div>
                                    <div class="progress radius-10 mt-4" style="height:4.5px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 68%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 overflow-hidden">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0">Comments</p>
                                            <h5 class="mb-0">869</h5>
                                        </div>
                                        <div class="ms-auto">	<i class='bx bx-chat font-30'></i>
                                        </div>
                                    </div>
                                    <div class="progress radius-10 mt-4" style="height:4.5px;">
                                        <div class="progress-bar bg-info" role="progressbar" style="width: 66%"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Static Widgets</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Revenue</p>
                                            <h4 class="my-1">$4805</h4>
                                            <p class="mb-0 font-13 text-success"><i class="bx bxs-up-arrow align-middle"></i>$34 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-light-success text-success ms-auto"><i class="bx bxs-wallet"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Total Customers</p>
                                            <h4 class="my-1">8.4K</h4>
                                            <p class="mb-0 font-13 text-success"><i class='bx bxs-up-arrow align-middle'></i>$24 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-light-info text-info ms-auto"><i class='bx bxs-group'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Store Visitors</p>
                                            <h4 class="my-1">59K</h4>
                                            <p class="mb-0 font-13 text-danger"><i class='bx bxs-down-arrow align-middle'></i>$34 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-light-danger text-danger ms-auto"><i class='bx bxs-binoculars'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Bounce Rate</p>
                                            <h4 class="my-1">34.46%</h4>
                                            <p class="mb-0 font-13 text-danger"><i class='bx bxs-down-arrow align-middle'></i>12.2% from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-light-warning text-warning ms-auto"><i class='bx bx-line-chart-down'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Chrome Users</p>
                                            <h4 class="my-1">42K</h4>
                                        </div>
                                        <div class="text-primary ms-auto font-35"><i class='bx bxl-chrome'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Github Users</p>
                                            <h4 class="my-1">56M</h4>
                                        </div>
                                        <div class="text-danger ms-auto font-35"><i class='bx bxl-github'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Firefox Users</p>
                                            <h4 class="my-1">42M</h4>
                                        </div>
                                        <div class="text-warning ms-auto font-35"><i class='bx bxl-firefox'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-secondary">Shopify Users</p>
                                            <h4 class="my-1">85M</h4>
                                        </div>
                                        <div class="text-success ms-auto font-35"><i class='bx bxl-shopify'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <div class="row row-cols-1 row-cols-md-3 row-cols-xl-5">
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="widgets-icons rounded-circle mx-auto bg-light-primary text-primary mb-3"><i class='bx bxl-facebook-square'></i>
                                        </div>
                                        <h4 class="my-1">84K</h4>
                                        <p class="mb-0 text-secondary">Facebook Users</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="widgets-icons rounded-circle mx-auto bg-light-danger text-danger mb-3"><i class='bx bxl-twitter'></i>
                                        </div>
                                        <h4 class="my-1">34M</h4>
                                        <p class="mb-0 text-secondary">Twitter Followers</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="widgets-icons rounded-circle mx-auto bg-light-info text-info mb-3"><i class='bx bxl-linkedin-square'></i>
                                        </div>
                                        <h4 class="my-1">56K</h4>
                                        <p class="mb-0 text-secondary">Linkedin Followers</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="widgets-icons rounded-circle mx-auto bg-light-success text-success mb-3"><i class='bx bxl-youtube'></i>
                                        </div>
                                        <h4 class="my-1">38M</h4>
                                        <p class="mb-0 text-secondary">YouTube Subscribers</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="widgets-icons rounded-circle mx-auto bg-light-warning text-warning mb-3"><i class='bx bxl-dropbox'></i>
                                        </div>
                                        <h4 class="my-1">28K</h4>
                                        <p class="mb-0 text-secondary">Dropbox Users</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Color Static Widgets</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
                        <div class="col">
                            <div class="card radius-10 bg-primary bg-gradient">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-white">Total Orders</p>
                                            <h4 class="my-1 text-white">845</h4>
                                        </div>
                                        <div class="text-white ms-auto font-35"><i class='bx bx-cart-alt'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-danger bg-gradient">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-white">Total Income</p>
                                            <h4 class="my-1 text-white">$89,245</h4>
                                        </div>
                                        <div class="text-white ms-auto font-35"><i class='bx bx-dollar'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-warning bg-gradient">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-dark">Total Users</p>
                                            <h4 class="text-dark my-1">24.5K</h4>
                                        </div>
                                        <div class="text-dark ms-auto font-35"><i class='bx bx-user-pin'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-success bg-gradient">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-white">Comments</p>
                                            <h4 class="my-1 text-white">8569</h4>
                                        </div>
                                        <div class="text-white ms-auto font-35"><i class='bx bx-comment-detail'></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-success">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-white">Revenue</p>
                                            <h4 class="my-1 text-white">$4805</h4>
                                            <p class="mb-0 font-13 text-white"><i class="bx bxs-up-arrow align-middle"></i>$34 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-white text-success ms-auto"><i class="bx bxs-wallet"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-info">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-dark">Total Customers</p>
                                            <h4 class="my-1 text-dark">8.4K</h4>
                                            <p class="mb-0 font-13 text-dark"><i class="bx bxs-up-arrow align-middle"></i>$24 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-white text-dark ms-auto"><i class="bx bxs-group"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-danger">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-white">Store Visitors</p>
                                            <h4 class="my-1 text-white">59K</h4>
                                            <p class="mb-0 font-13 text-white"><i class="bx bxs-down-arrow align-middle"></i>$34 from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-white text-danger ms-auto"><i class="bx bxs-binoculars"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card radius-10 bg-warning">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <p class="mb-0 text-dark">Bounce Rate</p>
                                            <h4 class="my-1 text-dark">34.46%</h4>
                                            <p class="mb-0 font-13 text-dark"><i class="bx bxs-down-arrow align-middle"></i>12.2% from last week</p>
                                        </div>
                                        <div class="widgets-icons bg-white text-dark ms-auto"><i class='bx bx-line-chart-down'></i>
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

	@section("script")
	@parent
	<script src="assets/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
	<script src="assets/js/widgets.js"></script>
	@endsection
