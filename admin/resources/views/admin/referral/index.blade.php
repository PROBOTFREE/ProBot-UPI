@extends('admin.layouts.app')
@section('panel')
<div class="row">
    @foreach($commissionTypes as $key => $type)
        <div class="col-lg-4 mb-4">
            <div class="card border--primary parent">
                <div class="card-header bg--primary">
                    <h5 class="text-white float-start">{{ __($type) }}</h5>
                    @if($general->$key == 0)
                    <a href="{{ route('admin.referrals.status',$key) }}" class="btn btn--success btn-sm float-end"><i class="las la-toggle-on"></i> @lang('Enable Now')</a>
                    @else
                    <a href="{{ route('admin.referrals.status',$key) }}" class="btn btn--danger btn-sm float-end"><i class="las la-toggle-off"></i> @lang('Disable Now')</a>
                    @endif
                </div>

                <div class="card-body">

                    <ul class="list-group list-group-flush">
                    @foreach($referrals->where('commission_type',$key) as $referral)
                        <li class="list-group-item d-flex flex-wrap justify-content-between">
                            <span class="fw-bold">@lang('Level') {{ $referral->level }}</span>
                            <span class="fw-bold">{{ $referral->percent }}%</span>
                        </li>
                    @endforeach
                    </ul>


                    <div class="border-line-area mt-3">
                        <h6 class="border-line-title">@lang('Update Setting')</h6>
                    </div>

                    <div class="form-group">
                        <label>@lang('Number of Level')</label>
                        <div class="input-group">
                            <input type="number" name="level" min="1" placeholder="Type a number & hit ENTER ↵" class="form-control">
                            <button type="button" class="btn btn--primary generate">@lang('Generate')</button>
                        </div>
                        <span class="text--danger required-message d-none">@lang('Please enter a number')</span>
                    </div>

                    <form action="{{ route('admin.referrals.update') }}" method="post" class="d-none levelForm">
                        @csrf
                        <input type="hidden" name="commission_type" value="{{ $key  }}">
                            <h6 class="text--danger mb-3">@lang('The Old setting will be removed after generating new')</h6>
                            <div class="form-group">
                                <div class="referralLevels"></div>
                            </div>
                        <button type="submit" class="btn btn--primary h-45 w-100">@lang('Submit')</button>
                    </form>

                </div>
            </div>
        </div>
    @endforeach
</div>

@endsection

@push('style')
    <style>
        .border-line-area {
            position: relative;
            text-align: center;
            z-index: 1;
        }
        .border-line-area::before {
            position: absolute;
            content: '';
            top: 50%;
            left: 0;
            width: 100%;
            height: 1px;
            background-color: #e5e5e5;
            z-index: -1;
        }
        .border-line-title {
            display: inline-block;
            padding: 3px 10px;
            background-color: #fff;
        }

    </style>
@endpush


@push('script')
    <script>
    (function($){
        "use strict"

        $('[name="level"]').on('focus', function(){
            $(this).on('keyup', function(e){
                if(e.which == 13){
                    generrateLevels($(this));
                }
            });
        });

        $(".generate").on('click', function () {
            let $this = $(this).parents('.card-body').find('[name="level"]');
            generrateLevels($this);
        });

        $(document).on('click', '.deleteBtn', function () {
            $(this).closest('.input-group').remove();
        });

        function generrateLevels($this){
            let numberOfLevel = $this.val();
            let parent = $this.parents('.card-body');
            let html = '';
            if (numberOfLevel && numberOfLevel > 0){
                parent.find('.levelForm').removeClass('d-none');
                parent.find('.required-message').addClass('d-none');

                for (i = 1; i <= numberOfLevel; i++){
                    html += `
                    <div class="input-group mb-3">
                        <span class="input-group-text justify-content-center">@lang('Level') ${i}</span>
                        <input type="hidden" name="level[]" value="${i}" required>
                        <input name="percent[]" class="form-control col-10" type="text" required placeholder="@lang('Commission Percentage')">
                        <button class="btn btn--danger input-group-text deleteBtn" type="button"><i class=\'la la-times\'></i></button>
                    </div>`
                }

                parent.find('.referralLevels').html(html);
            }else {
                parent.find('.levelForm').addClass('d-none');
                parent.find('.required-message').removeClass('d-none');
            }
        }

    })(jQuery);
    </script>
@endpush
