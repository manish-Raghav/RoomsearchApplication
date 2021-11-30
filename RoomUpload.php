
<?php
    $conn = mysqli_connect("localhost","root","","roomdatabase");
 
     if($conn)
     {
         echo " Api is connect";
     }
     else{
         echo "some problem happning";
     }
 


        $email=$_POST['email'] ?? "";
       //$uname =$_POST['Name'] ?? "";
        $uphone =$_POST['phone'] ?? "";
        $uadress =$_POST['adress'] ?? "";
        $urant =$_POST['rent']  ?? "";
        $countpeople = $_POST['talentcount'] ?? "";
        $descripttion =$_POST['des'] ?? "";

        $encodedimag1 = $_POST['img1'] ?? "";
        $encodedimag2 = $_POST['img2'] ?? "";
        $encodedimag3 = $_POST['img3'] ?? "";

       //  $image1 =$_FILES['']
    

          // $firstloc =$_FILES['image1']['tmp_name'] ?? "";
          // $secondloc =$_FILES['image2']['tmp_name'] ?? "";
          // $thirdloc = $_FILES['image3']['tmp_name'] ?? "";
         // $forthloc =$_FILES['image4']['tmp_name'] ?? "";

         // //   $firstsize = $_FILES['image1']['size'];
    // //   $secondsize = $_FILES['image2']['size'];
    // //   $thirdsize = $_FILES['image3']['size'];
    // //   $fourthsize = $_FILES['image4']['size'];


          // $firstname =$_FILES['image1']['name'] ?? "";
          // $secondname =$_FILES['image2']['name'] ?? "";
          // $thirdname =$_FILES['image3']['name'] ?? "";
          // $fourthname =$_FILES['image4']['name']  ?? "";
          $firstname = "firstimage";
          $secondname ="secondimage";
          $thirdname = "thirdimage";

          $firstdesi ="imageupload/.$firstname.jpg";
          $seconddesi ="imageupload/.$secondname.jpg";
           $thirddesi ="imageupload/.$thirdname.jpg";
        //  $fourthdesi ="imageupload/".$fourthname;
       
        //$email ="karansing123@";

            
           // $movedata1= move_uploaded_file($firstloc,"upload\tj.jpg");

        //    ,`img1`, `img2`, `img3`
        //    ,'$firstdesi' , '$seconddesi' , '$thirddesi' 

          $myquery ="INSERT INTO `room`(`email`, `phone`, `adress`, `rent`, `talentcount`, `des` ) VALUES
           ( '$email','$uphone' ,'$uadress' , '$urant', '$countpeople' ,'$descripttion'  )";

        $m =mysqli_query($conn, $myquery);

          echo $m;

               if(mysqli_query($conn, $myquery))
              {
                file_put_contents($firstdesi, base64_decode( $encodedimag1));
                file_put_contents($seconddesi, base64_decode( $encodedimag2));
                file_put_contents($thirddesi, base64_decode( $encodedimag3));

                // $movedata1= move_uploaded_file($firstloc,$firstdesi);
                // $movedata2= move_uploaded_file($,$seconddesi);
                //  $movedata3= move_uploaded_file($thirdloc,$thirddesi);
               //    $movedata4= move_uploaded_file($forthloc,$fourthdesi);
                        
                    $result["data"] = "your data is uoloded";
                  
                   
                   }   
               else{
                $result["data"] = "your data is not uploded";

                echo " not connected "; 

                  // die();
              }                      
  


        mysqli_close($conn);
        print(json_encode($result));

 ?> 










  

