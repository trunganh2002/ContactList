package com.example.contactlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Viewholder> {

    Activity activity;
    ArrayList<ContactModel> arrayList;

    public MainAdapter(Activity activity,ArrayList<ContactModel> arrayList){
        this.activity = activity;
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.Viewholder holder, int position) {
        ContactModel model = arrayList.get(position);

        holder.tvname.setText(model.getName());
        holder.tvnumber.setText(model.getNumber());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvname,tvnumber;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.name);
            tvnumber = itemView.findViewById(R.id.tv_number);
        }
    }
}
