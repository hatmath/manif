<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{
		$id = $_GET['id'];	
		
		$requete = "SELECT * FROM member WHERE id=$id";
		$reponse = mysqli_query($connexion,$requete);
		
		if ($reponse == true) 
		{
			
			$result = array();
			
			$row = mysqli_fetch_array($reponse);
			array_push($result,array(
					"id"=>$row['id'],
					"username"=>$row['username'],
					"password"=>$row['password'],
					"salt"=>$row['salt'],
					"description"=>$row['description'],
					"avatar"=>$row['avatar'],
					"mail"=>$row['mail'],
					"phone"=>$row['phone'],					
					"date_created"=>$row['date_created'],
					"last_update"=>$row['last_update'],
					"last_login"=>$row['last_login']
					
					 			
				));

			echo json_encode(array('result'=>$result));
			
		}
		else				
		{
			echo "[ERREUR INTO getMember.php]"; 
		}
		
		mysqli_close($connexion);
		
	}
	
}
	
 ?>

