<?PHP
if(@$_POST["submit"]){
	$user = $_POST['email'];
	$pw = $_POST['pw'];
	$nome = $_POST['nome'];
	$cognome = $_POST['cognome'];
	$num_tel = $_POST['num_tel'];
	$datan = "blabla";	
	$indirizzo = $_POST['indirizzo'];	
	$città = $_POST['città'];		
	$cap = $_POST['cap'];		
		
	$data=array("email" => $user,
			"password" => $pw,
			"nome" => $nome,
			"cognome" => $cognome,
			"numeroTelefono" => $num_tel,
			"indirizzo" => $indirizzo,
			"dataNascita" => $datan,
			"città" => $città);
$opts = array('http'=>array(
				'header' => "Content-type: application/x-www-form-urlencoded\r\n",
				'method'  => 'POST',
				'content' => json_encode($data)));
$context = stream_context_create($opts);
//url dell'api
$url='http://lucatedeschini2000.pythonanywhere.com/API/Registrati';
//con sto comando invii i dati e riceve la risposta nella variabile
$header = file_get_contents($url,false,$context);
//traduce il risultato in un vettore
$header = json_decode($header, true);
//per vedere i nomi del vettore guarda il file LEGGIMI.txt
//echo $header['status'];			
	
	$REGISTRATISUC= '<html><head>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>NOME SITO</h1>
<h1> Registrazione avvenuta con successo <a href="home.php">clicca qua</a> per eseguire il login</h1>
</body>
</html>';
	
	$REGISTRATIERRATO='<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>NOME SITO</h1>
<form action="registrati.php" method="get">
<h1 class="h1 registrati">
<ul>
<li>
INSERISCI e-mail: <input type="text" name="email" required> 
INSERISCI password: <input type="password" name="pw" required> </li> <br> </br>
<li>INSERISCI nome: <input type="text" name="nome" required> 
INSERISCI cognome: <input type="text" name="cognome" required> </li> <br> </br>
<li>INSERISCI numero di telefono: <input type="text" name="num_tel" required> 
INSERISCI data di nascita: <input type="date" name="data" required> </li> <br> </br>
<li>INSERISCI l\'indirizzo di spedizione: <input type="text" name="indirizzo" required> 
INSERISCI la citta\': <input type="text" name="città" required> </li> <br> </br> 
<li>INSERISCI il cap: <input type="text" name="cap" required> E-mail gia\' presente <a href="home.php">Clicca qua</a> per eseguire il login
<br></br><input class="input input2" type="submit" value="REGISTRATI	" name="submit" </li>
</h1>
</ul>

</form>
</body>
</html>';
	

				
	if($header['status'] == "ok")
	{
		echo $REGISTRATISUC;
	}
	else
	{
		echo $REGISTRATIERRATO;
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
<form action="registrati.php" method="POST">
<h1 class="h1 registrati">
<ul>

<li>INSERISCI e-mail: <input type="text" name="email" required> 
INSERISCI password: <input type="password" name="pw" required> </li> <br> </br>
<li>INSERISCI nome: <input type="text" name="nome" required> 
INSERISCI cognome: <input type="text" name="cognome" required> </li> <br> </br>
<li>INSERISCI numero di telefono: <input type="int" name="num_tel" required> 
INSERISCI data di nascita: <input type="date" name="datan" required> </li> <br> </br>
<li>INSERISCI l'indirizzo di spedizione: <input type="text" name="indirizzo" required> 
INSERISCI la città: <input type="text" name="città" required> </li> <br> </br> 
<li>INSERISCI il cap: <input type="text" name="cap" required> </li> 

</ul>
<input class="input input2" type="submit" value="REGISTRATI	" name="submit"</h1>
</form>





</body>



</html>