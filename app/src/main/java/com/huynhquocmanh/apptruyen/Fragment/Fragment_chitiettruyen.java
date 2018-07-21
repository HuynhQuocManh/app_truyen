package com.huynhquocmanh.apptruyen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Activity.NoidungtruyenActivity;
import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.Chuong;
import com.huynhquocmanh.apptruyen.Model.Truyenvachitiettheoid;
import com.huynhquocmanh.apptruyen.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_chitiettruyen extends Fragment {
    TextView txttentruyen, txttacgia, txtmota;
    ImageView imghinhanh,imgyeuthich;
    Button btnxem;
    View view;
    public static ArrayList<ArrayList<Truyenvachitiettheoid>> mangtruyen = new ArrayList<ArrayList<Truyenvachitiettheoid>>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chitiettruyen, container, false);
        Anhxa();

        imgyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgyeuthich.setImageResource(R.drawable.like);
                DataService dataService= APIService.getdata();
                Call<String> callback =dataService.Updateyeuthich("1",chitiettruyenActivity.idtruyen);
           callback.enqueue(new Callback<String>() {
               @Override
               public void onResponse(Call<String> call, Response<String> response) {
                   String ketqua = response.body();
                   if(ketqua.equals("Success")){
                       Toast.makeText(getActivity(), "Đã thích", Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(getActivity(), "Lỗi", Toast.LENGTH_SHORT).show();
                   }
                   imghinhanh.setEnabled(false);
               }

               @Override
               public void onFailure(Call<String> call, Throwable t) {

               }
           });
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getDatatruyen(chitiettruyenActivity.idtruyen);
        btnxem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatanoidungchuong(chitiettruyenActivity.idtruyen);
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    private void Anhxa() {
        txtmota = view.findViewById(R.id.textviewgioithieu);
        txttentruyen = view.findViewById(R.id.textviewTentruyen);
        txttacgia = view.findViewById(R.id.textviewtacgia);
        btnxem = view.findViewById(R.id.buttonxem);
        imghinhanh = view.findViewById(R.id.imagetruyen);
        imgyeuthich = view.findViewById(R.id.yeuthich);
    }

    private void getDatatruyen(final int idtruyen) {
        DataService dataService = APIService.getdata();
        Call<List<Truyenvachitiettheoid>> callback = dataService.Getchitiettruyen(idtruyen);
        callback.enqueue(new Callback<List<Truyenvachitiettheoid>>() {
            @Override
            public void onResponse(Call<List<Truyenvachitiettheoid>> call, Response<List<Truyenvachitiettheoid>> response) {
                ArrayList<Truyenvachitiettheoid> truyenvachitiettheoids = (ArrayList<Truyenvachitiettheoid>) response.body();
                txttentruyen.setText(truyenvachitiettheoids.get(0).getTenTruyen());
                txttacgia.setText("Tác giả: " + truyenvachitiettheoids.get(0).getTacGia());
                txtmota.setText(truyenvachitiettheoids.get(0).getMoTaTruyen());
                Picasso.with(getActivity()).load(truyenvachitiettheoids.get(0).getHinhTruyen()).into(imghinhanh);
            }

            @Override
            public void onFailure(Call<List<Truyenvachitiettheoid>> call, Throwable t) {

            }
        });
    }
    private void  getDatanoidungchuong(final int idtruyen){
        DataService dataService = APIService.getdata();
        Call<List<Chuong>> callback = dataService.Getchuong(idtruyen);
        callback.enqueue(new Callback<List<Chuong>>() {
            @Override
            public void onResponse(Call<List<Chuong>> call, Response<List<Chuong>> response) {
                List<Chuong> tenchuong = response.body();
                String noidungtruyen = tenchuong.get(0).getNoiDungTruong();
                Intent intent = new Intent(getActivity(),NoidungtruyenActivity.class);
                intent.putExtra("noidungchuong",noidungtruyen);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Chuong>> call, Throwable t) {

            }
        });
    }
}
