package com.huynhquocmanh.apptruyen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Activity.NoidungtruyenActivity;
import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Model.Chuong;
import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_listchuong extends Fragment {
    View view;
    ListView listView;
    public static String noidungchuong;
int Position;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listchuong, container, false);
        listView = view.findViewById(R.id.listviewchuong);

        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Getdatachuong(chitiettruyenActivity.idtruyen);
        super.onActivityCreated(savedInstanceState);
    }

    private void Getdatachuong(int idtruyen) {
        DataService dataService = APIService.getdata();
        Call<List<Chuong>> callback = dataService.Getchuong(idtruyen);
        callback.enqueue(new Callback<List<Chuong>>() {
            @Override
            public void onResponse(Call<List<Chuong>> call, Response<List<Chuong>> response) {
                final List<Chuong> tenchuong = response.body();
                final ArrayList<String> mangtenchuong = new ArrayList<>();
                for(int i=0;i<tenchuong.size();i++){
                mangtenchuong.add(tenchuong.get(i).getTenChuong());
                }
                ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mangtenchuong);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), NoidungtruyenActivity.class);
                        noidungchuong = tenchuong.get(0).getNoiDungTruong();
                        intent.putExtra("noidungchuong",tenchuong.get(position).getNoiDungTruong());
                        intent.putExtra("mangtenchuong",mangtenchuong);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Chuong>> call, Throwable t) {

            }
        });
    }
}
