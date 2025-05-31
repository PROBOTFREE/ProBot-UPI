<?php

namespace App\Notify;

use App\Models\AdminNotification;
use App\Models\NotificationLog;
use App\Models\NotificationTemplate;

class NotifyProcess{

    /*
    |--------------------------------------------------------------------------
    | Notification Process
    |--------------------------------------------------------------------------
    |
    | This is the core processor to send a notification to receiver. In this
    | class, find the notification template from database and build the final
    | message replacing the short codes and provide this to the method to send
    | the notification. Also notification log and error is creating here.
    |
    */


    /**
    * Template name, which contain the short codes and messages
    *
    * @var string
    */
	public $templateName;


    /**
    * Short Codes, which will be replaced
    *
    * @var array
    */
    public $shortCodes;


    /**
    * Instance of user, who will get the notification
    *
    * @var object
    */
    public $user;


    /**
    * System general setting's instances
    *
    * @var object
    */
	public $setting;


    /**
    * Status field name in database of notification template
    *
    * @var string
    */
	protected $statusField;


    /**
    * Global template field name in database of notification method
    *
    * @var string
    */
	protected $globalTemplate;


    /**
    * Message body field name in database of notification
    *
    * @var string
    */
	protected $body;


    /**
    * Notification template instance
    *
    * @var object
    */
	public $template;


    /**
    * Message, if the email template doesn't exists
    *
    * @var string|null
    */
	public $message;


    /**
    * Notification log will be created or not
    *
    * @var bool
    */
	public $createLog;


    /**
    * Method configuration field name in database
    *
    * @var string
    */
	public $notifyConfig;


    /**
    * Subject of notification
    *
    * @var string
    */
    public $subject;


    /**
    * Name of receiver
    *
    * @var string
    */
	public $receiverName;


    /**
    * The relational field name like user_id, agent_id
    *
    * @var string
    */
	public $userColumn;


    /**
    * Address of receiver, like email, mobile number etc
    *
    * @var string
    */
    protected $toAddress;

    /**
    * Final message of notification
    *
    * @var string
    */
    protected $finalMessage;

    /**
    * Get the final message after replacing the short code.
    *
    * Also custom message will be return from here if notification template doesn't exist.
    *
    * @return string
    */
	protected function getMessage(){
        $this->prevConfiguration();
        $this->setSetting();

		$body = $this->body;
		$user = $this->user;
		$globalTemplate = $this->globalTemplate;

        //finding the notification template
		$template = NotificationTemplate::where('act', $this->templateName)->where($this->statusField, 1)->first();
		$this->template = $template;

        //Getting the notification message from database if use and template exist
        //If not exist, get the message which have sent via method
		if ($user && $template) {
		    $message = $this->replaceShortCode($user->fullname,$user->username,$this->setting->$globalTemplate,$template->$body);
		    if (empty($message)) {
		        $message = $template->$body;
		    }
		}else{
			$message = $this->replaceShortCode($this->receiverName,$this->toAddress,$this->setting->$globalTemplate,$this->message);
		}

        //replace the all short cod of template
	    if ($this->shortCodes) {
		    foreach ($this->shortCodes as $code => $value) {
		        $message = str_replace('{{' . $code . '}}', $value, $message);
		    }
	    }

        //Check email enable
        if (!$this->template && $this->templateName) return false;

        //set subject to property
        $this->getSubject();


        $this->finalMessage = $message;

        //return the final message
	    return $message;
	}

    /**
    * Replace the short code of global template
    *
    * @return string
    */
	protected function replaceShortCode($name,$username,$template,$body){
		$message = str_replace("{{fullname}}", $name, $template);
	    $message = str_replace("{{username}}", is_array($username) ? @$this->user->username : $username, $message);
	    $message = str_replace("{{message}}", $body, $message);
	    return $message;
	}

    /**
    * Set the subject with replaced the short codes
    *
    * @return void
    */
	protected function getSubject(){
		if ($this->template) {
			$subject = $this->template->subj;
			if ($this->shortCodes) {
			    foreach ($this->shortCodes as $code => $value) {
			        $subject = str_replace('{{' . $code . '}}', $value, $subject);
			    }
		    }
			$this->subject = $subject;
		}
	}

    /**
    * Set the setting if not set yet
    *
    * @return void
    */
	protected function setSetting(){
		if (!$this->setting) {
			$this->setting = gs();
		}
	}

    /**
    * Create the notification log
    *
    * @return void
    */
	public function createErrorLog($message){
		$adminNotification = new AdminNotification();
        $adminNotification->user_id = 0;
        $adminNotification->title = $message;
        $adminNotification->click_url = '#';
        $adminNotification->save();
	}


    /**
    * Create the error log
    *
    * @return void
    */
	public function createLog($type){
        $userColumn = $this->userColumn;
		if ($this->user && $this->createLog) {
			$notifyConfig = $this->notifyConfig;
			$config = $this->setting->$notifyConfig;
			$notificationLog = new NotificationLog();
            if (@$this->user->id) {
                $notificationLog->$userColumn = $this->user->id;
            }
		    $notificationLog->notification_type = $type;
		    $notificationLog->sender = @$config->name;
		    $notificationLog->sent_from = $this->setting->email_from;
		    $notificationLog->sent_to = $this->toAddress;
		    $notificationLog->subject = $this->subject;
		    $notificationLog->message = $type == 'email' ? $this->finalMessage : strip_tags($this->finalMessage);
		    $notificationLog->save();
		}
	}

}
