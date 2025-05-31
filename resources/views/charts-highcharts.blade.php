@extends("layouts.app")
	@section("style")
	<link href="assets/plugins/highcharts/css/highcharts.css" rel="stylesheet" />
	@endsection

		@section("wrapper")
            <div class="page-wrapper">
            <div class="page-content">
                <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                    <div class="breadcrumb-title pe-3">Charts</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Highcharts</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary">Settings</button>
                            <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown"> <span class="visually-hidden">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">    <a class="dropdown-item" href="javascript:;">Action</a>
                                <a class="dropdown-item" href="javascript:;">Another action</a>
                                <a class="dropdown-item" href="javascript:;">Something else here</a>
                                <div class="dropdown-divider"></div>    <a class="dropdown-item" href="javascript:;">Separated link</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end breadcrumb-->
                <div class="row">
                    <div class="col-xl-12 mx-auto">
                        <div class="card">
                            <div class="card-body">
                                <div id="chart12"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart13"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart14"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart15"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart1"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart2"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart3"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart4"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart5"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart6"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart7"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart8"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart9"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart10"></div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div id="chart11"></div>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <!--end row-->
            </div>
        </div>
		@endsection

@section("script")
<script src="assets/plugins/highcharts/js/highcharts.js"></script>
<script src="assets/plugins/highcharts/js/highcharts-more.js"></script>
<script src="assets/plugins/highcharts/js/variable-pie.js"></script>
<script src="assets/plugins/highcharts/js/solid-gauge.js"></script>
<script src="assets/plugins/highcharts/js/highcharts-3d.js"></script>
<script src="assets/plugins/highcharts/js/cylinder.js"></script>
<script src="assets/plugins/highcharts/js/funnel3d.js"></script>
<script src="assets/plugins/highcharts/js/exporting.js"></script>
<script src="assets/plugins/highcharts/js/export-data.js"></script>
<script src="assets/plugins/highcharts/js/accessibility.js"></script>
<script src="assets/plugins/highcharts/js/highcharts-custom.script.js"></script>
@endsection
