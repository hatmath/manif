<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{			
		
		$requete = "SELECT * FROM `member`;";
		$reponse = mysqli_query($connexion,$requete);
		
		
		if ($reponse == true) 
		{
			
			$result = array();			
			
			while($row = mysqli_fetch_array($reponse)){
			array_push($result,array(
					"id"			=>	$row['id'],
					"username"		=>	$row['username'],
					"password"		=>	$row['password'],
					"salt"			=>	$row['salt'],
					"description"	=>	$row['description'],
					"avatar"		=>	$row['avatar'],
					"mail"			=>	$row['mail'],
					"phone"			=>	$row['phone'],
					"last_login"	=>	$row['last_login'],					
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

