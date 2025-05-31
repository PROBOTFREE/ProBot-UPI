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
                                    <li class="breadcrumb-item active" aria-current="page">Buttons</li>
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
                        <div class="col col-lg-9 mx-auto">
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Basic Examples</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-primary px-5">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-danger px-5">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-success px-5">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-info px-5">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-warning px-5">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-dark px-5">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-secondary px-5">Secondary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-light px-5">Light</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Outline Examples</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary px-5">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger px-5">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success px-5">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info px-5">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning px-5">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark px-5">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary px-5">Secondary</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                            </div>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Round Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-primary px-5 radius-30">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-danger px-5 radius-30">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-success px-5 radius-30">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-info px-5 radius-30">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-warning px-5 radius-30">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-dark px-5 radius-30">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-secondary px-5 radius-30">Secondary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-light px-5 radius-30">Light</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Round Outline Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary px-5 radius-30">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger px-5 radius-30">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success px-5 radius-30">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info px-5 radius-30">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning px-5 radius-30">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark px-5 radius-30">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary px-5 radius-30">Secondary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-light px-5 radius-30">Light</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                            </div>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Square Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-primary px-5 rounded-0">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-danger px-5 rounded-0">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-success px-5 rounded-0">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-info px-5 rounded-0">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-warning px-5 rounded-0">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-dark px-5 rounded-0">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-secondary px-5 rounded-0">Secondary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-light px-5 rounded-0">Light</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Square Outline Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary px-5 rounded-0">Primary</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger px-5 rounded-0">Danger</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success px-5 rounded-0">Success</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info px-5 rounded-0">Info</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning px-5 rounded-0">Warning</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark px-5 rounded-0">Dark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary px-5 rounded-0">Secondary</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                            </div>

                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Button With Icons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-info px-5"><i class='bx bx-cloud-download mr-1'></i>Downloads</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-warning px-5"><i class='bx bx-heart-circle mr-1'></i>Love</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-dark px-5"><i class='bx bx-cloud-upload mr-1'></i>Upload</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-secondary px-5"><i class='bx bx-comment mr-1'></i>Comments</button>
                                        </div>
                                        <div class="w-100 border-top"></div>

                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                        <div class="w-100 border-top"></div>

                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>

                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Outline Button With Icons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info px-5"><i class='bx bx-cloud-download mr-1'></i>Downloads</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning px-5"><i class='bx bx-heart-circle mr-1'></i>Love</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark px-5"><i class='bx bx-cloud-upload mr-1'></i>Upload</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary px-5"><i class='bx bx-comment mr-1'></i>Comments</button>
                                        </div>
                                        <div class="w-100 border-top"></div>

                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-outline-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-outline-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-lg btn-outline-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                        <div class="w-100 border-top"></div>

                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-outline-primary px-5"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-outline-danger px-5"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-sm btn-outline-success px-5"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>



                                <div class="card-body">
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary px-5 radius-30"><i class='bx bx-user mr-1'></i>Person</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger px-5 radius-30"><i class='bx bx-bookmark mr-1'></i>Bookmark</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success px-5 radius-30"><i class='bx bx-home mr-1'></i>Home</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info px-5 radius-30"><i class='bx bx-cloud-download mr-1'></i>Downloads</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning px-5 radius-30"><i class='bx bx-heart-circle mr-1'></i>Love</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark px-5 radius-30"><i class='bx bx-cloud-upload mr-1'></i>Upload</button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary px-5 radius-30"><i class='bx bx-comment mr-1'></i>Comments</button>
                                        </div>

                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-primary"><i class='bx bx-user me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-danger"><i class='bx bx-blanket me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-success"><i class='bx bx-home-alt me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-info"><i class='bx bx-refresh me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-warning"><i class='bx bx-heart me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-dark"><i class='bx bx-like me-0'></i>
                                            </button>
                                        </div>
                                        <div class="col">
                                            <button type="button" class="btn btn-outline-secondary"><i class='bx bx-comment-detail me-0'></i>
                                            </button>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                            </div>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Group Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="First group">
                                                <button type="button" class="btn btn-primary">1</button>
                                                <button type="button" class="btn btn-primary">2</button>
                                                <button type="button" class="btn btn-primary">3</button>
                                                <button type="button" class="btn btn-primary">4</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="First group">
                                                <button type="button" class="btn btn-dark">5</button>
                                                <button type="button" class="btn btn-dark">6</button>
                                                <button type="button" class="btn btn-dark">7</button>
                                                <button type="button" class="btn btn-dark">8</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="First group">
                                                <button type="button" class="btn btn-warning">9</button>
                                                <button type="button" class="btn btn-warning">10</button>
                                                <button type="button" class="btn btn-warning">11</button>
                                                <button type="button" class="btn btn-warning">12</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="First group">
                                                <button type="button" class="btn btn-outline-secondary">13</button>
                                                <button type="button" class="btn btn-outline-secondary">14</button>
                                                <button type="button" class="btn btn-outline-secondary">15</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="First group">
                                                <button type="button" class="btn btn-outline-primary">16</button>
                                                <button type="button" class="btn btn-outline-primary">17</button>
                                                <button type="button" class="btn btn-outline-primary">18</button>
                                                <button type="button" class="btn btn-outline-primary">19</button>
                                                <button type="button" class="btn btn-outline-primary">20</button>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                                <button type="button" class="btn btn-primary">1</button>
                                                <button type="button" class="btn btn-primary">2</button>
                                                <div class="btn-group" role="group">
                                                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                                <button type="button" class="btn btn-danger">1</button>
                                                <button type="button" class="btn btn-danger">2</button>
                                                <div class="btn-group" role="group">
                                                    <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                                <button type="button" class="btn btn-success">1</button>
                                                <button type="button" class="btn btn-success">2</button>
                                                <div class="btn-group" role="group">
                                                    <button type="button" class="btn btn-success dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                                <button type="button" class="btn btn-info">1</button>
                                                <button type="button" class="btn btn-info">2</button>
                                                <div class="btn-group" role="group">
                                                    <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                        <li><a class="dropdown-item" href="#">Dropdown link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-secondary">Left</button>
                                                <button type="button" class="btn btn-secondary">Middle</button>
                                                <button type="button" class="btn btn-secondary">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-primary">Left</button>
                                                <button type="button" class="btn btn-primary">Middle</button>
                                                <button type="button" class="btn btn-primary">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-danger">Left</button>
                                                <button type="button" class="btn btn-danger">Middle</button>
                                                <button type="button" class="btn btn-danger">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-success">Left</button>
                                                <button type="button" class="btn btn-success">Middle</button>
                                                <button type="button" class="btn btn-success">Right</button>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-secondary">Left</button>
                                                <button type="button" class="btn btn-outline-secondary">Middle</button>
                                                <button type="button" class="btn btn-outline-secondary">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-primary">Left</button>
                                                <button type="button" class="btn btn-outline-primary">Middle</button>
                                                <button type="button" class="btn btn-outline-primary">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-danger">Left</button>
                                                <button type="button" class="btn btn-outline-danger">Middle</button>
                                                <button type="button" class="btn btn-outline-danger">Right</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-success">Left</button>
                                                <button type="button" class="btn btn-outline-success">Middle</button>
                                                <button type="button" class="btn btn-outline-success">Right</button>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-dark"><i class="bx bx-like"></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class="bx bx-share"></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class="bx bx-comment-detail"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-info"><i class="bx bxs-music"></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class="bx bxs-heart"></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class="bx bxs-florist"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-warning"><i class="bx bx-left-arrow"></i>
                                                </button>
                                                <button type="button" class="btn btn-warning"><i class="bx bx-up-arrow"></i>
                                                </button>
                                                <button type="button" class="btn btn-warning"><i class="bx bx-right-arrow"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-primary"><i class="bx bxl-facebook-square"></i>
                                                </button>
                                                <button type="button" class="btn btn-primary"><i class="bx bxl-twitter"></i>
                                                </button>
                                                <button type="button" class="btn btn-primary"><i class="bx bxl-linkedin-square"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-danger"><i class='bx bx-pointer me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-danger"><i class='bx bx-search-alt me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-danger"><i class='bx bx-rotate-right me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-danger"><i class='bx bx-aperture me-0'></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-secondary"><i class='bx bx-export me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-secondary"><i class='bx bx-star me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-secondary"><i class='bx bx-pin me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-secondary"><i class='bx bx-cloud-light-rain me-0'></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-dark"><i class="bx bx-like"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-dark"><i class="bx bx-share"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-dark"><i class="bx bx-comment-detail"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-info"><i class="bx bxs-music"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-info"><i class="bx bxs-heart"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-info"><i class="bx bxs-florist"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-warning"><i class="bx bx-left-arrow"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-warning"><i class="bx bx-up-arrow"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-warning"><i class="bx bx-right-arrow"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-primary"><i class="bx bxl-facebook-square"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-primary"><i class="bx bxl-twitter"></i>
                                                </button>
                                                <button type="button" class="btn btn-outline-primary"><i class="bx bxl-linkedin-square"></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-dark">Button</button>
                                                <button type="button" class="btn btn-dark">Button</button>
                                                <button type="button" class="btn btn-dark">Button</button>
                                                <button type="button" class="btn btn-dark">Button</button>
                                                <button type="button" class="btn btn-dark">Button</button>
                                                <button type="button" class="btn btn-dark">Button</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-warning">Button</button>
                                                <button type="button" class="btn btn-warning">Button</button>
                                                <button type="button" class="btn btn-warning">Button</button>
                                                <button type="button" class="btn btn-warning">Button</button>
                                                <button type="button" class="btn btn-warning">Button</button>
                                                <button type="button" class="btn btn-warning">Button</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-outline-danger">Button</button>
                                                <button type="button" class="btn btn-outline-danger">Button</button>
                                                <button type="button" class="btn btn-outline-danger active">Button</button>
                                                <button type="button" class="btn btn-outline-danger">Button</button>
                                                <button type="button" class="btn btn-outline-danger">Button</button>
                                                <button type="button" class="btn btn-outline-danger">Button</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                                <button type="button" class="btn btn-outline-success">Button</button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-info"><i class='bx bxl-facebook-square me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class='bx bxl-twitter me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class='bx bxl-linkedin-square me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class='bx bxl-youtube me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class='bx bxl-wordpress me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-info"><i class='bx bxl-pinterest me-0'></i>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                                                <button type="button" class="btn btn-dark"><i class='bx bx-home-smile me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class='bx bx-coin-stack me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class='bx bx-book-heart me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class='bx bx-video-recording me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class='bx bx-paper-plane me-0'></i>
                                                </button>
                                                <button type="button" class="btn btn-dark"><i class='bx bx-trash-alt me-0'></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <!--end row-->
                                </div>
                            </div>
                            <div class="card radius-10">
                                <div class="card-body">
                                    <div>
                                        <h5 class="card-title">Dropdown Buttons</h5>
                                    </div>
                                    <hr/>
                                    <div class="row row-cols-auto g-3">
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Primary</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Secondary</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Success</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-info dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Info</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-warning dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Warning</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="dropdown">
                                                <button class="btn btn-danger dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Danger</button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary">Primary</button>
                                                <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-secondary">Secondary</button>
                                                <button type="button" class="btn btn-secondary split-bg-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-success">Success</button>
                                                <button type="button" class="btn btn-success split-bg-success dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-info">Info</button>
                                                <button type="button" class="btn btn-info split-bg-info dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-warning">Warning</button>
                                                <button type="button" class="btn btn-warning split-bg-warning dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-danger">Danger</button>
                                                <button type="button" class="btn btn-danger split-bg-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="w-100 border-top"></div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-primary">Dropdown</button>
                                                <button type="button" class="btn btn-outline-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-secondary">Dropdown</button>
                                                <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-success">Dropdown</button>
                                                <button type="button" class="btn btn-outline-success dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-info">Dropdown</button>
                                                <button type="button" class="btn btn-outline-info dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-warning">Dropdown</button>
                                                <button type="button" class="btn btn-outline-warning dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-outline-danger">Dropdown</button>
                                                <button type="button" class="btn btn-outline-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a class="dropdown-item" href="#">Action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Another action</a>
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Something else here</a>
                                                    </li>
                                                    <li>
                                                        <hr class="dropdown-divider">
                                                    </li>
                                                    <li><a class="dropdown-item" href="#">Separated link</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!--end row -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection
