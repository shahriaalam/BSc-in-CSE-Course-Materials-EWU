<?php
include 'submitJobPosting.php';
include 'getJobPosting.php';
$hn='localhost';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='TAMAS_ADMIN';

$conn=new mysqli($hn,$un,$pw,$db);
// if cannot connect to db, terminate
if ($conn->connect_error) mysql_fatal_error("Cannot connect");
$instructor_name="Paul Python";
$course="ECSE321";
$type="Marker";
$hour=14;
$description="A fantastic course!";
$day="Monday Tuesday Wednesday";
$startTime="800 900 1000 1100 800";
$endTime="900 1000 1000 1200 1300";

 $query = "INSERT INTO `JobPostData` (`INSTRUCTOR_NAME`, `COURSE`,`JOB_TYPE`, `HOUR`, `DESCRIPTION`, `DAYS_OF_WEEK`, `MON_START_TIME`, `MON_END_TIME`, `TUE_START_TIME`, `TUE_END_TIME`, `WED_START_TIME`, `WED_END_TIME`, `THU_START_TIME`, `THU_END_TIME`, `FRI_START_TIME`, `FRI_END_TIME`) VALUES ('$instructor_name','$course','$type','$hour','$description','$day','$startTime[0]','$endTime[0]','$startTime[1]','$endTime[1]','$startTime[2]','$endTime[2]','$startTime[3]','$endTime[3]','$startTime[4]','$endTime[4]');";



//test of all get functions
$post_id=8;
$instructor_name="Proferssor Paul Python";
$course_name="ECSE321"; 
getJobPostingByID($post_id); 
getJobPostingByInstructorName($instructor_name);
getJobPostingByCouseName($course_name);

$post_id=1;
$instructor_name="Proferssor James Java";
$course_name="ECSE223"; 
getJobPostingByID($post_id); 
getJobPostingByInstructorName($instructor_name);
getJobPostingByCouseName($course_name);

$post_id=4;
$instructor_name="Proferssor Jay C";
$course_name="ECSE222"; 
getJobPostingByID($post_id); 
getJobPostingByInstructorName($instructor_name);
getJobPostingByCouseName($course_name);

$post_id=6;
$instructor_name="Proferssor Jean Android";
$course_name="ECSE200"; 
getJobPostingByID($post_id); 
getJobPostingByInstructorName($instructor_name);
getJobPostingByCouseName($course_name);
?>