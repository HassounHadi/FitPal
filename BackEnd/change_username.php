<?php
if($_SERVER['REQUEST_METHOD']=='POST'){


 $con = mysqli_connect('localhost','root','','fitpal');

 $response = array();

 //Initializing variables required for changing username
 $username = $_POST['usrn'];
 $nUsername = $_POST['usrn'];

 //checking if the user exists in the database
 $CheckSQL = "SELECT * FROM user WHERE usrn='$usrn' AND pass='$password'"; 
 
 $check = mysqli_query($con,$CheckSQL);
  
 if($check->num_rows>0){

    $response["error"] = true;
    $response["message"] = "Username already exists.";


 echo json_encode($response);
 }
else{
$Sql_Query = "UPDATE `user` SET `usrn` = '$nUsername' WHERE `user`.`usrn` = '$username'";

    echo json_encode($response);

}

 
}
 
?>

