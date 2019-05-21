<!DOCTYPE html>
<html>
<head>
<title>Inserimento dati</title>
<meta charset="UTF-8" />
</head>
<body>
<?php
$dbhost="127.0.0.1";
$dbuser="root";
$dbpass="";

$conn = mysqli_connect($dbhost,$dbuser,$dbpass);
if (!$conn) die("Errore: impossibile connettersi al DB ".mysqli_error($conn));

$sql = "USE eCommerce";
$ok = mysqli_query($conn,$sql);

if (!$ok) die("ERRORE, DATABASE eCommerce NON TROVATO".mysqli_error($conn));
echo "Connessione al database eseguita <br>";

$sql ="SELECT * FROM Prodotti";
$ok = mysqli_query($conn,$sql);
if (!$ok) {

	$sql ="";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
}
?>
<br><br><br><br><br>

Torna alla <a href="home.html">home</a>
</body>
</html>