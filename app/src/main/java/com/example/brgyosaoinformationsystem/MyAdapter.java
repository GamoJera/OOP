package com.example.brgyosaoinformationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context context;
    private ArrayList id,housenum,name,birthdate,age,gender,status,purok;

    public MyAdapter(Context context, ArrayList id,ArrayList housenum, ArrayList name, ArrayList birthdate, ArrayList age, ArrayList gender, ArrayList status, ArrayList purok) {
        this.context = context;
        this.id = id;
        this.housenum = housenum;
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.purok = purok;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.housenum.setText(String.valueOf(housenum.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.birthdate.setText(String.valueOf(birthdate.get(position)));
        holder.age.setText(String.valueOf(age.get(position)));
        holder.gender.setText(String.valueOf(gender.get(position)));
        holder.status.setText(String.valueOf(status.get(position)));
        holder.purok.setText(String.valueOf(purok.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,housenum,name, birthdate, age, gender, status,purok;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            housenum = itemView.findViewById(R.id.tHousenum);
            name = itemView.findViewById(R.id.tName);
            birthdate = itemView.findViewById(R.id.tBirthdate);
            age = itemView.findViewById(R.id.tAge);
            gender = itemView.findViewById(R.id.tGender);
            status = itemView.findViewById(R.id.tStatus);
            purok = itemView.findViewById(R.id.tPurok);
        }
    }
}
