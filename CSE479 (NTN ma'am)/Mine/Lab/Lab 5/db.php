<?php
$server ="localhost";
$user= "root";
$pass="";
$dbname="Blood_db";

$conn= new mysqli($server, $user, $pass, $dbname);
if(!$conn){
    echo "Error: {$conn->connect_error}".$conn;
}
?>