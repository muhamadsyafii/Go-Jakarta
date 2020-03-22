package dev.syafii.gojakarta.controller.puskesmas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.model.puskesmas.PuskesmasData;
import dev.syafii.gojakarta.util.ActivityUtils;
import dev.syafii.gojakarta.util.CustomToolbar;
import es.dmoral.toasty.Toasty;

import static dev.syafii.gojakarta.util.Constant.KEY_DATA;

public class PuskesmasDetailActivity extends AppCompatActivity {

    private static final String TAG = "PuskesmasDetailActivity";
    @BindView(R.id.tv_callPuskesmas)
    TextView tvCall;
    @BindView(R.id.tv_emailPuskesmas)
    TextView tvEmail;
    @BindView(R.id.tv_directionPuskesmas)
    TextView tvMaps;
    @BindView(R.id.tv_addressPuskesmas)
    TextView tvAddress;
    @BindView(R.id.tv_faxPuskesmas)
    TextView tvFax;
    @BindView(R.id.tv_headPuskesmas)
    TextView tvHead;
    @BindView(R.id.tv_namePuskesmas)
    TextView tvName;

    private PuskesmasData puskesmasData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puskesmas_detail);
        ButterKnife.bind(this);
        CustomToolbar.setupToolbar(this, "Puskesmas Detail");
        Gson gson = new Gson();

        String json = getIntent().getStringExtra(KEY_DATA);
        Log.e(TAG, "onCreate: " + json);

        puskesmasData = gson.fromJson(json, PuskesmasData.class);
        Log.e(TAG, "onCreate: " + puskesmasData);


        if (puskesmasData != null) {

            String fax = String.valueOf(puskesmasData.getFaximile());
            char[] chars = fax.toCharArray();
            StringBuilder stringBuilder = new StringBuilder("(021) ");
            stringBuilder.append(chars);
            tvAddress.setText(puskesmasData.getLocation().getAlamat());
            tvFax.setText(stringBuilder);
            tvHead.setText(puskesmasData.getKepalaPuskesmas());
            tvName.setText(puskesmasData.getNamaPuskesmas());
        }
    }

    @OnClick(R.id.tv_callPuskesmas)
    public void onCallClick() {
        ActivityUtils.callNumber(this, "021" + puskesmasData.getTelepon());
    }

    @OnClick(R.id.tv_emailPuskesmas)
    public void onEmailClick() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{puskesmasData.getEmail()});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toasty.info(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.tv_directionPuskesmas)
    public void onDirectionClick() {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("geo:" + puskesmasData.getLocation().getLatitude() + "," + puskesmasData.getLocation().getLongitude()
                + "?q=" + puskesmasData.getNamaPuskesmas()));
        startActivity(intent);
    }

}
