package com.huynhquocmanh.apptruyen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Activity.chitiettruyenActivity;
import com.huynhquocmanh.apptruyen.Adapter.theloaiAdapter;
import com.huynhquocmanh.apptruyen.Adapter.truyentheotheloaiAdapter;
import com.huynhquocmanh.apptruyen.Model.Laytruyentheotheloai;
import com.huynhquocmanh.apptruyen.Model.Theloai;
import com.huynhquocmanh.apptruyen.R;
import com.huynhquocmanh.apptruyen.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TheLoai extends Fragment {
    RecyclerView recyclerView;
    View view;
    ListView listView;
    theloaiAdapter theloaiAdapter;
    ArrayList<Theloai> theloais;
    public static ArrayList<Laytruyentheotheloai> truyentheotheloai;
    truyentheotheloaiAdapter truyentheotheloaiAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        listView = view.findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), chitiettruyenActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        laytruyentutheloai();
        return view;
    }
    private void GetData() {
        DataService dataService = APIService.getdata();
        Call<List<Theloai>> callback = dataService.Getdatatheloai();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                theloais = (ArrayList<Theloai>) response.body();
                ArrayList<String> mangtentheloai = new ArrayList<>();
                for (int i = 0; i < theloais.size(); i++) {
                    mangtentheloai.add(theloais.get(i).getTenTheLoai());
                }

                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
                recyclerView.addItemDecoration(dividerItemDecoration);
                theloaiAdapter = new theloaiAdapter(getActivity(), mangtentheloai);
                recyclerView.setAdapter(theloaiAdapter);
                getDatatruyen(0);
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {
            }
        });


    }

    private void laytruyentutheloai() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        getDatatruyen(position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }

    private void getDatatruyen( int position) {
        DataService dataService = APIService.getdata();
        Call<List<Laytruyentheotheloai>> callback = dataService.Gettruyentheotheloai(Integer.valueOf(theloais.get(position).getIdTheLoai()));
        callback.enqueue(new Callback<List<Laytruyentheotheloai>>() {
            @Override
            public void onResponse(Call<List<Laytruyentheotheloai>> call, Response<List<Laytruyentheotheloai>> response) {
                truyentheotheloai = (ArrayList<Laytruyentheotheloai>) response.body();
                truyentheotheloaiAdapter = new truyentheotheloaiAdapter(truyentheotheloai, getActivity());
                listView.setAdapter(truyentheotheloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<Laytruyentheotheloai>> call, Throwable t) {
            }
        });
    }
}
