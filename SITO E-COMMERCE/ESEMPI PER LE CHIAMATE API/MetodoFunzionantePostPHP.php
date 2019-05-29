<!DOCTYPE html>
<html>
<head>
<title> chiaccherone</title>
<meta charset="UTF-8" />
</head>
<body>


<?php
//tutta sta roba ti conviene farla in una funzione che chiede in ingresso la variabile $data e l'url, e poi returna l'$header
//costruire un array con i dati che richiede il sito (vedi LEGGIMI.txt)
$data=array("email" => "prova",
			"password" => "provaa");
//questo va lasciato uguale
$opts = array('http'=>array(
				'header' => "Content-type: application/x-www-form-urlencoded\r\n",
				'method'  => 'POST',
				'content' => json_encode($data)));
$context = stream_context_create($opts);
//url dell'api
$url='http://lucatedeschini2000.pythonanywhere.com/API/Login';
//con sto comando invii i dati e riceve la risposta nella variabile
$header = file_get_contents($url,false,$context);
//traduce il risultato in un vettore
$header = json_decode($header, true);
//per vedere i nomi del vettore guarda il file LEGGIMI.txt
echo $header['status'];
?>


</body>
</html>