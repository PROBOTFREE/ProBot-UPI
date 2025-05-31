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
                                    <li class="breadcrumb-item active" aria-current="page">Media Object</li>
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
                        <div class="col-12 col-lg-9 mx-auto">
                            <h6 class="mb-0 text-uppercase">Basic Media Object</h6>
                            <hr/>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <img src="assets/images/avatars/avatar-1.png" class="rounded-circle p-1 border" width="90" height="90" alt="...">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0">Media heading</h5>
                                            <p class="mb-0">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Nesting Media Object</h6>
                            <hr/>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <img src="assets/images/avatars/avatar-2.png" class="rounded-circle p-1 border" width="90" height="90" alt="...">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0">Media heading</h5>
                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla
                                            <div class="d-flex align-items-center mt-3">
                                                <a class="mr-3" href="#">
                                                    <img src="assets/images/avatars/avatar-3.png" class=" rounded-circle p-1 border" width="90" height="90" alt="...">
                                                </a>
                                                <div class="flex-grow-1 ms-3">
                                                    <h5 class="mt-0">Media heading</h5>
                                                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Alignment</h6>
                            <hr/>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div class="d-flex align-items-center">
                                        <img src="assets/images/avatars/avatar-4.png" class="align-self-start rounded-circle p-1 border" width="90" height="90" alt="...">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0">Top-aligned media</h5>
                                            <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</p>
                                            <p>Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex align-items-center">
                                        <img src="assets/images/avatars/avatar-5.png" class="align-self-center rounded-circle p-1 border" width="90" height="90" alt="...">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0">Center-aligned media</h5>
                                            <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</p>
                                            <p class="mb-0">Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex align-items-center">
                                        <img src="assets/images/avatars/avatar-6.png" class="align-self-end rounded-circle p-1 border" width="90" height="90" alt="...">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0">Bottom-aligned media</h5>
                                            <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</p>
                                            <p class="mb-0">Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="d-flex align-items-center">
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="mt-0 mb-1">Order Change media</h5>
                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</div>
                                        <img src="assets/images/avatars/avatar-7.png" class="ml-3 rounded-circle p-1 border" width="90" height="90" alt="...">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Media list</h6>
                            <hr/>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <ul class="list-unstyled">
                                        <li class="d-flex align-items-center border-bottom pb-2">
                                            <img src="assets/images/avatars/avatar-8.png" class="rounded-circle p-1 border" width="90" height="90" alt="...">
                                            <div class="flex-grow-1 ms-3">
                                                <h5 class="mt-0 mb-1">List-based media object</h5>
                                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</div>
                                        </li>
                                        <li class="d-flex align-items-center my-4 border-bottom pb-2">
                                            <img src="assets/images/avatars/avatar-9.png" class="rounded-circle p-1 border" width="90" height="90" alt="...">
                                            <div class="flex-grow-1 ms-3">
                                                <h5 class="mt-0 mb-1">List-based media object</h5>
                                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</div>
                                        </li>
                                        <li class="d-flex align-items-center">
                                            <img src="assets/images/avatars/avatar-10.png" class="rounded-circle p-1 border" width="90" height="90" alt="...">
                                            <div class="flex-grow-1 ms-3">
                                                <h5 class="mt-0 mb-1">List-based media object</h5>
                                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla</div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection
