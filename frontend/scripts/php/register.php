<?php 

if($_SERVER['REQUEST_METHOD']=='POST')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{	
		
		$id 				= $_POST['id'];
		$username 			= $_POST['username'];
		$password 			= $_POST['password'];
		$salt 				= $_POST['salt'];
		$description 		= $_POST['description'];
		$avatar 			= $_POST['avatar'];
		$mail 				= $_POST['mail'];
		$phone 				= $_POST['phone'];
		$last_login 		= $_POST['last_login'];
		$date_created 		= $_POST['date_created'];
		$last_update 		= $_POST['last_update'];
		   
		
		$requete = "INSERT INTO `member`(`id`, `username`, `password`, `salt`, `description`, `avatar`, `mail`, `phone`, `last_login`, `date_created`, `last_update`) VALUES ('$id', '$username', '$password', '$salt', '$description', '$avatar', '$mail', '$phone', '$last_login', '$date_created', '$last_update');";  

		$reponse = mysqli_query($connexion, $requete);		
			
		if ($reponse == true) {	$reponse = "onSuccess";	}
		else				  {	$reponse = $id;	}
		
		echo $reponse;
				
		mysqli_close($connexion);
	}
	else { 	echo "Impossible de se connecter"; }
	
}

 ?>

