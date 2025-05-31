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
                                    <li class="breadcrumb-item active" aria-current="page">Paginations</li>
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
                                <h5 class="mb-0">Basic pagination</h5>
                            </div>
                            <hr>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item"><a class="page-link" href="javascript:;">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;javascript:;">1</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">2</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <h5 class="mb-0">Round pagination</h5>
                            </div>
                            <hr>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination round-pagination">
                                    <li class="page-item"><a class="page-link" href="javascript:;">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;javascript:;">1</a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="javascript:;">2</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                            <nav aria-label="Page navigation">
                                <ul class="pagination pagination-lg round-pagination">
                                    <li class="page-item"><a class="page-link" href="javascript:;">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;javascript:;">1</a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="javascript:;">2</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <h5 class="mb-0">Working with icons</h5>
                            </div>
                            <hr>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="javascript:;" aria-label="Previous">	<span aria-hidden="true">«</span>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">1</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">2</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link" href="javascript:;" aria-label="Next">	<span aria-hidden="true">»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <h5 class="mb-0">Disabled and active states</h5>
                            </div>
                            <hr>
                            <nav aria-label="...">
                                <ul class="pagination">
                                    <li class="page-item disabled"><a class="page-link" href="javascript:;" tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">1</a>
                                    </li>
                                    <li class="page-item active" aria-current="page"><a class="page-link" href="javascript:;">2 <span class="visually-hidden">(current)</span></a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <h5 class="mb-0">Sizing</h5>
                            </div>
                            <hr>
                            <nav aria-label="...">
                                <ul class="pagination pagination-lg">
                                    <li class="page-item disabled"><a class="page-link" href="javascript:;" tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">1</a>
                                    </li>
                                    <li class="page-item active" aria-current="page"><a class="page-link" href="javascript:;">2 <span class="visually-hidden">(current)</span></a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                            <nav aria-label="...">
                                <ul class="pagination pagination-sm">
                                    <li class="page-item disabled"><a class="page-link" href="javascript:;" tabindex="-1" aria-disabled="true">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">1</a>
                                    </li>
                                    <li class="page-item active" aria-current="page"><a class="page-link" href="javascript:;">2 <span class="visually-hidden">(current)</span></a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
		@endsection
