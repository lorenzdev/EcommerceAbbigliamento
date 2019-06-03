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

if (!$ok) die("ERRORE, DATABASE eCommerce NON TROVATO".mysqli_error($conn));
echo "Connessione al database eseguita <br>";

$sql ="SELECT * FROM Prodotti";
$ok = mysqli_query($conn,$sql);
if (!$ok) {

	$sql ="CREATE TABLE Prodotti (
	idProdotto INT(4) NOT NULL AUTO_INCREMENT,
	tipologia CHAR(20) NOT NULL,
	nome CHAR(30) NOT NULL,
	descrizione CHAR(100) NOT NULL,
	marca CHAR(30) NOT NULL,
	prezzo FLOAT(8) NOT NULL,
	aggiuntoDa CHAR(100) DEFAULT 'prodotto base',
	PRIMARY KEY (idProdotto)
	);";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile creare tabella Prodotti <br> ".mysqli_error($conn));
	else echo "tabella Prodotti creata correttamente<br>";
	
	$sql ="CREATE TABLE Utenti (
	email CHAR(50) NOT NULL,
	password CHAR(20) NOT NULL,
	nome CHAR(50) NOT NULL,
	cognome CHAR(50) NOT NULL,
	numeroTelefono CHAR(30) NOT NULL,
	dataNascita CHAR(10) NOT NULL,
	indirizzo CHAR(60) NOT NULL,
	citta CHAR(57) NOT NULL,
	PRIMARY KEY (email)
	);";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile creare tabella Utenti <br> ".mysqli_error($conn));
	else echo "tabella Utenti creata correttamente<br>";
	
	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile creare tabella Prodotti <br> ".mysqli_error($conn));
	else echo "tabella Prodotti creata correttamente<br>";
	
	$sql ="CREATE TABLE Possiede (
	idProdotto INT UNSIGNED NOT NULL,
    email INT UNSIGNED NOT NULL,
    PRIMARY KEY (idProdotto, email),
    FOREIGN KEY (idProdotto)  REFERENCES Prodotti (idProdotto),
    FOREIGN KEY (email) REFERENCES Utenti (email)
	);";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile creare tabella Utenti <br> ".mysqli_error($conn));
	else echo "tabella Utenti creata correttamente<br>";
}
else{
echo "tabelle già create in precedenza <br>";
}
?>
<br><br><br><br><br>

torna alla <a href="home.html">home</a>
</body>
</html>