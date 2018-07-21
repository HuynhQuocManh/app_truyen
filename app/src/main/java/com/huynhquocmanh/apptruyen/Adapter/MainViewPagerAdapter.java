package com.huynhquocmanh.apptruyen.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayfragment =new ArrayList<>();
    private ArrayList<String> arraytitle =new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayfragment.get(position);
    }
    @Override
    public int getCount() {
        return arrayfragment.size();
    }
    public void addfragment(Fragment fragment,String title){
        arrayfragment.add(fragment);
        arraytitle.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
