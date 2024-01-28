<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{
		$id = $_GET['id'];	
		
		$requete = "SELECT * FROM manif WHERE id=$id";
		$reponse = mysqli_query($connexion,$requete);
		
		if ($reponse == true) 
		{
			
			$result = array();
			
			$row = mysqli_fetch_array($reponse);
			array_push($result,array(
					"id"=>$row['id'],
					"owner"=>$row['owner'],
					"name"=>$row['name'],
					"description"=>$row['description'],
					"slogan"=>$row['slogan'],
					"city"=>$row['city'],
					"meeting"=>$row['meeting'],
					"interest"=>$row['interest'],
					"start_date"=>$row['start_date'],
					"end_date"=>$row['end_date'],
					"date_created"=>$row['date_created'],
					"last_update"=>$row['last_update']
										
				));

			echo json_encode(array('result'=>$result));
			
		}
		else				
		{
			echo "[ERREUR INTO getManif.php]"; 
		}
		
		mysqli_close($connexion);
		
	}
	
}
	
 ?>

