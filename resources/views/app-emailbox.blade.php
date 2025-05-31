@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--start email wrapper-->
                    <div class="email-wrapper my-5">
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
                                                    <div class="dropdown-menu dropdown-menu-end">	<a class="dropdown-item" href="javascript:;">Settings</a>
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
                            <div class="">
                                <div class="email-list">
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Wordpress</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">It is a long established fact that a reader will be distracted by the readable...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">5:56 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Locanto</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">The point of using Lorem Ipsum is that it has a more-or-less normal...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">5:45 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Facebook</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">There are many variations of passages of Lorem Ipsum available, majority suffered...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">4:32 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Alex Xender</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">4:25 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Alisha Mastana</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">4:18 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Synergy Technology</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">If you are going to use a passage of Lorem Ipsum, you need to be sure there...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">3:56 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Robina Consultant</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">3:43 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>HCl Technologies</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Bonorum et Malorum" by Cicero are also reproduced in their exact original form...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">2:25 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Tata India</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">But I must explain to you how all this mistaken idea of denouncing pleasure...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">2:14 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Jessica Jhons</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">At vero eos et accusamus et iusto odio dignissimos ducimus...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">1:30 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Anaxa Marvel</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">1:15 PM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Maxwell Linga</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">On the other hand, we denounce with righteous indignation and dislike...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">12:45 AM</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Cricket India</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Oct 25</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Start Sports Australia</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Excepteur sint occaecat cupidatat non proident, sunt in culpa...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Oct 22</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Diana Dating Services</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Nor again is there anyone who loves or pursues or desires to obtain pain...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Oct 18</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Himalaya India</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Oct 10</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>NASA USA</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">All the Lorem Ipsum generators on the Internet tend to repeat predefined...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Sep 28</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Indeed Jobs</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Content here, content here', making it look like readable English...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Sep 22</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Wordfence</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Various versions have evolved over the years, sometimes by accident...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Sep 18</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>DocsApp India</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">But I must explain to you how all this mistaken idea of denouncing pleasure...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Sep 12</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Alex ReliableSoft</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Sep 02</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Ryan Robinson</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Business it will frequently occur that pleasures have to be repudiated...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Aug 22</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>TechGig Job Alert</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Aug 18</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1 bg-body">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Paytm India</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">All the Lorem Ipsum generators on the Internet tend to repeat predefined...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Jul 27</p>
                                            </div>
                                        </div>
                                    </a>
                                    <a href="{{ url('app-emailread') }}">
                                        <div class="d-md-flex align-items-center email-message px-3 py-1">
                                            <div class="d-flex align-items-center email-actions">
                                                <input class="form-check-input" type="checkbox" value="" /> <i class='bx bx-star font-20 mx-2 email-star'></i>
                                                <p class="mb-0"><b>Uber America</b>
                                                </p>
                                            </div>
                                            <div class="">
                                                <p class="mb-0">Chunks as necessary, making this the first true generator on the Internet...</p>
                                            </div>
                                            <div class="ms-auto">
                                                <p class="mb-0 email-time">Jul 24</p>
                                            </div>
                                        </div>
                                    </a>
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
		@endsection

@section("script")
<script>
	new PerfectScrollbar('.email-navigation');
	new PerfectScrollbar('.email-list');
</script>
@endsection
