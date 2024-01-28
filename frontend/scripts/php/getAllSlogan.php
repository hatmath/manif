<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{			
		
		$requete = "SELECT * FROM `slogan`;";
		$reponse = mysqli_query($connexion,$requete);
		
		
		if ($reponse == true) 
		{
			
			$result = array();			
			
			while($row = mysqli_fetch_array($reponse)){
			array_push($result,array(
					"id"			=>	$row['id'],
					"title"			=>	$row['title'],				
					"slogan"		=>	$row['slogan'],		
					"interest"		=>	$row['interest'],						
					"date_created"	=>	$row['date_created'],
					"last_update"	=>	$row['last_update']					
				));
			}
		
			echo json_encode(array('result'=>$result));
			
		}
		else				
		{
			echo "Une erreur est survenu"; 
		}
		mysqli_close($connexion);
		
	}
	
}
	
 ?>

