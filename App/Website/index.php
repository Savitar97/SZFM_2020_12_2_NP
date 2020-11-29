<?php
require_once 'config/config.php';
require_once 'modells/Reservation.php';
require_once 'view/header.php';
require_once 'view/bodyhero.php';
require_once 'view/about.php';
require_once 'view/booktable.php';
require_once 'view/footer.php';
if ($_SERVER['REQUEST_METHOD'] == 'POST'){
    $obj=new Reservation($_POST['people'],$_POST['date'],$_POST['idopont'],$_POST['email'],$_POST['name'],$_POST['phone']);
    $obj->insertReservation();
    }
?>