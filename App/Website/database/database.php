<?php

class Database {
    private $_connection;
	private static $_instance;

    private $_host = "localhost";
	private $_username = "root";
	private $_password = "";
    private $_database = "etterem";
    
    public static function getInstance() {
		if(!self::$_instance) {
			self::$_instance = new self();
		}
		return self::$_instance;
    }
    
    private function __construct() {
        try{
            $this->_connection = new PDO("mysql:host=".$this->_host.";dbname=".$this->_database.";charset=utf8mb4",$this->_username,$this->_password);
            $this->_connection->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE,PDO::FETCH_ASSOC);
        }catch(PDOException $e){
            echo "Connection failed: ".$e->getMessage();
        }
    }

    private function __clone() { }

    public function getConnection() {
		return $this->_connection;
	}
}