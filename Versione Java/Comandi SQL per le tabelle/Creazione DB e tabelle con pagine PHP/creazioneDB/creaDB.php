<!DOCTYPE html>
<html>
<head>
<title>Creazione tabelle</title>
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

if (!$ok){
$sql = "CREATE DATABASE eCommerce";
$ok = mysqli_query($conn,$sql);	
echo "DATABASE creato correttamente<br>";
}
else{
echo "DB già esistente <br>";
}


?>
<br><br><br><br><br>
torna alla <a href="home.html">home</a>
</body>
</html>