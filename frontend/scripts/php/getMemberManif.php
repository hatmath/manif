<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{
		$id = $_GET['id'];	
		
		$requete = "SELECT * FROM member_manif WHERE id=$id";
		$reponse = mysqli_query($connexion,$requete);
		
		if ($reponse == true) 
		{
			
			$result = array();
			
			$row = mysqli_fetch_array($reponse);
			array_push($result,array(
					"id"=>$row['id'],
					"manif"=>$row['manif'],
					"member"=>$row['member'],
					"is_present"=>$row['is_present'],
					"rating"=>$row['rating'],					
					"date_created"=>$row['date_created'],
					"last_update"=>$row['last_update']			
				));

			echo json_encode(array('result'=>$result));
			
		}
		else				
		{
			echo "[ERREUR INTO getMemberManif.php]"; 
		}
		mysqli_close($connexion);
		
	}
	
}
	
 ?>

