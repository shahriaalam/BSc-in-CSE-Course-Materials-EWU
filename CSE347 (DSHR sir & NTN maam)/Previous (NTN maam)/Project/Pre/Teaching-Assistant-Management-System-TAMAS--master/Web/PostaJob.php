<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Brower UI for Job Post</title>
<link href="css/main.css" rel="stylesheet" type="text/css"> 
<?php   
    require_once "php/inputValidation.php";
?>    
<body>
<div id="main_div">
	<h1> TAMAS</h1><h3> Post A Job</h3>
	
<form method="post" action="">
<div id="courseForm">
	<p> Course:</p>
    <!– course name here will be dynamically generated in later release ->
	<select name="course">
        <option value="ECSE222">ECSE 222</option>
        <option value="ECSE223">ECSE 223</option>
        <option value="ECSE321">ECSE 321</option>
    </select>
	</div>
	<hr><br>
    <div id="hourForm">
	<p> Job Type</p>
    <select name="job_type"><option value="Marker">Marker</option>
    <option value="Grader">Grader</option></select>
        <hr><br>
</div>
<div id="hourForm">
	<p> Hours: </p>
	<input type="text" name="hour">
</div>
	<hr><br>
<div id="descriptionForm">
	<p> Description: </p>
	<textarea id="descriptionTextArea" name="description"
    wrap="soft">
	</textarea>
</div>
<hr><br>
<div id="scheduleForm">
	<p class="inline_p"> Schedule</p>
    <br>
    Monday:
    <select name="endTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
     <select name="startTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select> 
    <input type="checkbox"
    name="daysofWeek[]" value="Monday">
    <br>
    Tuesday:
    
    <select name="endTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
       <select name="startTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
    <input type="checkbox"
    name="daysofWeek[]" value="Tuesday"><br>
    Wednesday:
    
    <select name="endTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
       <select name="startTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
    <input type="checkbox" name="daysofWeek[]" value="Wednesday"><br>
    Thursday:
    
    <select name="endTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
       <select name="startTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
    <input type="checkbox"
    name="daysofWeek[]"
    value="Thursdsday"><br>
    Friday:
    <select name="endTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
       <select name="startTime[]">
        <option value="800">8:00</option>
        <option value="900">9:00</option>
        <option value="1000">10:00</option>
        <option value="1100">11:00</option>
        <option value="1200">12:00</option>
        <option value="1300">13:00</option>
        <option value="1400">14:00</option>
        <option value="1500">15:00</option>
        <option value="1600">16:00</option>
        <option value="1700">17:00</option>
        <option value="1800">18:00</option>
    </select>
    <input type="checkbox"
           name="daysofWeek[]" value="Friday">
	</div>
	<hr><br>
	<br>
<button type="submit" id="submitButton" name="submit">Submit</button>
    </div>
    </form>
</body>
</html>
