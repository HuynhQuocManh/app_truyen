package com.huynhquocmanh.sukienlac;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeDectectorc implements SensorEventListener {
    float SHAKE_THRESHOLD_GRAVITY = 2.0f;
    int SHAKE_SLOP_TIME_MS = 500;
    int SHAKE_COUNT_RESET_TIME_MS = 3000;
    public OnShakeListener listener;
    public long mShakeTimetamp;
    public int mShekecount;

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.listener = onShakeListener;
    }

    public interface OnShakeListener {
        public void onShake(int count);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (listener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float gx = x / SensorManager.GRAVITY_EARTH;
            float gy = y / SensorManager.GRAVITY_EARTH;
            float gz = z / SensorManager.GRAVITY_EARTH;
            float fForce = (float) Math.sqrt(gx * gx + gy * gy + gz * gz);
            if (fForce > SHAKE_THRESHOLD_GRAVITY) {
                long now = System.currentTimeMillis();
                if (mShakeTimetamp + SHAKE_SLOP_TIME_MS > now) {
                    return;
                }
                if (mShakeTimetamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                    mShekecount = 0;
                }
                mShakeTimetamp = now;
                mShekecount++;
                listener.onShake(mShekecount);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
