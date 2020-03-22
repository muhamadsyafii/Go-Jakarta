package dev.syafii.gojakarta.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.controller.pospemadam.PosPemadamActivity;
import dev.syafii.gojakarta.controller.puskesmas.PuskesmasActivity;
import dev.syafii.gojakarta.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_posPemadam)
    Button btnPosPemadam;
    @BindView(R.id.btn_puskesmas)
    Button btnPuskesmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnPosPemadam.setOnClickListener(v -> {
            ActivityUtils.openActivity(this, PosPemadamActivity.class);
        });

        btnPuskesmas.setOnClickListener(v -> {
            ActivityUtils.openActivity(this, PuskesmasActivity.class);
        });
    }
}
