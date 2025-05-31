	@extends("layouts.app")
	@section("style")
	<link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
	@endsection
	
		@section("wrapper")
		<div class="page-wrapper">
			<div class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Maps</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Vector Maps</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-light">Settings</button>
							<button type="button" class="btn btn-light dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
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
				<div class="row">
					<div class="col-xl-9 mx-auto">
						<h6 class="text-uppercase">World Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="world-map-markers" style="height: 300px"></div>
							</div>
						</div>
						<h6 class="text-uppercase">India</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="india" style="height: 350px"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Usa</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="usa" style="height: 350px"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Australia Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="australia" style="height: 350px"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Uk Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="uk" style="height: 350px"></div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
			</div>
		</div>
		@endsection
		
	
	@section("script")
	<!-- Vector map JavaScript -->
	<script src="assets/plugins/vectormap/jquery-jvectormap-2.0.2.min.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-in-mill.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-us-aea-en.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-uk-mill-en.js"></script>
	<script src="assets/plugins/vectormap/jquery-jvectormap-au-mill.js"></script>
	<script src="assets/plugins/vectormap/jvectormap.custom.js"></script>
	@endsection
