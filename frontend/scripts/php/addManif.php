<?php 

if($_SERVER['REQUEST_METHOD']=='POST')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{		
		
		
		$id 			= $_POST['id'];				
		$owner 			= $_POST['owner'];	
		$name 			= $_POST['name'];				
		$description 	= $_POST['description'];	
		$slogan 		= $_POST['slogan'];	
		$city 			= $_POST['city'];				
		$meeting 		= $_POST['meeting'];
		$interest 		= $_POST['interest'];	
		$start_date 	= $_POST['start_date'];				
		$end_date 		= $_POST['end_date'];
		$date_created 	= $_POST['date_created'];				
		$last_update 	= $_POST['last_update'];
		
		$requete = "INSERT INTO `manif`(`id`, `owner`, `name`, `description`, `slogan`, `meeting`, `interest`, `start_date`,`end_date`, `date_created`, `last_update`) VALUES ('$id', '$owner', '$name', '$description', '$slogan', '$city','$meeting', '$interest', '$start_date', '$end_date', '$date_created', '$last_update');";  

		$reponse = mysqli_query($connexion, $requete);		
		
		if ($reponse == false) 	  {	$reponse = "Une erreur est survenu dans addManif";		}
			else 				{ exit(); } 
			
		echo "Requete: ";   echo $requete;  echo "\n";
		echo "Reponse: ";	echo $reponse;	echo "\n";
		
		mysqli_close($connexion);
	}
	else { 	echo "Impossible de se connecter"; }

	
}



 ?>

