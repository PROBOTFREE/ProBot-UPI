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
                                    <li class="breadcrumb-item active" aria-current="page">Spinners</li>
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
                    <div class="row row-cols-auto row-cols-1 row-cols-lg-2">
                        <div class="col">
                            <h5 class="mb-0">Border spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-border" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h5 class="mb-0">Border Color spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-border text-primary" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-secondary" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-success" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-danger" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-warning" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-info" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-light" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-border text-dark" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h5 class="mb-0">Growing spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-grow" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h5 class="mb-0">Border Color spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-grow text-primary" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-secondary" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-success" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-danger" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-warning" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-info" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-light" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow text-dark" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h5 class="mb-0">Growing Size Spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-border spinner-border-sm" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow spinner-grow-sm" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h5 class="mb-0">Border Color spinner</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="spinner-border" style="width: 3rem; height: 3rem;" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                    <div class="spinner-grow" style="width: 3rem; height: 3rem;" role="status"> <span class="visually-hidden">Loading...</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <h5 class="mb-0">Spinners With Buttons</h5>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <button class="btn btn-primary" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-primary" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <button class="btn btn-primary" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-primary" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <hr/>
                                    <button class="btn btn-danger" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-danger" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <button class="btn btn-danger" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-danger" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <hr>
                                    <button class="btn btn-success" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-success" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <button class="btn btn-success" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-success" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <hr/>
                                    <button class="btn btn-dark" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-dark" type="button" disabled> <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                    <button class="btn btn-dark" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        <span class="visually-hidden">Loading...</span>
                                    </button>
                                    <button class="btn btn-dark" type="button" disabled> <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                                        Loading...</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection
