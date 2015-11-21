<?php
require_once 'db.php';
global $pdo;
check_login($_POST['username'],$_POST['password']);

function check_login($username,$password){
	global $pdo;
	$cmd=$pdo->prepare("SELECT * FROM `accounts` WHERE name=:username;");
	$cmd->bindParam(":username",$username,PDO::PARAM_STR);
	$cmd->execute();
	$result=$cmd->fetchAll(PDO::FETCH_OBJ);
	$json =json_decode($result[0]->{'jsondata'});
	$name=$json->{'owners'}->{'list'}[0]->{'name'};
	if($name == $username && $name == $password){
		echo  'ok';
	}else{
		echo 'not ok';
	}
}

?>