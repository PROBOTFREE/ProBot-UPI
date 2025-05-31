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
                                    <li class="breadcrumb-item active" aria-current="page">Navs & Tabs</li>
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
                    <div class="row row-cols-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2">
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Primary Nav Tabs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-tabs nav-primary" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="tab" href="#primaryhome" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#primaryprofile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#primarycontact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content py-3">
                                        <div class="tab-pane fade show active" id="primaryhome" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="primaryprofile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="primarycontact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Danger Nav Tabs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-tabs nav-danger" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="tab" href="#dangerhome" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#dangerprofile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#dangercontact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content py-3">
                                        <div class="tab-pane fade show active" id="dangerhome" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="dangerprofile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="dangercontact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Success Nav Tabs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-tabs nav-success" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="tab" href="#successhome" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#successprofile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#successcontact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content py-3">
                                        <div class="tab-pane fade show active" id="successhome" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="successprofile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="successcontact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Warning Nav Tabs</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-tabs nav-warning" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="tab" href="#warninghome" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#warningprofile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#warningcontact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content py-3">
                                        <div class="tab-pane fade show active" id="warninghome" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="warningprofile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="warningcontact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Primary Nav Pills</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-pills mb-3" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="pill" href="#primary-pills-home" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#primary-pills-profile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#primary-pills-contact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content" id="pills-tabContent">
                                        <div class="tab-pane fade show active" id="primary-pills-home" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="primary-pills-profile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="primary-pills-contact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Danger Nav Pills</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-pills nav-pills-danger mb-3" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="pill" href="#danger-pills-home" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#danger-pills-profile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#danger-pills-contact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content" id="danger-pills-tabContent">
                                        <div class="tab-pane fade show active" id="danger-pills-home" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="danger-pills-profile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="danger-pills-contact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Success Nav Pills</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-pills nav-pills-success mb-3" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="pill" href="#success-pills-home" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#success-pills-profile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#success-pills-contact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade show active" id="pills-home" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="success-pills-profile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="success-pills-contact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <h6 class="mb-0 text-uppercase">Warning Nav Pills</h6>
                            <hr/>
                            <div class="card">
                                <div class="card-body">
                                    <ul class="nav nav-pills nav-pills-warning mb-3" role="tablist">
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="pill" href="#warning-pills-home" role="tab" aria-selected="true">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-home font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Home</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#warning-pills-profile" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-user-pin font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Profile</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="nav-item" role="presentation">
                                            <a class="nav-link" data-bs-toggle="pill" href="#warning-pills-contact" role="tab" aria-selected="false">
                                                <div class="d-flex align-items-center">
                                                    <div class="tab-icon"><i class='bx bx-microphone font-18 me-1'></i>
                                                    </div>
                                                    <div class="tab-title">Contact</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade show active" id="warning-pills-home" role="tabpanel">
                                            <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
                                        </div>
                                        <div class="tab-pane fade" id="warning-pills-profile" role="tabpanel">
                                            <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                        </div>
                                        <div class="tab-pane fade" id="warning-pills-contact" role="tabpanel">
                                            <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
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
