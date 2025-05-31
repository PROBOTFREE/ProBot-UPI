		@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
      <div class="page-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
          <div class="breadcrumb-title pe-3">Earnings</div>
          <div class="ps-3">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb mb-0 p-0">
                <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">Earnings</li>
              </ol>
            </nav>
          </div>
          <div class="ms-auto">
            <div class="btn-group">
              <button type="button" class="btn btn-primary">Settings</button>
              <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown"> <span class="visually-hidden">Toggle Dropdown</span>
              </button>
              <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">  <a class="dropdown-item" href="javascript:;">Action</a>
                <a class="dropdown-item" href="javascript:;">Another action</a>
                <a class="dropdown-item" href="javascript:;">Something else here</a>
                <div class="dropdown-divider"></div>  <a class="dropdown-item" href="javascript:;">Separated link</a>
              </div>
            </div>
          </div>
        </div>
        <!--end breadcrumb-->
        
        <div class="row row-cols-1 row-cols-md-2 row-cols-xl-4">
          <div class="col">
            <div class="card radius-10 bg-gradient-blues">
           <div class="card-body">
             <div class="text-center">
               <p class="mb-2 text-white">This months earnings</p>
               <h3 class="mb-0 text-white">$857.73</h3>
             </div>
           </div>
          </div><!--end row-->
          </div>
          <div class="col">
            <div class="card radius-10 bg-gradient-burning">
           <div class="card-body">
            <div class="text-center">
               <p class="mb-2 text-white">Last 30 days earnings</p>
               <h3 class="mb-0 text-white">$1258.24</h3>
             </div>
           </div>
          </div><!--end row-->
          </div>
          <div class="col">
            <div class="card radius-10 bg-gradient-lush">
           <div class="card-body">
            <div class="text-center">
               <p class="mb-2 text-white">Earnings of this year</p>
               <h3 class="mb-0 text-white">$14,560.83</h3>
             </div>
           </div>
          </div><!--end row-->
          </div>
          <div class="col">
            <div class="card radius-10 bg-gradient-moonlit">
           <div class="card-body">
            <div class="text-center">
               <p class="mb-2 text-white">Life time earnings</p>
               <h3 class="mb-0 text-white">$8,59,672.78</h3>
             </div>
           </div>
          </div><!--end row-->
          </div>
          
        </div><!--end row-->
        
        
        <div class="card radius-10">
          <div class="card-header bg-transparent">
             <h5 class="mb-0">Daily earnings</h5>
             <small><i class="bx bxs-calendar"></i> in last 30 days</small>
          </div>
          <div class="card-body">
           <div id="chart1"></div>
          </div>
        </div>
        
        <div class="row">
          <div class="col-12 col-lg-6 col-xl-6">
            <div class="card radius-10">
            <div class="card-body">
               <div class="table-responsive">
               <table class="table">
                 <thead class="table-dark">
                 <tr>
                   <th>#</th>
                 <th>Day</th>
                 <th>Sale</th>
                 <th>Earnings</th>
                 </tr>
               </thead>
               <tbody>
                 <tr>
                   <td>1</td>
                 <td>Monday</td>
                 <td>6</td>
                 <td>$40</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Tuesday</td>
                 <td>8</td>
                 <td>$60</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Wednesday</td>
                 <td>5</td>
                 <td>$80</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Thursday</td>
                 <td>10</td>
                 <td>$120</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Friday</td>
                 <td>5</td>
                 <td>$70</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Saturday</td>
                 <td>7</td>
                 <td>$44</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Sunday</td>
                 <td>9</td>
                 <td>$40</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Monday</td>
                 <td>4</td>
                 <td>$56</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Tuesday</td>
                 <td>6</td>
                 <td>$132</td>
                 </tr>
                 <tr>
                   <td>1</td>
                 <td>Wednesday</td>
                 <td>5</td>
                 <td>$80</td>
                 </tr>
               </tbody>
               </table>
             </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-lg-6 col-xl-6">
            <div class="card radius-10 overflow-hidden">
            <div class="card-body">
              <div class="d-lg-flex align-items-center">
                <div>
                  <h5 class="mb-0">Top countries</h5>
                </div>
                <div class="ms-auto">
                  <h3 class="mb-0"><span class="font-14">Total Sales:</span> 9587</h3>
                </div>
              </div>
            
            <hr/>
            <div class="dashboard-top-countries">
              <ul class="list-group list-group-flush radius-10">
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-in"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">India</h6>
                    </div>
                  </div>
                  <div class="ms-auto">647</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-us"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">United States</h6>
                    </div>
                  </div>
                  <div class="ms-auto">435</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-vn"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Vietnam</h6>
                    </div>
                  </div>
                  <div class="ms-auto">287</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-au"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Australia</h6>
                    </div>
                  </div>
                  <div class="ms-auto">432</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-dz"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Angola</h6>
                    </div>
                  </div>
                  <div class="ms-auto">345</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-ax"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Aland Islands</h6>
                    </div>
                  </div>
                  <div class="ms-auto">134</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-ar"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Argentina</h6>
                    </div>
                  </div>
                  <div class="ms-auto">147</div>
                </li>
                <li class="list-group-item d-flex align-items-center">
                  <div class="d-flex align-items-center">
                    <div class="font-20"><i class="flag-icon flag-icon-be"></i>
                    </div>
                    <div class="flex-grow-1 ms-2">
                      <h6 class="mb-0">Belgium</h6>
                    </div>
                  </div>
                  <div class="ms-auto">210</div>
                </li>
              </ul>
            </div>
            </div>
          </div>
          </div>
        </div><!--end row-->
        
        
      </div>
    </div>
		@endsection
    @section('script')
    <script src="assets/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
    <script src="assets/js/earnings.js"></script>
    @endsection
