	@extends("layouts.app")
	@section("style")
	<link href="assets/plugins/notifications/css/lobibox.min.css" rel="stylesheet" />
	@endsection


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
                                    <li class="breadcrumb-item active" aria-current="page">Notifications</li>
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
                    <h6 class="mb-0 text-uppercase">Default Notifications</h6>
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <div class="row row-cols-auto g-3">
                                <div class="col">
                                    <button type="button" class="btn btn-dark px-5" onclick="default_noti()">Default</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-info px-5" onclick="info_noti()"><i class="bx bx-info-circle mr-1"></i> Info</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-warning px-5" onclick="warning_noti()"><i class="bx bx-error mr-1"></i> Warning</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-danger px-5" onclick="error_noti()"><i class="bx bx-x-circle mr-1"></i> Danger</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-success px-5" onclick="success_noti()"><i class="bx bx-check-circle mr-1"></i> Success</button>
                                </div>
                            </div>
                            <!--end row-->
                        </div>
                    </div>
                    <h6 class="mb-0 text-uppercase">Rounded Corners Notifications</h6>
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <div class="row row-cols-auto g-3">
                                <div class="col">
                                    <button type="button" class="btn btn-dark px-5" onclick="round_default_noti()">Default</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-info px-5" onclick="round_info_noti()"><i class="bx bx-info-circle mr-1"></i>Info</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-warning px-5" onclick="round_warning_noti()"><i class="bx bx-error mr-1"></i>Warning</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-danger px-5" onclick="round_error_noti()"><i class="bx bx-x-circle mr-1"></i> Danger</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-success px-5" onclick="round_success_noti()"><i class="bx bx-check-circle mr-1"></i>Success</button>
                                </div>
                            </div>
                            <!--end row-->
                        </div>
                    </div>
                    <h6 class="mb-0 text-uppercase">Notifications With image</h6>
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <div class="row row-cols-auto g-3">
                                <div class="col">
                                    <button type="button" class="btn btn-dark px-5" onclick="img_default_noti()">Default</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-info px-5" onclick="img_info_noti()"><i class="bx bx-info-circle"></i>Info</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-warning px-5" onclick="img_warning_noti()"><i class="bx bx-error"></i>Warning</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-danger px-5" onclick="img_error_noti()"><i class="bx bx-x-circle"></i> Danger</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-success px-5" onclick="img_success_noti()"><i class="bx bx-check-circle"></i>Success</button>
                                </div>
                            </div>
                            <!--end row-->
                        </div>
                    </div>
                    <h6 class="mb-0 text-uppercase">Alternative Position</h6>
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <div class="row row-cols-auto g-3">
                                <div class="col">
                                    <button type="button" class="btn btn-dark px-5" onclick="pos1_default_noti()">Default</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-info px-5" onclick="pos2_info_noti()"><i class="bx bx-info-circle mr-1"></i>Info</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-warning px-5" onclick="pos3_warning_noti()"><i class="bx bx-error"></i>Warning</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-danger px-5" onclick="pos4_error_noti()"><i class="bx bx-x-circle"></i> Danger</button>
                                </div>
                                <div class="col">
                                    <button type="button" class="btn btn-success px-5" onclick="pos5_success_noti()"><i class="bx bx-check-circle"></i>Success</button>
                                </div>
                            </div>
                            <!--end row-->
                        </div>
                    </div>
                </div>
            </div>
		@endsection

	@section("script")
	@parent
	<!--notification js -->
	<script src="assets/plugins/notifications/js/lobibox.min.js')  }}"></script>
	<script src="assets/plugins/notifications/js/notifications.min.js')  }}"></script>
	<script src="assets/plugins/notifications/js/notification-custom-script.js')  }}"></script>
	@endsection
