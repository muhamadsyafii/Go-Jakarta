package dev.syafii.gojakarta.controller.pospemadam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.controller.puskesmas.PuskesmasDetailActivity;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;
import dev.syafii.gojakarta.util.CustomProgressBar;
import dev.syafii.gojakarta.util.CustomToolbar;
import dev.syafii.gojakarta.util.ItemClickListener;
import es.dmoral.toasty.Toasty;

import static dev.syafii.gojakarta.util.Constant.KEY_DATA;

public class PosPemadamActivity extends AppCompatActivity implements PosPemadamContract.View {

    private PosPemadamContract.Presenter presenter;

    @BindView(R.id.rv_posPemadam)
    RecyclerView rvPosPemadam;
    @BindView(R.id.srf_posPemadam)
    SwipeRefreshLayout swipeRefresh;

    PosPemadamAdapter posPemadamAdapter;
    CustomProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_pemadam);
        ButterKnife.bind(this);
        progressBar = new CustomProgressBar(this);
        CustomToolbar.setupToolbar(this, "Pos Pemadam Kebakaran");

        presenter = new PosPemadamPresenter(this, new PosPemadamModel());
        presenter.start();
    }

    @Override
    public void initView() {
        posPemadamAdapter = new PosPemadamAdapter(this, new ArrayList<PosPemadamData>());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvPosPemadam.setLayoutManager(manager);
        rvPosPemadam.setItemAnimator(new DefaultItemAnimator());
        rvPosPemadam.setNestedScrollingEnabled(true);
        rvPosPemadam.setAdapter(posPemadamAdapter);

        swipeRefresh.setOnRefreshListener(() -> {
            showLoading();
            presenter.getPemadamList();
//            swipeRefresh.setRefreshing(false);
            hideLoading();
        });

        posPemadamAdapter.setItemClickListener(new ItemClickListener<PosPemadamData>() {
            @Override
            public void onItemClick(PosPemadamData data) {
                Intent intent = new Intent(PosPemadamActivity.this, PosPemadamDetailActivity.class);
                intent.putExtra(KEY_DATA, new Gson().toJson(data));
                startActivity(intent);
            }
        });

        presenter.getPemadamList();
    }

    @Override
    public void showLoading() {
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        if (swipeRefresh !=null) swipeRefresh.setRefreshing(false);
        progressBar.hide();
    }

    @Override
    public void setPemadamData(List<PosPemadamData> pemadamDataList) {
        posPemadamAdapter.setPosPemadamDataList(pemadamDataList);
    }

    @Override
    public void showError(String message) {
        Toasty.error(this, message, Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(PosPemadamContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
