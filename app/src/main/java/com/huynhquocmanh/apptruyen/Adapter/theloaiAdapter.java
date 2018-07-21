package com.huynhquocmanh.apptruyen.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;

public class theloaiAdapter extends RecyclerView.Adapter<theloaiAdapter.ViewHolder> {
    Context context;
    ArrayList<String> mangloaitruyen;

    public theloaiAdapter(Context context, ArrayList<String> mangloaitruyen) {
        this.context = context;
        this.mangloaitruyen = mangloaitruyen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.dong_the_loai, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttheloai.setText(" " + mangloaitruyen.get(position) + " ");
    }

    @Override
    public int getItemCount() {
        return mangloaitruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttheloai;

        public ViewHolder(View itemView) {
            super(itemView);
            txttheloai = itemView.findViewById(R.id.textview);
        }
    }


}
