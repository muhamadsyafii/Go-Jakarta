package dev.syafii.gojakarta.controller.pospemadam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;
import dev.syafii.gojakarta.util.CustomToolbar;

import static dev.syafii.gojakarta.util.Constant.KEY_DATA;

public class PosPemadamDetailActivity extends AppCompatActivity {

    public String TAG = "PosPemadamDetailActivity";
    private PosPemadamData pemadamData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_pemadam_detail);
        ButterKnife.bind(this);
        CustomToolbar.setupToolbar(this, "Pos Pemadam Kebakaran Detail");
        Gson gson = new Gson();

        String json = getIntent().getStringExtra(KEY_DATA);
        Log.e(TAG, "onCreate: " + json );

        pemadamData = gson.fromJson(json, PosPemadamData.class);
    }

    @OnClick(R.id.ll_direction)
    public void onDirectionClick(){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("geo:" + pemadamData.getLAT() + "," + pemadamData.getLNG()
                + "?q=" + + pemadamData.getLAT() + "," + pemadamData.getLNG()));
        startActivity(intent);
    }
}
