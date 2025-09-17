<?php

include('db.php');
$name_error = $email_error = $nid_error = $dob_error = $contact_error = $address_error = $blood_type_error = $password_error = "";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $name = $_POST['name'];
    $nid = $_POST['nid'];
    $dob = $_POST['dob'];
    $email = $_POST['email'];
    $contact = $_POST['contact'];
    $address = $_POST['address'];
    $blood_type = $_POST['blood-type'];
    $height = $_POST['height'];
    $weight = $_POST['weight'];
    $password = $_POST['password'];
    $confirm_password = $_POST['confirm-password'];

    
    if (!preg_match("/^\d{13}$/", $nid)) {
        $nid_error = "NID must be a 13-digit number.";
    }

    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $email_error = "Invalid email format.";
    }

 
    if (!preg_match("/^\+8801[3-9]\d{8}$/", $contact)) {
        $contact_error = "Please enter a valid Bangladeshi mobile number.";
    }

    if (strlen($password) < 8 || strlen($password) > 20 || !preg_match("/[A-Z]/", $password) || !preg_match("/[a-z]/", $password) || !preg_match("/[0-9]/", $password)) {
        $password_error = "Password must be 8-20 characters long and include at least one uppercase letter, one lowercase letter, and one number.";
    }

    if ($password !== $confirm_password) {
        $password_error = "Passwords do not match.";
    }

    if (empty($name_error) && empty($email_error) && empty($nid_error) && empty($contact_error) && empty($address_error) && empty($password_error)) {
        $sql = "SELECT * FROM donors WHERE nid = ? AND dob = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ss", $nid, $dob);
        $stmt->execute();
        $result = $stmt->get_result();
        
        if ($result->num_rows > 0) {
            header("Location: already_registered.php");
        } else {
            $insert_sql = "INSERT INTO donors (name, nid, dob, email, contact, address, blood_type, height, weight, password) 
                           VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            $stmt = $conn->prepare($insert_sql);
            $hashed_password = password_hash($password, PASSWORD_DEFAULT); // Hash password
            $stmt->bind_param("ssssssssss", $name, $nid, $dob, $email, $contact, $address, $blood_type, $height, $weight, $hashed_password);
            
            if ($stmt->execute()) {
                header("Location: success.php");
            } else {
                echo "Error: " . $stmt->error;
            }
        }
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form of a Donor</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="form-container">
        <h2>Registration Form of a Donor</h2>
        <form id="donor-form" action="register.php" method="POST">
            <div class="form-row">
                <!-- Left column -->
                <div class="form-column">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required>
                        <small id="name-error" class="error"><?php echo $name_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="nid">NID:</label>
                        <input type="text" id="nid" name="nid" required>
                        <small id="nid-error" class="error"><?php echo $nid_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="dob">Date of Birth:</label>
                        <input type="date" id="dob" name="dob" required>
                        <small id="dob-error" class="error"><?php echo $dob_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required>
                        <small id="email-error" class="error"><?php echo $email_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label>Gender:</label>
                        <div class="radio-group">
                            <input type="radio" id="male" name="gender" value="male" required>
                            <label for="male">Male</label>
                            <input type="radio" id="female" name="gender" value="female" required>
                            <label for="female">Female</label>
                            <input type="radio" id="other" name="gender" value="other" required>
                            <label for="other">Other</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contact">Contact Number:</label>
                        <input type="tel" id="contact" name="contact" pattern="^\+8801[3-9]\d{8}$" required>
                        <small id="contact-error" class="error"><?php echo $contact_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <textarea id="address" name="address" maxlength="150" required></textarea>
                        <small id="address-error" class="error"><?php echo $address_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="blood-type">Blood Type:</label>
                        <select id="blood-type" name="blood-type" required>
                            <option value="A+">A+</option>
                            <option value="A-">A-</option>
                            <option value="B+">B+</option>
                            <option value="B-">B-</option>
                            <option value="O+">O+</option>
                            <option value="O-">O-</option>
                            <option value="AB+">AB+</option>
                            <option value="AB-">AB-</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="height">Height:</label>
                        <input type="number" id="height" name="height" required>
                    </div>
                    <div class="form-group">
                        <label for="weight">Weight:</label>
                        <input type="number" id="weight" name="weight" required>
                    </div>
                </div>

                <!-- Right column -->
                <div class="form-column">
                    <div class="form-group">
                        <label>Donated Blood Before?:</label>
                        <div class="radio-group">
                            <input type="radio" id="blood-yes" name="donated-blood" value="yes" required>
                            <label for="blood-yes">Yes</label>
                            <input type="radio" id="blood-no" name="donated-blood" value="no" required>
                            <label for="blood-no">No</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="allergy">Allergy Details:</label>
                        <input type="text" id="allergy" name="allergy" value="I have no allergy issue.">
                    </div>
                    <div class="form-group">
                        <label for="disease-history">Serious Disease History:</label>
                        <input type="text" id="disease-history" name="disease-history" value="HbsAg/Hcv/HIV/Hepatitis/Covid">
                    </div>
                    <div class="form-group">
                        <label>Has Anemia?:</label>
                        <div class="radio-group">
                            <input type="radio" id="anemia-yes" name="anemia" value="yes" required>
                            <label for="anemia-yes">Yes</label>
                            <input type="radio" id="anemia-no" name="anemia" value="no" required>
                            <label for="anemia-no">No</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Cardiac Patient?:</label>
                        <div class="radio-group">
                            <input type="radio" id="cardiac-yes" name="cardiac" value="yes" required>
                            <label for="cardiac-yes">Yes</label>
                            <input type="radio" id="cardiac-no" name="cardiac" value="no" required>
                            <label for="cardiac-no">No</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Under Medication?:</label>
                        <div class="radio-group">
                            <input type="radio" id="medication-yes" name="medication" value="yes" required>
                            <label for="medication-yes">Yes</label>
                            <input type="radio" id="medication-no" name="medication" value="no" required>
                            <label for="medication-no">No</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                        <small id="password-error" class="error"><?php echo $password_error; ?></small>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm Password:</label>
                        <input type="password" id="confirm-password" name="confirm-password" required>
                        <small id="confirm-password-error" class="error"></small>
                    </div>
                </div>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
