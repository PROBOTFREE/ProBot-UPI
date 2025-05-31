		@extends("layouts.app")
		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Timeline</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Timeline</li>
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
                    <div class="">
                        <div class="">
                            <div class="container py-2">
                                <h2 class="font-weight-light text-center text-muted py-3">Timeline Example 1</h2>
                                <!-- timeline item 1 -->
                                <div class="row">
                                    <!-- timeline item 1 left dot -->
                                    <div class="col-auto text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <!-- timeline item 1 event content -->
                                    <div class="col py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted">Mon, Jan 9th 2020 7:00 AM</div>
                                                <h4 class="card-title text-muted">Day 1 Orientation</h4>
                                                <p class="card-text">Welcome to the campus, introduction and get started with the tour.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 2 -->
                                <div class="row">
                                    <div class="col-auto text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-primary">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col py-2">
                                        <div class="card border-primary shadow radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-primary">Tue, Jan 10th 2019 8:30 AM</div>
                                                <h4 class="card-title text-primary">Day 2 Sessions</h4>
                                                <p class="card-text">Sign-up for the lessons and speakers that coincide with your course syllabus. Meet and greet with instructors.</p>
                                                <button class="btn btn-sm btn-outline-secondary" type="button" data-bs-target="#t2_details" data-bs-toggle="collapse">Show Details ▼</button>
                                                <div class="collapse border" id="t2_details">
                                                    <div class="p-2 text-monospace">
                                                        <div>08:30 - 09:00 Breakfast in CR 2A</div>
                                                        <div>09:00 - 10:30 Live sessions in CR 3</div>
                                                        <div>10:30 - 10:45 Break</div>
                                                        <div>10:45 - 12:00 Live sessions in CR 3</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 3 -->
                                <div class="row">
                                    <div class="col-auto text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted">Wed, Jan 11th 2019 8:30 AM</div>
                                                <h4 class="card-title">Day 3 Sessions</h4>
                                                <p>Shoreditch vegan artisan Helvetica. Tattooed Codeply Echo Park Godard kogi, next level irony ennui twee squid fap selvage. Meggings flannel Brooklyn literally small batch, mumblecore PBR try-hard kale chips. Brooklyn vinyl lumbersexual bicycle rights, viral fap cronut leggings squid chillwave pickled gentrify mustache. 3 wolf moon hashtag church-key Odd Future. Austin messenger bag normcore, Helvetica Williamsburg sartorial tote bag distillery Portland before they sold out gastropub taxidermy Vice.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 4 -->
                                <div class="row">
                                    <div class="col-auto text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted">Thu, Jan 12th 2019 11:30 AM</div>
                                                <h4 class="card-title">Day 4 Wrap-up</h4>
                                                <p>Join us for lunch in Bootsy's cafe across from the Campus Center.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                            </div>
                            <!--container-->
                            <hr>
                            <div class="container py-2">
                                <h2 class="font-weight-light text-center text-muted py-3">Timeline Example 2</h2>
                                <!-- timeline item 1 -->
                                <div class="row g-0">
                                    <div class="col-sm">
                                        <!--spacer-->
                                    </div>
                                    <!-- timeline item 1 center dot -->
                                    <div class="col-sm-1 text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <!-- timeline item 1 event content -->
                                    <div class="col-sm py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted small">Jan 9th 2019 7:00 AM</div>
                                                <h4 class="card-title text-muted">Day 1 Orientation</h4>
                                                <p class="card-text">Welcome to the campus, introduction and get started with the tour.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 2 -->
                                <div class="row g-0">
                                    <div class="col-sm py-2">
                                        <div class="card border-primary shadow radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-primary small">Jan 10th 2019 8:30 AM</div>
                                                <h4 class="card-title text-primary">Day 2 Sessions</h4>
                                                <p class="card-text">Sign-up for the lessons and speakers that coincide with your course syllabus. Meet and greet with instructors.</p>
                                                <button class="btn btn-sm btn-outline-secondary" type="button" data-bs-target="#t22_details" data-bs-toggle="collapse">Show Details ▼</button>
                                                <div class="collapse border" id="t22_details">
                                                    <div class="p-2 text-monospace">
                                                        <div>08:30 - 09:00 Breakfast in CR 2A</div>
                                                        <div>09:00 - 10:30 Live sessions in CR 3</div>
                                                        <div>10:30 - 10:45 Break</div>
                                                        <div>10:45 - 12:00 Live sessions in CR 3</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-1 text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-primary">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <!--spacer-->
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 3 -->
                                <div class="row g-0">
                                    <div class="col-sm">
                                        <!--spacer-->
                                    </div>
                                    <div class="col-sm-1 text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col-sm py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted small">Jan 11th 2019 8:30 AM</div>
                                                <h4 class="card-title">Day 3 Sessions</h4>
                                                <p>Shoreditch vegan artisan Helvetica. Tattooed Codeply Echo Park Godard kogi, next level irony ennui twee squid fap selvage. Meggings flannel Brooklyn literally small batch, mumblecore PBR try-hard kale chips. Brooklyn vinyl lumbersexual bicycle rights, viral fap cronut leggings squid chillwave pickled gentrify mustache.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--/row-->
                                <!-- timeline item 4 -->
                                <div class="row g-0">
                                    <div class="col-sm py-2">
                                        <div class="card radius-15">
                                            <div class="card-body">
                                                <div class="float-end text-muted small">Jan 12th 2019 11:30 AM</div>
                                                <h4 class="card-title">Day 4 Wrap-up</h4>
                                                <p>Join us for lunch in Bootsy's cafe across from the Campus Center.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-1 text-center flex-column d-none d-sm-flex">
                                        <div class="row h-50">
                                            <div class="col border-end">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                        <h5 class="m-2">
                                            <span class="badge rounded-pill bg-light border">&nbsp;</span>
                                        </h5>
                                        <div class="row h-50">
                                            <div class="col">&nbsp;</div>
                                            <div class="col">&nbsp;</div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <!--spacer-->
                                    </div>
                                </div>
                                <!--/row-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection



