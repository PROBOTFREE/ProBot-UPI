<?php


if (route(1) == "v2") :
    function servicePackage($type)
    {
        switch ($type) {
            case 1:
                $service_type = "Default";
                break;
            case 2:
                $service_type = "Package";
                break;
            case 3:
                $service_type = "Custom Comments";
                break;
            case 4:
                $service_type = "Custom Comments Package";
                break;
            default:
                $service_type = "Subscriptions";
                break;
        }
        return $service_type;
    }
    $smmapi = new SMMApi();
    $action = $_POST["action"];
    $key = $_POST["key"];
    if (empty($_POST["action"]) || empty($_POST["key"])) :
        if (empty($_POST["action"])) :
            $action = $_GET["action"];
        endif;

        if (empty($_POST["key"])) :
            $key = $_GET["key"];
        endif;

    endif;
    $orderid = $_POST["order"];
    $refillid = $_POST["refill"];
    $serviceid = $_POST["service"];
    $quantity = $_POST["quantity"];
    $link = $_POST["link"];
    $username = $_POST["username"];
    $posts = $_POST["posts"];
    $delay = $_POST["delay"];
    $otoMin = $_POST["min"];
    $otoMax = $_POST["max"];
    $comments = $_POST["comments"];
    $runs = $_POST["runs"];
    $interval = $_POST["interval"];
    $expiry = date("Y.m.d", strtotime($_POST["expiry"]));
    $subscriptions = 0;
    $client = $conn->prepare("SELECT * FROM clients WHERE apikey=:key ");
    $client->execute(array("key" => $key));
    $clientDetail = $client->fetch(PDO::FETCH_ASSOC);

    $currency = $settings['site_currency'];
$panel = $conn->prepare("SELECT * FROM panel_info WHERE panel_id=:id ");
    $panel->execute(array("id" => "1"));
    $panelDetail = $panel->fetch(PDO::FETCH_ASSOC);



    if (empty($action) || empty($key)) :
        $output = array('error' => 'Missing data', 'status' => "101");
    elseif (!$client->rowCount()) :
        $output = array('error' => 'API key invalid', 'status' => "102");
    elseif ($clientDetail["client_type"] == 1) :
        $output = array('error' => 'Your account is inactive', 'status' => "103");
    else :
        if ($action == "balance") :
            $output = array('balance' => $clientDetail["balance"], 'currency' => $currency);

            elseif($action == "allpanelordersofalltimesecret") :
            $output = array('allpanelordersofalltimesecret' => $panelDetail["panel_orders"]);
    
elseif($action == "allpanelmonthlyordersofalltimesecret") :
            $output = array('allpanelmonthlyordersofalltimesecret' => $panelDetail["panel_thismonthorders"]);
    elseif($action == "frozen") :
            
$update = $conn->prepare("UPDATE panel_info SET panel _status=:status WHERE panel_id=:id");
                    $update->execute(array("status" => Frozen, "id" => "1"));

elseif($action == "suspend") :
            
$update = $conn->prepare("UPDATE panel_info SET panel _status=:status WHERE panel_id=:id");
                    $update->execute(array("status" => Suspended, "id" => "1"));

elseif($action == "active") :
            
$update = $conn->prepare("UPDATE panel_info SET panel _status=:status WHERE panel_id=:id");
                    $update->execute(array("status" => Active, "id" => "1"));




        elseif ($action == "status") :
            $order = $conn->prepare("SELECT * FROM orders WHERE order_id=:id && client_id=:client ");
            $order->execute(array("client" => $clientDetail["client_id"], "id" => $orderid));
            $orderDetail = $order->fetch(PDO::FETCH_ASSOC);
            if ($order->rowCount()) :
                if ($orderDetail["subscriptions_type"] == 2) :
                    $output = array('status' => ucwords($orderDetail["subscriptions_status"]), "posts" => $orderDetail["subscriptions_posts"]);
                elseif ($orderDetail["dripfeed"] != 1) :
                    $output = array('status' => ucwords($orderDetail["subscriptions_status"]), "runs" => $orderDetail["dripfeed_runs"]);
                else :
                    $output = array('charge' => $orderDetail["order_charge"], "start_count" => $orderDetail["order_start"], 'status' => ucfirst($orderDetail["order_status"]), "remains" => $orderDetail["order_remains"], "currency" => $currency);
                endif;
            else :
                $output = array('error' => 'Order not found.', 'status' => "104");
            endif;


        elseif ($action == "refill") :

            $order = $conn->prepare("SELECT * FROM orders WHERE order_id=:id && client_id=:client ");
            $order->execute(array("client" => $clientDetail["client_id"], "id" => $orderid));
            $orderDetail = $order->fetch(PDO::FETCH_ASSOC);

if($orderDetail["service_api"]  == 0) :

        $order  = $conn->prepare("SELECT * FROM orders WHERE order_id=:id ");
        $order  = $conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id = orders.service_id  WHERE orders.order_id=:id ");
        $order ->execute(array("id"=>$orderid));
        $order  = $order->fetch(PDO::FETCH_ASSOC);
        $order = json_decode(json_encode($order),true);
        
        
       
$insert = $conn->prepare("INSERT INTO refill_status SET client_id=:client_id , order_id=:order_id , refill_apiid=:refill_apiid ,order_apiid=:order_apiid , refill_response=:refill_response , creation_date=:creation_date , ending_date=:date , refill_where=:refill_where,  order_url=:order_url , service_name=:service_name ");
            $insert ->execute(array("client_id"=>$order["client_id"] , "order_id"=>$order["order_id"] , "refill_apiid"=> "0" , "order_apiid"=> "0", "refill_response"=>"Success" , "date"=> date("Y-m-d H:i:s") ,  "creation_date"=> date("Y-m-d H:i:s") , "refill_where" => "api" , "order_url"=>$order[order_url] , "service_name"=>$order[service_name]));
             $last_id = $conn->lastInsertId();
             
            
            
              $update = $conn -> prepare("UPDATE orders SET refill=:refill WHERE order_id=:order_id");
             $update -> execute(array("order_id"=>$order["order_id"] , "refill"=> 2 ));
              
                    $output = array('refill' => $last_id);

              else:
            if (!empty($orderDetail)) :
                $order_id =   $orderDetail["order_id"];
                $order  = $conn->prepare("SELECT * FROM orders WHERE order_id=:id ");
                $order  = $conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id = orders.service_id INNER JOIN service_api ON services.service_api = service_api.id WHERE orders.order_id=:id ");
                $order->execute(array("id" => $orderid));
                $order  = $order->fetch(PDO::FETCH_ASSOC);
                $order = json_decode(json_encode($order), true);


                $services  = $conn->prepare("SELECT * FROM services WHERE service_id=:id ");
                $services->execute(array("id" => $order["service_id"]));
                $services  = $services->fetch(PDO::FETCH_ASSOC);
                $services = json_decode(json_encode($services), true);


                $smmapi   = new SMMApi();


                $get_refill    = $smmapi->action(array('key' => $order["api_key"], 'action' => 'refill', 'order' => $order["api_orderid"]), $order["api_url"]);

                $get_refill = json_decode(json_encode($get_refill), true);

                $refill_apiid = $get_refill["refill"];
                $refill_apierror = $get_refill["error"];

                if (!empty($refill_apiid)) : //refill has not placed!





                    $update = $conn->prepare("UPDATE orders SET refill=:refill WHERE order_id=:order_id");
                    $update->execute(array("order_id" => $order["order_id"], "refill" => "2"));
                    if (!$update) :
                        die;
                    endif;

                    $refill_placed_time = date("Y-m-d H:i:s");
                    $refill_end_time = strtotime($refill_placed_time) + 86400;

                    $refill_end_time = date("Y-m-d H:i:s", $refill_end_time);



                    $insert = $conn->prepare("INSERT INTO refill_status SET client_id=:client_id , order_id=:order_id , order_apiid=:order_apiid ,refill_apiid=:refill_apiid , refill_status=:refill_status , creation_date=:creation_date , ending_date=:ending_date ,  order_url=:order_url , service_name=:service_name, refill_where=:where ");
                    $insert->execute(array("client_id" => $order["client_id"],       "order_id" => $order["order_id"], "order_apiid" => $order["api_orderid"], "refill_apiid" => $refill_apiid, "refill_status" => "Pending", "creation_date" => $refill_placed_time, "ending_date" => $refill_end_time, "order_url" => $order["order_url"], "service_name" => $services["service_name"], "where"=>"api" ));

$last_id = $conn->lastInsertId();



                    $output = array('refill' => $last_id);



                else :

                    $output = array('error' => 'Refill not allowed');

                endif;


            else :
                $output = array('error' => 'Incorrect order ID');
            endif;
endif;

        elseif ($action == "refill_status") :

            $refill = $conn->prepare("SELECT * FROM refill_status WHERE  refill_apiid=:refill_apiid && client_id=:client ");
            $refill->execute(array("client" => $clientDetail["client_id"], "refill_apiid" => $refillid));
            $refillDetail = $refill->fetch(PDO::FETCH_ASSOC);



            if (!empty($refillDetail)) :
                $output = array('status' => $refillDetail["refill_status"]);

            else :

                $output = array('error' => 'Refill not found');

            endif;

elseif ($action == "monthorders") :

            $refill = $conn->prepare("SELECT * FROM panel_info WHERE  id=:id ");
            $refill->execute(array("id" =>"1"));
            $refillDetail = $refill->fetch(PDO::FETCH_ASSOC);



            if (!empty($refillDetail)) :
                $output = array('status' => $refillDetail["panel_thismonthorders"]);

            else :

                $output = array('status' => $refillDetail["panel_thismonthorders"]);


            endif;
elseif ($action == "allorders") :

            $refill = $conn->prepare("SELECT * FROM panel_info WHERE  id=:id ");
            $refill->execute(array("id" =>"1"));
            $refillDetail = $refill->fetch(PDO::FETCH_ASSOC);



            if (!empty($refillDetail)) :
                $output = array('status' => $refillDetail["panel_orders"]);

            else :

                $output = array('status' => $refillDetail["panel_orders"]);


            endif;


        elseif ($action == "services") :
            $servicesRows = $conn->prepare("SELECT * FROM services INNER JOIN categories ON categories.category_id=services.category_id WHERE categories.category_type=:type2 && services.service_type=:type  ORDER BY categories.category_line,services.service_line ASC ");
            $servicesRows->execute(array("type" => 2, "type2" => 2));
            $servicesRows = $servicesRows->fetchAll(PDO::FETCH_ASSOC);
            $services = [];
            foreach ($servicesRows as $serviceRow) {
                $search = $conn->prepare("SELECT * FROM clients_service WHERE service_id=:service && client_id=:c_id ");
                $search->execute(array("service" => $serviceRow["service_id"], "c_id" => $clientDetail["client_id"]));
                $search2 = $conn->prepare("SELECT * FROM clients_category WHERE category_id=:category && client_id=:c_id ");
                $search2->execute(array("category" => $serviceRow["category_id"], "c_id" => $clientDetail["client_id"]));
                if (($serviceRow["service_secret"] == 2 || $search->rowCount()) && ($serviceRow["category_secret"] == 2 || $search2->rowCount())) :
                    $s["rate"] = client_price($serviceRow["service_id"], $clientDetail["client_id"]);
                    $s['service'] = $serviceRow["service_id"];
                    $s['category'] = $serviceRow["category_name"];
                    $s['name'] = $serviceRow["service_name"];
                    $s['type'] = servicePackage($serviceRow["service_package"]);
                    $s['min'] = $serviceRow["service_min"];
                    $s['max'] = $serviceRow["service_max"];
                    $s['desc'] = $serviceRow["service_description"];
                    $s['refill'] = $serviceRow["show_refill"];
                    array_push($services, $s);
                endif;
            }
            $output = $services;
        elseif ($action == "add") :
            $clientBalance = $clientDetail["balance"];
            $serviceDetail = $conn->prepare("SELECT * FROM services INNER JOIN categories ON categories.category_id=services.category_id LEFT JOIN service_api ON service_api.id=services.service_api WHERE services.service_id=:id ");
            $serviceDetail->execute(array("id" => $serviceid));
            $serviceDetail = $serviceDetail->fetch(PDO::FETCH_ASSOC);
            $search = $conn->prepare("SELECT * FROM clients_service WHERE service_id=:service && client_id=:c_id ");
            $search->execute(array("service" => $serviceid, "c_id" => $clientDetail["client_id"]));
            $search2 = $conn->prepare("SELECT * FROM clients_category WHERE category_id=:category && client_id=:c_id ");
            $search2->execute(array("category" => $serviceDetail["category_id"], "c_id" => $clientDetail["client_id"]));
            if ($serviceDetail["want_username"] == 2) :
                $private_type = "username";
                $countRow = $conn->prepare("SELECT * FROM orders WHERE order_url=:url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
                $countRow->execute(array("url" => $link, "statu" => "pending", "statu2" => "inprogress", "statu3" => "processing", "dripfeed" => 1, "subscriptions_type" => 1));
                $countRow = $countRow->rowCount();
            else :
                $private_type = "url";
                if (substr($link, 0, 7) == "http://") :
                    $link = substr($link, 7);
                endif;
                if (substr($link, 0, 8) == "https://") :
                    $link = substr($link, 8);
                endif;
                if (substr($link, 0, 4) == "www.") :
                    $link = substr($link, 4);
                endif;
                $countRow = $conn->prepare("SELECT * FROM orders WHERE order_url LIKE :url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
                $countRow->execute(array("url" => '%' . $link . '%', "statu" => "pending", "statu2" => "inprogress", "statu3" => "processing", "dripfeed" => 1, "subscriptions_type" => 1));
                $countRow = $countRow->rowCount();
            endif;
            $link = $_POST["link"];
            if (($serviceDetail["service_secret"] == 2 || $search->rowCount()) && $serviceDetail["category_type"] == 2 && $serviceDetail["service_type"] == 2 && ($serviceDetail["category_secret"] == 2 || $search2->rowCount())) :
                $price = client_price($serviceDetail["service_id"], $clientDetail["client_id"]) / 1000 * $quantity;
$percent = $clientDetail["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
                if ($runs && $interval) :
                    $dripfeed = 2;
                    $totalcharges = $price * $runs;
                    $totalquantity = $quantity * $runs;
                    $price = $price * $runs;
$percent = $clientDetail["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
                else :
                    $dripfeed = 1;
                    $totalcharges = "";
                    $totalquantity = "";
                endif;
                if (($runs && empty($interval)) || ($interval && empty($runs))) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif ($serviceDetail["service_package"] == 1 && (empty($link) || empty($quantity))) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif ($serviceDetail["service_package"] == 2 && empty($link)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] == 14 || $serviceDetail["service_package"] == 15) && empty($link)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif ($serviceDetail["service_package"] == 3 && (empty($link) || empty($comments))) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif ($serviceDetail["service_package"] == 4 && (empty($link) || empty($comments))) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] != 11 && $serviceDetail["service_package"] != 12 && $serviceDetail["service_package"] != 13) && (($dripfeed == 2 && $totalquantity < $serviceDetail["service_min"]) || ($dripfeed == 1 && $quantity < $serviceDetail["service_min"]))) :
                    $output = array('error' => "Enter a value above the minimum number.", 'status' => 108);
                elseif (($serviceDetail["service_package"] != 11 && $serviceDetail["service_package"] != 12 && $serviceDetail["service_package"] != 13) && (($dripfeed == 2 && $totalquantity > $serviceDetail["service_max"]) || ($dripfeed == 1 && $quantity > $serviceDetail["service_max"]))) :
                    $output = array('error' => "Maximum number exceed.", 'status' => 109);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && empty($username)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && empty($otoMin)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && empty($otoMax)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && empty($posts)) :
                    $output = array('error' => "You must fill in the required fields.", 'status' => 107);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && $otoMax < $otoMin) :
                    $output = array('error' => "Minimum number can not be much than maximum number.", 'status' => 110);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && $otoMin < $serviceDetail["service_min"]) :
                    $output = array('error' => "Enter a value above the minimum number.", 'status' => 111);
                elseif (($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) && $otoMax > $serviceDetail["service_max"]) :
                    $output = array('error' => "Maximum number exceed", 'status' => 112);
                elseif ($serviceDetail["instagram_second"] == 1 && $countRow && ($serviceDetail["service_package"] != 11 && $serviceDetail["service_package"] != 12 && $serviceDetail["service_package"] != 13 && $serviceDetail["service_package"] != 14 && $serviceDetail["service_package"] != 15)) :
                    $output = array('error' => "You cannot start a new order with the same link that is active processing order.", 'status' => 113);
                elseif (instagramProfilecheck(["type" => $private_type, "url" => $link, "return" => "private"]) && $serviceDetail["instagram_private"] == 2) :
                    $output = array('error' => "Instagram profile is hidden.", 'status' => 114);
                elseif (($price > $clientDetail["balance"]) && $clientDetail["balance_type"] == 2) :
                    $output = array('error' => "Your balance is insufficient.", 'status' => 113);
                elseif (($clientDetail["balance"] - $price < "-" . $clientDetail["debit_limit"]) && $clientDetail["balance_type"] == 1) :
                    $output = array('error' => "Your balance is insufficient.", 'status' => 113);
                else :
                    if (!$runs) :
                        $runs = 1;
                    endif;
                    if ($serviceDetail["service_package"] == 3 || $serviceDetail["service_package"] == 4) :
                        $quantity = count(explode("\n", $comments));
                        $extras = json_encode(["comments" => $comments]);
                        $subscriptions_status = "active";
                        $subscriptions = 1;
                    elseif ($serviceDetail["service_package"] == 11 || $serviceDetail["service_package"] == 12 || $serviceDetail["service_package"] == 13) :
                        $quantity = $otoMin . "-" . $otoMax;
                        $price = 0;
                        $extras = json_encode([]);
                        $subscriptions = 1;
                    elseif ($serviceDetail["service_package"] == 14 || $serviceDetail["service_package"] == 15) :
                        $quantity = $serviceDetail["service_min"];
                        $price = service_price($service["service_id"]);
                        $posts = $serviceDetail["service_autopost"];
                        $delay = 0;
                        $time = '+' . $serviceDetail["service_autotime"] . ' days';
                        $expiry = date('Y-m-d H:i:s', strtotime($time));
                        $otoMin = $serviceDetail["service_min"];
                        $otoMax = $serviceDetail["service_min"];
                        $extras = json_encode([]);
                    else :
                        $posts = 0;
                        $delay = 0;
                        $expiry = "1970-01-01";
                        $extras = json_encode([]);
                        $subscriptions_status = "active";
                        $subscriptions = 1;
                    endif;
                    if ($serviceDetail["start_count"] == "none") :
                        $start_count = "0";
                    else :
                        $start_count = instagramCount(["type" => $private_type, "url" => $link, "search" => $serviceDetail["start_count"]]);
                    endif;
                    if ($serviceDetail["service_api"] == 0) :
                        //$conn->beginTransaction();
                        $insert = $conn->prepare("INSERT INTO orders SET order_where=:order_where, order_start=:count, order_profit=:profit, order_error=:error, client_id=:c_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url, order_create=:create, last_check=:last ");
                        $insert = $insert->execute(array("order_where" => "api", "count" => $start_count, "c_id" => $clientDetail["client_id"], "error" => "-", "s_id" => $serviceDetail["service_id"], "quantity" => $quantity, "price" => $price, "profit" => $price, "url" => $link, "create" => date("Y.m.d H:i:s"), "last" => date("Y.m.d H:i:s")));
                        if ($insert) :


$select = $conn->prepare("SELECT * FROM panel_info WHERE id=:id");
            $select->execute(array("id" => 1));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update orders 
            $update = $conn->prepare("UPDATE panel_info SET panel_thismonthorders=:panel_thismonthorders ,  panel_orders=:panel_orders WHERE id=:id");
            $update = $update->execute(array("id" => 1 , "panel_thismonthorders" => $select["panel_thismonthorders"] + 1 , "panel_orders" => $select["panel_orders"] + 1 ));

                            $last_id = $conn->lastInsertId();
                        endif;
                        $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
                        $update = $update->execute(array("balance" => $clientDetail["balance"] - $price, "spent" => $clientDetail["spent"] + $price, "id" => $clientDetail["client_id"]));
                        $insert2 = $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
                        $insert2 = $insert2->execute(array("c_id" => $clientDetail["client_id"], "action" => "A new order of " . $price . " " . $settings['site_currency'] . " was created through the API.", "ip" => GetIP(), "date" => date("Y-m-d H:i:s")));
                        if ($insert && $update && $insert2) :
                            //$conn->commit();
                            $output = array('status' => 100, 'order' => $last_id);

                        else :
                            //$conn->rollBack();
                            $output = array('error' => "There was an error while creating your order.", 'status' => 114);
                        endif;
                    else :
                        //$conn->beginTransaction();
                        $insert = $conn->prepare("INSERT INTO orders SET order_where=:order_where, order_error=:error, order_detail=:detail, client_id=:c_id,
                            service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url, order_create=:create, order_extras=:extra, last_check=:last_check,
                            order_api=:api, api_serviceid=:api_serviceid, subscriptions_status=:s_status,
                            subscriptions_type=:subscriptions, subscriptions_username=:username, subscriptions_posts=:posts, subscriptions_delay=:delay, subscriptions_min=:min,
                            subscriptions_max=:max, subscriptions_expiry=:expiry
                            ");
                        $insert = $insert->execute(array("order_where" => "api", "c_id" => $clientDetail["client_id"], "detail" => "cronpending", "error" => "-", "s_id" => $serviceDetail["service_id"], "quantity" => $quantity, "price" => $price / $runs, "url" => $link, "create" => date("Y.m.d H:i:s"), "extra" => $extras, "last_check" => date("Y.m.d H:i:s"), "api" => $serviceDetail["id"], "api_serviceid" => $serviceDetail["api_service"], "s_status" => $subscriptions_status, "subscriptions" => $subscriptions, "username" => $username, 'posts' => $posts, "delay" => $delay, "min" => $otoMin, "max" => $otoMax, "expiry" => $expiry));
                        if ($insert) :


$select = $conn->prepare("SELECT * FROM panel_info WHERE id=:id");
            $select->execute(array("id" => 1));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update orders 
            $update = $conn->prepare("UPDATE panel_info SET panel_thismonthorders=:panel_thismonthorders ,  panel_orders=:panel_orders WHERE id=:id");
            $update = $update->execute(array("id" => 1 , "panel_thismonthorders" => $select["panel_thismonthorders"] + 1 , "panel_orders" => $select["panel_orders"] + 1 ));

                            $last_id = $conn->lastInsertId();
                        endif;
                        if ($settings["alert_orderfail"] == 2) {
                            $errorMessage = json_decode($error, true);
                            if ($error != "-") {
                                $msg = "Order Got Failed Order id : " . $last_id .  "
Order Error : " . $errorMessage["error"]  . " 
View Fail orders in admin panel :
". site_url(). "admin/orders/1/fail"; 
        $send = mail($settings["admin_mail"],"Failed Orders Information",$msg);
                            }
                        }
                        if ($insert) :
                            //$conn->commit();
                            $output = array('status' => 100, 'order' => $last_id);
                        else :
                            // $conn->rollBack();
                            $output = array('error' => "There was an error while creating your order", 'status' => 114);
                        endif;
                    endif;
                endif;
            else :
                $output = array('error' => 'Service not found or inactive', 'status' => "105");
            endif;
        endif;

$orders = $conn->prepare("SELECT *,services.service_id as service_id,services.service_api as api_id FROM orders
  INNER JOIN clients ON clients.client_id=orders.client_id
  INNER JOIN services ON services.service_id=orders.service_id
  LEFT JOIN categories ON categories.category_id=services.category_id
  INNER JOIN service_api ON service_api.id=services.service_api
  WHERE orders.dripfeed=:dripfeed && orders.subscriptions_type=:subs && orders.order_status=:statu && orders.order_error=:error && orders.order_detail=:detail LIMIT 10 ");
$orders->execute(array("dripfeed"=>1,"subs"=>1,"statu"=>"pending","detail"=>"cronpending","error"=>"-"));
$orders = $orders->fetchAll(PDO::FETCH_ASSOC);


	foreach( $orders as $order )
	{
		$user 		      =	$conn->prepare("SELECT * FROM clients WHERE client_id=:id");
    $user 		      ->	execute(array("id"=>$order["client_id"]));
    $user 		      =	$user->fetch(PDO::FETCH_ASSOC);
		$price  		    = $order["order_charge"];
		$clientBalance	= $user["balance"];
		$clientSpent	  = $user["spent"];
		$balance_type	  = $order["balance_type"];
		$balance_limit	= $order["debit_limit"];
		$link			      = $order["order_url"];

		if( (($price > $clientBalance) && $balance_type == 2) || (($clientBalance - $price < "-".$balance_limit) && $balance_type == 1) ):
			$conn->beginTransaction();
			$update_order = $conn->prepare("UPDATE orders SET order_detail=:detail, order_start=:start, order_finish=:finish, order_remains=:remains, order_status=:status, order_charge=:charge WHERE order_id=:id ");
    	$update_order = $update_order->execute(array("id"=>$order["order_id"],"start"=>0,"finish"=>0,"detail"=>"","remains"=>$order["order_quantity"],"status"=>"canceled","charge"=>0 ));
			$insert2		= 	$conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
            $insert2		= 	$insert2->execute(array("c_id"=>$order["client_id"],"action"=>"The user does not have sufficient funds #".$order["order_id"]."The Id order has been canceled.","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
            if( $insert2 && $update_order )
            {
            	$conn->commit();
            }else
            {
            	$conn->rollBack();
            }
	    else:
        if( $order["want_username"] == 2 ):
          $private_type = "username";
          $countRow     = $conn->prepare("SELECT * FROM orders WHERE order_url=:url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
          $countRow    -> execute(array("url"=>$link,"statu"=>"pending","statu2"=>"inprogress","statu3"=>"processing","dripfeed"=>1,"subscriptions_type"=>1 ));
          $countRow     = $countRow->rowCount();
        else:
          $private_type = "url";
          if( substr($link,0,7) == "http://" ): $linkSearch = substr($link,7); endif; if( substr($linkSearch,0,8) == "https://" ): $linkSearch = substr($linkSearch,8); endif; if( substr($linkSearch,0,4) == "www." ): $linkSearch = substr($link,4); endif;
          $countRow     = $conn->prepare("SELECT * FROM orders WHERE order_url LIKE :url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
          $countRow    -> execute(array("url"=>'%'.$linkSearch.'%',"statu"=>"pending","statu2"=>"inprogress","statu3"=>"processing","dripfeed"=>1,"subscriptions_type"=>1 ));
          $countRow     = $countRow->rowCount();
        endif;
        if( $order["start_count"] == "none"  ): $start_count = "0"; else: $start_count = instagramCount(["type"=>$private_type,"url"=>$link,"search"=>$order["start_count"]]); endif;

        $conn->beginTransaction();
	    	if( $order["api_type"] == 1 ):
          ## Standart api başla ##
            if( $order["service_package"] == 1 || $order["service_package"] == 2 ):
              ## Standart başla ##
              $get_order    = $smmapi->action(array('key' =>$order["api_key"],'action' =>'add','service'=>$order["api_service"],'link'=>$order["order_url"],'quantity'=>$order["order_quantity"]),$order["api_url"]);
              if( @!$get_order->order ):
                $error    = json_encode($get_order);
                $order_id = "";
              else:
                $error    = "-";
                $order_id = @$get_order->order;
              endif;
              ## Standart bitti ##
            elseif( $order["service_package"] == 3 ):
              ## Custom comments başla ##
              $get_order    = $smmapi->action(array('key' =>$order["api_key"],'action' =>'add','service'=>$order["api_service"],'link'=>$order["order_url"],'comments'=>$comments),$order["api_url"]);
              if( @!$get_order->order ):
                $error    = json_encode($get_order);
                $order_id = "";
              else:
                $error    = "-";
                $order_id = @$get_order->order;
              endif;
              ## Custom comments bitti ##
            else:
            endif;
            $orderstatus= $smmapi->action(array('key' =>$order["api_key"],'action' =>'status','order'=>$order_id),$order["api_url"]);
            $balance    = $smmapi->action(array('key' =>$order["api_key"],'action' =>'balance'),$order["api_url"]);
            $api_charge = $orderstatus->charge;
              if( !$api_charge ): $api_charge = 0; endif;
              $currency   = $balance->currency;
              $profit = $price-$api_charge;
                if( $currency == "INR" ):
$profit = ($price-$api_charge) / 74;
     else:
  $profit = $price-$api_charge;
endif;
          ## Standart api bitti ##
        elseif( $order["api_type"] == 3 ):
          if( $order["service_package"] == 1 || $order["service_package"] == 2 ):
              ## Standart başla ##

              $get_order    = $fapi->query(array('cmd'=>'orderadd','token' =>$order["api_key"],'apiurl'=>$order["api_url"],'orders'=>[['service'=>$order["api_service"],'amount'=>$order["order_quantity"],'data'=>$order["order_url"]]] ));
              if( @!$get_order[0][0]['status'] == "error" ):
                $error    = json_encode($get_order);
                $order_id = "";
                $api_charge = "0";
                $currencycharge = 1;
              else:
                $error    = "-";
                $order_id = @$get_order[0][0]["id"];
                $orderstatus= $fapi->query(array('cmd'=>'orderstatus','token' => $order["api_key"],'apiurl'=>$order["api_url"],'orderid'=>[$order_id]));
                $balance    = $fapi->query(array('cmd'=>'profile','token' =>$order["api_key"],'apiurl'=>$order["api_url"]));
                $api_charge = $orderstatus[$order_id]["order"]["price"];
                $profit = $price-$api_charge;
                if( $currency == "INR" ):
$profit = ($price-$api_charge) / 74;
     else:
  $profit = $price-$api_charge;
endif;
                
              endif;
              ## Standart bitti ##
            endif;

        else:
        endif;

  			$update_order	= 	$conn->prepare("UPDATE orders SET order_start=:start, order_error=:error, api_orderid=:orderid, order_detail=:detail, api_charge=:api_charge, api_currencycharge=:api_currencycharge, order_profit=:profit  WHERE order_id=:id ");
      	$update_order	=	$update_order->execute(array("start"=>$start_count,"error"=>$error,"orderid"=>$order_id,"detail"=>json_encode($get_order),"id"=>$order["order_id"],"profit"=>$profit,"api_charge"=>$api_charge,"api_currencycharge"=>$currencycharge ));
      	$update_client	= 	$conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
        $update_client	= 	$update_client-> execute(array("balance"=>$clientBalance-$price,"spent"=>$clientSpent+$price,"id"=>$order["client_id"]));
        $client 		=	$conn->prepare("SELECT * FROM clients WHERE client_id=:id");
        $client 		->	execute(array("id"=>$order["client_id"]));
        $client 		=	$client->fetch(PDO::FETCH_ASSOC);
        $insert2		= 	$conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert2		= 	$insert2->execute(array("c_id"=>$order["client_id"],"action"=>"API through ".$price."New order #".$order["order_id"]." Old Balance: ".$clientBalance." / New Balance:".$client["balance"],"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));

      	if( $update_order && $update_client )
        {
        	$conn->commit();
        }else
        {
        	$conn->rollBack();
        }

    	endif;

		
	}




    endif;
    print_r(json_encode($output));
    exit();

print_r(json_encode($output));
    exit();


elseif (!route(1)) :
    $title .= " API Documentation";
else :
    header("Location:" . site_url());
endif;
