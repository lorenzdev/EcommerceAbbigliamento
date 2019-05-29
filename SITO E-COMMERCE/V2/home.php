<?PHP
if(@$_GET["submit"]){
	
	$user = $_GET['email'];
	$pw = $_GET['pw'];

	
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
	
	$url='http://lucatedeschini2000.pythonanywhere.com/API/Login';
	$data=array("email" => $user,
				"password" => $pw);
	$risp=POST($data,$url);
	echo $risp['status'];
	
	$LOGINSUCCESSO = '<html>
<head>

  <link rel="stylesheet" type="text/css" href="style.css">




</head>
<body>
<h1>NOME SITO</h1>
<h1 class="h1 bentornato">
Bentornato *nome dell\'utente*</h1 class="h1 bentornato">


<h1 class="h1 tipologia">
Seleziona la tipologia:
<form action="tipologia.php">
  <select name="tipologia">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
  </select>
  <input class="input input2" type="submit" value="cerca">
</form>
</h1 class="h1 tipologia">

<h1 class="h1 prodotti">
blabla

</h1 class="h1 prodotti">


</body>



</html>';
	$LOGINERRATO = '<html>
				<head>  <link rel="stylesheet" type="text/css" href="style.css">
				</head>
				<body>
				<h1>NOME SITO</h1>
				<form action="home.php" method="get">
				<h1 class="h1 login">
				INSERISCI e-mail: <input type="text" name="email" required> <br> </br>
				INSERISCI password: <input type="password" name="pw" required> <br> </br>
				<input class="input input2" type="submit" value="LOGIN" name="submit"> Credenziali errate riprova</h1> 
				</form>

				<reg><a href="registrati.html">registrati ora</a></reg>



				</html>';
	if(true)
	{
		echo $LOGINSUCCESSO;
	}
	else
	{
		
	}
	exit;
	//setcookie('parlo',$risp['status']);			
				
	
}


?>

<html>
<head>

  <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<h1>NOME SITO</h1>
<form action="inserire_con.php" method="get">
<h1 class="h1 login">
INSERISCI e-mail: <input type="text" name="email" required> <br> </br>
INSERISCI password: <input type="password" name="pw" required> <br> </br>
<input class="input input2" type="submit" value="LOGIN"</h1>
</form>
<reg><a href="registrati.html">registrati ora</a></reg>



<button onclick="myFunction()">Try it</button>

<script>
function myFunction() {
var v= confirm("Are u sure?");  
if(v==true){  
alert("ok");  
}  
else{  
alert("cancel");  
} 
}

</script>



</body>



</html>