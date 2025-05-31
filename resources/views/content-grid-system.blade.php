@extends("layouts.app")
		
		@section("wrapper")
		<!--start page wrapper -->
		<div class="page-wrapper">
			<div class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Content</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Grid System</li>
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
				<div class="card">
					<div class="card-body">
						<div class="card-title">
							<h5 class="mb-0">Available breakpoints</h5>
						</div>
						<hr/>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Breakpoint</th>
										<th>Class infix</th>
										<th>Dimensions</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>X-Small</td>
										<td><em>None</em>
										</td>
										<td>&lt;576px</td>
									</tr>
									<tr>
										<td>Small</td>
										<td><code>sm</code>
										</td>
										<td>≥576px</td>
									</tr>
									<tr>
										<td>Medium</td>
										<td><code>md</code>
										</td>
										<td>≥768px</td>
									</tr>
									<tr>
										<td>Large</td>
										<td><code>lg</code>
										</td>
										<td>≥992px</td>
									</tr>
									<tr>
										<td>Extra large</td>
										<td><code>xl</code>
										</td>
										<td>≥1200px</td>
									</tr>
									<tr>
										<td>Extra extra large</td>
										<td><code>xxl</code>
										</td>
										<td>≥1400px</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<div class="card-title">
							<h5 class="mb-0">Containers</h5>
						</div>
						<hr/>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<td class="border-dark"></td>
										<th scope="col">Extra small
											<br>	<span class="fw-normal">&lt;576px</span>
										</th>
										<th scope="col">Small
											<br>	<span class="fw-normal">≥576px</span>
										</th>
										<th scope="col">Medium
											<br>	<span class="fw-normal">≥768px</span>
										</th>
										<th scope="col">Large
											<br>	<span class="fw-normal">≥992px</span>
										</th>
										<th scope="col">X-Large
											<br>	<span class="fw-normal">≥1200px</span>
										</th>
										<th scope="col">XX-Large
											<br>	<span class="fw-normal">≥1400px</span>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row" class="fw-normal"><code>.container</code>
										</th>
										<td class="text-muted">100%</td>
										<td>540px</td>
										<td>720px</td>
										<td>960px</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-sm</code>
										</th>
										<td class="text-muted">100%</td>
										<td>540px</td>
										<td>720px</td>
										<td>960px</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-md</code>
										</th>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td>720px</td>
										<td>960px</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-lg</code>
										</th>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td>960px</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-xl</code>
										</th>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-xxl</code>
										</th>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th scope="row" class="fw-normal"><code>.container-fluid</code>
										</th>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
										<td class="text-muted">100%</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<div class="card-title">
							<h5 class="mb-0">Grid options</h5>
						</div>
						<hr/>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col">xs
											<br>	<span class="fw-normal">&lt;576px</span>
										</th>
										<th scope="col">sm
											<br>	<span class="fw-normal">≥576px</span>
										</th>
										<th scope="col">md
											<br>	<span class="fw-normal">≥768px</span>
										</th>
										<th scope="col">lg
											<br>	<span class="fw-normal">≥992px</span>
										</th>
										<th scope="col">xl
											<br>	<span class="fw-normal">≥1200px</span>
										</th>
										<th scope="col">xxl
											<br>	<span class="fw-normal">≥1400px</span>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th class="text-nowrap" scope="row">Container <code class="fw-normal">max-width</code>
										</th>
										<td>None (auto)</td>
										<td>540px</td>
										<td>720px</td>
										<td>960px</td>
										<td>1140px</td>
										<td>1320px</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row">Class prefix</th>
										<td><code>.col-</code>
										</td>
										<td><code>.col-sm-</code>
										</td>
										<td><code>.col-md-</code>
										</td>
										<td><code>.col-lg-</code>
										</td>
										<td><code>.col-xl-</code>
										</td>
										<td><code>.col-xxl-</code>
										</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row"># of columns</th>
										<td colspan="6">12</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row">Gutter width</th>
										<td colspan="6">1.5rem (.75rem on left and right)</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row">Custom gutters</th>
										<td colspan="6"><a href="/docs/5.0/layout/gutters/">Yes</a>
										</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row">Nestable</th>
										<td colspan="6"><a href="#nesting">Yes</a>
										</td>
									</tr>
									<tr>
										<th class="text-nowrap" scope="row">Column ordering</th>
										<td colspan="6"><a href="/docs/5.0/layout/columns/#reordering">Yes</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end page wrapper -->
		@endsection
	