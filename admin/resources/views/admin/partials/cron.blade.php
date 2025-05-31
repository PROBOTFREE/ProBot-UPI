<div id="cronModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">@lang('Please Set Cron Job Now')</h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <i class="las la-times"></i>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group text-center border-bottom mb-4">
                    <div class="text--primary">
                        <i class="las la-info-circle"></i>
                        @lang('Set the Cron time ASAP')
                    </div>
                    <p class="fst-italic">
                        @lang('Once per 5-15 minutes is ideal while once every minute is the best option')
                    </p>
                </div>
                <div class="row g-3">
                    <div class="co-md-12">
                        <div class="form-group">
                            <div class="justify-content-between d-flex flex-wrap">
                                <div>
                                    <label class="fw-bold">@lang('Cron Command')</label>
                                    <small class="fst-italic">
                                        (@lang('Last Cron Run'): <strong>{{ @$general->last_cron ? diffForHumans(@$general->last_cron) : 'N/A' }}</strong>)
                                    </small>
                                </div>
                            </div>
                            <div class="input-group">
                                <input type="text" class="form-control form-control-lg" id="fiatCron" value="curl -s {{ route('cron') }}" readonly>
                                <button type="button" class="input-group-text copytext btn--primary copyCronPath border--primary" data-id="fiatCron"> @lang('Copy')</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn--danger h-45 w-100" data-bs-dismiss="modal">@lang('Close')</button>
            </div>
        </div>
    </div>
</div>

@push('script')
    <script>
        (function($) {
            "use strict";
            $(document).on('click', '.copyCronPath', function() {
                var copyText = document.getElementById($(this).data('id'));
                copyText.select();
                copyText.setSelectionRange(0, 99999);
                document.execCommand('copy');
                notify('success', 'Copied: ' + copyText.value);
            });
        })(jQuery)
    </script>
@endpush
