<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{
		$id = $_GET['id'];	
		
		$requete = "SELECT * FROM interest WHERE id=$id";
		$reponse = mysqli_query($connexion,$requete);
		
		if ($reponse == true) 
		{
			
			$result = array();
			
			$row = mysqli_fetch_array($reponse);
			array_push($result,array(
					"id"=>$row['id'],
					"name"=>$row['name'],
					"description"=>$row['description'],
					"date_created"=>$row['date_created']			
				));

			echo json_encode(array('result'=>$result));
			
		}
		else				
		{
			echo "[ERREUR INTO getInterest.php]"; 
		}
		mysqli_close($connexion);
		
	}
	
}
	
 ?>

