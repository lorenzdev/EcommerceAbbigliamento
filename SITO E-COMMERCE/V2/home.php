<style>
body {
  background-color: white;
}


h1 {
  color: #ff531a;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  font-size: 60px;
  font-weight: bold;
  text-align: center;
}
.login
{
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 125px;
  width: 500px;  
  font-size:20px;
}
.bentornato
{
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 60px;
  width: 450px;  
  font-size: 30px;	
	
	
}

.tipologia
{
  font-size: 25px;
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 100px;
  width: 300px;  
  display:inline-block;
  	
}

.prodotti
{
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 1000px;
  width: 800px;  
  font-weight: bold;
  font-size: 20px; 
  display:inline-block;
  position: relative;  
  bottom: 33px;
  left:50px;	
	
	
}

.login
{
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 210px;
  width: 230px;  
  font-size:20px;
}

.registrati
{
  color: #ff531a;
  text-align: left;
  font-family: 'Roboto', sans-serif;
  border: 3px solid grey;
  border-radius: 8px;
  height: 410px;
  width: 1000px;  
  font-size:20px;
  position: relative;  
  bottom: 10px;
  left: 150px;	  
}

a {
  color: #1a53ff;
  font-family: 'Roboto', sans-serif;
  font-size: 15;

}
a:link{
color: #1a53ff;
}


p {
  font-family: 'Roboto', sans-serif;
  font-size: 20px;
}

input {
color: grey;
  font-family: 'Roboto', sans-serif;
  font-size: 15px;
  font-weight: bold;
  
 }

.input2 {
  cursor: pointer;

 }
</style>
<?PHP

if(@$_POST["submit"]){
	
	$user = $_POST['email'];
	$pw = $_POST['pw'];

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
	
	$url='http://lucatedeschini2000.pythonanywhere.com/API/Login';
	$data=array("email" => $user,
				"password" => $pw);
	$risp=POST($data,$url);
	//echo $risp['status'];
	//echo $user;
	$LOGGATO = '<html>
				<head>
				<link rel="stylesheet" type="text/css" href="style.css">
				</head>
				<body>
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
				</h1 class="h1 tipologia>
				</body>
				</html>';
	$NONLOGGATO = '<html>
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
	
	
$p='<?PHP

if(@$_POST["submit"]){
	function POST ($data,$url) {
		$opts = array("http"=>array(
						"header" => "Content-type: application/x-www-form-urlencoded\r\n",
						"method\' \ => "POST",
						"content" => json_encode($data)));
		$context = stream_context_create($opts);
		$header = file_get_contents($url,false,$context);
		//echo $header;
		$header = json_decode($header, true);
		return $header;
		//echo $header["status"];	
	}		
	$tipologia = $_POST["tipologia"];

	//echo $user;




	
	$url="http://lucatedeschini2000.pythonanywhere.com/API/ListaProdotti";
	$data=array("categoria" => $tipologia);
	$risp=POST($data,$url);
	//echo $risp["status"];
	//echo $user;


	
	exit;
	//setcookie("parlo",$risp["status"]);			
				
	
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



</html>';	
	if($risp['status'] == "nonloggato")
	{
		echo '<h1>NOME SITO</h1>';
		echo '				<h1 class="h1 bentornato">
				Bentornato '. $user .'
							</h1 class="h1 bentornato>
			';
		
		echo $p;
		
	}
	else
	{
		echo $LOGGATO;		
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
<form action="home.php" method="post">
<h1 class="h1 login">
INSERISCI e-mail: <input type="text" name="email" required> <br> </br>
INSERISCI password: <input type="password" name="pw" required> <br> </br>
<input class="input input2" type="submit" value="LOGIN" name="submit"></h1>
</form>
<reg><a href="registrati.php">registrati ora</a></reg>

<!--

<button onclick="myFunction()">Try it</button>

<script>
function myFunction() {
  alert("I am an alert box!");
}
</script>

-->

</body>



</html>