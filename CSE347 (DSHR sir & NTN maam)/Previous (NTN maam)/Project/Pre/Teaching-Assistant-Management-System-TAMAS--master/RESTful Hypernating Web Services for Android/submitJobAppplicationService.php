<?php
//echo "Connection started<br>";
$hn='Jamesgtang.com';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='ECSE_ADMIN';

$conn=new mysqli($hn,$un,$pw,$db);

if(isset($_POST['APPLICANT_ID'])) $applicant_id =($_POST['APPLICANT_ID']);
if(isset($_POST['JOB_POSTING_ID'])) $jobpostingid =($_POST['JOB_POSTING_ID']);
if(isset($_POST['APPLICANT_FNAME'])) $applicant_fname =($_POST['APPLICANT_FNAME']);
if(isset($_POST['APPLICANT_LNAME'])) $applicant_lname =($_POST['APPLICANT_LNAME']);
if(isset($_POST['APPLICANT_EMAIL'])) $applicant_email =($_POST['APPLICANT_EMAIL']);
if(isset($_POST['STATUS'])) $status =($_POST['STATUS']);
if(isset($_POST['CV'])) $cv =($_POST['CV']);

if ($conn->connect_error) mysql_fatal_error();
$query="INSERT INTO `ApplicationData` (`APPLICANT_ID`, `JOB_POSTING_ID`, `APPLICANT_FNAME`, `APPLICANT_LNAME`, `APPLICANT_EMAIL`, `STATUS`, `CV`)  VALUES  ('$applicant_id','$jobpostingid','$applicant_fname','$applicant_lname','$applicant_email','$status','$cv')";
$result=$conn->query($query);
if (!$result) echo "Failed";
else echo "Successful update!s";

function mysql_fatal_error()
{
	echo "Cannot connect";
}


?>