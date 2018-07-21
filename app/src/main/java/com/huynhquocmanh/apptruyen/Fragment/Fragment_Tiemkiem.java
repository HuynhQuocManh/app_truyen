package com.huynhquocmanh.apptruyen.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Adapter.timkiemtruyenAdapter;
import com.huynhquocmanh.apptruyen.Model.Timkiem;
import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Tiemkiem extends Fragment {
    View view;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tiemkiem, container, false);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recyclerviewtimkiem);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.timkiem, menu);
        MenuItem menuItem = menu.findItem(R.id.timkiem);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                timkiemtukhoabaihat(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void timkiemtukhoabaihat(String query) {
        DataService dataService = APIService.getdata();
        Call<List<Timkiem>> callback = dataService.Getdatatimkiem(query);
        callback.enqueue(new Callback<List<Timkiem>>() {
            @Override
            public void onResponse(Call<List<Timkiem>> call, Response<List<Timkiem>> response) {
                ArrayList<Timkiem> mangtruyen = (ArrayList<Timkiem>) response.body();
                if (mangtruyen.size() > 0) {
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    timkiemtruyenAdapter timkiemtruyenAdapter = new timkiemtruyenAdapter(mangtruyen,getActivity());
                    recyclerView.setAdapter(timkiemtruyenAdapter);
                }else {
                    Toast.makeText(getActivity(), "Không Tìm Thấy", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Timkiem>> call, Throwable t) {

            }
        });
    }
}
