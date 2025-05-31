@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--start email wrapper-->
                    <div class="email-wrapper">
                        <div class="email-sidebar">
                            <div class="email-sidebar-header d-grid"> <a href="javascript:;" class="btn btn-primary compose-mail-btn"><i class='bx bx-plus me-2'></i> Compose</a>
                            </div>
                            <div class="email-sidebar-content">
                                <div class="email-navigation">
                                    <div class="list-group list-group-flush"> <a href="{{ url('app-emailbox') }}" class="list-group-item active d-flex align-items-center"><i class='bx bxs-inbox me-3 font-20'></i><span>Inbox</span><span class="badge bg-primary rounded-pill ms-auto">7,513</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-star me-3 font-20'></i><span>Starred</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-alarm-snooze me-3 font-20'></i><span>Snoozed</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-send me-3 font-20'></i><span>Sent</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-file-blank me-3 font-20'></i><span>Drafts</span><span class="badge bg-primary rounded-pill ms-auto">4</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-bookmark me-3 font-20'></i><span>Important</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-message-rounded-error me-3 font-20'></i><span>Chats</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bx-mail-send me-3 font-20'></i><span>Scheduled</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-envelope-open me-3 font-20'></i><span>All Mail</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-info-circle me-3 font-20'></i><span>Spam</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-trash-alt me-3 font-20'></i><span>Trash</span></a>
                                    </div>
                                </div>
                                <div class="email-meeting">
                                    <div class="list-group list-group-flush">
                                        <div class="list-group-item"><span>Meet</span>
                                        </div> <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-video me-3 font-20'></i><span>Start a meeting</span></a>
                                        <a href="javascript:;" class="list-group-item d-flex align-items-center"><i class='bx bxs-group me-3 font-20'></i><span>Join a meeting</span></a>
                                        <div class="list-group-item email-hangout cursor-pointer border-top">
                                            <div class="d-flex align-items-center">
                                                <div class="chat-user-online">
                                                    <img src="assets/images/avatars/avatar-1.png" width="42" height="42" class="rounded-circle" alt="" />
                                                </div>
                                                <div class="flex-grow-1 ms-2">
                                                    <p class="mb-0">Jessica Doe</p>
                                                </div>
                                                <div class="dropdown">
                                                    <div class="font-24 dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown"><i class='bx bx-plus'></i>
                                                    </div>
                                                    <div class="dropdown-menu dropdown-menu-right">	<a class="dropdown-item" href="javascript:;">Settings</a>
                                                        <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Help & Feedback</a>
                                                        <a class="dropdown-item" href="javascript:;">Enable Split View Mode</a>
                                                        <a class="dropdown-item" href="javascript:;">Keyboard Shortcuts</a>
                                                        <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Sign Out</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="email-header d-xl-flex align-items-center">
                            <div class="d-flex align-items-center">
                                <div class="email-toggle-btn"><i class='bx bx-menu'></i>
                                </div>
                                <div class="btn btn-white">
                                    <input class="form-check-input" type="checkbox">
                                </div>
                                <div class="">
                                    <button type="button" class="btn btn-white ms-2"><i class='bx bx-refresh me-0'></i>
                                    </button>
                                </div>
                                <div class="">
                                    <button type="button" class="btn btn-white ms-2"><i class='bx bx-downvote me-0'></i>
                                    </button>
                                </div>
                                <div class="d-none d-md-flex">
                                    <button type="button" class="btn btn-white ms-2"><i class='bx bx-file me-0'></i>
                                    </button>
                                </div>
                                <div class="">
                                    <button type="button" class="btn btn-white ms-2"><i class='bx bx-trash me-0'></i>
                                    </button>
                                </div>
                            </div>
                            <div class="flex-grow-1 mx-xl-2 my-2 my-xl-0">
                                <div class="input-group">	<span class="input-group-text bg-transparent"><i class="bx bx-search"></i></span>
                                    <input type="text" class="form-control" placeholder="Search mail">
                                </div>
                            </div>
                            <div class="ms-auto d-flex align-items-center">
                                <button class="btn btn-sm btn-light">1-50 of 8,740</button>
                                <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-left me-0'></i>
                                </button>
                                <button class="btn btn-white px-2 ms-2"><i class='bx bx-chevron-right me-0'></i>
                                </button>
                            </div>
                        </div>
                        <div class="email-content">
                            <div class="email-read-box p-3">
                                <h4>It is a long established fact that a reader will be distracted.</h4>
                                <hr>
                                <div class="d-flex align-items-center">
                                    <img src="assets/images/avatars/avatar-1.png" width="42" height="42" class="rounded-circle" alt="" />
                                    <div class="flex-grow-1 ms-2">
                                        <p class="mb-0 font-weight-bold">Himalaya India</p>
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-bs-toggle="dropdown">to me</div>
                                            <div class="dropdown-menu">	<a class="dropdown-item" href="javascript:;">Settings</a>
                                                <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Help & Feedback</a>
                                                <a class="dropdown-item" href="javascript:;">Enable Split View Mode</a>
                                                <a class="dropdown-item" href="javascript:;">Keyboard Shortcuts</a>
                                                <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Sign Out</a>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="mb-0 chat-time ps-5 ms-auto">Sep 15, 2020, 11:04 PM (19 hours ago)</p>
                                </div>
                                <div class="email-read-content px-md-5 py-5">
                                    <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</p>
                                    <h5>Where can I get some?</h5>
                                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet.</p>
                                    <hr>
                                    <h5>Where does it come from?</h5>
                                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words.</p>
                                    <p>consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
                                    <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>
                                </div>
                            </div>
                        </div>
                        <!--start compose mail-->
                        <div class="compose-mail-popup">
                            <div class="card">
                                <div class="card-header bg-dark text-white py-2 cursor-pointer">
                                    <div class="d-flex align-items-center">
                                        <div class="compose-mail-title">New Message</div>
                                        <div class="compose-mail-close ms-auto">x</div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="email-form">
                                        <div class="mb-3">
                                            <input type="text" class="form-control" placeholder="To" />
                                        </div>
                                        <div class="mb-3">
                                            <input type="text" class="form-control" placeholder="Subject" />
                                        </div>
                                        <div class="mb-3">
                                            <textarea class="form-control" placeholder="Message" rows="10" cols="10"></textarea>
                                        </div>
                                        <div class="mb-0">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <div class="btn-group">
                                                        <button type="button" class="btn btn-primary">Action</button>
                                                        <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                                                        </button>
                                                        <div class="dropdown-menu">	<a class="dropdown-item" href="javascript:;">Action</a>
                                                            <a class="dropdown-item" href="javascript:;">Another action</a>
                                                            <a class="dropdown-item" href="javascript:;">Something else here</a>
                                                            <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="ms-2">
                                                    <button type="button" class="btn border-0 btn-sm btn-white"><i class="lni lni-text-format"></i>
                                                    </button>
                                                    <button type="button" class="btn border-0 btn-sm btn-white"><i class='bx bx-link-alt'></i>
                                                    </button>
                                                    <button type="button" class="btn border-0 btn-sm btn-white"><i class="lni lni-emoji-tounge"></i>
                                                    </button>
                                                    <button type="button" class="btn border-0 btn-sm btn-white"><i class="lni lni-google-drive"></i>
                                                    </button>
                                                </div>
                                                <div class="ms-auto">
                                                    <button type="button" class="btn border-0 btn-sm btn-white"><i class="lni lni-trash"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end compose mail-->
                        <!--start email overlay-->
                        <div class="overlay email-toggle-btn-mobile"></div>
                        <!--end email overlay-->
                    </div>
                    <!--end email wrapper-->
                </div>
            </div>
		<!--end page wrapper -->
		@endsection
@section("script")
<script>
	new PerfectScrollbar('.email-navigation');
	new PerfectScrollbar('.email-read-box');
</script>
@endsection
