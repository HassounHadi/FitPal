<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'db_info.php';

 $con = mysqli_connect('localhost','root','','fitpal');

 $response = array();

 //Initializing variables required for login
 $usrn = $_POST['usrn'];
 $password = $_POST['pass'];

 //checking if the user exists in the database
 $CheckSQL = "SELECT * FROM user WHERE usrn='$usrn' AND pass='$password'"; 
 
 $check = mysqli_query($con,$CheckSQL);
  
 if($check->num_rows!=1){

    $response["error"] = true;
    $response["message"] = "Wrong username or password! OR user does not exist.";


 echo json_encode($response);
 }
else{
$Sql_Query = "SELECT usrn,DOS,picture FROM user WHERE usrn='$usrn'";

//Checking if the log in was successful or not
$userQ = mysqli_query($con,$Sql_Query);

    //if login is successful we fetch the needed data inside the app
    $response["error"] = false;
    $response["message"] = "Logged In Successfully!";
    $response["user"]= mysqli_fetch_assoc($userQ);

    echo json_encode($response);

}

 
}
 
?>

