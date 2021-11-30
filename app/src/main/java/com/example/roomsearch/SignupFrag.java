package com.example.roomsearch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupFrag extends Fragment {

     private static final   String url ="http://192.168.0.114/php/";
     EditText phn ,rnt,tlt,adrss,des;

     ImageView imge1 ,imge2,imge3;
     Button btn;
    Bitmap bitmap1 ,bitmap2 ,bitmap3;
    String email ;
    //ContentResolver contentResolver;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.signupactivity, container, false);

        imge1 = view.findViewById(R.id.img1);
        imge2 = view.findViewById(R.id.img2);
        imge3 = view.findViewById(R.id.img3);
        btn = view.findViewById(R.id.upload);
        phn = view.findViewById(R.id.phone);
        adrss = view.findViewById(R.id.adress);
        rnt = view.findViewById(R.id.rent);
        tlt = view.findViewById(R.id.talent);
        des = view.findViewById(R.id.desi);
          Bundle bundle = this.getArguments();
          email = bundle.getString("email");
           btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Serverdata();



               }
           });

        ActivityResultLauncher  resultLauncher, resultLauncher1  ,resultLauncher2 ;

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent !=null) {

                    try {

                        bitmap1= MediaStore.Images.Media.getBitmap( getActivity().getContentResolver(), intent.getData());

                        imge1.setImageBitmap(bitmap1);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//
            }


        });
          resultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

              @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent !=null) {

                    try {

                        bitmap2= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), intent.getData());

                        imge2.setImageBitmap(bitmap2);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
          resultLauncher2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent !=null) {

                    try {

                        bitmap3= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), intent.getData());



                        imge3.setImageBitmap(bitmap3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//
            }


        });




         // 64 Algoritham



        imge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher.launch(intent);

//                Intent intent =new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//
//                resultLauncher.launch(intent);
                // folow(resultLauncher);

            }

        });


        imge2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent =new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher1.launch(intent);
                //image1.setImageBitmap(arr.get(1));
                //  folow(resultLauncher);

            }

        });

        imge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher2.launch(intent);

                // image2.setImageBitmap(arr.get(2));
                //folow(resultLauncher);

            }

        });





        return view;
    }

    private void Serverdata() {

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG,75,byteArrayOutputStream1);
        bitmap2.compress(Bitmap.CompressFormat.JPEG,75,byteArrayOutputStream2);
        bitmap3.compress(Bitmap.CompressFormat.JPEG,75,byteArrayOutputStream3);
        byte[]  firstimg = byteArrayOutputStream1.toByteArray();
        byte[]  secondimg = byteArrayOutputStream1.toByteArray();
        byte[]  thirdimg = byteArrayOutputStream1.toByteArray();
        String encode1 = Base64.encodeToString(firstimg,Base64.DEFAULT);
        String encode2 = Base64.encodeToString(secondimg,Base64.DEFAULT);
        String encode3 = Base64.encodeToString(thirdimg,Base64.DEFAULT);
        Call<Insertdata> call = Reapi.getInstance().getApidata().adddata(email,phn.getText().toString(),adrss.getText().toString(),Integer.parseInt(rnt.getText().toString()),Integer.parseInt(tlt.getText().toString()),des.getText().toString(),encode1,encode2,encode3);

       call.enqueue(new Callback<Insertdata>() {
           @Override
           public void onResponse(Call<Insertdata> call, Response<Insertdata> response) {
               Toast.makeText(getContext(), response.body().getData(), Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(Call<Insertdata> call, Throwable t) {

           }
       });



    }


}