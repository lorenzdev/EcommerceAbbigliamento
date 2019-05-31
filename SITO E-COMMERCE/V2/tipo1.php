<?PHP

	function POST ($data,$url) {
		$opts = array("http"=>array(
						"header" => "Content-type: application/x-www-form-urlencoded\r\n",
						"method"  => "POST",
						"content" => json_encode($data)));
		$context = stream_context_create($opts);
		$header = file_get_contents($url,false,$context);
		//echo $header;
		$header = json_decode($header, true);
		return $header;
		//echo $header["status"];	
	}		
	$tipologia = "tipo1";

	//echo $user;





	$url="http://lucatedeschini2000.pythonanywhere.com/API/ListaProdotti";
	$data=array("categoria" => $tipologia);
	$risp=POST($data,$url);
	echo $risp["status"];
	//echo $user;



	exit;
	//setcookie("parlo",$risp["status"]);			
				
	


?>