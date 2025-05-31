@extends("layouts.app")

		@section("wrapper")
		<div class="page-wrapper">
			<div class="page-content">
				<div class="row row-cols-1 row-cols-lg-4">
					<div class="col">
						<div class="card radius-10 overflow-hidden bg-gradient-cosmic">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div>
										<p class="mb-0 text-white">Total Orders</p>
										<h5 class="mb-0 text-white">867</h5>
									</div>
									<div class="ms-auto text-white"><i class='bx bx-cart font-30'></i>
									</div>
								</div>
								<div class="progress bg-white-2 radius-10 mt-4" style="height:4.5px;">
									<div class="progress-bar bg-white" role="progressbar" style="width: 46%"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10 overflow-hidden bg-gradient-burning">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div>
										<p class="mb-0 text-white">Total Income</p>
										<h5 class="mb-0 text-white">$52,945</h5>
									</div>
									<div class="ms-auto text-white"><i class='bx bx-wallet font-30'></i>
									</div>
								</div>
								<div class="progress bg-white-2 radius-10 mt-4" style="height:4.5px;">
									<div class="progress-bar bg-white" role="progressbar" style="width: 72%"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10 overflow-hidden bg-gradient-Ohhappiness">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div>
										<p class="mb-0 text-white">Total Users</p>
										<h5 class="mb-0 text-white">24.5K</h5>
									</div>
									<div class="ms-auto text-white"><i class='bx bx-bulb font-30'></i>
									</div>
								</div>
								<div class="progress bg-white-2 radius-10 mt-4" style="height:4.5px;">
									<div class="progress-bar bg-white" role="progressbar" style="width: 68%"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="card radius-10 overflow-hidden bg-gradient-moonlit">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div>
										<p class="mb-0 text-white">Comments</p>
										<h5 class="mb-0 text-white">869</h5>
									</div>
									<div class="ms-auto text-white"><i class='bx bx-chat font-30'></i>
									</div>
								</div>
								<div class="progress  bg-white-2 radius-10 mt-4" style="height:4.5px;">
									<div class="progress-bar bg-white" role="progressbar" style="width: 66%"></div>
								</div>
							</div>
						</div>
					</div>
				</div><!--end row-->
				
				<div class="card radius-10">
					<div class="card-header border-bottom-0 bg-transparent">
						<div class="d-lg-flex align-items-center">
							<div>
								<h6 class="font-weight-bold mb-2 mb-lg-0">Monthly Revenue</h6>
							</div>
							<div class="ms-lg-auto mb-2 mb-lg-0">
								<div class="btn-group-round">
									<div class="btn-group">
										<button type="button" class="btn btn-white">Day</button>
										<button type="button" class="btn btn-white">Week</button>
										<button type="button" class="btn btn-white">Month</button>
									</div>
								</div>
							</div>
							<div>
								<button type="button" class="btn btn-primary radius-10 ms-lg-3">Download CSV</button>
							</div>
						</div>
					</div>
					<div class="card-body">
						<div id="chart1"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-12 col-lg-8">
						<div class="card radius-10">
							<div class="card-header border-bottom-0 bg-transparent">
								<div class="d-lg-flex align-items-center">
									<div>
										<h6 class="font-weight-bold mb-2 mb-lg-0">Historical Analytics</h6>
									</div>
									<div class="font-22 ms-auto"><i class="bx bx-dots-horizontal-rounded"></i>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="d-flex align-items-center ms-auto font-13 gap-2">
									<span class="border px-1 rounded cursor-pointer"><i class="bx bxs-circle text-danger me-1"></i>Visitors</span>
									<span class="border px-1 rounded cursor-pointer"><i class="bx bxs-circle text-success me-1"></i>Chats</span>
									<span class="border px-1 rounded cursor-pointer"><i class="bx bxs-circle text-info me-1"></i>Page Views</span>
								</div>
								<div id="chart2"></div>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-4">
						<div class="card radius-10 bg-primary">
							<div class="card-body">
								<h6 class="text-white">Active Visitors</h6>
								<h4 class="font-weight-bold text-white">3467</h4>
								<p class="font-13 text-white">Page view per minute</p>
								<div id="chart3"></div>
							</div>
						</div>
						<div class="card radius-10">
							<div class="card-body">
								<div class="revenue-by-channel">
									<h6 class="mb-4 font-weight-bold">Revenue by Channel</h6>
									<div class="progress-wrapper">
										<div class="d-flex align-items-center">
											<div class="text-secondary">Direct</div>
											<div class="ms-auto pe-4">$1,24,685</div>
											<div class="text-success">65.6%</div>
										</div>
										<div class="progress mt-2" style="height:3px;">
											<div class="progress-bar" role="progressbar" style="width: 65%"></div>
										</div>
									</div>
									<div class="progress-wrapper mt-3">
										<div class="d-flex align-items-center">
											<div class="text-secondary">Referral</div>
											<div class="ms-auto pe-4">$1,22,863</div>
											<div class="text-success">45.6%</div>
										</div>
										<div class="progress mt-2" style="height:3px;">
											<div class="progress-bar" role="progressbar" style="width: 55%"></div>
										</div>
									</div>
									<div class="progress-wrapper mt-3">
										<div class="d-flex align-items-center">
											<div class="text-secondary">Social</div>
											<div class="ms-auto pe-4">$1,24,685</div>
											<div class="text-danger">25.2%</div>
										</div>
										<div class="progress mt-2" style="height:3px;">
											<div class="progress-bar" role="progressbar" style="width: 35%"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
				<div class="row">
					<div class="col-12 col-lg-6 d-flex">
						<div class="card radius-10 w-100">
							<div class="card-body">
								<div class="d-flex align-items-center">
									<div>
										<h6 class="font-weight-bold mb-0">Order Status</h6>
									</div>
									<div class="dropdown ms-auto">
										<div class="cursor-pointer text-dark font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class="bx bx-dots-horizontal-rounded"></i>
										</div>
										<div class="dropdown-menu dropdown-menu-end">
											<a class="dropdown-item" href="javaScript:;">Action</a>
											<a class="dropdown-item" href="javaScript:;">Another action</a>
											<div class="dropdown-divider"></div>	
											<a class="dropdown-item" href="javaScript:;">Something else here</a>
										</div>
									</div>
								</div>
								<div id="chart4"></div>
								<div class="d-flex align-items-center justify-content-between text-center">
									<div>
										<h5 class="mb-1 font-weight-bold">289</h5>
										<p class="mb-0 text-secondary">Booked</p>
									</div>
									<div class="mb-1">
										<h5 class="mb-1 font-weight-bold">348</h5>
										<p class="mb-0 text-secondary">In Progress</p>
									</div>
									<div>
										<h5 class="mb-1 font-weight-bold">152</h5>
										<p class="mb-0 text-secondary">Canceled</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-6 d-flex">
						<div class="card w-100 radius-10 shadow-none bg-transparent">
							<div class="card-body p-0">
								<div class="card radius-10 bg-primary">
									<div class="card-body">
										<div id="chart5"></div>
										<div class="d-flex align-items-center justify-content-between">
											<div>
												<h4 class="mb-0 font-weight-bold text-white">$534.8</h4>
												<p class="mb-0 text-white">Average Weekly Sales</p>
											</div>
											<div><i class='bx bx-diamond font-24 text-white'></i>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-cols-1 row-cols-sm-2">
									<div class="col">
										<div class="card radius-10 mb-sm-0">
											<div class="card-body">
												<div id="chart6"></div>
											</div>
										</div>
									</div>
									<div class="col">
										<div class="card radius-10 mb-0">
											<div class="card-body">
												<div id="chart7"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->

				<div class="row row-cols-1 row-cols-lg-3">
                   <div class="col d-flex">
					<div class="card radius-10 w-100">
						<div class="card-body">
							<div class="d-flex align-items-center">
								<div>
									<h6 class="font-weight-bold mb-0">Best Selling Products</h6>
								</div>
								<div class="dropdown ms-auto">
									<div class="cursor-pointer text-dark font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class="bx bx-dots-horizontal-rounded"></i>
									</div>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="javaScript:;">Action</a>
										<a class="dropdown-item" href="javaScript:;">Another action</a>
										<div class="dropdown-divider"></div>	
										<a class="dropdown-item" href="javaScript:;">Something else here</a>
									</div>
								</div>
							</div>
						   </div>
							<div class="best-selling-products p-3 mb-3">
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/ice-cream-cornet.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Cone Ice Cream</h6>
										<p class="mb-0 text-secondary">$29/Each 56 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$521.52</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/wine-glass.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Wine Glass</h6>
										<p class="mb-0 text-secondary">$30/Each 48 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$406.87</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/banana.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Banana Toy</h6>
										<p class="mb-0 text-secondary">$26/Each 66 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$685.69</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/telephone.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Old Telephone</h6>
										<p class="mb-0 text-secondary">$39/Each 26 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$913.72</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/plate.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Orange Plate</h6>
										<p class="mb-0 text-secondary">$22/Each 34 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$372.62</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/telephone.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Old Telephone</h6>
										<p class="mb-0 text-secondary">$39/Each 26 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$913.72</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/banana.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Banana Toy</h6>
										<p class="mb-0 text-secondary">$26/Each 66 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$685.69</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/wine-glass.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Wine Glass</h6>
										<p class="mb-0 text-secondary">$30/Each 48 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$406.87</p>
								</div>
								<hr>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/ice-cream-cornet.png" class="p-1" class="" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Cone Ice Cream</h6>
										<p class="mb-0 text-secondary">$29/Each 56 Orders</p>
									</div>
									<p class="ms-auto mb-0 text-purple">$521.52</p>
								</div>
							</div>
					</div>
				   </div>
				   <div class="col d-flex">
					<div class="card radius-10 w-100">
						<div class="card-body">
							<div class="d-flex align-items-center">
								<div>
									<h6 class="font-weight-bold mb-0">Recent Reviews</h6>
								</div>
								<div class="dropdown ms-auto">
									<div class="cursor-pointer text-dark font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class="bx bx-dots-horizontal-rounded"></i>
									</div>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="javaScript:;">Action</a>
										<a class="dropdown-item" href="javaScript:;">Another action</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="javaScript:;">Something else here</a>
									</div>
								</div>
							</div>
						  </div>
							<div class="recent-reviews p-3 mb-3">
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/banana.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Banana Toy</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/telephone.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Old Telephone</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/wine-glass.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Wine Glass</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/plate.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Orange Plate</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/ice-cream-cornet.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Cone Ice Cream</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/telephone.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Old Telephone</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/wine-glass.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Wine Glass</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
								<hr/>
								<div class="d-flex align-items-center">
									<div class="product-img">
										<img src="assets/images/icons/plate.png" class="p-1" alt="" />
									</div>
									<div class="ps-3">
										<h6 class="mb-0 font-weight-bold">Orange Plate</h6>
									</div>
									<p class="ms-auto mb-0"><i class='bx bxs-star text-warning mr-1'></i> 5.00</p>
								</div>
							</div>
						
					</div>
				   </div>
				   <div class="col d-flex">
					<div class="card radius-10 w-100">
						<div class="card-body">
							<div class="d-flex align-items-center">
								<div>
									<h6 class="font-weight-bold mb-0">Support Inbox</h6>
								</div>
								<div class="dropdown ms-auto">
									<div class="cursor-pointer text-dark font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class="bx bx-dots-horizontal-rounded"></i>
									</div>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="javaScript:;">Action</a>
										<a class="dropdown-item" href="javaScript:;">Another action</a>
										<div class="dropdown-divider"></div>	
										<a class="dropdown-item" href="javaScript:;">Something else here</a>
									</div>
								</div>
							 </div>
						    </div>
							<div class="support-list p-3 mb-3">
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-1.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Jordan Ntolo <span class="text-primary float-end font-13">2 hours ago</span></h6>
										<p class="mb-0 font-13 text-secondary">My item doesn't ship to correct address. Please check It Proper</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-2.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Carolien Bloeme <span class="text-primary float-end font-13">3 hours ago</span></h6>
										<p class="mb-0 font-13 text-secondary">You shipped different color, I need it to be changed</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-3.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Lisanne Viscall <span class="text-primary float-end font-13">12 hours ago</span></h6>
										<p class="mb-0 font-13 text-secondary">Can you please refund my money. I don't want to wait anymore</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-4.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Sun Jun <span class="text-primary float-end font-13">12 Yesterday</span></h6>
										<p class="mb-0 font-13 text-secondary">Please return my phone. it is not iPhon7. I send you many request.</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-5.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Lotila Remo <span class="text-primary float-end font-13">2 days ago</span></h6>
										<p class="mb-0 font-13 text-secondary">Hello, I need admin template product. how can i purchase?</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-2.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Carolien Bloeme <span class="text-primary float-end font-13">3 hours ago</span></h6>
										<p class="mb-0 font-13 text-secondary">You shipped different color, I need it to be changed</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-3.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Lisanne Viscall <span class="text-primary float-end font-13">12 hours ago</span></h6>
										<p class="mb-0 font-13 text-secondary">Can you please refund my money. I don't want to wait anymore</p>
									</div>
								</div>
								<hr/>
								<div class="d-flex align-items-top">
									<div class="">
										<img src="assets/images/avatars/avatar-4.png" width="45" height="45" class="rounded-circle" alt="" />
									</div>
									<div class="ps-2">
										<h6 class="mb-1 font-weight-bold">Sun Jun <span class="text-primary float-end font-13">12 Yesterday</span></h6>
										<p class="mb-0 font-13 text-secondary">Please return my phone. it is not iPhon7. I send you many request.</p>
									</div>
								</div>
							</div>
						
					</div>
				   </div>
				</div>
				<!--end row-->

				<div class="card radius-10">
					<div class="card-header border-bottom-0 bg-transparent">
						<div class="d-flex align-items-center">
							<div>
								<h5 class="font-weight-bold mb-0">Recent Orders</h5>
							</div>
							<div class="ms-auto">
								<button type="button" class="btn btn-white radius-10">View More</button>
							</div>
						</div>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table mb-0 align-middle">
								<thead>
									<tr>
										<th>Photo</th>
										<th>Product Name</th>
										<th>Customer</th>
										<th>Product id</th>
										<th>Price</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/shoes.png" class="p-1" alt="">
											</div>
										</td>
										<td>Nike Sports NK</td>
										<td>Mitchell Daniel</td>
										<td>#9668521</td>
										<td>$99.85</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-success radius-30">Delivered</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/smartphone.png" class="p-1" alt="">
											</div>
										</td>
										<td>Redmi Airdts</td>
										<td>Craig Clayton</td>
										<td>#8627523</td>
										<td>$59.35</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-danger radius-30">Cancelled</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/mouse.png" class="p-1" alt="">
											</div>
										</td>
										<td>Magic Mouse 2</td>
										<td>Julia Burke</td>
										<td>#6875954</td>
										<td>$42.68</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-warning radius-30">Pending</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/tshirt.png" class="p-1" alt="">
											</div>
										</td>
										<td>Coton-T-Shirt</td>
										<td>Clark Natela</td>
										<td>#4587892</td>
										<td>$32.78</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-success radius-30">Delivered</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/headphones.png" class="p-1" alt="">
											</div>
										</td>
										<td>Headphones 7</td>
										<td>Robin Mandela</td>
										<td>#5587426</td>
										<td>$29.52</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-success radius-30">Delivered</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/mouse.png" class="p-1" alt="">
											</div>
										</td>
										<td>Magic Mouse 2</td>
										<td>Julia Burke</td>
										<td>#6875954</td>
										<td>$42.68</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-warning radius-30">Pending</a>
										</td>
									</tr>
									<tr>
										<td>
											<div class="product-img bg-transparent border">
												<img src="assets/images/icons/tshirt.png" class="p-1" alt="">
											</div>
										</td>
										<td>Coton-T-Shirt</td>
										<td>Clark Natela</td>
										<td>#4587892</td>
										<td>$32.78</td>
										<td><a href="javaScript:;" class="btn btn-sm btn-success radius-30">Delivered</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		@endsection
		
	@section("script")
	<script src="assets/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
	<script src="assets/js/index3.js"></script>
	<script>
		new PerfectScrollbar('.best-selling-products');
		new PerfectScrollbar('.recent-reviews');
		new PerfectScrollbar('.support-list');
	</script>
	<script>
		$("html").attr("class","color-sidebar sidebarcolor3 color-header headercolor1");
	</script>
	@endsection