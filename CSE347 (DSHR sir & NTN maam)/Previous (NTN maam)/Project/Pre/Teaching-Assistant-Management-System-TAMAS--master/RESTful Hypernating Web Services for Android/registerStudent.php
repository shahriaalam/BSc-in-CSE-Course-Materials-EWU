<?php

$hn='Jamesgtang.com';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='ECSE_ADMIN';

//echo "Connection started<br>";

$conn=new mysqli($hn,$un,$pw,$db);
$user_id=0;
$user_password=0;

if(isset($_POST['STUDENT_ID'])) $student_id =($_POST['STUDENT_ID']);
if(isset($_POST['FNAME'])) $fname =($_POST['FNAME']);
if(isset($_POST['LNAME'])) $lname =($_POST['LNAME']);
if(isset($_POST['STATUS'])) $status =($_POST['STATUS']);
if(isset($_POST['PASSWORD'])) $pwd =($_POST['PASSWORD']);
if(isset($_POST['EMAIL'])) $email =($_POST['EMAIL']);

if ($conn->connect_error) mysql_fatal_error();
$query="INSERT INTO `StudentRecord` (`STUDENT_ID`,`FNAME`,`LNAME`,`STATUS`,`EMAIL`,`PASSWORD`)  VALUES  ('$student_id','$fname','$lname','$status','$email','$pwd')";
$result=$conn->query($query);
if (!$result) echo "Failed";
else echo "Successful update!s";

function mysql_fatal_error()
{
	echo "Cannot connect";
}

?>