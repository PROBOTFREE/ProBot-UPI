@extends("layouts.app")
		
		@section("wrapper")
		<!--start page wrapper -->
		<div class="page-wrapper">
			<div class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Component</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Text Utilities</li>
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
				<h6 class="mb-0 text-uppercase">Background Colors</h6>
				<hr/>
				<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
					<div class="col">
						<div class="card bg-primary text-center">
							<div class="card-body">
								<div class="p-4 text-white rounded">.bg-primary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-secondary text-center">
							<div class="card-body">
								<div class="p-4 text-white rounded">.bg-secondary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-success text-center">
							<div class="card-body">
								<div class="p-4 text-white rounded">.bg-success</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-danger text-center">
							<div class="card-body">
								<div class="p-4 text-white rounded">.bg-danger</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-warning text-center">
							<div class="card-body">
								<div class="p-4 text-dark rounded">.bg-warning</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-info text-center">
							<div class="card-body">
								<div class="p-4 text-dark rounded">.bg-info</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-light text-center">
							<div class="card-body">
								<div class="p-4 text-dark rounded">.bg-light</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-dark text-center">
							<div class="card-body">
								<div class="p-4 text-white rounded">.bg-dark</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<h6 class="mb-0 text-uppercase">Gradient Background Colors</h6>
				<hr/>
				<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
					<div class="col">
						<div class="card bg-primary bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-white rounded">.bg-primary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-secondary bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-white rounded">.bg-secondary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-success bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-white rounded">.bg-success</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-danger bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-white rounded">.bg-danger.bg-gradient</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-warning bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-dark rounded">.bg-warning.bg-gradient</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-info bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-dark rounded">.bg-info.bg-gradient</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-light bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-dark rounded">.bg-light.bg-gradient</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card bg-dark bg-gradient text-center">
							<div class="card-body">
								<div class="p-3 text-white rounded">.bg-dark.bg-gradient</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<h6 class="mb-0 text-uppercase">Text Colors</h6>
				<hr/>
				<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-primary rounded">.text-primary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-secondary rounded">.text-secondary</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-success rounded">.text-success</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-danger rounded">.text-danger</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-warning rounded">.text-warning</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-info rounded">.text-info</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center bg-dark">
							<div class="card-body">
								<div class="text-light rounded">.text-light</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card text-center">
							<div class="card-body">
								<div class="text-dark rounded">.text-dark</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<h6 class="mb-0 text-uppercase">Border Utilities</h6>
				<hr/>
				<div class="card">
					<div class="card-body">
						<div class="row row-cols-auto row-cols-1 row-cols-md-2 row-cols-lg-4 g-3">
							<div class="col">
								<div class="p-4 border text-center rounded bg-light">.border</div>
							</div>
							<div class="col">
								<div class="p-4 border-top text-center rounded bg-light">.border-top</div>
							</div>
							<div class="col">
								<div class="p-4 border-bottom text-center rounded bg-light">.border-bottom</div>
							</div>
							<div class="col">
								<div class="p-4 border-start text-center rounded bg-light">.border-start</div>
							</div>
							<div class="col">
								<div class="p-4 border-end text-center rounded bg-light">.border-end</div>
							</div>
							<div class="col">
								<div class="p-4 border-1 border text-center rounded bg-light">.border-1</div>
							</div>
							<div class="col">
								<div class="p-4 border-2 border text-center rounded bg-light">.border-2</div>
							</div>
							<div class="col">
								<div class="p-4 border-3 border text-center rounded bg-light">.border-3</div>
							</div>
							<div class="col">
								<div class="p-4 border-4 border text-center rounded bg-light">.border-4</div>
							</div>
							<div class="col">
								<div class="p-4 border-5 border text-center rounded bg-light">.border-5</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-primary text-center rounded bg-light">.border-primary</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-danger text-center rounded bg-light">.border-danger</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-success text-center rounded bg-light">.border-success</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-info text-center rounded bg-light">.border-info</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-warning text-center rounded bg-light">.border-warning</div>
							</div>
							<div class="col">
								<div class="p-4 border border-3 border-dark text-center rounded bg-light">.border-dark</div>
							</div>
						</div>
						<!--end row-->
					</div>
				</div>
				<h6 class="mb-0 text-uppercase">Border Radius</h6>
				<hr/>
				<div class="card">
					<div class="card-body">
						<div class="row row-cols-auto g-3 align-items-center">
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded-top">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded-bottom">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded-start">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded-end">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/120x120" height="120" alt="..." class="img-fluid rounded-circle">
							</div>
							<div class="col">
								<img src="http://via.placeholder.com/150x75" height="120" alt="..." class="img-fluid rounded-pill">
							</div>
						</div>
						<!--end row-->
					</div>
				</div>
				<h6 class="mb-0 text-uppercase">Shadows Examples</h6>
				<hr/>
				<div class="card">
					<div class="card-body">
						<div class="row row-cols-1 row-cols-lg-4 g-3 align-items-center">
							<div class="col">
								<div class="shadow-none p-4 rounded">No shadow</div>
							</div>
							<div class="col">
								<div class="shadow-sm p-4 rounded">Small shadow</div>
							</div>
							<div class="col">
								<div class="shadow p-4 rounded">Regular shadow</div>
							</div>
							<div class="col">
								<div class="shadow-lg p-4 rounded">Larger shadow</div>
							</div>
						</div>
						<!--end row-->
					</div>
				</div>
			</div>
		</div>
		<!--end page wrapper -->
		@endsection
	