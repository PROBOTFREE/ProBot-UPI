		@extends("layouts.app")
		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Forms</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Form Layouts</li>
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
                        <div class="col-xl-7 mx-auto">
                            <h6 class="mb-0 text-uppercase">Basic Form</h6>
                            <hr/>
                            <div class="card border-top border-0 border-4 border-primary">
                                <div class="card-body p-5">
                                    <div class="card-title d-flex align-items-center">
                                        <div><i class="bx bxs-user me-1 font-22 text-primary"></i>
                                        </div>
                                        <h5 class="mb-0 text-primary">User Registration</h5>
                                    </div>
                                    <hr>
                                    <form class="row g-3">
                                        <div class="col-md-6">
                                            <label for="inputFirstName" class="form-label">First Name</label>
                                            <input type="email" class="form-control" id="inputFirstName">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputLastName" class="form-label">Last Name</label>
                                            <input type="password" class="form-control" id="inputLastName">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputEmail" class="form-label">Email</label>
                                            <input type="email" class="form-control" id="inputEmail">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputPassword" class="form-label">Password</label>
                                            <input type="password" class="form-control" id="inputPassword">
                                        </div>
                                        <div class="col-12">
                                            <label for="inputAddress" class="form-label">Address</label>
                                            <textarea class="form-control" id="inputAddress" placeholder="Address..." rows="3"></textarea>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputAddress2" class="form-label">Address 2</label>
                                            <textarea class="form-control" id="inputAddress2" placeholder="Address 2..." rows="3"></textarea>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputCity" class="form-label">City</label>
                                            <input type="text" class="form-control" id="inputCity">
                                        </div>
                                        <div class="col-md-4">
                                            <label for="inputState" class="form-label">State</label>
                                            <select id="inputState" class="form-select">
                                                <option selected>Choose...</option>
                                                <option>...</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputZip" class="form-label">Zip</label>
                                            <input type="text" class="form-control" id="inputZip">
                                        </div>
                                        <div class="col-12">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                                <label class="form-check-label" for="gridCheck">Check me out</label>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary px-5">Register</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Form with icons</h6>
                            <hr/>
                            <div class="card border-top border-0 border-4 border-danger">
                                <div class="card-body p-5">
                                    <div class="card-title d-flex align-items-center">
                                        <div><i class="bx bxs-user me-1 font-22 text-danger"></i>
                                        </div>
                                        <h5 class="mb-0 text-danger">User Registration</h5>
                                    </div>
                                    <hr>
                                    <form class="row g-3">
                                        <div class="col-md-6">
                                            <label for="inputLastName1" class="form-label">First Name</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-user'></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputLastName1" placeholder="First Name" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="inputLastName2" class="form-label">Last Name</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-user'></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputLastName2" placeholder="Last Name" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputPhoneNo" class="form-label">Phone No</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-microphone' ></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputPhoneNo" placeholder="Phone No" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputEmailAddress" class="form-label">Email Address</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-message' ></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputEmailAddress" placeholder="Email Address" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputChoosePassword" class="form-label">Choose Password</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-lock-open' ></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputChoosePassword" placeholder="Choose Password" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputConfirmPassword" class="form-label">Confirm Password</label>
                                            <div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-lock' ></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputConfirmPassword" placeholder="Confirm Password" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputAddress3" class="form-label">Address</label>
                                            <textarea class="form-control" id="inputAddress3" placeholder="Enter Address" rows="3"></textarea>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" id="gridCheck2">
                                                <label class="form-check-label" for="gridCheck2">Check me out</label>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-danger px-5">Register</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Login Form</h6>
                            <hr/>
                            <div class="card border-top border-0 border-4 border-dark">
                                <div class="card-body p-5">
                                    <div class="card-title text-center"><i class="bx bxs-user-circle text-dark font-50"></i>
                                        <h5 class="mb-5 mt-2 text-dark">User Login</h5>
                                    </div>
                                    <hr>
                                    <form class="row g-3">
                                        <div class="col-12">
                                            <label for="inputLastEnterUsername" class="form-label">Enter Username</label>
                                            <div class="input-group input-group-lg"> <span class="input-group-text bg-transparent"><i class='bx bxs-user'></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputLastEnterUsername" placeholder="Enter Username" />
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <label for="inputLastEnterPassword" class="form-label">Enter Password</label>
                                            <div class="input-group input-group-lg"> <span class="input-group-text bg-transparent"><i class='bx bxs-lock-open'></i></span>
                                                <input type="text" class="form-control border-start-0" id="inputLastEnterPassword" placeholder="Enter Password" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" id="gridCheck3">
                                                <label class="form-check-label" for="gridCheck3">Check me out</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 text-end">	<a href="javascript:;">Forgot Password ?</a>
                                        </div>
                                        <div class="col-12">
                                            <div class="d-grid">
                                                <button type="submit" class="btn btn-dark btn-lg px-5"><i class='bx bxs-lock-open'></i>Login</button>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="col-12 text-center">
                                            <p class="mb-0">or Sign in with:</p>
                                        </div>
                                        <div class="col-12">
                                            <div class="d-grid gap-2">
                                                <button type="submit" class="btn btn-facebook btn-lg px-5"><i class='bx bxl-facebook'></i>Login with facebook</button>
                                                <button type="submit" class="btn btn-light btn-lg px-5"><i class='bx bxl-google'></i>Login with Google</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                    <div class="row">
                        <div class="col-xl-9 mx-auto">
                            <h6 class="mb-0 text-uppercase">Horizontal Form</h6>
                            <hr/>
                            <div class="card border-top border-0 border-4 border-info">
                                <div class="card-body">
                                    <div class="border p-4 rounded">
                                        <div class="card-title d-flex align-items-center">
                                            <div><i class="bx bxs-user me-1 font-22 text-info"></i>
                                            </div>
                                            <h5 class="mb-0 text-info">User Registration</h5>
                                        </div>
                                        <hr/>
                                        <div class="row mb-3">
                                            <label for="inputEnterYourName" class="col-sm-3 col-form-label">Enter Your Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="inputEnterYourName" placeholder="Enter Your Name">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputPhoneNo2" class="col-sm-3 col-form-label">Phone No</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="inputPhoneNo2" placeholder="Phone No">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputEmailAddress2" class="col-sm-3 col-form-label">Email Address</label>
                                            <div class="col-sm-9">
                                                <input type="email" class="form-control" id="inputEmailAddress2" placeholder="Email Address">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputChoosePassword2" class="col-sm-3 col-form-label">Choose Password</label>
                                            <div class="col-sm-9">
                                                <input type="email" class="form-control" id="inputChoosePassword2" placeholder="Choose Password">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputConfirmPassword2" class="col-sm-3 col-form-label">Confirm Password</label>
                                            <div class="col-sm-9">
                                                <input type="email" class="form-control" id="inputConfirmPassword2" placeholder="Confirm Password">
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputAddress4" class="col-sm-3 col-form-label">Address</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" id="inputAddress4" rows="3" placeholder="Address"></textarea>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="inputAddress4" class="col-sm-3 col-form-label"></label>
                                            <div class="col-sm-9">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" id="gridCheck4">
                                                    <label class="form-check-label" for="gridCheck4">Check me out</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-3 col-form-label"></label>
                                            <div class="col-sm-9">
                                                <button type="submit" class="btn btn-info px-5">Register</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection



