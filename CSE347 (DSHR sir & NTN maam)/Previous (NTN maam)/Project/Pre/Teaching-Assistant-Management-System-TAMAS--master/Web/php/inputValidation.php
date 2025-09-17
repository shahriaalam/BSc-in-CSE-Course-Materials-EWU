<?php
// Todo: clearn sql insertion statement
// validate input with javascript
require_once "php/persistenceLayer.php";
include 'php/submitJobPosting.php';
include 'php/getJobPosting.php';

$LPL=new LocalPersistenceLayer();
$daysofWeek="";
$startTime="800 800 800 800 800";
$endTime="800 800 800 800 800";
$type="";
// instructor name will be added dynamically in later release

// course name here will be dynamically generated in later release
if(isset($_POST['submit'])){
    echo "done!";
$instructor_name="Proferssor Paul Python";
// load the course selection
if(isset($_POST['course'])) $course=$_POST['course'];
else $course=" ";

if(isset($_POST['job_type'])) $type=$_POST['job_type'];
// load the hour field
if(isset($_POST['hour'])) $hour=$_POST['hour'];

// get the description of the courses
if(isset($_POST['description'])) $description=$_POST['description'];

// load the checkboxes of days of week
// into $ daysofWeek as an array 
if(isset($_POST['daysofWeek'])){
$daysofWeek=$_POST['daysofWeek'];
/*
// test the input from daysofWeek below
// print the choices below
foreach ($daysofWeek as $day){
    echo $day;
    echo "<br>";
}*/
}
// the startTime into 
//$startTime as an array
if(isset($_POST['startTime'])){
$startTime=$_POST['startTime'];
}
    
if(isset($_POST['endTime'])){
$endTime=$_POST['endTime'];

}
connect($instructor_name,$course,$type,$hour,$description,$daysofWeek,$startTime,$endTime);

    

}

// input clean up functions, prevents html injection to DB
function sanitizeString($var)
{
$var = stripslashes($var);
$var = strip_tags($var);
$var = htmlentities($var);
return $var;
}
function sanitizeMySQL($connection, $var)
{
$var = $connection->real_escape_string($var);
$var = sanitizeString($var);
return $var;
}
?>


