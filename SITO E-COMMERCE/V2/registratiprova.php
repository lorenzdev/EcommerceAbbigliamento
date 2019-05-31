<?PHP

if(@$_POST["submit"]){
	
	$tipologia = $_POST['tipologia'];

	//echo $user;


	function POST ($data,$url) {
		$opts = array('http'=>array(
						'header' => "Content-type: application/x-www-form-urlencoded\r\n",
						'method'  => 'POST',
						'content' => json_encode($data)));
		$context = stream_context_create($opts);
		$header = file_get_contents($url,false,$context);
		//echo $header;
		$header = json_decode($header, true);
		return $header;
		//echo $header['status'];	
	}	

	
	$url='http://lucatedeschini2000.pythonanywhere.com/API/ListaProdotti';
	$data=array("categoria" => $tipologia);
	$risp=POST($data,$url);
	echo $risp['status'];
	//echo $user;


	
	exit;
	//setcookie('parlo',$risp['status']);			
				
	
}


?>

<html>
<head>

  <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form action="registratiprova.php" method="POST">
<h1 class="h1 registrati">

INSERISCI il tipo: <input type="text" name="tipologia" required> 

<input class="input input2" type="submit" value="CERCA" name="submit"</h1>
</form>





</body>



</html>