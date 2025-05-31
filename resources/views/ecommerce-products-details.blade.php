@extends("layouts.app")
		
		@section("style")
		<link href="assets/plugins/OwlCarousel/css/owl.carousel.min.css" rel="stylesheet" />
		@endsection

		@section("wrapper")
		<!--start page wrapper -->
		<div class="page-wrapper">
			<div class="page-content">

				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">eCommerce</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Products Details</li>
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

				 <div class="card">
					<div class="row g-0">
					  <div class="col-md-4 border-end">
						<div class="image-zoom-section">
							<div class="product-gallery owl-carousel owl-theme border mb-3 p-3" data-slider-id="1">
								<div class="item">
									<img src="assets/images/products/11.png" class="img-fluid" alt="">
								</div>
								<div class="item">
									<img src="assets/images/products/12.png" class="img-fluid" alt="">
								</div>
								<div class="item">
									<img src="assets/images/products/13.png" class="img-fluid" alt="">
								</div>
								<div class="item">
									<img src="assets/images/products/14.png" class="img-fluid" alt="">
								</div>
							</div>
							<div class="owl-thumbs d-flex justify-content-center" data-slider-id="1">
								<button class="owl-thumb-item">
									<img src="assets/images/products/11.png" class="" alt="">
								</button>
								<button class="owl-thumb-item">
									<img src="assets/images/products/12.png" class="" alt="">
								</button>
								<button class="owl-thumb-item">
									<img src="assets/images/products/13.png" class="" alt="">
								</button>
								<button class="owl-thumb-item">
									<img src="assets/images/products/14.png" class="" alt="">
								</button>
							</div>
						</div>
					  </div>
					  <div class="col-md-8">
						<div class="card-body">
						  <h4 class="card-title">Off-White Odsy-1000 Men Half T-Shirt</h4>
						  <div class="d-flex gap-3 py-3">
							<div class="cursor-pointer">
								<i class='bx bxs-star text-warning'></i>
								<i class='bx bxs-star text-warning'></i>
								<i class='bx bxs-star text-warning'></i>
								<i class='bx bxs-star text-warning'></i>
								<i class='bx bxs-star text-secondary'></i>
							  </div>	
							  <div>142 reviews</div>
							  <div class="text-success"><i class='bx bxs-cart-alt align-middle'></i> 134 orders</div>
						  </div>
						  <div class="mb-3"> 
							<span class="price h4">$149.00</span> 
							<span class="text-muted">/per kg</span> 
						  </div>
						  <p class="card-text fs-6">Virgil Abloh’s Off-White is a streetwear-inspired collection that continues to break away from the conventions of mainstream fashion. Made in Italy, these black and brown Odsy-1000 low-top sneakers.</p>
						  <dl class="row">
							<dt class="col-sm-3">Model#</dt>
							<dd class="col-sm-9">Odsy-1000</dd>
						  
							<dt class="col-sm-3">Color</dt>
							<dd class="col-sm-9">Brown</dd>
						  
							<dt class="col-sm-3">Delivery</dt>
							<dd class="col-sm-9">Russia, USA, and Europe </dd>
						  </dl>
						  <hr>
						  <div class="row row-cols-auto align-items-center mt-3">
							<div class="col">
								<label class="form-label">Quantity</label>
								<select class="form-select form-select-sm">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="col">
								<label class="form-label">Size</label>
								<select class="form-select form-select-sm">
									<option>S</option>
									<option>M</option>
									<option>L</option>
									<option>XS</option>
									<option>XL</option>
								</select>
							</div>
							<div class="col">
								<label class="form-label">Colors</label>
								<div class="color-indigators d-flex align-items-center gap-2">
									<div class="color-indigator-item bg-primary"></div>
									<div class="color-indigator-item bg-danger"></div>
									<div class="color-indigator-item bg-success"></div>
									<div class="color-indigator-item bg-warning"></div>
								</div>
							</div>
						</div>
						<!--end row-->
						<div class="d-flex gap-2 mt-3">
							<a href="javascript:;" class="btn btn-primary"><i class="bx bxs-cart-add"></i>Add to Cart</a>
							<a href="javascript:;" class="btn btn-light"><i class="bx bx-heart"></i>Add to Wishlist</a>
						</div>
						</div>
					  </div>
					</div>
                    <hr/>
					<div class="card-body">
						<ul class="nav nav-tabs nav-primary mb-0" role="tablist">
							<li class="nav-item" role="presentation">
								<a class="nav-link active" data-bs-toggle="tab" href="#primaryhome" role="tab" aria-selected="true">
									<div class="d-flex align-items-center">
										<div class="tab-icon"><i class='bx bx-comment-detail font-18 me-1'></i>
										</div>
										<div class="tab-title"> Product Description </div>
									</div>
								</a>
							</li>
							<li class="nav-item" role="presentation">
								<a class="nav-link" data-bs-toggle="tab" href="#primaryprofile" role="tab" aria-selected="false">
									<div class="d-flex align-items-center">
										<div class="tab-icon"><i class='bx bx-bookmark-alt font-18 me-1'></i>
										</div>
										<div class="tab-title">Tags</div>
									</div>
								</a>
							</li>
							<li class="nav-item" role="presentation">
								<a class="nav-link" data-bs-toggle="tab" href="#primarycontact" role="tab" aria-selected="false">
									<div class="d-flex align-items-center">
										<div class="tab-icon"><i class='bx bx-star font-18 me-1'></i>
										</div>
										<div class="tab-title">Reviews</div>
									</div>
								</a>
							</li>
						</ul>
						<div class="tab-content pt-3">
							<div class="tab-pane fade show active" id="primaryhome" role="tabpanel">
								<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
								<ul>
									<li>Not just for commute</li>
									<li>Branded tongue and cuff</li>
									<li>Super fast and amazing</li>
									<li>Lorem sed do eiusmod tempor</li>
								</ul>
								<p class="mb-1">Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone.</p>
								<p class="mb-1">Seitan aliquip quis cardigan american apparel, butcher voluptate nisi.</p>
							</div>
							<div class="tab-pane fade" id="primaryprofile" role="tabpanel">
								<div class="tags-box w-50">	<a href="javascript:;" class="tag-link">Cloths</a>
									<a href="javascript:;" class="tag-link">Electronis</a>
									<a href="javascript:;" class="tag-link">Furniture</a>
									<a href="javascript:;" class="tag-link">Sports</a>
									<a href="javascript:;" class="tag-link">Men Wear</a>
									<a href="javascript:;" class="tag-link">Women Wear</a>
									<a href="javascript:;" class="tag-link">Laptops</a>
									<a href="javascript:;" class="tag-link">Formal Shirts</a>
									<a href="javascript:;" class="tag-link">Topwear</a>
									<a href="javascript:;" class="tag-link">Headphones</a>
									<a href="javascript:;" class="tag-link">Bottom Wear</a>
									<a href="javascript:;" class="tag-link">Bags</a>
									<a href="javascript:;" class="tag-link">Sofa</a>
									<a href="javascript:;" class="tag-link">Shoes</a>
								</div>
							</div>
							<div class="tab-pane fade" id="primarycontact" role="tabpanel">
								<div class="row">
									<div class="col col-lg-8">
										<div class="product-review">
											<h5 class="mb-4">3 Reviews For The Product</h5>
											<div class="review-list">
												<div class="d-flex align-items-start">
													<div class="review-user">
														<img src="assets/images/avatars/avatar-1.png" width="65" height="65" class="rounded-circle" alt="" />
													</div>
													<div class="review-content ms-3">
														<div class="rates cursor-pointer fs-6">	<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-light-4"></i>
														</div>
														<div class="d-flex align-items-center mb-2">
															<h6 class="mb-0">James Caviness</h6>
															<p class="mb-0 ms-auto">February 16, 2021</p>
														</div>
														<p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan</p>
													</div>
												</div>
												<hr/>
												<div class="d-flex align-items-start">
													<div class="review-user">
														<img src="assets/images/avatars/avatar-2.png" width="65" height="65" class="rounded-circle" alt="" />
													</div>
													<div class="review-content ms-3">
														<div class="rates cursor-pointer fs-6"> <i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-light-4"></i>
														</div>
														<div class="d-flex align-items-center mb-2">
															<h6 class="mb-0">David Buckley</h6>
															<p class="mb-0 ms-auto">February 22, 2021</p>
														</div>
														<p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan</p>
													</div>
												</div>
												<hr/>
												<div class="d-flex align-items-start">
													<div class="review-user">
														<img src="assets/images/avatars/avatar-3.png" width="65" height="65" class="rounded-circle" alt="" />
													</div>
													<div class="review-content ms-3">
														<div class="rates cursor-pointer fs-6">	<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-warning"></i>
															<i class="bx bxs-star text-light-4"></i>
														</div>
														<div class="d-flex align-items-center mb-2">
															<h6 class="mb-0">Peter Costanzo</h6>
															<p class="mb-0 ms-auto">February 26, 2021</p>
														</div>
														<p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col col-lg-4">
										<div class="add-review bg-dark-1 border rounded bg-light">
											<div class="form-body p-3">
												<h4 class="mb-4">Write a Review</h4>
												<div class="mb-3">
													<label class="form-label">Your Name</label>
													<input type="text" class="form-control rounded-0">
												</div>
												<div class="mb-3">
													<label class="form-label">Your Email</label>
													<input type="text" class="form-control rounded-0">
												</div>
												<div class="mb-3">
													<label class="form-label">Rating</label>
													<select class="form-select rounded-0">
														<option selected>Choose Rating</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
														<option value="3">4</option>
														<option value="3">5</option>
													</select>
												</div>
												<div class="mb-3">
													<label class="form-label">Example textarea</label>
													<textarea class="form-control rounded-0" rows="3"></textarea>
												</div>
												<div class="d-grid">
													<button type="button" class="btn btn-primary">Submit a Review</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--end row-->
							</div>
						</div>
					</div>

				  </div>


					<h6 class="text-uppercase mb-0">Related Product</h6>
					<hr/>
                     <div class="row row-cols-1 row-cols-lg-3">
						   <div class="col">
							<div class="card">
								<div class="row g-0">
								  <div class="col-md-4">
									<img src="assets/images/products/16.png" class="img-fluid" alt="...">
								  </div>
								  <div class="col-md-8">
									<div class="card-body">
									  <a href='{{ url('ecommerce-products-details')}}'>
									  	<h6 class="card-title">Light Grey Headphone</h6>
									  </a>
									  <div class="cursor-pointer my-2">
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-secondary"></i>
									  </div>
									  <div class="clearfix">
										<p class="mb-0 float-start fw-bold"><span class="me-2 text-decoration-line-through text-secondary">$240</span><span>$199</span></p>
									 </div>
									</div>
								  </div>
								</div>
							  </div>
						   </div>
						   <div class="col">
							<div class="card">
								<div class="row g-0">
								  <div class="col-md-4">
									<img src="assets/images/products/17.png" class="img-fluid" alt="...">
								  </div>
								  <div class="col-md-8">
									<div class="card-body">
									  <a href='{{ url('ecommerce-products-details')}}'>
									  	<h6 class="card-title">Black Cover iPhone 8</h6>
									  </a>
									  <div class="cursor-pointer my-2">
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
									  </div>
									  <div class="clearfix">
										<p class="mb-0 float-start fw-bold"><span class="me-2 text-decoration-line-through text-secondary">$179</span><span>$110</span></p>
									 </div>
									</div>
								  </div>
								</div>
							  </div>
						   </div>
						   <div class="col">
							<div class="card">
								<div class="row g-0">
								  <div class="col-md-4">
									<img src="assets/images/products/19.png" class="img-fluid" alt="...">
								  </div>
								  <div class="col-md-8">
									<div class="card-body">
									  <a href='{{ url('ecommerce-products-details')}}'>
									  	<h6 class="card-title">Men Hand Watch</h6>
									  </a>
									  <div class="cursor-pointer my-2">
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-warning"></i>
										<i class="bx bxs-star text-secondary"></i>
										<i class="bx bxs-star text-secondary"></i>
									  </div>
									  <div class="clearfix">
										<p class="mb-0 float-start fw-bold"><span class="me-2 text-decoration-line-through text-secondary">$150</span><span>$120</span></p>
									 </div>
									</div>
								  </div>
								</div>
							  </div>
						   </div>
					   </div>
					
				  
			</div>
		</div>
		<!--end page wrapper -->
		@endsection
		@section("script")
		<script src="assets/plugins/OwlCarousel/js/owl.carousel.min.js"></script>
		<script src="assets/plugins/OwlCarousel/js/owl.carousel2.thumbs.min.js"></script>
		<script src="assets/js/product-details.js"></script>
		@endsection
	