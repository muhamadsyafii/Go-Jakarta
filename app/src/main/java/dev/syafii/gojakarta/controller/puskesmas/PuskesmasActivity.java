package dev.syafii.gojakarta.controller.puskesmas;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.syafii.gojakarta.R;
import dev.syafii.gojakarta.model.PuskesmasData;
import dev.syafii.gojakarta.util.CustomToolbar;
import es.dmoral.toasty.Toasty;

public class PuskesmasActivity extends AppCompatActivity implements PuskesmasContract.View {

    private PuskesmasContract.Presenter presenter;

    @BindView(R.id.rv_puskesmas)
    RecyclerView rvPuskesmas;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.srf_puskesmas)
    SwipeRefreshLayout swipeRefresh;

    List<PuskesmasData> puskesmasDataList;
    private PuskesmasAdapter puskesmasAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puskesmas);
        ButterKnife.bind(this);
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

        presenter.getPuskesmasList();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
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
