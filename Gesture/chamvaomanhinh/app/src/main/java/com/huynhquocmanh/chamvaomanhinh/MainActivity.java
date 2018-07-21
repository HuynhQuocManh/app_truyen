package com.huynhquocmanh.chamvaomanhinh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    TextView txt;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageview);
        txt = findViewById(R.id.textview);
        gestureDetector = new GestureDetector(this, new MyGetture());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(MotionEvent.obtain(event));
                return false;
            }
        });

    }

    class MyGetture extends GestureDetector.SimpleOnGestureListener {
        @Override
        //khi chạm lần đầu
        public boolean onDown(MotionEvent e) {
            txt.setText("onDoaw khi chạm lần đầu" + e.toString());
            return super.onDown(e);
        }

        @Override
        //khi chạm du 1 luc
        public boolean onSingleTapUp(MotionEvent e) {
            txt.setText("onSingleTapUp khi chạm du 1 luc" + e.toString());
            return super.onSingleTapUp(e);
        }

        @Override
        //khi chạm vào dữ vào 1 lúc lâu
        public void onShowPress(MotionEvent e) {
            txt.setText("onShowPress khi chạm vào dữ vào 1 lúc lâu" + e.toString());
            super.onShowPress(e);
        }

        @Override
        //ki chạm vào liên tục
        public void onLongPress(MotionEvent e) {
            txt.setText("onLongPress" + e.toString());
            super.onLongPress(e);
        }
    }
}
