package com.huynhquocmanh.phongtothunho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageview);
        scaleGestureDetector = new ScaleGestureDetector(this ,new Mygesture());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class Mygesture extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        float scale = 1.0f,onscaleStart=0,onscaleend =0;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale*=detector.getScaleFactor();
             img.setScaleX(scale);
             img.setScaleY(scale);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Toast.makeText(MainActivity.this, "on scale start", Toast.LENGTH_SHORT).show();
             onscaleStart =scale;
            Log.d("bbb", "gia tri truoc khi bat dau scale"+onscaleStart);
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Toast.makeText(MainActivity.this, "on scale End", Toast.LENGTH_SHORT).show();
            onscaleend =scale;
            Log.d("bbb", "gia tri sau khi scale"+onscaleend);
            super.onScaleEnd(detector);
        }
    }
}
