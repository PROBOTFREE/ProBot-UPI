@extends('admin.layouts.app')

@section('panel')
    <div class="row">
        <div class="col-md-12">
            <div class="card b-radius--10 ">
                <div class="card-body p-0">
                    <div class="table-responsive--sm table-responsive">
                        <table class="table table--light style--two custom-data-table">
                            <thead>
                                <tr>
                                    <th>@lang('Extension')</th>
                                    <th>@lang('Status')</th>
                                    <th>@lang('Action')</th>
                                </tr>
                            </thead>
                            <tbody>
                                @foreach ($extensions as $extension)
                                    <tr>
                                        <td>
                                            <div class="user">
                                                <div class="thumb"><img src="{{ getImage(getFilePath('extensions') . '/' . $extension->image, getFileSize('extensions')) }}" alt="{{ __($extension->name) }}" class="plugin_bg"></div>
                                                <span class="name">{{ __($extension->name) }}</span>
                                            </div>
                                        </td>
                                        <td>
                                            @php
                                                echo $extension->statusBadge;
                                            @endphp
                                        </td>
                                        <td>
                                            <div class="button--group">
                                                <button type="button" class="btn btn-sm btn-outline--primary ms-1 mb-2 editBtn" data-name="{{ __($extension->name) }}" data-shortcode="{{ json_encode($extension->shortcode) }}" data-action="{{ route('admin.extensions.update', $extension->id) }}">
                                                    <i class="la la-cogs"></i> @lang('Configure')
                                                </button>
                                                <button type="button" class="btn btn-sm btn-outline--dark ms-1 mb-2 helpBtn" data-description="{{ __($extension->description) }}" data-support="{{ __($extension->support) }}">
                                                    <i class="la la-question"></i> @lang('Help')
                                                </button>
                                                @if ($extension->status == 0)
                                                    <button type="button" class="btn btn-sm btn-outline--success ms-1 mb-2 confirmationBtn" data-action="{{ route('admin.extensions.status', $extension->id) }}" data-question="@lang('Are you sure to enable this extension?')">
                                                        <i class="la la-eye"></i> @lang('Enable')
                                                    </button>
                                                @else
                                                    <button type="button" class="btn btn-sm btn-outline--danger mb-2 confirmationBtn" data-action="{{ route('admin.extensions.status', $extension->id) }}" data-question="@lang('Are you sure to disable this extension?')">
                                                        <i class="la la-eye-slash"></i> @lang('Disable')
                                                    </button>
                                                @endif
                                            </div>
                                        </td>
                                    </tr>
                                @endforeach
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>



    {{-- EDIT METHOD MODAL --}}
    <div id="editModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">@lang('Update Extension'): <span class="extension-name"></span></h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="las la-times"></i>
                    </button>
                </div>
                <form method="POST">
                    @csrf
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-md-12 control-label fw-bold">@lang('Script')</label>
                            <div class="col-md-12">
                                <textarea name="script" class="form-control" required rows="8" placeholder="@lang('Paste your script with proper key')">{{ old('script') }}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn--primary w-100 h-45" id="editBtn">@lang('Submit')</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    {{-- HELP METHOD MODAL --}}
    <div id="helpModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">@lang('Need Help')?</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="las la-times"></i>
                    </button>
                </div>
                <div class="modal-body">

                </div>
            </div>
        </div>
    </div>

    <x-confirmation-modal />
@endsection


@push('breadcrumb-plugins')
    <div class="d-inline">
        <div class="input-group justify-content-end">
            <input type="text" name="search_table" class="form-control bg--white" placeholder="@lang('Search')...">
            <button class="btn btn--primary input-group-text"><i class="fa fa-search"></i></button>
        </div>
    </div>
@endpush


@push('script')
    <script>
        (function($) {
            "use strict";

            $(document).on('click', '.editBtn', function() {
                var modal = $('#editModal');
                var shortcode = $(this).data('shortcode');

                modal.find('.extension-name').text($(this).data('name'));
                modal.find('form').attr('action', $(this).data('action'));

                var html = '';
                $.each(shortcode, function(key, item) {
                    html += `<div class="form-group">
                        <label class="col-md-12 control-label fw-bold">${item.title}</label>
                        <div class="col-md-12">
                            <input name="${key}" class="form-control" placeholder="--" value="${item.value}" required>
                        </div>
                    </div>`;
                })
                modal.find('.modal-body').html(html);

                modal.modal('show');
            });

            $(document).on('click', '.helpBtn', function() {
                var modal = $('#helpModal');
                var path = "{{ asset(getFilePath('extensions')) }}";
                modal.find('.modal-body').html(`<div class="mb-2">${$(this).data('description')}</div>`);
                if ($(this).data('support') != 'na') {
                    modal.find('.modal-body').append(`<img src="${path}/${$(this).data('support')}">`);
                }
                modal.modal('show');
            });

        })(jQuery);
    </script>
@endpush
