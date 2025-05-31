@extends("layouts.app")
		
		@section("wrapper")
		<!--start page wrapper -->
		<div class="page-wrapper">
			<div class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">Faq</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">Faq</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-light">Settings</button>
							<button type="button" class="btn btn-light dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
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
					<div class="col-12 col-lg-9 mx-auto">
						<div class="text-center">
							<h5 class="mb-0 text-uppercase">Frequently asked questions (FAQ<small class="text-lowercase">s</small>)</h5>
							<hr/>
						</div>
						<div class="card">
							<div class="card-body">
								<div class="accordion" id="accordionExample">
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingOne">
						  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							Just once I'd like to eat dinner with a celebrity?
						  </button>
						</h2>
										<div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
											<div class="accordion-body">
												<p>Yes, if you make it look like an electrical fire. When you do things right, people won't be sure you've done anything at all. I was having the most wonderful dream. Except you were there, and you were there, and you were there! No argument here. Goodbye, cruel world. Goodbye, cruel lamp. Goodbye, cruel velvet drapes, lined with what would appear to be some sort of cruel muslin and the cute little pom-pom curtain pull cords. Cruel though they may be.</p>
												<p><strong>Example: </strong>Shut up and get to the point!</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingTwo">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							Bender, I didn't know you liked cooking?
						  </button>
						</h2>
										<div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
											<div class="accordion-body">
												<p>That's so cute. Can we have Bender Burgers again? Is the Space Pope reptilian!? I wish! It's a nickel. Bender! Ship! Stop bickering or I'm going to come back there and change your opinions manually!</p>
												<p><strong>Example: </strong>Okay, I like a challenge. Is that a cooking show? No argument here.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingThree">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							My fellow Earthicans?
						  </button>
						</h2>
										<div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
											<div class="accordion-body">
												<p>As I have explained in my book 'Earth in the Balance', and the much more popular 'Harry Potter and the Balance of Earth', we need to defend our planet against pollution. Also dark wizards. Fry, you can't just sit here in the dark listening to classical music.</p>
												<p><strong>Example: </strong>Actually, that's still true. Well, let's just dump it in the sewer and say we delivered it.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingFour">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
							Who am I making this out to?
						  </button>
						</h2>
										<div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
											<div class="accordion-body">
												<p>Morbo can't understand his teleprompter because he forgot how you say that letter that's shaped like a man wearing a hat. Also Zoidberg. Can we have Bender Burgers again? Goodbye, cruel world. Goodbye, cruel lamp. Goodbye, cruel velvet drapes, lined with what would appear to be some sort of cruel muslin and the cute little pom-pom curtain pull cords.</p>
												<p><strong>Example: </strong>Cruel though they may be...</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="text-center">
							<h5 class="mb-0 text-uppercase">Frequently asked questions (FAQ<small class="text-lowercase">s</small>)</h5>
							<hr/>
						</div>
						<div class="card">
							<div class="card-body">
								<div class="accordion accordion-flush" id="accordionExample2">
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingFive">
						  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
							Michelle, I don't regret this, but I both rue and lament it?
						  </button>
						</h2>
										<div id="collapseFive" class="accordion-collapse collapse show" aria-labelledby="headingFive" data-bs-parent="#accordionExample2">
											<div class="accordion-body">
												<p>Look, last night was a mistake. We'll need to have a look inside you with this camera. Good news, everyone! There's a report on TV with some very bad news! You know, I was God once. You lived before you met me?!</p>
												<p><strong>Example: </strong>I'm Santa Claus! Pansy. That's a popular name today. Little "e", big "B"?</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingSix">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
							Why am I sticky and naked?
						  </button>
						</h2>
										<div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample2">
											<div class="accordion-body">
												<p>Did I miss something fun? Humans dating robots is sick. You people wonder why I'm still single? It's 'cause all the fine robot sisters are dating humans! Kids don't turn rotten just from watching TV.</p>
												<p><strong>Example: </strong>I usually try to keep my sadness pent up inside where it can fester quietly as a mental illness.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingSeven">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
							Is that a cooking show?
						  </button>
						</h2>
										<div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample2">
											<div class="accordion-body">
												<p>OK, this has gotta stop. I'm going to remind Fry of his humanity the way only a woman can. You seem malnourished. Are you suffering from intestinal parasites? Check it out, y'all. Everyone who was invited is here. I am Singing Wind, Chief of the Martians.</p>
												<p><strong>Example: </strong>Man, I'm sore all over. I feel like I just went ten rounds with mighty Thor.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<h2 class="accordion-header" id="headingEight">
						  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
							You are the last hope of the universe?
						  </button>
						</h2>
										<div id="collapseEight" class="accordion-collapse collapse" aria-labelledby="headingEight" data-bs-parent="#accordionExample2">
											<div class="accordion-body">
												<p>I don't want to be rescued. I videotape every customer that comes in here, so that I may blackmail them later. Ah, computer dating. It's like pimping, but you rarely have to use the phrase "upside your head."</p>
												<p><strong>Example: </strong>Tell them I hate them.</p>
											</div>
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
		<!--end page wrapper -->
		@endsection
	