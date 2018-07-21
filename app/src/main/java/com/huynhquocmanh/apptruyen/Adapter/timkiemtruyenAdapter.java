package com.huynhquocmanh.apptruyen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.Timkiem;
import com.huynhquocmanh.apptruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class timkiemtruyenAdapter extends RecyclerView.Adapter<timkiemtruyenAdapter.ViewHolder> {
    ArrayList<Timkiem> mangtruyen;
    Context context;

    public timkiemtruyenAdapter(ArrayList<Timkiem> datatruyen, Context context) {
        this.mangtruyen = datatruyen;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.dong_tim_kiem, parent, false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttentruyen.setText(mangtruyen.get(position).getTenTruyen());
        holder.txttacgia.setText( "Tác Giả: "+mangtruyen.get(position).getTacGia());
        holder.txtchuong.setText("Số chương: "+ mangtruyen.get(position).getSochuong());
        Picasso.with(context).load(mangtruyen.get(position).getHinhTruyen()).into(holder.imghinhtruyen);
    }

    @Override
    public int getItemCount() {
        return mangtruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttentruyen, txttacgia, txtchuong;
        ImageView imghinhtruyen;

        public ViewHolder(View itemView) {
            super(itemView);
            txttentruyen = itemView.findViewById(R.id.tentruyen);
            txttacgia = itemView.findViewById(R.id.tacgia);
            txtchuong = itemView.findViewById(R.id.chuong);
            imghinhtruyen = itemView.findViewById(R.id.imageview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, chitiettruyenActivity.class);
                    intent.putExtra("truyen", Integer.valueOf(mangtruyen.get(getPosition()).getIdTruyen()));
                    context.startActivity(intent);
                }
            });
        }
    }

}
