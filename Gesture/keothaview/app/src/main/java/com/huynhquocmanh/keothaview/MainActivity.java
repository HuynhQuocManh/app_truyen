package com.huynhquocmanh.keothaview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    int mode = 0;
    int DRAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageview);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(250, 250);
        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 50;
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new View.OnTouchListener() {
            RelativeLayout.LayoutParams params;
            float dx = 0, dy = 0, x = 0, y = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView imageView = (ImageView) v;
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                        dx = event.getRawX() - params.leftMargin;
                        dy = event.getRawY() - params.topMargin;
                        mode= DRAG;
                      break;
                    case MotionEvent.ACTION_MOVE:
                        if(mode==DRAG){
                            x= event.getRawX();
                            y =event.getRawY();
                            params.leftMargin= (int) (x- dx);
                            params.topMargin = (int) (y-dy);
                            params.rightMargin = 0;
                            params.bottomMargin =0;
                            params.rightMargin =params.leftMargin+(5*params.width);
                            params.bottomMargin =params.topMargin+(5*params.height);
                            imageView.setLayoutParams(params);
                        }

                }
                return true;
            }
        });
    }
}
