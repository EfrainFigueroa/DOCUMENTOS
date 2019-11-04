<?php 

define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','bd_documentos');

$conn =new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);

if(mysqli_connect_errno()){
	echo "fallo al conectar con mysql".mysql_connect_errno();
	die();
}

$stmt=$conn->prepare("SELECT documento_nombre FROM documentos");
$stmt->execute();
$stmt->bind_result($documento_nombre);
$archivos=array();

while($stmt->fetch()){
	$temp=array();
	$temp['documento_nombre']=$documento_nombre;
	array_push($archivos,$temp);
}

echo json_encode($archivos);