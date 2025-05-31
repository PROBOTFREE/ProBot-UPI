	@extends("layouts.app")
		@section("style")
		<link href="assets/plugins/input-tags/css/tagsinput.css" rel="stylesheet" />
		@endsection
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
                                    <li class="breadcrumb-item active" aria-current="page">Form Elements</li>
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
                            <h6 class="mb-0 text-uppercase">Text Inputs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <input class="form-control form-control-lg mb-3" type="text" placeholder=".form-control-lg" aria-label=".form-control-lg example">
                                    <input class="form-control mb-3" type="text" placeholder="Default input" aria-label="default input example">
                                    <input class="form-control form-control-sm mb-3" type="text" placeholder=".form-control-sm" aria-label=".form-control-sm example">
                                    <input class="form-control mb-3" type="text" placeholder="Disabled input" aria-label="Disabled input example" disabled>
                                    <input class="form-control mb-3" type="text" placeholder="Disabled readonly input" aria-label="Disabled input example" disabled readonly>
                                    <input class="form-control" type="text" placeholder="Readonly input here..." aria-label="readonly input example" readonly>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Select Inputs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <select class="form-select mb-3" aria-label="Default select example">
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                    <select class="form-select form-select-sm mb-3" aria-label=".form-select-sm example">
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                    <select class="form-select" aria-label="Disabled select example" disabled>
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">File input</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="mb-3">
                                        <label for="formFile" class="form-label">Default file input example</label>
                                        <input class="form-control" type="file" id="formFile">
                                    </div>
                                    <div class="mb-3">
                                        <label for="formFileMultiple" class="form-label">Multiple files input example</label>
                                        <input class="form-control" type="file" id="formFileMultiple" multiple>
                                    </div>
                                    <div class="mb-3">
                                        <label for="formFileDisabled" class="form-label">Disabled file input example</label>
                                        <input class="form-control" type="file" id="formFileDisabled" disabled>
                                    </div>
                                    <div class="mb-3">
                                        <label for="formFileSm" class="form-label">Small file input example</label>
                                        <input class="form-control form-control-sm" id="formFileSm" type="file">
                                    </div>
                                    <div>
                                        <label for="formFileLg" class="form-label">Large file input example</label>
                                        <input class="form-control form-control-lg" id="formFileLg" type="file">
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Datalists</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <label for="exampleDataList" class="form-label">Datalist example</label>
                                    <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search...">
                                    <datalist id="datalistOptions">
                                        <option value="San Francisco">
                                        <option value="New York">
                                        <option value="Seattle">
                                        <option value="Los Angeles">
                                        <option value="Chicago">
                                    </datalist>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Checkboxes and radios</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">Default checkbox</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                                        <label class="form-check-label" for="flexCheckChecked">Checked checkbox</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckIndeterminate">
                                        <label class="form-check-label" for="flexCheckIndeterminate">Indeterminate checkbox</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDisabled" disabled>
                                        <label class="form-check-label" for="flexCheckDisabled">Disabled checkbox</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckCheckedDisabled" checked disabled>
                                        <label class="form-check-label" for="flexCheckCheckedDisabled">Disabled checked checkbox</label>
                                    </div>
                                    <hr/>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                        <label class="form-check-label" for="flexRadioDefault1">Default radio</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                                        <label class="form-check-label" for="flexRadioDefault2">Default checked radio</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="flexRadioDisabled" id="flexRadioDisabled" disabled>
                                        <label class="form-check-label" for="flexRadioDisabled">Disabled radio</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="flexRadioDisabled" id="flexRadioCheckedDisabled" checked disabled>
                                        <label class="form-check-label" for="flexRadioCheckedDisabled">Disabled checked radio</label>
                                    </div>
                                    <hr/>
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">
                                        <label class="form-check-label" for="flexSwitchCheckDefault">Default switch checkbox input</label>
                                    </div>
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" checked>
                                        <label class="form-check-label" for="flexSwitchCheckChecked">Checked switch checkbox input</label>
                                    </div>
                                    <div class="form-check-danger form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckCheckedDanger" checked>
                                        <label class="form-check-label" for="flexSwitchCheckCheckedDanger">Checked switch checkbox input</label>
                                    </div>
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDisabled" disabled>
                                        <label class="form-check-label" for="flexSwitchCheckDisabled">Disabled switch checkbox input</label>
                                    </div>
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckCheckedDisabled" checked disabled>
                                        <label class="form-check-label" for="flexSwitchCheckCheckedDisabled">Disabled checked switch checkbox input</label>
                                    </div>
                                    <hr/>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                        <label class="form-check-label" for="inlineCheckbox1">1</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                        <label class="form-check-label" for="inlineCheckbox2">2</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" disabled>
                                        <label class="form-check-label" for="inlineCheckbox3">3 (disabled)</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                        <label class="form-check-label" for="inlineRadio1">1</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                        <label class="form-check-label" for="inlineRadio2">2</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" disabled>
                                        <label class="form-check-label" for="inlineRadio3">3 (disabled)</label>
                                    </div>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Input Mask</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <form>
                                        <div class="mb-3">
                                            <label class="form-label">Date:</label>
                                            <input type="date" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Date time:</label>
                                            <input type="datetime-local" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Email:</label>
                                            <input type="email" class="form-control" placeholder="example@gmail.com">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Password:</label>
                                            <input type="password" class="form-control" value="........">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Input File:</label>
                                            <input type="file" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Month:</label>
                                            <input type="month" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Search:</label>
                                            <input type="search" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Tel:</label>
                                            <input type="tel" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Time:</label>
                                            <input type="time" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Url:</label>
                                            <input type="url" class="form-control" placeholder="https://example.com/users/">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Week:</label>
                                            <input type="week" class="form-control">
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Input Tags</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <form>
                                        <div class="mb-3">
                                            <label class="form-label">Basic</label>
                                            <input type="text" class="form-control" data-role="tagsinput" value="jQuery,Script,Net">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Multi Select</label>
                                            <select multiple data-role="tagsinput">
                                                <option value="Amsterdam">Amsterdam</option>
                                                <option value="Washington">Washington</option>
                                                <option value="Sydney">Sydney</option>
                                                <option value="Beijing">Beijing</option>
                                                <option value="Cairo">Cairo</option>
                                            </select>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <h6 class="mb-0 text-uppercase">Range Inputs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <div class="mb-3">
                                        <label for="customRange1" class="form-label">Example range</label>
                                        <input type="range" class="form-range" id="customRange1">
                                    </div>
                                    <div class="mb-3">
                                        <label for="disabledRange" class="form-label">Disabled range</label>
                                        <input type="range" class="form-range" id="disabledRange" disabled>
                                    </div>
                                    <div class="mb-3">
                                        <label for="customRange2" class="form-label">Example range</label>
                                        <input type="range" class="form-range" min="0" max="5" id="customRange2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection

	@section("script")
	<script src="assets/plugins/input-tags/js/tagsinput.js"></script>
	@endsection
