package com.huynhquocmanh.cuchivuot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    RelativeLayout relativeLayout;
    int[] manghinhanh = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    int position = 0;
    //khoảng cách vuốt
    int SWIPE_THRESHOLD = 50;
    //vận tốc vuốt
    int SWIPE_VELOCITY_THRESHOLD = 50;
    GestureDetector gestureDetector;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageview);
        relativeLayout = findViewById(R.id.manhinh);
        img.setImageResource(manghinhanh[position]);
        gestureDetector = new GestureDetector(this, new mygesture());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class mygesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        //e1 vị trí lần đầu tiên chạm
        //e2 vị trí khi buông tay
        //velocityX vận tốc khi kéo chiều ngang
        //velocityy vận tốc khi kéo chiều dọc
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //kéo từ trái sang phải
            if (e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                Toast.makeText(MainActivity.this, "từ trái sang phải", Toast.LENGTH_SHORT).show();
//                position--;
//                if (position < 0) {
//                    position = manghinhanh.length - 1;
//                }
//                img.setImageResource(manghinhanh[position]);
            }
            //kéo từ phải sang trái
            if (e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                Toast.makeText(MainActivity.this, "kéo từ phải sang trái", Toast.LENGTH_SHORT).show();
         //       position++;
//                if (position < manghinhanh.length - 1) {
//                    position = 0;
//                }
//                img.setImageResource(manghinhanh[position]);
            }
            //kéo từ trên xuống dưới
            if (e2.getY() - e1.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                Toast.makeText(MainActivity.this, "kéo từ trên xuống dưới", Toast.LENGTH_SHORT).show();
            }
            //kéo từ dưới lên trên
            if (e1.getY() - e2.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                Toast.makeText(MainActivity.this, "kéo từ dưới lên trên", Toast.LENGTH_SHORT).show();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
