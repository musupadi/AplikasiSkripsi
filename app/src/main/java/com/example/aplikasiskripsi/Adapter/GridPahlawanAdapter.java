package com.example.aplikasiskripsi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aplikasiskripsi.Model.ModelPahlawan;
import com.example.aplikasiskripsi.R;

import java.util.ArrayList;

public class GridPahlawanAdapter extends RecyclerView.Adapter<GridPahlawanAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<ModelPahlawan> listPahlawan;

    private ArrayList<ModelPahlawan> getListPahlawan() {
        return listPahlawan;
    }

    public void setListPahlawan(ArrayList<ModelPahlawan> listPahlawan) {
        this.listPahlawan = listPahlawan;
    }

    public GridPahlawanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_pahlawan, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListPahlawan().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPahlawan().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

