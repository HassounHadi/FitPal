<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'db_info.php';

 $con = mysqli_connect('localhost','root','','fitpal');

 $response = array();

 //Initializing variables required for creating a user
 $usrn = $_POST['usrn'];
 $Fname = $_POST['Fname'];
 $Lname = $_POST['Lname'];
 $DOS = $_POST['DOS'];
 $pnumber = $_POST['pnumber'];
 $email = $_POST['email'];
 $password = $_POST['pass'];
 $picture = $_POST['picture'];

 //making sure username is unique
 $CheckSQL = "SELECT * FROM user WHERE usrn='$usrn'";
 
 $check = mysqli_query($con,$CheckSQL);
 
 if($check->num_rows>0){

    $response["error"] = true;
    $response["message"]= "Username Already Exists";


 echo json_encode($response);
 }
else{
$Sql_Query = "INSERT INTO user (usrn,Fname,Lname,DOS,pnumber,email,pass,picture) values ('$usrn','$Fname','$Lname','$DOS','$pnumber','$email','$password','$picture')";

 if(mysqli_query($con,$Sql_Query))
{   $response["error"] = false;
    $response["message"]= "User Registered Successully";

    echo json_encode($response);

}
else
{
    $response["error"] = true;
    $response["message"]= "Try Again Later";

    echo json_encode($response);
 }
 }
}
 
?>

