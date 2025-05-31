@extends('admin.layouts.app')

@section('panel')
    <div class="row gy-4">
        @foreach ($templates as $temp)
            <div class="col-xl-4 col-md-6">
                <div class="card">
                    <div class="card-header bg--primary d-flex justify-content-between flex-wrap">
                        <h4 class="card-title text-white"> {{ __(keyToTitle($temp['name'])) }} </h4>
                        @if ($general->active_template == $temp['name'])
                            <button type="submit" name="name" value="{{ $temp['name'] }}" class="btn btn--info">
                                @lang('SELECTED')
                            </button>
                        @else
                            <form action="" method="post">
                                @csrf
                                <button type="submit" name="name" value="{{ $temp['name'] }}"
                                    class="btn btn--success w-100">
                                    @lang('SELECT')
                                </button>
                            </form>
                        @endif
                    </div>
                    <div class="card-body p-0">
                        <img src="{{ $temp['image'] }}" alt="@lang('Template')" class="w-100">
                    </div>
                </div>
            </div>
        @endforeach

        @if ($extra_templates)
            @foreach ($extra_templates as $temp)
                <div class="col-lg-3">
                    <div class="card">
                        <div class="card-header bg--primary">
                            <h4 class="card-title text-white"> {{ __(keyToTitle($temp['name'])) }} </h4>
                        </div>
                        <div class="card-body">
                            <img src="{{ $temp['image'] }}" alt="@lang('Template')" class="w-100">
                        </div>
                        <div class="card-footer">
                            <a href="{{ $temp['url'] }}" target="_blank"
                                class="btn btn--primary w-100">@lang('Purchase Now')</a>
                        </div>
                    </div>
                </div>
            @endforeach
        @endif
    </div>
    
    <!-- Modal -->
    <div class="modal fade" id="uploadTemplate">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">@lang('Upload Template')</h5>
            <button type="button" class="close" data-bs-dismiss="modal">
              <span><i class="las la-times"></i></span>
            </button>
          </div>
          <form action="{{ route('admin.frontend.templates.upload') }}" enctype="multipart/form-data" method="post">
            @csrf
            <div class="modal-body">
                <div class="form-group">
					<label>@lang('Envato Username')</label>
					<input type="text" name="envato_username" class="form-control" required>
				</div>
                <div class="form-group">
					<label>@lang('Email')</label>
					<input type="email" name="email" class="form-control" required>
				</div>
				<div class="form-group">
					<label>@lang('Template Purchase Code')</label>
					<input type="text" name="template_purchase_code" class="form-control" required>
				</div>
				<div class="form-group">
					<label>@lang('Files')</label>
					<input type="file" name="file" class="form-control" accept=".zip" required>
				</div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn--primary h-45 w-100">@lang('Submit')</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    

@endsection
@push('breadcrumb-plugins')
<div>
    @if(!extension_loaded('zip'))
    <span class="text--danger mx-3"><span class="fw-bold text--danger">PHP-zip</span> Extension is required</span>
    <button type="button" disabled class="btn btn-outline--primary btn-sm" data-bs-toggle="modal" data-bs-target="#uploadTemplate"><i class="las la-puzzle-piece"></i>@lang('Upload Template')</button>
    @else
    <button type="button" class="btn btn-outline--primary btn-sm" data-bs-toggle="modal" data-bs-target="#uploadTemplate"><i class="las la-puzzle-piece"></i>@lang('Upload Template')</button>
    @endif
</div>
@endpush