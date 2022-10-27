package com.if31.pahlawan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class adapterGrid extends RecyclerView.Adapter<adapterGrid.ViewHolder> {
private ArrayList<MODEL_PAHLAWAN>datapahlawan;

    public adapterGrid(ArrayList<MODEL_PAHLAWAN> datapahlawan) {
        this.datapahlawan = datapahlawan;
    }

    @NonNull
    @Override
    public adapterGrid.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterGrid.ViewHolder holder, int position) {
     MODEL_PAHLAWAN pahlawan = datapahlawan.get(position);
        Glide.with(holder.itemView.getContext()).load(pahlawan.getFoto()).apply(new RequestOptions().override(350,550)).into(holder.ivGrid);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = pahlawan.getNama();
                String tentang = pahlawan.getTentang();
                String foto = pahlawan.getFoto();

                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity2.class);
                intent.putExtra("varNama" , nama);
                intent.putExtra("varTentang" , tentang);
                intent.putExtra("varFoto" , foto);
                holder.itemView.getContext().startActivity(intent);
            }
        });


}

    @Override
    public int getItemCount() {
        return datapahlawan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
