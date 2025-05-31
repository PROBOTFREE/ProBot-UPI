@extends('admin.layouts.master')
@section('content')
    <div class="login-main" style="background-image: url('{{ asset('assets/admin/images/login.jpg') }}')">
        <div class="container custom-container">
            <div class="row justify-content-center">
                <div class="col-xxl-5 col-xl-5 col-lg-6 col-md-8 col-sm-11">
                    <div class="login-area">
                        <div class="login-wrapper">
                            <div class="login-wrapper__top">
                                <h3 class="title text-white">@lang('Recover Account')</h3>
                            </div>
                            <div class="login-wrapper__body">
                                <form action="{{ route('admin.password.reset') }}" method="POST" class="login-form">
                                    @csrf
                                    <div class="mb-3">
                                        <label>@lang('Email')</label>
                                        <input type="email" name="email" class="form-control" value="{{ old('email') }}" required>
                                    </div>
                                    <div class="d-flex flex-wrap justify-content-between">
                                        <a href="{{ route('admin.login') }}" class="forget-text">@lang('Login Here')</a>
                                    </div>
                                    <button type="submit" class="btn cmn-btn w-100">@lang('Submit')</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection


