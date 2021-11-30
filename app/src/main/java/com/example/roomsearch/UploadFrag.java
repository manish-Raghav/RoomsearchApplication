package com.example.roomsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadFrag extends Fragment {


    Button btn;
    EditText name, email;
    private static final String url = "http://localhost/php/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ExtraActivity, container, false);

        btn = view.findViewById(R.id.signupbt);
        name = view.findViewById(R.id.nm);
        email = view.findViewById(R.id.em);
        Bundle bundel = new Bundle();
          bundel.putString("email",email.getText().toString());



        com.example.roomsearch.SignupFrag frag = new com.example.roomsearch.SignupFrag();
        frag.setArguments(bundel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
                getChildFragmentManager().beginTransaction().replace(R.id.mani, frag).commit();

            }
        });


        return view;


    }

    private void upload() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        com.example.roomsearch.Eapi api = retrofit.create(com.example.roomsearch.Eapi.class);

        Call<com.example.roomsearch.NmEml> call = api.adddata(email.getText().toString(), name.getText().toString());
        call.enqueue(new Callback<com.example.roomsearch.NmEml>() {
            @Override
            public void onResponse(Call<com.example.roomsearch.NmEml> call, Response<com.example.roomsearch.NmEml> response) {

                Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<com.example.roomsearch.NmEml> call, Throwable t) {

            }
        });

    }
}
