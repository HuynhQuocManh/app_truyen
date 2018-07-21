package com.huynhquocmanh.apptruyen.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynhquocmanh.apptruyen.API.APIService;
import com.huynhquocmanh.apptruyen.API.DataService;
import com.huynhquocmanh.apptruyen.Adapter.GioithieuAdapter;
import com.huynhquocmanh.apptruyen.Model.Gioithieu;
import com.huynhquocmanh.apptruyen.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_gioithieu extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    GioithieuAdapter gioithieuAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.framgmen_gioithieu, container, false);
        Anhxa();
        GetData();
        return view;
    }

    private void Anhxa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.circleindicator);
    }

    private void GetData() {
        DataService dataService = APIService.getdata();
        Call<List<Gioithieu>> callback = dataService.Getdatagioithieu();
        callback.enqueue(new Callback<List<Gioithieu>>() {
            @Override
            public void onResponse(Call<List<Gioithieu>> call, Response<List<Gioithieu>> response) {
                ArrayList<Gioithieu> gioithieu = (ArrayList<Gioithieu>) response.body();
                gioithieuAdapter = new GioithieuAdapter(getActivity(), gioithieu);
                viewPager.setAdapter(gioithieuAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem > viewPager.getAdapter().getCount()){
                            currentItem =0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Gioithieu>> call, Throwable t) {
                Log.d("ccc", t + "");
            }
        });
    }
}
