package com.huynhquocmanh.apptruyen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.ThuNghiem;
import com.huynhquocmanh.apptruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class truyenmoiAdapter extends RecyclerView.Adapter<truyenmoiAdapter.ViewHolder> {
    Context context;
    ArrayList<ThuNghiem> mangtruyenloc;
    int Position;

    public truyenmoiAdapter(Context context, ArrayList<ThuNghiem> mangtruyenloc) {
        this.context = context;
        this.mangtruyenloc = mangtruyenloc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.dong_truyen_moi, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttentruyen.setText(mangtruyenloc.get(position).getTenTruyen());
        holder.txtngaycapnha.setText("cập nhât ngày"+mangtruyenloc.get(position).getLoctheo());
      Position = position;
        Picasso.with(context).load(mangtruyenloc.get(position).getHinhTruyen()).into(holder.imghinhtruyen);
    }

    @Override
    public int getItemCount() {
        return mangtruyenloc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttentruyen, txtngaycapnha;
        ImageView imghinhtruyen;

        public ViewHolder(View itemView) {
            super(itemView);
            txttentruyen = itemView.findViewById(R.id.textviewtentruyen);
            txtngaycapnha = itemView.findViewById(R.id.textviewngaycapnhat);
            imghinhtruyen = itemView.findViewById(R.id.imageviewhinhtruyenmoi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, chitiettruyenActivity.class);
                    intent.putExtra("truyen", Integer.valueOf(mangtruyenloc.get(getPosition()).getIdTruyen()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
