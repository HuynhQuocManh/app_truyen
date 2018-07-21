package com.huynhquocmanh.apptruyen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.huynhquocmanh.apptruyen.R;

public class manhinhchoActivity extends AppCompatActivity {
    ImageView imgshool, imgmanga, imglogo;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhcho);
        Anhxa();
        animation();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(manhinhchoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    private void animation() {
        Animation anim_shool = AnimationUtils.loadAnimation(this, R.anim.anim_school);
        imgshool.startAnimation(anim_shool);
        imgmanga.startAnimation(anim_shool);
    }

    private void Anhxa() {
        imglogo = findViewById(R.id.logo);
        imgmanga = findViewById(R.id.manga);
        imgshool = findViewById(R.id.school);
    }
}
