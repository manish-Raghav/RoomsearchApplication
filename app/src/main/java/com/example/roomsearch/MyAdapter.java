package com.example.roomsearch;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder> {

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView imge;
        TextView rnt , adrs,tana;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
           imge= itemView.findViewById(R.id.siimg);
            rnt= itemView.findViewById(R.id.sit2);
            adrs= itemView.findViewById(R.id.sit1);
            tana= itemView.findViewById(R.id.sit3);


        }
    }
}
