<div class="row">
	@foreach($details as $k => $val)
		<div class="col-md-12 mb-4">
			@if(is_object($val) || is_array($val))
				<h6>{{keyToTitle($k)}}</h6>
				<hr>
				<div class="ms-3">
					@include('admin.deposit.gateway_data',['details'=>$val])
				</div>
			@else
				<h6>{{@keyToTitle($k)}}</h6>
				<p>{{@$val}}</p>
			@endif
		</div>
	@endforeach
</div>
