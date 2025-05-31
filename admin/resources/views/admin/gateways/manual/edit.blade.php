@extends('admin.layouts.app')

@section('panel')
    <div class="row">
        <div class="col-lg-12">
            <div class="card mb-4">
                <form action="{{ route('admin.gateway.manual.update', $method->code) }}" method="POST" enctype="multipart/form-data">
                    @csrf
                    <div class="card-body">
                        <div class="payment-method-item">
                            <div class="payment-method-body">

                                <div class="row mt-4">
                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-4 mb-15">
                                        <div class="form-group">
                                            <label>@lang('Gateway Name')</label>
                                            <input type="text" class="form-control" name="name" value="{{ $method->name }}" required />
                                        </div>
                                    </div>
                                    <div class="col-xl-3 col-md-6">
                                        <div class="form-group">
                                            <label>@lang('Currency')</label>
                                            <input type="text" name="currency" class="form-control border-radius-5" value="{{ @$method->singleCurrency->currency }}" required />
                                        </div>
                                    </div>
                                    <div class="col-xl-5 col-md-12">
                                        <div class="form-group">
                                            <label>@lang('Rate')</label>
                                            <div class="input-group">
                                                <div class="input-group-text">1 {{ __($general->cur_text) }}=</div>
                                                <input type="number" step="any" class="form-control" name="rate" value="{{ getAmount(@$method->singleCurrency->rate) }}" required />
                                                <span class="currency_symbol input-group-text"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">

                                    <div class="col-lg-6">
                                        <div class="card border--primary mt-3">
                                            <h5 class="card-header bg--primary">@lang('Range')</h5>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <label>@lang('Minimum Amount')</label>
                                                    <div class="input-group">
                                                        <input type="number" step="any" class="form-control" name="min_limit" value="{{ getAmount(@$method->singleCurrency->min_amount) }}" required />
                                                        <div class="input-group-text">{{ __($general->cur_text) }}</div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label>@lang('Maximum Amount')</label>
                                                    <div class="input-group">
                                                        <input type="number" step="any" class="form-control" name="max_limit" value="{{ getAmount(@$method->singleCurrency->max_amount) }}" required />
                                                        <div class="input-group-text">{{ __($general->cur_text) }}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="card border--primary mt-3">
                                            <h5 class="card-header bg--primary">@lang('Charge')</h5>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <label>@lang('Fixed Charge')</label>
                                                    <div class="input-group">
                                                        <input type="number" step="any" class="form-control" name="fixed_charge" value="{{ getAmount(@$method->singleCurrency->fixed_charge) }}" required />
                                                        <div class="input-group-text">{{ __($general->cur_text) }}</div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label>@lang('Percent Charge')</label>
                                                    <div class="input-group">
                                                        <input type="number" step="any" class="form-control" name="percent_charge" value="{{ getAmount(@$method->singleCurrency->percent_charge) }}" required>
                                                        <div class="input-group-text">%</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-12">
                                        <div class="card border--primary mt-3">

                                            <h5 class="card-header bg--primary">@lang('Deposit Instruction')</h5>
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <textarea rows="8" class="form-control border-radius-5 nicEdit" name="instruction">{{ __(@$method->description) }}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-12">
                                        <div class="card border--primary mt-3">
                                            <div class="card-header bg--primary d-flex justify-content-between">
                                                <h5 class="text-white">@lang('User Data')</h5>
                                                <button type="button" class="btn btn-sm btn-outline-light float-end form-generate-btn"> <i class="la la-fw la-plus"></i>@lang('Add New')</button>
                                            </div>
                                            <div class="card-body">
                                                <div class="row addedField">
                                                    @if ($form)
                                                        @foreach ($form->form_data as $formData)
                                                            <div class="col-md-4">
                                                                <div class="card border mb-3" id="{{ $loop->index }}">
                                                                    <input type="hidden" name="form_generator[is_required][]" value="{{ $formData->is_required }}">
                                                                    <input type="hidden" name="form_generator[extensions][]" value="{{ $formData->extensions }}">
                                                                    <input type="hidden" name="form_generator[options][]" value="{{ implode(',', $formData->options) }}">

                                                                    <div class="card-body">
                                                                        <div class="form-group">
                                                                            <label>@lang('Label')</label>
                                                                            <input type="text" name="form_generator[form_label][]" class="form-control" value="{{ $formData->name }}" readonly>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label>@lang('Type')</label>
                                                                            <input type="text" name="form_generator[form_type][]" class="form-control" value="{{ $formData->type }}" readonly>
                                                                        </div>
                                                                        @php
                                                                            $jsonData = json_encode([
                                                                                'type' => $formData->type,
                                                                                'is_required' => $formData->is_required,
                                                                                'label' => $formData->name,
                                                                                'extensions' => explode(',', $formData->extensions) ?? 'null',
                                                                                'options' => $formData->options,
                                                                                'old_id' => '',
                                                                            ]);
                                                                        @endphp
                                                                        <div class="btn-group w-100">
                                                                            <button type="button" class="btn btn--primary editFormData" data-form_item="{{ $jsonData }}" data-update_id="{{ $loop->index }}"><i class="las la-pen"></i></button>
                                                                            <button type="button" class="btn btn--danger removeFormData"><i class="las la-times"></i></button>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        @endforeach
                                                    @endif
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn--primary w-100 h-45">@lang('Submit')</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <x-form-generator />
@endsection

@push('script')
    <script>
        "use strict"
        var formGenerator = new FormGenerator();
        formGenerator.totalField = {{ $form ? count((array) $form->form_data) : 0 }}
    </script>

    <script src="{{ asset('assets/global/js/form_actions.js') }}"></script>
@endpush



@push('breadcrumb-plugins')
    <x-back route="{{ route('admin.gateway.manual.index') }}" />
@endpush

@push('script')
    <script>
        (function($) {
            "use strict";

            $('input[name=currency]').on('input', function() {
                $('.currency_symbol').text($(this).val());
            });
            $('.currency_symbol').text($('input[name=currency]').val());

            @if (old('currency'))
                $('input[name=currency]').trigger('input');
            @endif
        })(jQuery);
    </script>
@endpush
