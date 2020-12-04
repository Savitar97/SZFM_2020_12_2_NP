<?php
require_once(__ROOT__.'/database/database.php'); 
class Reservation{
    private $amount_of_people;
    private $datetime;
    private $email;
    private $name;
    private $phone_number;

    public function __construct( $amount_of_people=null,$date=null,$time=null,$email=null, $name=null,$phone_number=null)
        {
            $this->amount_of_people = $amount_of_people;
            $this->datetime=str_replace('.','-',$date).' '.$time;
            $this->email=$email;
            $this->name = $name;
            $this->phone_number=$phone_number;
        }

    public function getAmountOfPeople()
        {
            return $this->amount_of_people;
        }

    public function setAmountOfPeople($amount_of_people)
        {
            $this->id = $amount_of_people;
        }

    public function getDatetime()
        {
            return $this->datetime;
        }

    public function SetDateTime($date,$time)
        {
            $this->datetime=str_replace('.','-',$date).' '.$time;
        }
    public function getName()
        {
            return $this->name;
        }

    public function setName($name)
        {
            $this->name = $name;
        }

    public function getPhoneNumber()
        {
            return $this->phone_number;
        }

    public function setPhoneNumber($phone_number)
        {
            $this->phone_number=$phone_number;
        }
    
    public function toString()
        {
            return "".$this->datetime." ".$this->name;
        }

    public function insertReservation()
        {
            $sql="INSERT INTO ReservationDataModel(amount_of_people,date,name,email,phone_number) VALUES (?, ?, ?, ?, ?)";
            $db=Database::getInstance()->getConnection();
            $sth = $db->prepare($sql);
            $sth->execute([$this->amount_of_people,$this->datetime,$this->name,$this->email,$this->phone_number]);
        }
}