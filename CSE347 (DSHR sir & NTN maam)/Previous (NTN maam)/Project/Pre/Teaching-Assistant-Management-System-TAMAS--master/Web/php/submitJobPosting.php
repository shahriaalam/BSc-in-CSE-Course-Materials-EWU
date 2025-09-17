<?php
require_once 'login.php';
    
function connect($instructor_name,$course,$type,$hour,$description,$day,$startTime,$endTime){
    echo "Connection started\n";
    
    // the local authentication information
    $hn='localhost';
    $db='TAMAS_ECSE321';
    $un='TAMAS_DATA_ADMIN';
    $pw='TAMAS_ADMIN';
    
    $day=implode(" ",$day);
    
    $conn=new mysqli($hn,$un,$pw,$db);
    // if cannot connect to db, terminate
    if ($conn->connect_error) mysql_fatal_error("Cannot connect");
    
    $query = "INSERT INTO `JobPostData` (`INSTRUCTOR_NAME`, `COURSE`,`JOB_TYPE`, `HOUR`, `DESCRIPTION`, `DAYS_OF_WEEK`, `MON_START_TIME`, `MON_END_TIME`, `TUE_START_TIME`, `TUE_END_TIME`, `WED_START_TIME`, `WED_END_TIME`, `THU_START_TIME`, `THU_END_TIME`, `FRI_START_TIME`, `FRI_END_TIME`) VALUES ('$instructor_name','$course','$type','$hour','$description','$day','$startTime[0]','$endTime[0]','$startTime[1]','$endTime[1]','$startTime[2]','$endTime[2]','$startTime[3]','$endTime[3]','$startTime[4]','$endTime[4]');";
    
    $result=$conn->query($query);
    if (!$result) die($conn->error);
    else echo "Tramission success! <br>";
} 

    function mysql_fatal_error($msg)
    {
        $msg2 = mysql_error();
        echo <<< _END
We are sorry, but it was not possible to complete
the requested task. The error message we got was:
<p>$msg: $msg2</p>
Please click the back button on your browser
and try again. If you are still having problems,
please <a href="mailto:admin@server.com">email
our administrator</a>. Thank you.
_END;
    }
?>