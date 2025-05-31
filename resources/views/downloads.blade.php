		@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
            <div class="page-content">
              <!--breadcrumb-->
                <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                    <div class="breadcrumb-title pe-3">Downloads</div>
                    <div class="ps-3">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mb-0 p-0">
                                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Downloads</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="ms-auto">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary">Settings</button>
                            <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown"> <span class="visually-hidden">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">    <a class="dropdown-item" href="javascript:;">Action</a>
                                <a class="dropdown-item" href="javascript:;">Another action</a>
                                <a class="dropdown-item" href="javascript:;">Something else here</a>
                                <div class="dropdown-divider"></div>    <a class="dropdown-item" href="javascript:;">Separated link</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end breadcrumb-->
                
                <div class="card radius-10">
                    <div class="card-body">
                      <div class="table-responsive">
                      <table class="table align-middle">
                     <thead class="table-dark">
                       <tr>
                         <th>#</th>
                         <th>Product Name</th>
                         <th>Download Button</th>
                       </tr>
                     </thead>
                     <tbody>
                       <tr>
                         <td>1</td>
                         <td>Amdash - Bootstrap 5 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>2</td>
                         <td>Bulona - Angular 10+ Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>3</td>
                         <td>Dashtrans - Bootstrap5 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>4</td>
                         <td>Dashtreme - Angular 10+ Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>5</td>
                         <td>Dashtreme - Laravel 8+ Bootstrap5 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>6</td>
                         <td>Dashtreme - Multipurpose Bootstrap5 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>7</td>
                         <td>Rocker - Angular 10+ Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>8</td>
                         <td>Skodash - Bootstrap 5 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>9</td>
                         <td>Syntrans – Bootstrap4 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                       <tr>
                         <td>10</td>
                         <td>Syndash – Bootstrap4 Admin Template</td>
                         <td><a href="javascript:;" class="btn btn-sm btn-outline-primary">Download</a></td>
                       </tr>
                     </tbody>
                   </table>
                      </div>
                    </div>
                </div>
                
                
            </div>
        </div>
		@endsection
