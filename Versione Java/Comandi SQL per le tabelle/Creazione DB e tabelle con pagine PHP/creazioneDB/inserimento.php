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

	$sql ="INSERT INTO Prodotti(tipologia, nome, descrizione, marca, prezzo, aggiuntoDa) VALUES ('Scarpe', 'Scarpe Sportive Nike', 'Scarpe sportive Nike', 'Nike', '30', 'Mario');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
	
	$sql ="INSERT INTO Utenti(email, password, nome, cognome, numeroTelefono, dataNascita, indirizzo, citta) VALUES ('mariorossi@gmail.com', '1234', 'Mario', 'Rossi', '0536123456', '1/1/1990', 'via Roma', 'Roma');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
	
	$sql ="INSERT INTO Prodotti(tipologia, nome, descrizione, marca, prezzo, aggiuntoDa) VALUES ('Maglia', 'Maglia invernale', 'Maglia invernale OVS', 'OVS', '35', 'Luca');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
	
	$sql ="INSERT INTO Utenti(email, password, nome, cognome, numeroTelefono, dataNascita, indirizzo, citta) VALUES ('lucaverdi@gmail.com', 'ciao123', 'Luca', 'Verdi', '0536214389', '2/2/1995', 'via Milano', 'Milano');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
	
	$sql ="INSERT INTO Prodotti(tipologia, nome, descrizione, marca, prezzo, aggiuntoDa) VALUES ('Pantaloni', 'Pantaloni invernali', 'Pantaloni invernali OVS', 'OVS', '25', 'Fabio');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
	
	$sql ="INSERT INTO Utenti(email, password, nome, cognome, numeroTelefono, dataNascita, indirizzo, citta) VALUES ('fabiobianchi@gmail.com', '123', 'Fabio', 'Bianchi', '053641349', '3/3/1999', 'via Firenze', 'Firenze');";

	$ok = mysqli_query($conn,$sql);
	if (!$ok) die("Impossibile inserire i dati <br> ".mysqli_error($conn));
	else echo "Inserimento dati avvenuto con successo<br>";
}
?>
<br><br><br><br><br>

Torna alla <a href="home.html">home</a>
</body>
</html>