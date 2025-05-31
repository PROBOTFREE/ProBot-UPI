		@extends("layouts.app")


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
								<li class="breadcrumb-item active" aria-current="page">Google Maps</li>
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
				<div class="row">
					<div class="col-xl-9 mx-auto">
						<h6 class="text-uppercase">Simple Basic Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="simple-map" class="gmaps"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Map With Marker</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="marker-map" class="gmaps"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Over Layer Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="overlay-map" class="gmaps"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Polygonal Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="polygons-map" class="gmaps"></div>
							</div>
						</div>
						<h6 class="text-uppercase">Styled Map</h6>
						<hr/>
						<div class="card">
							<div class="card-body">
								<div id="style-map" class="gmaps"></div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
			</div>
		</div>
		@endsection
		
	
	@section("script")
	<!-- google maps api -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDKXKdHQdtqgPVl2HI2RnUa_1bjCxRCQo4&callback=initMap" async defer></script>
	<script src="assets/plugins/gmaps/map-custom-script.js"></script>
	@endsection