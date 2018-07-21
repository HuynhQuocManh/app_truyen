package com.huynhquocmanh.apptruyen.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Adapter.truyenmoiAdapter;
import com.huynhquocmanh.apptruyen.Model.ThuNghiem;
import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_chuongmoi  extends Fragment {
    RecyclerView recyclerView;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chuongmoi,container,false);
        recyclerView = view.findViewById(R.id.recyclerviewchuongmoi);
        Getdata();
        return view;
    }
        private void Getdata() {
            DataService dataService = APIService.getdata();
            Call<List<ThuNghiem>> callback = dataService.Getdatachuongmoi();
            callback.enqueue(new Callback<List<ThuNghiem>>() {
                @Override
                public void onResponse(Call<List<ThuNghiem>> call, Response<List<ThuNghiem>> response) {
                    List<ThuNghiem> chuongmoi = response.body();
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    truyenmoiAdapter truyenmoiAdapter = new truyenmoiAdapter(getActivity(), (ArrayList<ThuNghiem>) chuongmoi);
                    recyclerView.setAdapter(truyenmoiAdapter);
                }

                @Override
                public void onFailure(Call<List<ThuNghiem>> call, Throwable t) {

                }
            });
    }
}
