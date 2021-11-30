package com.example.roomsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fatchimage extends Fragment {

      RecyclerView recyclerView ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fatchimage, container, false);
         recyclerView = view.findViewById(R.id.frecl);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<List<com.example.roomsearch.Backdata>> call = com.example.roomsearch.Reapi.getInstance().getApidata().getdata();
        call.enqueue(new Callback<List<com.example.roomsearch.Backdata>>() {
            @Override
            public void onResponse(Call<List<com.example.roomsearch.Backdata>> call, Response<List<com.example.roomsearch.Backdata>> response) {

            }

            @Override
            public void onFailure(Call<List<com.example.roomsearch.Backdata>> call, Throwable t) {

            }
        });


        return view;
    }
}