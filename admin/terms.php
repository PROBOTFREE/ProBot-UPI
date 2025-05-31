<?php
if( $panel["panel_status"] == "suspended" ): include 'app/views/frozen.twig';exit(); endif;
if( $panel["panel_status"] == "frozen" ): include 'app/views/frozen.twig';exit(); endif;
$title .= $languageArray["terms.title"];

if( $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
