@extends('admin.layouts.app')
@section('panel')
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form action="" method="POST">
                    @csrf
                    <div class="card-body">
                        <div class="form-group">
                            <label>@lang('Sms Send Method')</label>
                            <select name="sms_method" class="form-control">
                                <option value="clickatell" @if (@$general->sms_config->name == 'clickatell') selected @endif>@lang('Clickatell')</option>
                                <option value="infobip" @if (@$general->sms_config->name == 'infobip') selected @endif>@lang('Infobip')</option>
                                <option value="messageBird" @if (@$general->sms_config->name == 'messageBird') selected @endif>@lang('Message Bird')</option>
                                <option value="nexmo" @if (@$general->sms_config->name == 'nexmo') selected @endif>@lang('Nexmo')</option>
                                <option value="smsBroadcast" @if (@$general->sms_config->name == 'smsBroadcast') selected @endif>@lang('Sms Broadcast')</option>
                                <option value="twilio" @if (@$general->sms_config->name == 'twilio') selected @endif>@lang('Twilio')</option>
                                <option value="textMagic" @if (@$general->sms_config->name == 'textMagic') selected @endif>@lang('Text Magic')</option>
                                <option value="custom" @if (@$general->sms_config->name == 'custom') selected @endif>@lang('Custom API')</option>
                            </select>
                        </div>
                        <div class="row mt-4 d-none configForm" id="clickatell">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Clickatell Configuration')</h6>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>@lang('API Key') </label>
                                    <input type="text" class="form-control" placeholder="@lang('API Key')" name="clickatell_api_key" value="{{ @$general->sms_config->clickatell->api_key }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="infobip">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Infobip Configuration')</h6>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Username') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Username')" name="infobip_username" value="{{ @$general->sms_config->infobip->username }}" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Password') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Password')" name="infobip_password" value="{{ @$general->sms_config->infobip->password }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="messageBird">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Message Bird Configuration')</h6>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>@lang('API Key') </label>
                                    <input type="text" class="form-control" placeholder="@lang('API Key')" name="message_bird_api_key" value="{{ @$general->sms_config->message_bird->api_key }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="nexmo">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Nexmo Configuration')</h6>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('API Key') </label>
                                    <input type="text" class="form-control" placeholder="@lang('API Key')" name="nexmo_api_key" value="{{ @$general->sms_config->nexmo->api_key }}" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('API Secret') </label>
                                    <input type="text" class="form-control" placeholder="@lang('API Secret')" name="nexmo_api_secret" value="{{ @$general->sms_config->nexmo->api_secret }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="smsBroadcast">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Sms Broadcast Configuration')</h6>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Username') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Username')" name="sms_broadcast_username" value="{{ @$general->sms_config->sms_broadcast->username }}" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Password') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Password')" name="sms_broadcast_password" value="{{ @$general->sms_config->sms_broadcast->password }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="twilio">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Twilio Configuration')</h6>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>@lang('Account SID') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Account SID')" name="account_sid" value="{{ @$general->sms_config->twilio->account_sid }}" />
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>@lang('Auth Token') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Auth Token')" name="auth_token" value="{{ @$general->sms_config->twilio->auth_token }}" />
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>@lang('From Number') </label>
                                    <input type="text" class="form-control" placeholder="@lang('From Number')" name="from" value="{{ @$general->sms_config->twilio->from }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="textMagic">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Text Magic Configuration')</h6>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Username') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Username')" name="text_magic_username" value="{{ @$general->sms_config->text_magic->username }}" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>@lang('Apiv2 Key') </label>
                                    <input type="text" class="form-control" placeholder="@lang('Apiv2 Key')" name="apiv2_key" value="{{ @$general->sms_config->text_magic->apiv2_key }}" />
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 d-none configForm" id="custom">
                            <div class="col-md-12">
                                <h6 class="mb-2">@lang('Custom API')</h6>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>@lang('API URL') </label>
                                    <div class="input-group">
                                        <span class="input-group-text">
                                            <select name="custom_api_method" class="method-select">
                                                <option value="get">@lang('GET')</option>
                                                <option value="post">@lang('POST')</option>
                                            </select>
                                        </span>
                                        <input type="text" class="form-control" name="custom_api_url" value="{{ @$general->sms_config->custom->url }}" placeholder="@lang('API URL')" />
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="table-responsive table-responsive--sm mb-3">
                                        <table class=" table align-items-center table--light">
                                            <thead>
                                                <tr>
                                                    <th>@lang('Short Code') </th>
                                                    <th>@lang('Description')</th>
                                                </tr>
                                            </thead>
                                            <tbody class="list">
                                                <tr>
                                                    <td>@{{ message }}</td>
                                                    <td>@lang('Message')</td>
                                                </tr>
                                                <tr>
                                                    <td>@{{ number }}</td>
                                                    <td>@lang('Number')</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="card border--dark mb-3">
                                        <div class="card-header bg--dark d-flex justify-content-between">
                                            <h5 class="text-white">@lang('Headers')</h5>
                                            <button type="button" class="btn btn-sm btn-outline-light float-right addHeader"><i class="la la-fw la-plus"></i>@lang('Add') </button>
                                        </div>
                                        <div class="card-body">
                                            <div class="headerFields">
                                                @for ($i = 0; $i < count($general->sms_config->custom->headers->name); $i++)
                                                    <div class="row mt-3">
                                                        <div class="col-md-5">
                                                            <input type="text" name="custom_header_name[]" class="form-control" value="{{ @$general->sms_config->custom->headers->name[$i] }}" placeholder="@lang('Headers Name')">
                                                        </div>
                                                        <div class="col-md-5">
                                                            <input type="text" name="custom_header_value[]" class="form-control" value="{{ @$general->sms_config->custom->headers->value[$i] }}" placeholder="@lang('Headers Value')">
                                                        </div>
                                                        <div class="col-md-2">
                                                            <button type="button" class="btn btn--danger btn-block removeHeader h-100"><i class="las la-times"></i></button>
                                                        </div>
                                                    </div>
                                                @endfor
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="card border--dark mb-3">
                                        <div class="card-header bg--dark d-flex justify-content-between">
                                            <h5 class="text-white">@lang('Body')</h5>
                                            <button type="button" class="btn btn-sm btn-outline-light float-right addBody"><i class="la la-fw la-plus"></i>@lang('Add') </button>
                                        </div>
                                        <div class="card-body">
                                            <div class="bodyFields">
                                                @for ($i = 0; $i < count($general->sms_config->custom->body->name); $i++)
                                                    <div class="row mt-3">
                                                        <div class="col-md-5">
                                                            <input type="text" name="custom_body_name[]" class="form-control" value="{{ @$general->sms_config->custom->body->name[$i] }}" placeholder="@lang('Body Name')">
                                                        </div>
                                                        <div class="col-md-5">
                                                            <input type="text" name="custom_body_value[]" value="{{ @$general->sms_config->custom->body->value[$i] }}" class="form-control" placeholder="@lang('Body Value')">
                                                        </div>
                                                        <div class="col-md-2">
                                                            <button type="button" class="btn btn--danger btn-block removeBody h-100"><i class="las la-times"></i></button>
                                                        </div>
                                                    </div>
                                                @endfor
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn w-100 h-45 btn--primary">@lang('Submit')</button>
                    </div>
                </form>
            </div><!-- card end -->
        </div>


    </div>


    {{-- TEST MAIL MODAL --}}
    <div id="testSMSModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">@lang('Test SMS Setup')</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="las la-times"></i>
                    </button>
                </div>
                <form action="{{ route('admin.setting.notification.sms.test') }}" method="POST">
                    @csrf
                    <input type="hidden" name="id">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>@lang('Sent to') </label>
                                    <input type="text" name="mobile" class="form-control" placeholder="@lang('Mobile')">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn--primary w-100 h-45">@lang('Submit')</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
@endsection
@push('breadcrumb-plugins')
    <button type="button" data-bs-target="#testSMSModal" data-bs-toggle="modal" class="btn btn-outline--primary btn-sm"> <i class="las la-paper-plane"></i> @lang('Send Test SMS')</button>
@endpush
@push('style')
    <style>
        .method-select {
            padding: 2px 7px;
        }
    </style>
@endpush
@push('script')
    <script>
        (function($) {
            "use strict";

            var method = '{{ @$general->sms_config->name }}';

            if (!method) {
                method = 'clickatell';
            }

            smsMethod(method);
            $('select[name=sms_method]').on('change', function() {
                var method = $(this).val();
                smsMethod(method);
            });

            function smsMethod(method) {
                $('.configForm').addClass('d-none');
                if (method != 'php') {
                    $(`#${method}`).removeClass('d-none');
                }
            }

            $('.addHeader').click(function() {
                var html = `
                    <div class="row mt-3">
                        <div class="col-md-5">
                            <input type="text" name="custom_header_name[]" class="form-control" placeholder="@lang('Headers Name')">
                        </div>
                        <div class="col-md-5">
                            <input type="text" name="custom_header_value[]" class="form-control" placeholder="@lang('Headers Value')">
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn--danger btn-block removeHeader h-100"><i class="las la-times"></i></button>
                        </div>
                    </div>
                `;
                $('.headerFields').append(html);

            })
            $(document).on('click', '.removeHeader', function() {
                $(this).closest('.row').remove();
            })

            $('.addBody').click(function() {
                var html = `
                    <div class="row mt-3">
                        <div class="col-md-5">
                            <input type="text" name="custom_body_name[]" class="form-control" placeholder="@lang('Body Name')">
                        </div>
                        <div class="col-md-5">
                            <input type="text" name="custom_body_value[]" class="form-control" placeholder="@lang('Body Value')">
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn--danger btn-block removeBody h-100"><i class="las la-times"></i></button>
                        </div>
                    </div>
                `;
                $('.bodyFields').append(html);

            })
            $(document).on('click', '.removeBody', function() {
                $(this).closest('.row').remove();
            })

            $('select[name=custom_api_method]').val('{{ @$general->sms_config->custom->method }}');

        })(jQuery);
    </script>
@endpush
