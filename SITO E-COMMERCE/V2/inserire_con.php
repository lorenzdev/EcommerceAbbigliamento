<html><body>
<?php
$user = $_GET['email'];
$pw = $_GET['pw'];

$url='http://lucatedeschini2000.pythonanywhere.com/API/Login';
$data=array("email" => $user,
			"password" => $pw);
$risp=POST($data,$url);
echo $risp['status'];
setcookie('parlo',$risp['status']);			
			
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
?>

</body></html>