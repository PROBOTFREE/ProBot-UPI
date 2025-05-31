@extends('admin.layouts.app')
@section('panel')
    <div class="row">
        <div class="col-lg-12">
            <div class="card b-radius--10 ">
                <div class="card-body p-0">
                    <div class="table-responsive--md  table-responsive">
                        <table class="table table--light style--two">
                            <thead>
                                <tr>
                                    <th scope="col">@lang('Name')</th>
                                    <th scope="col">@lang('Invest Limit')</th>
                                    <th>@lang('Interest')</th>
                                    <th>@lang('Time')</th>
                                    <th scope="col">@lang('Featured')</th>
                                    <th scope="col">@lang('Status')</th>
                                    <th scope="col">@lang('Action')</th>
                                </tr>
                            </thead>
                            <tbody>
                            @forelse($plans as $plan)
                            <tr>
                                <td>{{__($plan->name)}}</td>
                                <td>
                                    @if($plan->fixed_amount == 0)
                                        <span>{{$general->cur_sym}}{{showAmount($plan->minimum)}}
                                            - {{$general->cur_sym}}{{showAmount($plan->maximum)}}</span>
                                    @else
                                        <span>{{$general->cur_sym}}{{showAmount($plan->fixed_amount)}}</span>
                                    @endif
                                </td>
                                <td>
                                    {{ showAmount($plan->interest) }} @if($plan->interest_type == 1) % @else {{ $general->cur_text }} @endif
                                </td>
                                <td>{{ $plan->time }} @lang('Hours')</td>
                                <td>
                                    @if($plan->featured == 1)
                                        <span class="badge badge--success">@lang('Yes')</span>
                                    @else
                                        <span class="badge badge--warning">@lang('No')</span>
                                    @endif
                                </td>
                                <td>
                                    @if($plan->status == 1)
                                        <span class="badge badge--success">@lang('Active')</span>
                                    @else
                                        <span class="badge badge--warning">@lang('Inactive')</span>
                                    @endif
                                </td>
                                <td>
                                    <button class="btn btn-sm btn-outline--primary modalShow me-2" data-type="edit" data-bs-toggle="modal" data-bs-target="#editModal" data-resource="{{ $plan }}" data-action="{{ route('admin.plan.update',$plan->id) }}"><i class="las la-pen"></i>@lang('Edit')</button>
                                    @if ($plan->status)
                                        <button class="btn btn-sm btn-outline--danger confirmationBtn" data-question="@lang('Are you sure to disable this plan?')" data-action="{{ route('admin.plan.status', $plan->id) }}"><i class="las la-eye-slash"></i>@lang('Disable')</button>
                                    @else
                                        <button class="btn btn-sm btn-outline--success confirmationBtn" data-question="@lang('Are you sure to enable this plan?')" data-action="{{ route('admin.plan.status', $plan->id) }}"><i class="las la-eye"></i>@lang('Enable')</button>
                                    @endif
                                </td>
                            </tr>
                            @empty
                                <tr>
                                    <td class="text-muted text-center" colspan="100%">{{ __($emptyMessage) }}</td>
                                </tr>
                            @endforelse
                            </tbody>
                        </table><!-- table end -->
                    </div>
                </div>
            </div><!-- card end -->
        </div>
    </div>

    <div class="modal fade" id="addModal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title">@lang('Add New Plan')</h5>
                <button type="button" class="close" data-bs-dismiss="modal">
                    <i class="las la-times"></i>
                </button>
                </div>
                <form action="{{ route('admin.plan.store') }}" method="post">
                    @csrf
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Name')</label>
                                    <input type="text" class="form-control" name="name" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Invest type')</label>
                                    <select name="invest_type" class="form-control" required>
                                        <option value="1">@lang('Range')</option>
                                        <option value="2">@lang('Fixed')</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row amount-fields"></div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Interest type')</label>
                                    <select name="interest_type" class="form-control" required>
                                        <option value="1">@lang('Percent')</option>
                                        <option value="2">@lang('Fixed')</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Interest')</label>
                                    <div class="input-group">
                                        <input type="number" step="any" class="form-control" name="interest" required>
                                        <span class="input-group-text interest-type"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Time')</label>
                                    <select name="time" class="form-control" required>
                                        <option value="">@lang('Select One')</option>
                                        @foreach($times as $time)
                                            <option value="{{ $time->time }}">{{ __($time->name) }}</option>
                                        @endforeach
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Return type')</label>
                                    <select name="return_type" class="form-control" required>
                                        <option value="1">@lang('Lifetime')</option>
                                        <option value="0">@lang('Repeat')</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="repeat-time row"></div>
                        <div class="form-group">
                            <label for="">@lang('Featured')</label>
                            <input type="checkbox" data-width="100%" data-onstyle="-success" data-offstyle="-danger"
                            data-bs-toggle="toggle" data-on="@lang('Yes')" data-off="@lang('No')" name="featured">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn--primary w-100 h-45">@lang('Submit')</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="editModal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">@lang('Edit Plan')</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="las la-times"></i>
                    </button>
                </div>
                <form action="" method="post">
                    @csrf
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Name')</label>
                                    <input type="text" class="form-control" name="name" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Invest type')</label>
                                    <select name="invest_type" class="form-control" required>
                                        <option value="1">@lang('Range')</option>
                                        <option value="2">@lang('Fixed')</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row amount-fields"></div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Interest type')</label>
                                    <select name="interest_type" class="form-control" required>
                                        <option value="1">@lang('Percent')</option>
                                        <option value="2">@lang('Fixed')</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Interest')</label>
                                    <div class="input-group">
                                        <input type="number" step="any" class="form-control" name="interest" required>
                                        <span class="input-group-text interest-type"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Time')</label>
                                    <select name="time" class="form-control" required>
                                        @foreach($times as $time)
                                            <option value="{{ $time->time }}">{{ __($time->name) }}</option>
                                        @endforeach
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Return type')</label>
                                    <select name="return_type" class="form-control" required>
                                        <option value="1">@lang('Lifetime')</option>
                                        <option value="0">@lang('Repeat')</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="repeat-time row"></div>
                        <div class="form-group">
                            <label for="">@lang('Featured')</label>
                            <input type="checkbox" data-width="100%" data-onstyle="-success" data-offstyle="-danger"
                            data-bs-toggle="toggle" data-on="@lang('Yes')" data-off="@lang('No')" name="featured">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn--primary w-100 h-45">@lang('Submit')</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <x-confirmation-modal />
@endsection
@push('breadcrumb-plugins')
    <button class="btn btn-outline--primary btn-sm modalShow" data-type="add" data-bs-toggle="modal" data-bs-target="#addModal"><i class="las la-plus"></i> @lang('Add New')</button>
@endpush


@push('script')
    <script>
        (function($){
            "use strict"

            $('.modalShow').on('click',function(){

                //get modal element
                if($(this).data('type') == 'add'){
                    var modal = $('#addModal');
                }else{
                    var modal = $('#editModal');
                }
                var plan = new HyipPlan(modal, $(this));

                modal.find('[name=invest_type]').change(function() {
                    plan.getInvestType($(this).val());
                }).change()


                modal.find('[name=interest_type]').change(function() {
                    plan.getInterestType($(this).val());
                }).change()

                plan.setupEditModal();

                modal.find('[name=return_type]').change(function() {
                    plan.getReturnType($(this).val());
                }).change()


            });


            class HyipPlan{
                constructor(modal,btn){
                    this.modal = modal;
                    this.btn = btn;
                    this.resource = btn.data('resource');
                    this.action = btn.data('action');
                    this.fixedAmount = '';
                    this.minimumAmount = '';
                    this.maximumAmount = '';

                    //this block for edit modal
                    if(this.resource){
                        //set amount
                        if(this.resource.fixed_amount <= 0){
                            this.modal.find('[name=invest_type]').val(1);
                            this.minimumAmount = parseFloat(this.resource.minimum).toFixed(2);
                            this.maximumAmount = parseFloat(this.resource.maximum).toFixed(2);
                        }else{
                            this.modal.find('[name=invest_type]').val(2);
                            this.fixedAmount = parseFloat(this.resource.fixed_amount).toFixed(2);
                        }

                        //set interest type
                        if(this.resource.interest_type == 1){
                            this.modal.find('[name=interest_type]').val(1);
                        }else{
                            this.modal.find('[name=interest_type]').val(2);
                        }

                        //set repeat type
                        if(this.resource.lifetime == 1){
                            this.modal.find('[name=return_type]').val(1);
                        }else{
                            this.modal.find('[name=return_type]').val(2);
                        }
                        if(this.resource.featured){
                            this.modal.find('[name=featured]').bootstrapToggle('on');
                        }else{
                            this.modal.find('[name=featured]').bootstrapToggle('off');
                        }
                    }
                }

                getInvestType(type){
                    if(type == 1){
                        var html = `
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="required">@lang('Minimum Invest')</label>
                                    <div class="input-group">
                                        <input type="number" step="any" class="form-control" name="minimum" value="${this.minimumAmount}" required>
                                        <span class="input-group-text">{{ $general->cur_text }}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="required">@lang('Maximum Invest')</label>
                                    <div class="input-group">
                                        <input type="number" step="any" class="form-control" name="maximum" value="${this.maximumAmount}" required>
                                        <span class="input-group-text">{{ $general->cur_text }}</span>
                                    </div>
                                </div>
                            </div>
                            `;
                    }else{
                        var html = `
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="required">@lang('Amount')</label>
                                    <div class="input-group">
                                        <input type="number" step="any" class="form-control" name="amount" value="${this.fixedAmount}" required>
                                        <span class="input-group-text">{{ $general->cur_text }}</span>
                                    </div>
                                </div>
                            </div>
                            `;
                    }

                    this.modal.find('.amount-fields').html(html);
                }

                getInterestType(type){
                    if(type == 1){
                        this.modal.find('.interest-type').text('%');
                    }else{
                        this.modal.find('.interest-type').text('{{ $general->cur_text }}');
                    }
                }

                getReturnType(type){
                    var html = ``;
                    var resource = this.resource;
                    if(type == 0){
                        var html = `
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="required">@lang('Repeat Times')</label>
                                    <div class="input-group">
                                        <input type="number" class="form-control" name="repeat_time" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Capital back')</label>
                                    <select name="capital_back" class="form-control" required>
                                        <option value="1">@lang('Yes')</option>
                                        <option value="0">@lang('No')</option>
                                    </select>
                                </div>
                            </div>
                        `;
                    }
                    this.modal.find('.repeat-time').html(html);
                    if(resource){
                        this.modal.find('[name=repeat_time]').val(resource.repeat_time);
                        this.modal.find('[name=capital_back]').val(resource.capital_back);
                    }
                }

                setupEditModal(){
                    var modal = this.modal;
                    var resource = this.resource;
                    if(resource){
                        modal.find('[name=name]').val(resource.name);
                        modal.find('[name=minimum]').val(parseFloat(resource.minimum).toFixed(2));
                        modal.find('[name=maximum]').val(parseFloat(resource.maximum).toFixed(2));
                        modal.find('[name=amount]').val(parseFloat(resource.fixed_amount).toFixed(2));
                        modal.find('[name=interest]').val(parseFloat(resource.interest).toFixed(2));
                        modal.find('[name=time]').val(resource.time);
                        modal.find('[name=repeat_time]').val(resource.repeat_time);
                        modal.find('[name=capital_back]').val(resource.capital_back);
                        modal.find('[name=return_type]').val(resource.lifetime);
                        modal.find('form').attr('action',this.btn.data('action'));
                    }
                }
            }

        })(jQuery);
    </script>
@endpush
