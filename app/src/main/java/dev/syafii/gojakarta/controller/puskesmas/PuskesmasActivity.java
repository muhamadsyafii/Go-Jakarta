package dev.syafii.gojakarta.controller.puskesmas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.model.PuskesmasData;
import dev.syafii.gojakarta.util.CustomProgressBar;
import dev.syafii.gojakarta.util.CustomToolbar;
import dev.syafii.gojakarta.util.ItemClickListener;
import es.dmoral.toasty.Toasty;

import static dev.syafii.gojakarta.util.Constant.KEY_DATA;

public class PuskesmasActivity extends AppCompatActivity implements PuskesmasContract.View {

    private PuskesmasContract.Presenter presenter;

    @BindView(R.id.rv_puskesmas)
    RecyclerView rvPuskesmas;
    @BindView(R.id.srf_puskesmas)
    SwipeRefreshLayout swipeRefresh;

    List<PuskesmasData> puskesmasDataList;
    private PuskesmasAdapter puskesmasAdapter;
    private CustomProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puskesmas);
        ButterKnife.bind(this);
        progressBar = new CustomProgressBar(this);
        CustomToolbar.setupToolbar(this, "Puskesmas");

        presenter = new PuskesmasPresenter(this, new PuskesmasModel());
        presenter.start();
    }

    @Override
    public void initView() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        puskesmasAdapter = new PuskesmasAdapter(this, new ArrayList<PuskesmasData>());
        rvPuskesmas.setLayoutManager(manager);
        rvPuskesmas.setItemAnimator(new DefaultItemAnimator());
        rvPuskesmas.setNestedScrollingEnabled(true);
        rvPuskesmas.setAdapter(puskesmasAdapter);

        swipeRefresh.setOnRefreshListener(() -> {
            showLoading();
            presenter.getPuskesmasList();
            swipeRefresh.setRefreshing(false);
        });

        puskesmasAdapter.setItemClickListener(new ItemClickListener<PuskesmasData>() {
            @Override
            public void onItemClick(PuskesmasData data) {
                Intent intent = new Intent(PuskesmasActivity.this, PuskesmasDetailActivity.class);
                intent.putExtra(KEY_DATA, new Gson().toJson(data));
                startActivity(intent);
            }
        });

        presenter.getPuskesmasList();
    }

    @Override
    public void showLoading() {
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        progressBar.hide();
    }

    @Override
    public void setPuskesmasData(List<PuskesmasData> puskesmasDataList) {
//        this.puskesmasDataList = puskesmasDataList;
        puskesmasAdapter.setPuskesmasDataList(puskesmasDataList);
    }

    @Override
    public void showError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(PuskesmasContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
