<?php

$hn='Jamesgtang.com';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='ECSE_ADMIN';

//echo "Connection started<br>";

/*
// for local testings
$hn='localhost';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='ECSE_ADMIN';*/

// establish connection
$conn=new mysqli($hn,$un,$pw,$db);
$user_id=0;
$user_password=0;

if(isset($_GET['user_id'])) $user_id =($_GET['user_id']);
if(isset($_GET['user_password'])) $user_password=($_GET['user_password']);

if ($conn->connect_error) mysql_fatal_error();
$query="SELECT * FROM `StudentRecord`  WHERE STUDENT_ID = $user_id AND PASSWORD= '$user_password'";
$result=$conn->query($query);
$rows=$result->num_rows; 

if($rows>0){
	echo "Success";
}
else{
	echo "Wrong password";
}

function mysql_fatal_error()
{
	echo "Cannot connect";
}

?>