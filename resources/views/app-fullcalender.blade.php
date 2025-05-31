
@extends("layouts.app")
@section("style")
<link href="assets/plugins/fullcalendar/css/main.min.css" rel="stylesheet" />
@endsection

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
                                    <li class="breadcrumb-item active" aria-current="page">Calendar</li>
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
                        <div class="card-body">
                            <div class="table-responsive">
                                <div id='calendar'></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection

@section("script")
<script src="assets/plugins/fullcalendar/js/main.min.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function () {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
				left: 'prev,next today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
			},
			initialView: 'dayGridMonth',
			initialDate: '2020-09-12',
			navLinks: true, // can click day/week names to navigate views
			selectable: true,
			nowIndicator: true,
			dayMaxEvents: true, // allow "more" link when too many events
			editable: true,
			selectable: true,
			businessHours: true,
			dayMaxEvents: true, // allow "more" link when too many events
			events: [{
				title: 'All Day Event',
				start: '2020-09-01',
			}, {
				title: 'Long Event',
				start: '2020-09-07',
				end: '2020-09-10'
			}, {
				groupId: 999,
				title: 'Repeating Event',
				start: '2020-09-09T16:00:00'
			}, {
				groupId: 999,
				title: 'Repeating Event',
				start: '2020-09-16T16:00:00'
			}, {
				title: 'Conference',
				start: '2020-09-11',
				end: '2020-09-13'
			}, {
				title: 'Meeting',
				start: '2020-09-12T10:30:00',
				end: '2020-09-12T12:30:00'
			}, {
				title: 'Lunch',
				start: '2020-09-12T12:00:00'
			}, {
				title: 'Meeting',
				start: '2020-09-12T14:30:00'
			}, {
				title: 'Happy Hour',
				start: '2020-09-12T17:30:00'
			}, {
				title: 'Dinner',
				start: '2020-09-12T20:00:00'
			}, {
				title: 'Birthday Party',
				start: '2020-09-13T07:00:00'
			}, {
				title: 'Click for Google',
				url: 'http://google.com/',
				start: '2020-09-28'
			}]
		});
		calendar.render();
	});
</script>
@endsection
