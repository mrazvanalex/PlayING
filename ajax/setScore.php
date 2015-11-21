
<?php
require_once 'db.php';
global $pdo;
user_score($_POST['username'],$_POST['score']);

function user_score($username,$score){
	global $pdo;
	$time=time();
	$object='{username:"'.$username.'",score:"'.$score.'"}';
		$cmd=$pdo->prepare("INSERT INTO `queue` (date_created,players) VALUES (:time,:object);");
		$cmd->bindParam(":time",$time,PDO::PARAM_INT);
		$cmd->bindParam(":object",$object,PDO::PARAM_STR);
		if($cmd->execute()){
			echo 'ok';
		}else{
			echo 'not ok';
		}

	
	
}

?>