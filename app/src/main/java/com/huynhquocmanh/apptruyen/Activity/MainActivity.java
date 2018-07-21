package com.huynhquocmanh.apptruyen.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huynhquocmanh.apptruyen.Adapter.MainViewPagerAdapter;
import com.huynhquocmanh.apptruyen.Fragment.Fragment_TheLoai;
import com.huynhquocmanh.apptruyen.Fragment.Fragment_Tiemkiem;
import com.huynhquocmanh.apptruyen.Fragment.Fragment_TrangTru;
import com.huynhquocmanh.apptruyen.R;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        inint();
    }
    private void inint() {
        MainViewPagerAdapter mainViewPagerAdapter =new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addfragment(new Fragment_TrangTru(),"Trang chủ");
        mainViewPagerAdapter.addfragment(new Fragment_TheLoai(),"Thể loại");
        mainViewPagerAdapter.addfragment(new Fragment_Tiemkiem(),"Tìm Kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.trangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.theloai);
        tabLayout.getTabAt(2).setIcon(R.drawable.search);
    }
    private void Anhxa() {
        tabLayout =findViewById(R.id.mytabLayout);
        viewPager =findViewById(R.id.viewpager);
    }
}
