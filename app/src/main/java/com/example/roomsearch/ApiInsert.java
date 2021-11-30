package com.example.roomsearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInsert {
    @FormUrlEncoded
    @POST("RoomUpload.php")
    Call<Insertdata> adddata(@Field("mail") String email ,@Field("phone") String Phone ,@Field("adress") String Adress ,@Field("rent") int Rent , @Field("talentcount") int Count
         ,@Field("des") String Des , @Field("img1") String encode1 ,@Field("img2") String encode2 , @Field("img3")  String encode3);

       @GET("")
    Call<List<Backdata>> getdata();

}
