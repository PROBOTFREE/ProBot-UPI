@extends('admin.layouts.master')
@section('content')
    <div class="login-main" style="background-image: url('{{ asset('assets/admin/images/login.jpg') }}')">
        <div class="container custom-container d-flex justify-content-center">
            <div class="login-area">
                <div class="text-center mb-3">
                    <h2 class="text-white mb-2">@lang('Verify Code')</h2>
                    <p class="text-white mb-2">@lang('Please check your email and enter the verification code you got in your email.')</p>
                </div>
                <form action="{{ route('admin.password.verify.code') }}" method="POST" class="login-form w-100">
                    @csrf

                    <div class="code-box-wrapper d-flex w-100">
                        <div class="form-group mb-3 flex-fill">
                            <span class="text-white fw-bold">@lang('Verification Code')</span>
                            <div class="verification-code">
                                <input type="text" name="code" class="overflow-hidden" autocomplete="off">
                                <div class="boxes">
                                    <span>-</span>
                                    <span>-</span>
                                    <span>-</span>
                                    <span>-</span>
                                    <span>-</span>
                                    <span>-</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex flex-wrap justify-content-between">
                        <a href="{{ route('admin.password.reset') }}" class="forget-text">@lang('Try to send again')</a>
                    </div>
                    <button type="submit" class="btn cmn-btn w-100 mt-4">@lang('Submit')</button>
                </form>
                <a href="{{ route('admin.login') }}" class="text-white mt-4"><i class="las la-sign-in-alt" aria-hidden="true"></i>@lang('Back to Login')</a>
            </div>
        </div>
    </div>


@endsection

@push('style')
    <link rel="stylesheet" href="{{ asset('assets/admin/css/verification_code.css') }}">
@endpush

@push('script')
    <script>
        (function($){
            'use strict';
            $('[name=code]').on('input', function () {

                $(this).val(function(i, val){
                    if (val.length >= 6) {
                        $('form').find('button[type=submit]').html('<i class="las la-spinner fa-spin"></i>');
                        $('form').find('button[type=submit]').removeClass('disabled');
                        $('form')[0].submit();
                    }else{
                        $('form').find('button[type=submit]').addClass('disabled');
                    }
                    if(val.length > 6){
                        return val.substring(0, val.length - 1);
                    }
                    return val;
                });

                for (let index = $(this).val().length; index >= 0 ; index--) {
                    $($('.boxes span')[index]).html('');
                }
            });

        })(jQuery)
    </script>
@endpush
