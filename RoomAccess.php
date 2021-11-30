<?php

$mani =mysqli_connect("localhost","root","","roomdatabase");
//$Email = $_POST['datamail'];
  
$quer ="SELECT * FROM room";
 $row = mysqli_query($mani,$quer);
    
     while($ext =mysqli_fetch_array($row))
     {
         $data["phone"] = $ext[1];
         $data["adress"] = $ext[2];
         $data["rent"] = $ext[3];
         $data["talecount"] = $ext[4];
         $data["des"] = $ext[5];

         $imageloc =$ext[6];
        $secondimageloc = $ext[7];
        $thirdimageloc = $ext[8];

        $image1 =   file_get_contents($imageloc);
        $image2  =file_get_contents($secondimageloc);
        $image3 = file_get_contents($thirdimageloc);
        $data["imageloc1"] = base64_encode($image1);
        $data["imageloc2"] = base64_encode($image2);
        $data["imageloc3"] = base64_encode($image3);


        

     }
     mysqli_close($mani);
     print(json_encode($data));




?>