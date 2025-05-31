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
                                    <li class="breadcrumb-item active" aria-current="page">Input Group</li>
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
                        <div class="col-xl-9 mx-auto">
                            <h6 class="mb-0 text-uppercase">Basic example</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3"> <span class="input-group-text" id="basic-addon1">@</span>
                                        <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2"> <span class="input-group-text" id="basic-addon2">@example.com</span>
                                    </div>
                                    <label for="basic-url" class="form-label">Your vanity URL</label>
                                    <div class="input-group mb-3"> <span class="input-group-text" id="basic-addon3">https://example.com/users/</span>
                                        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                                    </div>
                                    <div class="input-group mb-3"> <span class="input-group-text">$</span>
                                        <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)"> <span class="input-group-text">.00</span>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder="Username" aria-label="Username"> <span class="input-group-text">@</span>
                                        <input type="text" class="form-control" placeholder="Server" aria-label="Server">
                                    </div>
                                    <div class="input-group"> <span class="input-group-text">With textarea</span>
                                        <textarea class="form-control" aria-label="With textarea"></textarea>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Wrapping</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group flex-nowrap"> <span class="input-group-text" id="addon-wrapping">@</span>
                                        <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Sizing</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group input-group-sm mb-3"> <span class="input-group-text" id="inputGroup-sizing-sm">Small</span>
                                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                                    </div>
                                    <div class="input-group mb-3"> <span class="input-group-text" id="inputGroup-sizing-default">Default</span>
                                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                    </div>
                                    <div class="input-group input-group-lg"> <span class="input-group-text" id="inputGroup-sizing-lg">Large</span>
                                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Checkboxes and radios</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <div class="input-group-text">
                                            <input class="form-check-input" type="checkbox" value="" aria-label="Checkbox for following text input">
                                        </div>
                                        <input type="text" class="form-control" aria-label="Text input with checkbox">
                                    </div>
                                    <div class="input-group">
                                        <div class="input-group-text">
                                            <input class="form-check-input" type="radio" value="" aria-label="Radio button for following text input">
                                        </div>
                                        <input type="text" class="form-control" aria-label="Text input with radio button">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Multiple inputs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group"> <span class="input-group-text">First and last name</span>
                                        <input type="text" aria-label="First name" class="form-control">
                                        <input type="text" aria-label="Last name" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Multiple addons</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3"> <span class="input-group-text">$</span>
                                        <span class="input-group-text">0.00</span>
                                        <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
                                    </div>
                                    <div class="input-group">
                                        <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)"> <span class="input-group-text">$</span>
                                        <span class="input-group-text">0.00</span>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Button addons</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon1">Button</button>
                                        <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
                                    </div>
                                    <div class="input-group mb-3">
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                        <input type="text" class="form-control" placeholder="" aria-label="Example text with two button addons">
                                    </div>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username with two button addons">
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Buttons with dropdowns</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
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
                                        <input type="text" class="form-control" aria-label="Text input with dropdown button">
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" aria-label="Text input with dropdown button">
                                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                        <ul class="dropdown-menu dropdown-menu-end">
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
                                    <div class="input-group">
                                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="#">Action before</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Another action before</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Something else here</a>
                                            </li>
                                            <li>
                                                <hr class="dropdown-divider">
                                            </li>
                                            <li><a class="dropdown-item" href="#">Separated link</a>
                                            </li>
                                        </ul>
                                        <input type="text" class="form-control" aria-label="Text input with 2 dropdown buttons">
                                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                        <ul class="dropdown-menu dropdown-menu-end">
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
                            <h6 class="mb-0 text-uppercase">Segmented buttons</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <button type="button" class="btn btn-outline-secondary">Action</button>
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
                                        <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                                    </div>
                                    <div class="input-group">
                                        <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                                        <button type="button" class="btn btn-outline-secondary">Action</button>
                                        <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">	<span class="visually-hidden">Toggle Dropdown</span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-end">
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
                            <h6 class="mb-0 text-uppercase">Custom forms</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <label class="input-group-text" for="inputGroupSelect01">Options</label>
                                        <select class="form-select" id="inputGroupSelect01">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="input-group mb-3">
                                        <select class="form-select" id="inputGroupSelect02">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                        <label class="input-group-text" for="inputGroupSelect02">Options</label>
                                    </div>
                                    <div class="input-group mb-3">
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                        <select class="form-select" id="inputGroupSelect03" aria-label="Example select with button addon">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                    <div class="input-group">
                                        <select class="form-select" id="inputGroupSelect04" aria-label="Example select with button addon">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                        <button class="btn btn-outline-secondary" type="button">Button</button>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Custom file input</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="input-group mb-3">
                                        <label class="input-group-text" for="inputGroupFile01">Upload</label>
                                        <input type="file" class="form-control" id="inputGroupFile01">
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="file" class="form-control" id="inputGroupFile02">
                                        <label class="input-group-text" for="inputGroupFile02">Upload</label>
                                    </div>
                                    <div class="input-group mb-3">
                                        <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon03">Button</button>
                                        <input type="file" class="form-control" id="inputGroupFile03" aria-describedby="inputGroupFileAddon03" aria-label="Upload">
                                    </div>
                                    <div class="input-group">
                                        <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                                        <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Button</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection



