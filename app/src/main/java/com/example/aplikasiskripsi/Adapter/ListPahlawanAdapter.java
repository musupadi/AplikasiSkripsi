package com.example.aplikasiskripsi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aplikasiskripsi.Model.ModelPahlawan;
import com.example.aplikasiskripsi.R;

import java.util.ArrayList;

public class ListPahlawanAdapter extends RecyclerView.Adapter<ListPahlawanAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<ModelPahlawan> listPahlawan;

    private ArrayList<ModelPahlawan> getListPahlawan() {
        return listPahlawan;
    }

    public void setListPahlawan(ArrayList<ModelPahlawan> listPahlawan) {
        this.listPahlawan = listPahlawan;
    }

    public ListPahlawanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_pahlawan, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListPahlawan().get(position).getNama());
        categoryViewHolder.tvRemarks.setText(getListPahlawan().get(position).getRemarks());

        Glide.with(context)
                .load(getListPahlawan().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPahlawan().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout layoutCardView;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
