@extends('admin.layouts.app')

@section('panel')
<div class="row">
    <div class="col-lg-12">
        <div class="card bl--5-primary mb-3">
            <div class="card-body">
                <p>@lang('This module could be enabled or disabled from the') <a href="{{ route('admin.setting.system.configuration') }}">@lang('System Setting')</a>. @lang('If you enable the module you users will be able to use some HTML code to generate the referral users.')</p>
            </div>
        </div>
        <div class="card">
            <div class="card-body p-0">
                <div class="table-responsive--md  table-responsive">
                    <table class="table table--light style--two">
                        <thead>
                            <tr>
                                <th>@lang('S.N.')</th>
                                <th>@lang('Banner')</th>
                                <th>@lang('Name')</th>
                                <th>@lang('Action')</th>
                            </tr>
                        </thead>
                        <tbody class="list">
                            @forelse($tools as $tool)
                                <tr>
                                    <td> {{ ($tool->currentPage-1) * $tool->perPage + $loop->iteration }}</td>

                                    <td>
                                        <div class="user d-flex justify-content-center">
                                            <div class="thumb">
                                                <img src="{{ getImage(getFilePath('promotions').  '/'. @$tool->banner) }}" alt="@lang('image')">
                                            </div>
                                        </div>
                                    </td>
                                    <td> {{ __($tool->name) }} </td>

                                    <td>
                                        <button type="button"
                                            data-id="{{ $tool->id }}"
                                            data-name="{{ $tool->name }}"
                                            data-image="{{ getImage(getFilePath('promotions').  '/'. @$tool->banner) }}"
                                            data-action="{{ route('admin.promotional.tool.update',$tool->id) }}" class="btn btn-sm btn-outline--primary editBtn"> <i class="las la-pen"></i> @lang('Edit') </button>
                                        <button type="button" data-action="{{ route('admin.promotional.tool.remove', $tool->id) }}" class="btn btn-sm btn-outline--danger deleteBtn"> <i class="las la-trash"></i> @lang('Delete')</button>
                                    </td>
                                </tr>
                            @empty
                                <tr>
                                    <td class="text-muted text-center" colspan="100%">{{ __($emptyMessage) }}</td>
                                </tr>
                            @endforelse
                        </tbody>
                    </table>
                </div>
            </div>
            @if($tools->hasPages())
            <div class="card-footer py-4">
                {{ paginateLinks($tools) }}
            </div>
            @endif
        </div>
    </div>
</div>

<div id="addModal" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content ">
            <div class="modal-header">
                <h5 class="modal-title">@lang('Add New Banner')</h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="@lang('Close')">
                    <span aria-hidden="true"><i class="las la-times"></i></span>
                </button>
            </div>
            <form action="{{ route('admin.promotional.tool.store') }}" method="POST" enctype="multipart/form-data">
                @csrf
                <div class="modal-body">
                    <div class="image-upload">
                        <div class="thumb">
                            <div class="avatar-preview">
                                <div class="profilePicPreview" style="background-image: url({{ getImage(getFilePath('default')) }})">
                                    <button type="button" class="remove-image"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="avatar-edit">
                                <input type="file" class="profilePicUpload p-0" id="profilePicUpload2" accept="jpeg, jpg, png, gif" name="image_input" >
                                <label for="profilePicUpload2" class="bg--primary">@lang('Select Banner Image')</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group mt-3">
                      <label for="name">@lang('Name')</label>
                      <input type="text" class="form-control" name="name" id="name">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn w-100 btn--primary h-45">@lang('Submit')</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="editModal" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">@lang('Edit Banner')</h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="las la-times"></i></span>
                </button>
            </div>
            <form action="" method="POST" enctype="multipart/form-data">
                @csrf
                <div class="modal-body">
                    <div class="image-upload">
                        <div class="thumb">
                            <div class="avatar-preview">
                                <div class="profilePicPreview" style="background-image: url({{ getImage(getFilePath('default')) }})">
                                    <button type="button" class="remove-image"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="avatar-edit">
                                <input type="file" class="profilePicUpload p-0" id="profilePicUpload-1" accept="jpeg, jpg, png, gif" name="image_input" >
                                <label for="profilePicUpload-1" class="bg--primary">@lang('Select Banner Image')</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group mt-3">
                        <label for="name1">@lang('Name')</label>
                        <input type="text" class="form-control" name="name" id="name1">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn w-100 btn--primary h-45">@lang('Submit')</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="" method="POST">
                @csrf
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize">@lang('Removal Confirmation')</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="las la-times"></i></span>
                    </button>
                </div>
                <div class="modal-body">
                    @lang('Are you sure to delete this banner?')
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn--dark" data-dismiss="modal">@lang('No')</button>
                    <button type="submit" class="btn btn--primary">@lang('Yes')</button>
                </div>
            </form>
        </div>
    </div>
</div>

@endsection

@push('breadcrumb-plugins')
    <button data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-sm btn-outline--primary"> <i class="las la-plus"></i> @lang('Add New')</button>
@endpush


@push('script')
    <script>
        (function($){
            'use strict';

            $('.editBtn').on('click', function () {
                var modal = $('#editModal');
                var form = modal.find('form');

                modal.find('input[name=name]').val($(this).data('name'));
                modal.find('.profilePicPreview').css('background-image', `url(${$(this).data('image')})`);
                form.attr('action',$(this).data('action'));
                modal.modal('show');
            });

            $('.deleteBtn').on('click', function ()
            {
                var modal   = $('#deleteModal');
                var form    = modal.find('form');
                form.attr('action',$(this).data('action'));
                modal.modal('show');
            });

        })(jQuery)
    </script>
@endpush

@push('style')
    <style>
        .image-upload .thumb .profilePicUpload {
            display: none
        }
        .avatar-edit {
            padding: 15px 2px 0 ;
        }

        .image-upload .thumb .profilePicPreview {
            background-size: contain !important;
            background-position: center !important;
        }
    </style>
@endpush
