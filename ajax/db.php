<?php 
define ( 'DB_NAME_AND_HOST', 'mysql:host=localhost;dbname=playing');
define ( 'DB_USER', 'webratd' );
define ( 'DB_PASS', 'razvan312' );

$options = array(
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
); 

global $pdo;

try{
	$pdo = new PDO(DB_NAME_AND_HOST, DB_USER, DB_PASS,$options);
	$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}catch(PDOException $e){
	echo 'Connection to database failed! We\'re sorry for the inconvenience.';
}





?>