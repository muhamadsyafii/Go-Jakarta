package dev.syafii.gojakarta.controller.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.controller.puskesmas.PuskesmasActivity;
import dev.syafii.gojakarta.util.ActivityUtils;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ActivityUtils.openActivity(SplashScreenActivity.this, PuskesmasActivity.class);
                finish();
            }
        }, 1000);
    }
}
