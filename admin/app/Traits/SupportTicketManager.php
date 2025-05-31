<?php

namespace App\Traits;

use App\Models\AdminNotification;
use App\Models\SupportAttachment;
use App\Models\SupportMessage;
use App\Models\SupportTicket;
use Carbon\Carbon;
use Illuminate\Http\Request;

trait SupportTicketManager
{
    protected $files;
    protected $allowedExtension = ['jpg', 'png', 'jpeg', 'pdf', 'doc', 'docx'];
    protected $userType;
    protected $user = null;
    protected $column;

    public function supportTicket()
    {
        $user = $this->user;
        if (!$user) {
            abort(404);
        }
        $pageTitle = "Support Tickets";
        $supports = SupportTicket::where($this->column, $user->id)->orderBy('id', 'desc')->paginate(getPaginate());
        return view($this->activeTemplate . $this->userType . '.support.index', compact('supports', 'pageTitle'));
    }

    public function openSupportTicket()
    {
        $user = $this->user;
        if (!$user) {
            return to_route('home');
        }
        $pageTitle = "Open Ticket";
        return view($this->activeTemplate . $this->userType . '.support.create', compact('pageTitle', 'user'));
    }

    public function storeSupportTicket(Request $request)
    {
        $ticket  = new SupportTicket();
        $message = new SupportMessage();

        $this->validation($request);


        $column             = $this->column;
        $user               = $this->user;
        $ticket->$column    = $user->id;
        $ticket->ticket     = rand(100000, 999999);
        $ticket->name       = $request->name;
        $ticket->email      = $request->email;
        $ticket->subject    = $request->subject;
        $ticket->last_reply = Carbon::now();
        $ticket->status     = 0;
        $ticket->priority   = $request->priority;
        $ticket->save();


        $message->support_ticket_id = $ticket->id;
        $message->message           = $request->message;
        $message->save();

        $adminNotification            = new AdminNotification();
        $adminNotification->$column   = $user->id;
        $adminNotification->title     = 'New support ticket has opened';
        $adminNotification->click_url = urlPath('admin.ticket.view', $ticket->id);
        $adminNotification->save();

        if ($request->hasFile('attachments')) {
            $uploadAttachments = $this->storeSupportAttachments($message->id);
            if ($uploadAttachments != 200) return back()->withNotify($uploadAttachments);;
        }

        $notify[] = ['success', 'Ticket opened successfully!'];
        return to_route($this->redirectLink, $ticket->ticket)->withNotify($notify);
    }

    public function viewTicket($ticket)
    {
        $user      = $this->user;
        $column    = $this->column;
        $pageTitle = "View Ticket";
        $userId    = 0;
        $layout    = $this->layout;

        $myTicket = SupportTicket::where('ticket', $ticket)->orderBy('id', 'desc')->firstOrFail();

        if ($myTicket->$column > 0) {
            if ($user) {
                $userId = $user->id;
            } else {
                return to_route($this->userType . '.login');
            }
        }

        $myTicket = SupportTicket::where('ticket', $ticket)->where($this->column, $userId)->orderBy('id', 'desc')->firstOrFail();
        $messages = SupportMessage::where('support_ticket_id', $myTicket->id)->with('ticket', 'admin', 'attachments')->orderBy('id', 'desc')->get();

        return view($this->activeTemplate . $this->userType . '.support.view', compact('myTicket', 'messages', 'pageTitle', 'user', 'layout'));
    }


    public function replyTicket(Request $request, $id)
    {
        $user = $this->user;
        $userId = 0;
        if ($user) {
            $userId = $user->id;
        }
        $ticket = SupportTicket::where('id', $id)->firstOrFail();
        if (($this->userType == 'user') && ($userId != $ticket->user_id)) {
            abort(404);
        }
        $message = new SupportMessage();

        $request->merge(['ticket_reply' => 1]);

        $this->validation($request);

        $ticket->status = $this->userType != 'admin' ? 2 : 1;
        $ticket->last_reply = Carbon::now();
        $ticket->save();
        $message->support_ticket_id = $ticket->id;
        if ($this->userType == 'admin') {
            $message->admin_id = $user->id;
        }

        $message->message = $request->message;
        $message->save();

        if($request->hasFile('attachments')) {
            $uploadAttachments = $this->storeSupportAttachments($message->id);
            if($uploadAttachments != 200) return back()->withNotify($uploadAttachments);;
        }

        if ($this->userType == 'admin') {
            $createLog = false;
            $user = $ticket;
            if ($ticket->user_id != 0) {
                $createLog = true;
                $user = $ticket->user;
            }

            notify($user, 'ADMIN_SUPPORT_REPLY', [
                'ticket_id' => $ticket->ticket,
                'ticket_subject' => $ticket->subject,
                'reply' => $request->message,
                'link' => route('ticket.view', $ticket->ticket),
            ], null, $createLog);
        }


        $notify[] = ['success', 'Support ticket replied successfully!'];

        return back()->withNotify($notify);
    }

    protected function storeSupportAttachments($messageId)
    {
        $path = getFilePath('ticket');

        foreach ($this->files as  $file) {
            try {
                $attachment = new SupportAttachment();
                $attachment->support_message_id = $messageId;
                $attachment->attachment = fileUploader($file, $path);
                $attachment->save();
            } catch (\Exception $exp) {
                $notify[] = ['error', 'File could not upload'];
                return $notify;
            }
        }

        return 200;
    }

    protected function validation($request)
    {
        $maxSize = substr(ini_get('upload_max_filesize'), 0, -1);
        $maxSize = 1;
        $this->maxSize = $maxSize;
        $this->files = $request->file('attachments');

        $request->validate([
            'attachments' => [
                'max:4096',
                function ($attribute, $value, $fail){
                    foreach ($this->files as $file) {
                        $ext = strtolower($file->getClientOriginalExtension());
                        if (($file->getSize() / 1000000) > $this->maxSize) {
                            return $fail("Maximum $this->maxSize MB file size allowed!");
                        }
                        if (!in_array($ext, $this->allowedExtension)) {
                            return $fail("Only png, jpg, jpeg, pdf, doc, docx files are allowed");
                        }
                    }
                    if (count($this->files) > 5) {
                        return $fail("Maximum 5 files can be uploaded");
                    }
                },
            ],
            'name'      => 'required_without:ticket_reply',
            'email'     => 'required_without:ticket_reply|email|max:255',
            'subject'   => 'required_without:ticket_reply|max:255',
            'priority'  => 'required_without:ticket_reply|in:1,2,3',
            'message'   => 'required',
        ]);
    }

    public function closeTicket($id)
    {
        $user = $this->user;
        $ticket = SupportTicket::where('id', $id)->firstOrFail();
        if ($this->userType != 'admin') {
            $column = $this->column;
            if ($user->id != $ticket->$column) {
                abort(403);
            }
        }

        $ticket->status = 3;
        $ticket->save();
        $notify[] = ['success', 'Support ticket closed successfully!'];
        return back()->withNotify($notify);
    }

    public function ticketDownload($ticket_id)
    {
        $attachment = SupportAttachment::findOrFail(decrypt($ticket_id));
        $file = $attachment->attachment;
        $path = getFilePath('ticket');
        $full_path = $path . '/' . $file;
        $title = slug($attachment->supportMessage->ticket->subject);
        $ext = pathinfo($file, PATHINFO_EXTENSION);
        $mimetype = mime_content_type($full_path);
        header('Content-Disposition: attachment; filename="' . $title . '.' . $ext . '";');
        header("Content-Type: " . $mimetype);
        return readfile($full_path);
    }
}
