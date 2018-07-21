package com.huynhquocmanh.apptruyen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.Laytruyentheotheloai;
import com.huynhquocmanh.apptruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class truyentheotheloaiAdapter extends BaseAdapter {
    ArrayList<Laytruyentheotheloai> mangtruyen;
    Context context;
    public truyentheotheloaiAdapter(ArrayList<Laytruyentheotheloai> mangmonan , Context context) {
        this.mangtruyen = mangmonan;
        this.context = context;
    }
    @Override
    public int getCount() {
        return mangtruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return mangtruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class Holder {
        TextView txttentruyen;
        TextView txttacgia;
        TextView txtsochuong;
        ImageView imghinhanh;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.dongtruyentheotheloai, null);
            holder = new Holder();
            holder.txttentruyen = convertView.findViewById(R.id.textviewtentruyen);
            holder.txttacgia = convertView.findViewById(R.id.textviewtacgia);
            holder.txtsochuong = convertView.findViewById(R.id.textviewchuong);
            holder.imghinhanh = convertView.findViewById(R.id.imageview);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final Laytruyentheotheloai laytruyentheotheloai = mangtruyen.get(position);
        holder.txttentruyen.setText(laytruyentheotheloai.getTenTruyen());
        holder.txttacgia.setText("Tác giả: " + laytruyentheotheloai.getTacGia());
        holder.txtsochuong.setText("Cập nhật đến: Chap " + laytruyentheotheloai.getSoTruong());
        Picasso.with(context).load(mangtruyen.get(position).getHinhTruyen()).into(holder.imghinhanh);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, chitiettruyenActivity.class);
                intent.putExtra("truyen", Integer.valueOf(mangtruyen.get(position).getIdTruyen()));
                context.startActivity(intent);
            }
        });
        return convertView;

    }
}
