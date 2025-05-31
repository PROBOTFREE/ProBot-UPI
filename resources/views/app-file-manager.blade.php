@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Applications</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">File Manager</li>
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
                        <div class="col-12 col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-grid"> <a href="javascript:;" class="btn btn-primary">+ Add File</a>
                                    </div>
                                    <h5 class="my-3">My Drive</h5>
                                    <div class="fm-menu">
                                        <div class="list-group list-group-flush"> <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-folder me-2'></i><span>All Files</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-devices me-2'></i><span>My Devices</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-analyse me-2'></i><span>Recents</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-plug me-2'></i><span>Important</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-trash-alt me-2'></i><span>Deleted Files</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-file me-2'></i>
                                                <span>Documents</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-image me-2'></i><span>Images</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-video me-2'></i><span>Videos</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-music me-2'></i><span>Audio</span></a>
                                            <a href="javascript:;" class="list-group-item py-1"><i class='bx bx-beer me-2'></i><span>Zip Files</span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="mb-0 text-primary font-weight-bold">45.5 GB <span class="float-end text-secondary">50 GB</span></h5>
                                    <p class="mb-0 mt-2"><span class="text-secondary">Used</span><span class="float-end text-primary">Upgrade</span>
                                    </p>
                                    <div class="progress mt-3" style="height:7px;">
                                        <div class="progress-bar" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                                        <div class="progress-bar bg-warning" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                        <div class="progress-bar bg-danger" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                    <div class="mt-3"></div>
                                    <div class="d-flex align-items-center">
                                        <div class="fm-file-box bg-light-primary text-primary"><i class='bx bx-image'></i>
                                        </div>
                                        <div class="flex-grow-1 ms-2">
                                            <h6 class="mb-0">Images</h6>
                                            <p class="mb-0 text-secondary">1,756 files</p>
                                        </div>
                                        <h6 class="text-primary mb-0">15.3 GB</h6>
                                    </div>
                                    <div class="d-flex align-items-center mt-3">
                                        <div class="fm-file-box bg-light-success text-success"><i class='bx bxs-file-doc'></i>
                                        </div>
                                        <div class="flex-grow-1 ms-2">
                                            <h6 class="mb-0">Documents</h6>
                                            <p class="mb-0 text-secondary">123 files</p>
                                        </div>
                                        <h6 class="text-primary mb-0">256 MB</h6>
                                    </div>
                                    <div class="d-flex align-items-center mt-3">
                                        <div class="fm-file-box bg-light-danger text-danger"><i class='bx bx-video'></i>
                                        </div>
                                        <div class="flex-grow-1 ms-2">
                                            <h6 class="mb-0">Media Files</h6>
                                            <p class="mb-0 text-secondary">24 files</p>
                                        </div>
                                        <h6 class="text-primary mb-0">3.4 GB</h6>
                                    </div>
                                    <div class="d-flex align-items-center mt-3">
                                        <div class="fm-file-box bg-light-warning text-warning"><i class='bx bx-image'></i>
                                        </div>
                                        <div class="flex-grow-1 ms-2">
                                            <h6 class="mb-0">Other Files</h6>
                                            <p class="mb-0 text-secondary">458 files</p>
                                        </div>
                                        <h6 class="text-primary mb-0">3 GB</h6>
                                    </div>
                                    <div class="d-flex align-items-center mt-3">
                                        <div class="fm-file-box bg-light-info text-info"><i class='bx bx-image'></i>
                                        </div>
                                        <div class="flex-grow-1 ms-2">
                                            <h6 class="mb-0">Unknown Files</h6>
                                            <p class="mb-0 text-secondary">57 files</p>
                                        </div>
                                        <h6 class="text-primary mb-0">178 GB</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-9">
                            <div class="card">
                                <div class="card-body">
                                    <div class="fm-search">
                                        <div class="mb-0">
                                            <div class="input-group input-group-lg">	<span class="input-group-text bg-transparent"><i class='bx bx-search'></i></span>
                                                <input type="text" class="form-control" placeholder="Search the files">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="fm-icon-box radius-15 bg-primary text-white"><i class='lni lni-google-drive'></i>
                                                        </div>
                                                        <div class="ms-auto font-24"><i class='bx bx-dots-horizontal-rounded'></i>
                                                        </div>
                                                    </div>
                                                    <h5 class="mt-3 mb-0">Google Drive</h5>
                                                    <p class="mb-1 mt-4"><span>45.5 GB</span>  <span class="float-end">50 GB</span>
                                                    </p>
                                                    <div class="progress" style="height: 7px;">
                                                        <div class="progress-bar bg-primary" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="fm-icon-box radius-15 bg-danger text-white"><i class='lni lni-dropbox-original'></i>
                                                        </div>
                                                        <div class="ms-auto font-24"><i class='bx bx-dots-horizontal-rounded'></i>
                                                        </div>
                                                    </div>
                                                    <h5 class="mt-3 mb-0">Dropbox</h5>
                                                    <p class="mb-1 mt-4"><span>1,2 GB</span>  <span class="float-end">3 GB</span>
                                                    </p>
                                                    <div class="progress" style="height: 7px;">
                                                        <div class="progress-bar bg-danger" role="progressbar" style="width: 45%;" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="fm-icon-box radius-15 bg-warning text-dark"><i class='bx bxs-door-open'></i>
                                                        </div>
                                                        <div class="ms-auto font-24"><i class='bx bx-dots-horizontal-rounded'></i>
                                                        </div>
                                                    </div>
                                                    <h5 class="mt-3 mb-0">OneDrive</h5>
                                                    <p class="mb-1 mt-4"><span>2,5 GB</span>  <span class="float-end">3 GB</span>
                                                    </p>
                                                    <div class="progress" style="height: 7px;">
                                                        <div class="progress-bar bg-warning" role="progressbar" style="width: 65%;" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--end row-->
                                    <h5>Folders</h5>
                                    <div class="row mt-3">
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="font-30 text-primary"><i class='bx bxs-folder'></i>
                                                        </div>
                                                        <div class="user-groups ms-auto">
                                                            <img src="assets/images/avatars/avatar-1.png" width="35" height="35" class="rounded-circle" alt="" />
                                                            <img src="assets/images/avatars/avatar-2.png" width="35" height="35" class="rounded-circle" alt="" />
                                                        </div>
                                                        <div class="user-plus">+</div>
                                                    </div>
                                                    <h6 class="mb-0 text-primary">Analytics</h6>
                                                    <small>15 files</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="font-30 text-primary"><i class='bx bxs-folder'></i>
                                                        </div>
                                                        <div class="user-groups ms-auto">
                                                            <img src="assets/images/avatars/avatar-4.png" width="35" height="35" class="rounded-circle" alt="" />
                                                        </div>
                                                    </div>
                                                    <h6 class="mb-0 text-primary">Assets</h6>
                                                    <small>345 files</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12 col-lg-4">
                                            <div class="card shadow-none border radius-15">
                                                <div class="card-body">
                                                    <div class="d-flex align-items-center">
                                                        <div class="font-30 text-primary"><i class='bx bxs-folder'></i>
                                                        </div>
                                                        <div class="user-groups ms-auto">
                                                            <img src="assets/images/avatars/avatar-7.png" width="35" height="35" class="rounded-circle" alt="" />
                                                            <img src="assets/images/avatars/avatar-8.png" width="35" height="35" class="rounded-circle" alt="" />
                                                        </div>
                                                    </div>
                                                    <h6 class="mb-0 text-primary">Marketing</h6>
                                                    <small>143 files</small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--end row-->
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <h5 class="mb-0">Recent Files</h5>
                                        </div>
                                        <div class="ms-auto"><a href="javascript:;" class="btn btn-sm btn-outline-secondary">View all</a>
                                        </div>
                                    </div>
                                    <div class="table-responsive mt-3">
                                        <table class="table table-striped table-hover table-sm mb-0">
                                            <thead>
                                            <tr>
                                                <th>Name <i class='bx bx-up-arrow-alt ms-2'></i>
                                                </th>
                                                <th>Members</th>
                                                <th>Last Modified</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file-pdf me-2 font-24 text-danger'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-danger">Competitor Analysis Template</div>
                                                    </div>
                                                </td>
                                                <td>Only you</td>
                                                <td>Sep 3, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file me-2 font-24 text-primary'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-primary">How to Create a Case Study</div>
                                                    </div>
                                                </td>
                                                <td>3 members</td>
                                                <td>Jun 12, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file me-2 font-24 text-primary'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-primary">Landing Page Structure</div>
                                                    </div>
                                                </td>
                                                <td>10 members</td>
                                                <td>Jul 17, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file-pdf me-2 font-24 text-danger'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-danger">Meeting Report</div>
                                                    </div>
                                                </td>
                                                <td>5 members</td>
                                                <td>Aug 28, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file me-2 font-24 text-primary'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-primary">Project Documents</div>
                                                    </div>
                                                </td>
                                                <td>Only you</td>
                                                <td>Aug 17, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file-doc me-2 font-24 text-success'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-success">Review Checklist Template</div>
                                                    </div>
                                                </td>
                                                <td>7 members</td>
                                                <td>Sep 8, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file me-2 font-24 text-primary'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-primary">How to Create a Case Study</div>
                                                    </div>
                                                </td>
                                                <td>3 members</td>
                                                <td>Jun 12, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file me-2 font-24 text-primary'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-primary">Landing Page Structure</div>
                                                    </div>
                                                </td>
                                                <td>10 members</td>
                                                <td>Jul 17, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div><i class='bx bxs-file-doc me-2 font-24 text-success'></i>
                                                        </div>
                                                        <div class="font-weight-bold text-success">Review Checklist Template</div>
                                                    </div>
                                                </td>
                                                <td>7 members</td>
                                                <td>Sep 8, 2019</td>
                                                <td><i class='bx bx-dots-horizontal-rounded font-24'></i>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end row-->
                </div>
            </div>
		@endsection
