<?
define('__ROOT__', dirname(dirname(__FILE__))); 
require_once(__ROOT__.'/modells/Reservation.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST'){
    $obj=new Reservation($_POST['people'],$_POST['date'],$_POST['idopont'],$_POST['email'],$_POST['name'],$_POST['phone']);
    $obj->insertReservation();
    }