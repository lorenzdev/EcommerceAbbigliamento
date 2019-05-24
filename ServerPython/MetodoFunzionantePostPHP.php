<!DOCTYPE html>
<html>
<head>
<title> chiaccherone</title>
<meta charset="UTF-8" />
</head>
<body>
<?php
$data=array("email" => "prova",
			"password" => "provaa");

$opts = array('http'=>array(
				'header' => "Content-type: application/x-www-form-urlencoded\r\n",
				'method'  => 'POST',
				'content' => json_encode($data)));
$context = stream_context_create($opts);
$header = file_get_contents('http://lucatedeschini2000.pythonanywhere.com/API/Login',false,$context);
echo $header;
$header = json_decode($header, true);
echo $header['status'];
?>


</body>
</html>