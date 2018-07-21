package com.huynhquocmanh.apptruyen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.Gioithieu;
import com.huynhquocmanh.apptruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GioithieuAdapter extends PagerAdapter {
    Context context;
    ArrayList<Gioithieu> mangquangcao;
    public GioithieuAdapter(Context context, ArrayList<Gioithieu> mangquangcao) {
        this.context = context;
        this.mangquangcao = mangquangcao;
    }

    @Override
    public int getCount() {
        return mangquangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.donggioithieu,null);
        ImageView imgnen;
        TextView txttentruyen,txttacgia;
        imgnen =view.findViewById(R.id.imageviewnenquangcao);
        txttentruyen =view.findViewById(R.id.textviewtentruyen);
        txttacgia =view.findViewById(R.id.textviewtacgia);
        Picasso.with(context).load(mangquangcao.get(position).getHinhAnh()).into(imgnen);
        txttentruyen.setText(mangquangcao.get(position).getTenTruyen());
        txttacgia.setText( "Tác Giả: "+mangquangcao.get(position).getTacGia());
        container.addView(view);
        imgnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, chitiettruyenActivity.class);
                intent.putExtra("truyen", Integer.valueOf(mangquangcao.get(position).getIdTruyen()));
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
