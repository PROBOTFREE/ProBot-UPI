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
                                    <li class="breadcrumb-item active" aria-current="page">Cards</li>
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
                    <h6 class="mb-0 text-uppercase">Card with images</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 row-cols-xl-4">
                        <div class="col">
                            <div class="card border-primary border-bottom border-3 border-0">
                                <img src="assets/images/gallery/01.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title text-primary">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <hr>
                                    <div class="d-flex align-items-center gap-2">
                                        <a href="javascript:;" class="btn btn-inverse-primary"><i class='bx bx-star'></i>Button</a>
                                        <a href="javascript:;" class="btn btn-primary"><i class='bx bx-microphone' ></i>Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card border-danger border-bottom border-3 border-0">
                                <img src="assets/images/gallery/02.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title text-danger">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <hr>
                                    <div class="d-flex align-items-center gap-2">
                                        <a href="javascript:;" class="btn btn-inverse-danger"><i class='bx bx-star'></i>Button</a>
                                        <a href="javascript:;" class="btn btn-danger"><i class='bx bx-microphone' ></i>Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card border-success border-bottom border-3 border-0">
                                <img src="assets/images/gallery/03.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title text-success">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <hr>
                                    <div class="d-flex align-items-center gap-2">
                                        <a href="javascript:;" class="btn btn-inverse-success"><i class='bx bx-star'></i>Button</a>
                                        <a href="javascript:;" class="btn btn-success"><i class='bx bx-microphone' ></i>Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card border-warning border-bottom border-3 border-0">
                                <img src="assets/images/gallery/04.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title text-warning">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <hr>
                                    <div class="d-flex align-items-center gap-2">
                                        <a href="javascript:;" class="btn btn-inverse-warning"><i class='bx bx-star'></i>Button</a>
                                        <a href="javascript:;" class="btn btn-warning"><i class='bx bx-microphone' ></i>Button</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->

                    <h6 class="mb-0 text-uppercase">Card with list group</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-3 row-cols-xl-3">
                        <div class="col">
                            <div class="card">
                                <img src="assets/images/gallery/05.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Vestibulum at eros</li>
                                </ul>
                                <div class="card-body">	<a href="#" class="card-link">Card link</a>
                                    <a href="#" class="card-link">Another link</a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <img src="assets/images/gallery/06.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Vestibulum at eros</li>
                                </ul>
                                <div class="card-body">	<a href="#" class="card-link">Card link</a>
                                    <a href="#" class="card-link">Another link</a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <img src="assets/images/gallery/07.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Vestibulum at eros</li>
                                </ul>
                                <div class="card-body">	<a href="#" class="card-link">Card link</a>
                                    <a href="#" class="card-link">Another link</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->


                    <h6 class="mb-0 text-uppercase">Card with background color</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-3 row-cols-xl-3">
                        <div class="col d-flex">
                            <div class="card bg-danger w-100">
                                <img src="assets/images/gallery/35.png" class="card-img-top" alt="...">
                                <div class="card-body text-white">
                                    <h5 class="card-title text-white">Card Sample Title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small>Last updated 3 mins ago</small></p>
                                </div>
                            </div>
                        </div>
                        <div class="col d-flex">
                            <div class="card bg-success w-100">
                                <img src="assets/images/gallery/36.png" class="card-img-top" alt="...">
                                <div class="card-body text-white">
                                    <h5 class="card-title text-white">Card Sample Title</h5>
                                    <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                                    <p class="card-text"><small>Last updated 3 mins ago</small></p>
                                </div>
                            </div>
                        </div>
                        <div class="col d-flex">
                            <div class="card bg-warning w-100">
                                <img src="assets/images/gallery/37.png" class="card-img-top" alt="...">
                                <div class="card-body text-white">
                                    <h5 class="card-title text-white">Card Sample Title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                                    <p class="card-text"><small>Last updated 3 mins ago</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->


                    <h6 class="mb-0 text-uppercase">Image caps Card</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <div class="card mb-3">
                                <img src="assets/images/gallery/08.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small>
                                    </p>
                                </div>
                                <img src="assets/images/gallery/09.png" class="card-img-bottom" alt="...">
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Horizontal Card</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <div class="card">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img src="assets/images/gallery/10.png" alt="..." class="card-img">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img src="assets/images/gallery/11.png" alt="..." class="card-img">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Image overlays</h6>
                    <hr/>
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <div class="card bg-dark text-white">
                                <img src="assets/images/gallery/12.png" class="card-img" alt="...">
                                <div class="card-img-overlay">
                                    <h5 class="card-title text-white">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text">Last updated 3 mins ago</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-dark text-white">
                                <img src="assets/images/gallery/13.png" class="card-img" alt="...">
                                <div class="card-img-overlay">
                                    <h5 class="card-title text-white">Card title</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                    <p class="card-text">Last updated 3 mins ago</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <h6 class="mb-0 text-uppercase">Card Group</h6>
                    <hr/>
                    <div class="card-group shadow">
                        <div class="card border-end shadow-none">
                            <img src="assets/images/gallery/14.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                <hr>
                                <div class="d-flex align-items-center gap-2">
                                    <a href="javascript:;" class="btn btn-inverse-dark"><i class='bx bx-star'></i>Button</a>
                                    <a href="javascript:;" class="btn btn-dark"><i class='bx bx-microphone' ></i>Button</a>
                                </div>
                            </div>
                            <div class="card-footer bg-white"> <small class="text-muted">Last updated 3 mins ago</small>
                            </div>
                        </div>
                        <div class="card border-end shadow-none">
                            <img src="assets/images/gallery/15.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                <hr>
                                <div class="d-flex align-items-center gap-2">
                                    <a href="javascript:;" class="btn btn-inverse-warning"><i class='bx bx-star'></i>Button</a>
                                    <a href="javascript:;" class="btn btn-warning"><i class='bx bx-microphone' ></i>Button</a>
                                </div>
                            </div>
                            <div class="card-footer bg-white"> <small class="text-muted">Last updated 3 mins ago</small>
                            </div>
                        </div>
                        <div class="card shadow-none">
                            <img src="assets/images/gallery/16.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                <hr>
                                <div class="d-flex align-items-center gap-2">
                                    <a href="javascript:;" class="btn btn-inverse-info"><i class='bx bx-star'></i>Button</a>
                                    <a href="javascript:;" class="btn btn-info"><i class='bx bx-microphone' ></i>Button</a>
                                </div>
                            </div>
                            <div class="card-footer bg-white"> <small class="text-muted">Last updated 3 mins ago</small>
                            </div>
                        </div>
                    </div>
                    <h6 class="mb-0 text-uppercase">Card with text</h6>
                    <hr class="border-top" />
                    <div class="row row-cols-1 row-cols-md-3 row-cols-lg-3 row-cols-xl-3">
                        <div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Special title treatment</h5>
                                    </div>
                                    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>	<a href="javascript:;" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Special title treatment</h5>
                                    </div>
                                    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>	<a href="javascript:;" class="btn btn-danger">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Special title treatment</h5>
                                    </div>
                                    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>	<a href="javascript:;" class="btn btn-success">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <div class="row row-cols-1 row-cols-md-3 row-cols-lg-3 row-cols-xl-3">
                        <div class="col">
                            <div class="card bg-primary text-white">
                                <div class="card-body">
                                    <h5 class="card-title text-white">Special title treatment</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-danger text-white">
                                <div class="card-body">
                                    <h5 class="card-title text-white">Special title treatment</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-success text-white">
                                <div class="card-body">
                                    <h5 class="card-title text-white">Special title treatment</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-dark text-white">
                                <div class="card-body">
                                    <h5 class="card-title text-white">Special title treatment</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-warning">
                                <div class="card-body">
                                    <h5 class="card-title text-dark">Special title treatment</h5>
                                    <p class="card-text text-dark">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card bg-info">
                                <div class="card-body">
                                    <h5 class="card-title text-dark">Special title treatment</h5>
                                    <p class="card-text text-dark">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection
