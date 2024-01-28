<?php 



if($_SERVER['REQUEST_METHOD']=='GET')
{	
	$connexion = mysqli_connect("localhost", "root", "", "manif-jnt");
	if ($connexion)
	{			
		
		$requete = "SELECT * FROM `member_manif`;";
		$reponse = mysqli_query($connexion,$requete);
		
		
		if ($reponse == true) 
		{
			
			$result = array();			
			
			while($row = mysqli_fetch_array($reponse)){
			array_push($result,array(
					"id"			=>	$row['id'],
					"manif"			=>	$row['manif'],				
					"member"		=>	$row['member'],		
					"is_present"	=>	$row['is_present'],
					"rating"		=>	$row['rating'],						
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

