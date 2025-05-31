@extends("layouts.app")

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
                                <li class="breadcrumb-item active" aria-current="page">Chartjs</li>
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
                    <div class="col">
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Bar Chart</h6>
                                 <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart2"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Line Chart</h6>
                               <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart1"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Pie Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart3"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Radar Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart4"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Polar Area Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart5"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Doughnut Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart6"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Horizontal Bar Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart7"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Grouped Bar Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart8"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Mixed Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart9"></canvas>
                                </div>
                            </div>
                        </div>
                        
                        <div class="card">
                            <div class="card-body">
                                <h6 class="mb-0 text-uppercase">Bubble Chart</h6>
                        <hr/>
                                <div class="chart-container1">
                                    <canvas id="chart10"></canvas>
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
<script src="assets/plugins/chartjs/js/Chart.min.js"></script>
<script src="assets/plugins/chartjs/js/chartjs-custom.js"></script>
@endsection
