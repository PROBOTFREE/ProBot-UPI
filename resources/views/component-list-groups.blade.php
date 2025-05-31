		@extends("layouts.app")
		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Components</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">List Groups</li>
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
                    <h6 class="mb-0 text-uppercase">Color List Group</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <div class="card bg-primary">
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-cart-alt font-18 align-middle me-1'></i> Cras justo odio</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-paper-plane font-18 align-middle me-1'></i> Dapibus ac facilisis in</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx bx-plug font-18 align-middle me-1'></i>Morbi leo risus</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-hourglass font-18 align-middle me-1'></i>Porta ac consectetur ac</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx bx-support font-18 align-middle me-1'></i>Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-danger">
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-like font-18 align-middle me-1'></i> Cras justo odio</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-export font-18 align-middle me-1'></i> Dapibus ac facilisis in</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-star font-18 align-middle me-1'></i>Morbi leo risus</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-file font-18 align-middle me-1'></i>Porta ac consectetur ac</li>
                                        <li class="list-group-item bg-transparent text-white"><i class='bx bx-group font-18 align-middle me-1'></i>Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-info">
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-like font-18 align-middle me-1'></i> Cras justo odio</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-export font-18 align-middle me-1'></i> Dapibus ac facilisis in</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-star font-18 align-middle me-1'></i>Morbi leo risus</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-file font-18 align-middle me-1'></i>Porta ac consectetur ac</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-group font-18 align-middle me-1'></i>Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-warning">
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-cart-alt font-18 align-middle me-1'></i> Cras justo odio</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-paper-plane font-18 align-middle me-1'></i> Dapibus ac facilisis in</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx bx-plug font-18 align-middle me-1'></i>Morbi leo risus</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx-hourglass font-18 align-middle me-1'></i>Porta ac consectetur ac</li>
                                        <li class="list-group-item bg-transparent text-dark"><i class='bx bx bx-support font-18 align-middle me-1'></i>Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Basic example</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="list-group">
                                        <li class="list-group-item">Cras justo odio</li>
                                        <li class="list-group-item">Dapibus ac facilisis in</li>
                                        <li class="list-group-item">Morbi leo risus</li>
                                        <li class="list-group-item">Porta ac consectetur ac</li>
                                        <li class="list-group-item">Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Active items</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="list-group">
                                        <li class="list-group-item active" aria-current="true">Cras justo odio</li>
                                        <li class="list-group-item">Dapibus ac facilisis in</li>
                                        <li class="list-group-item">Morbi leo risus</li>
                                        <li class="list-group-item">Porta ac consectetur ac</li>
                                        <li class="list-group-item">Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">List Group Flush</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Cras justo odio</li>
                                        <li class="list-group-item">Dapibus ac facilisis in</li>
                                        <li class="list-group-item">Morbi leo risus</li>
                                        <li class="list-group-item">Porta ac consectetur ac</li>
                                        <li class="list-group-item">Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">List Group With badges</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="list-group">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">Cras justo odio	<span class="badge bg-primary rounded-pill">14</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">Dapibus ac facilisis in	<span class="badge bg-primary rounded-pill">2</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">Morbi leo risus	<span class="badge bg-primary rounded-pill">8</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">Porta ac consectetur ac	<span class="badge bg-primary rounded-pill">10</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">Vestibulum at eros	<span class="badge bg-primary rounded-pill">22</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <div class="card">
                        <div class="card-body">
                            <div class="list-group">
                                <a href="javascript:;" class="list-group-item list-group-item-action active" aria-current="true">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1 text-white">List group item heading</h5>
                                        <small>3 days ago</small>
                                    </div>
                                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>	<small>Donec id elit non mi porta.</small>
                                </a>
                                <a href="javascript:;" class="list-group-item list-group-item-action">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">List group item heading</h5>
                                        <small class="text-muted">3 days ago</small>
                                    </div>
                                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>	<small class="text-muted">Donec id elit non mi porta.</small>
                                </a>
                                <a href="javascript:;" class="list-group-item list-group-item-action">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">List group item heading</h5>
                                        <small class="text-muted">3 days ago</small>
                                    </div>
                                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>	<small class="text-muted">Donec id elit non mi porta.</small>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection
