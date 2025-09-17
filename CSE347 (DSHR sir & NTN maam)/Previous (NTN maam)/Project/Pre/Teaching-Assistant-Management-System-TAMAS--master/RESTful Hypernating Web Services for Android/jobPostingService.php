<?php

$hn='Jamesgtang.com';
$db='TAMAS_ECSE321';
$un='TAMAS_DATA_ADMIN';
$pw='ECSE_ADMIN';

//echo "Connection started<br>";

//open connection to mysql db
$conn=new mysqli($hn,$un,$pw,$db);
if ($conn->connect_error) mysql_fatal_error();

//fetch table rows from mysql db
$sql = "SELECT * FROM JobPostData";
$result = mysqli_query($conn, $sql) or mysql_fatal_error();

//create an array
$emparray = array();
while($row =mysqli_fetch_assoc($result))
{
	$emparray[] = $row;
}
// echo the JSON object

echo json_encode($emparray);


//close the db connection
mysqli_close($connection);

function mysql_fatal_error()
{
	echo "Cannot connect";
}
?>