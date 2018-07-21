package com.huynhquocmanh.apptruyen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huynhquocmanh.apptruyen.R;

public class chitiettruyenActivity extends AppCompatActivity {
    public static   int idtruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiettruyen);
        Intent intent = getIntent();
        idtruyen = intent.getIntExtra("truyen",0);
    }

}
