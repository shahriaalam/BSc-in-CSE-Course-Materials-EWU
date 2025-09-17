<?php
require_once 'login.php';
    
function getJobPostingByID($post_id){
    echo "Connection started<br>";
    
    // the authentication information
    $hn='localhost';
    $db='TAMAS_ECSE321';
    $un='TAMAS_DATA_ADMIN';
    $pw='TAMAS_ADMIN';
    $conn = new mysqli($hn, $un, $pw, $db);
    if ($conn->connect_error)  mysql_get_fatal_error("Cannot connect");
    
    $query="SELECT * FROM `JobPostData` WHERE POST_ID='$post_id'";
    $result=$conn->query($query);
    if (!$result) die($conn->error);
    
    $rows = $result->num_rows;
    
    for ($j = 0 ; $j < $rows ; ++$j)
    {
    $result->data_seek($j);
    echo 'INSTRUCTOR_NAME: ' . $result->fetch_assoc()['INSTRUCTOR_NAME'] . '<br>';
    $result->data_seek($j);
    echo 'COURSE: ' . $result->fetch_assoc()['COURSE'] . '<br>';
    $result->data_seek($j);
    echo 'Type_of_Job: ' . $result->fetch_assoc()['JOB_TYPE'] . '<br>';
    $result->data_seek($j);
    echo 'HOUR: ' . $result->fetch_assoc()['HOUR'] . '<br>';
    $result->data_seek($j);
    echo 'DESCRIPTION: ' . $result->fetch_assoc()['DESCRIPTION'] . '<br>';
    $result->data_seek($j);
    echo 'DAYS_OF_WEEK: ' . $result->fetch_assoc()['DAYS_OF_WEEK'] . '<br>';
    $result->data_seek($j);
    }
}

function getJobPostingByInstructorName($instructor_name){
    echo "Connection started<br>";
    
    // the authentication information
    $hn='localhost';
    $db='TAMAS_ECSE321';
    $un='TAMAS_DATA_ADMIN';
    $pw='TAMAS_ADMIN';
    $conn = new mysqli($hn, $un, $pw, $db);
    if ($conn->connect_error)  mysql_get_fatal_error("Cannot connect");
    
    $query="SELECT * FROM `JobPostData` WHERE INSTRUCTOR_NAME='$instructor_name'";
    $result=$conn->query($query);
    if (!$result) die($conn->error);
    
    $rows = $result->num_rows;
    
    for ($j = 0 ; $j < $rows ; ++$j)
    {
    $result->data_seek($j);
    echo 'INSTRUCTOR_NAME: ' . $result->fetch_assoc()['INSTRUCTOR_NAME'] . '<br>';
    $result->data_seek($j);
    echo 'COURSE: ' . $result->fetch_assoc()['COURSE'] . '<br>';
    $result->data_seek($j);
    echo 'Type_of_Job: ' . $result->fetch_assoc()['JOB_TYPE'] . '<br>';
    $result->data_seek($j);
    echo 'HOUR: ' . $result->fetch_assoc()['HOUR'] . '<br>';
    $result->data_seek($j);
    echo 'DESCRIPTION: ' . $result->fetch_assoc()['DESCRIPTION'] . '<br>';
    $result->data_seek($j);
    echo 'DAYS_OF_WEEK: ' . $result->fetch_assoc()['DAYS_OF_WEEK'] . '<br>';
    $result->data_seek($j);
    }
}

function getJobPostingByCouseName($course_name){
    echo "Connection started<br>";
    
    // the authentication information
    $hn='localhost';
    $db='TAMAS_ECSE321';
    $un='TAMAS_DATA_ADMIN';
    $pw='TAMAS_ADMIN';
    $conn = new mysqli($hn, $un, $pw, $db);
    if ($conn->connect_error)  mysql_get_fatal_error("Cannot connect");
    
    $query="SELECT * FROM `JobPostData` WHERE COURSE='$course_name'";
    $result=$conn->query($query);
    if (!$result) die($conn->error);
    
    $rows = $result->num_rows;
    
    for ($j = 0 ; $j < $rows ; ++$j)
    {
    $result->data_seek($j);
    echo 'INSTRUCTOR_NAME: ' . $result->fetch_assoc()['INSTRUCTOR_NAME'] . '<br>';
    $result->data_seek($j);
    echo 'COURSE: ' . $result->fetch_assoc()['COURSE'] . '<br>';
    $result->data_seek($j);
    echo 'Type_of_Job: ' . $result->fetch_assoc()['JOB_TYPE'] . '<br>';
    $result->data_seek($j);
    echo 'HOUR: ' . $result->fetch_assoc()['HOUR'] . '<br>';
    $result->data_seek($j);
    echo 'DESCRIPTION: ' . $result->fetch_assoc()['DESCRIPTION'] . '<br>';
    $result->data_seek($j);
    echo 'DAYS_OF_WEEK: ' . $result->fetch_assoc()['DAYS_OF_WEEK'] . '<br>';
    $result->data_seek($j);
    }
}
        
        
    function mysql_get_fatal_error($msg)
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