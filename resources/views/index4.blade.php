@extends("layouts.app")

	@section("style")
	<link href="assets/plugins/highcharts/css/highcharts.css" rel="stylesheet" />
	@endsection

		@section("wrapper")
		<div class="page-wrapper">
			<div class="page-content">
				<div class="row row-cols-1 row-cols-lg-3">
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">Sessions</p>
										<h4 class="font-weight-bold">32,842 <small class="text-success font-13">(+40%)</small></h4>
										<p class="text-success mb-0 font-13">Analytics for last week</p>
									</div>
									<div class="widgets-icons bg-gradient-cosmic text-white"><i class='bx bx-refresh'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">Users</p>
										<h4 class="font-weight-bold">16,352 <small class="text-success font-13">(+22%)</small></h4>
										<p class="text-secondary mb-0 font-13">Analytics for last week</p>
									</div>
									<div class="widgets-icons bg-gradient-burning text-white"><i class='bx bx-group'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">Time on Site</p>
										<h4 class="font-weight-bold">34m 14s <small class="text-success font-13">(+55%)</small></h4>
										<p class="text-secondary mb-0 font-13">Analytics for last week</p>
									</div>
									<div class="widgets-icons bg-gradient-lush text-white"><i class='bx bx-time'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">Goal Completions</p>
										<h4 class="font-weight-bold">1,94,2335</h4>
										<p class="text-secondary mb-0 font-13">Analytics for last month</p>
									</div>
									<div class="widgets-icons bg-gradient-kyoto text-white"><i class='bx bxs-cube'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">Bounce Rate</p>
										<h4 class="font-weight-bold">58% <small class="text-danger font-13">(-16%)</small></h4>
										<p class="text-secondary mb-0 font-13">Analytics for last week</p>
									</div>
									<div class="widgets-icons bg-gradient-blues text-white"><i class='bx bx-line-chart'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div class="flex-grow-1">
										<p class="mb-0">New Sessions</p>
										<h4 class="font-weight-bold">96% <small class="text-danger font-13">(+54%)</small></h4>
										<p class="text-secondary mb-0 font-13">Analytics for last week</p>
									</div>
									<div class="widgets-icons bg-gradient-moonlit text-white"><i class='bx bx-bar-chart'></i>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<div class="row">
					<div class="col-12 col-lg-6">
						<div class="card radius-10">
							<div class="card-body">
								<div id="chart1"></div>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-6">
						<div class="card radius-10">
							<div class="card-body">
								<div id="chart2"></div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<div class="row">
					<div class="col-12 col-lg-8 d-lg-flex align-items-lg-stretch">
						<div class="card radius-10 w-100">
							<div class="card-header border-bottom-0 bg-transparent">
								<div class="d-lg-flex align-items-center">
									<div class="">
										<h5 class="mb-1">Website Audience Overview</h5>
										<p class="text-secondary mb-2 mb-lg-0 font-14">There are plenty of free web proxy sites that you can use</p>
									</div>
									<div class="ms-lg-auto">
										<div class="btn-group-round">
											<div class="btn-group">
												<button type="button" class="btn btn-white">Day</button>
												<button type="button" class="btn btn-white">Week</button>
												<button type="button" class="btn btn-white">Month</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div id="chart3"></div>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-4 d-lg-flex align-items-lg-stretch">
						<div class="card radius-10 w-100">
							<div class="card-header bg-transparent">Traffic Sources</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-striped mb-0">
										<thead>
											<tr>
												<th>Source</th>
												<th>Visitors</th>
												<th>Bounce Rate</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>(direct)</td>
												<td>56</td>
												<td>10%</td>
											</tr>
											<tr>
												<td>google</td>
												<td>29</td>
												<td>12%</td>
											</tr>
											<tr>
												<td>linkedin.com</td>
												<td>68</td>
												<td>33%</td>
											</tr>
											<tr>
												<td>bing</td>
												<td>14</td>
												<td>24%</td>
											</tr>
											<tr>
												<td>facebook.com</td>
												<td>87</td>
												<td>22%</td>
											</tr>
											<tr>
												<td>other</td>
												<td>98</td>
												<td>27%</td>
											</tr>
											<tr>
												<td>linkedin.com</td>
												<td>68</td>
												<td>33%</td>
											</tr>
											<tr>
												<td>bing</td>
												<td>14</td>
												<td>24%</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
                
				<div class="row row-cols-1 row-cols-lg-3">
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div id="chart4"></div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div id="chart5"></div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10">
							<div class="card-body">
								<div id="chart6"></div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		@endsection
		
	@section("script")
	<!-- highcharts js -->
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
	<script src="assets/js/index4.js"></script>
	<script>
		$("html").attr("class","color-sidebar sidebarcolor3");
	</script>
	@endsection