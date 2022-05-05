<?php
if($_SERVER['REQUEST_METHOD']=='POST'){


 $con = mysqli_connect('localhost','root','','fitpal');

 $response = array();

 //Initializing variables required for changing username
 $pic = $_POST['picture'];
 $nPic = $_POST['picture'];

$Sql_Query = "UPDATE `user` SET `usrn` = '$nPic' WHERE `user`.`usrn` = '$pic'";

    echo json_encode($response); 
}
 
?>

