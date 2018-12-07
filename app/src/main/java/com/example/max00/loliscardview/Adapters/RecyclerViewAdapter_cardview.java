package com.example.max00.loliscardview.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.max00.loliscardview.Classes.Lolis;
import com.example.max00.loliscardview.R;

import java.util.ArrayList;

public abstract class RecyclerViewAdapter_cardview extends RecyclerView.Adapter<RecyclerViewAdapter_cardview.LolisViewHolder>{

    private ArrayList<Lolis> lolis;
    private int pos;

    public abstract void onFavClick(boolean b, int position);

    public static class LolisViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView name;
        ImageView img;
        CheckBox checkBox;

        public LolisViewHolder(View itemview){
            super(itemview);
            cardView = itemview.findViewById(R.id.card_view);
            name = itemview.findViewById(R.id.TV_name);
            img = itemview.findViewById(R.id.imagen);
            checkBox = itemview.findViewById(R.id.checked);
        }
    }

    public RecyclerViewAdapter_cardview(ArrayList<Lolis> lolis) {
        this.lolis = lolis;
    }

    @NonNull
    @Override
    public LolisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return (new  LolisViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull final LolisViewHolder holder, int position) {
        pos = holder.getAdapterPosition();
        holder.name.setText(lolis.get(position).getNombre());
        holder.img.setImageResource(lolis.get(position).getImg());
        holder.checkBox.setChecked(lolis.get(position).getaBoolean());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                onFavClick(b, pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lolis.size();
    }
}

