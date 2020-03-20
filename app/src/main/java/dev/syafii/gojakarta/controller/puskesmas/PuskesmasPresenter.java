package dev.syafii.gojakarta.controller.puskesmas;

import java.util.List;

import dev.syafii.gojakarta.base.BaseModel;
import dev.syafii.gojakarta.model.PuskesmasData;

public class PuskesmasPresenter implements PuskesmasContract.Presenter {

    private final PuskesmasContract.View view;
    private final PuskesmasContract.Model model;

    public PuskesmasPresenter(PuskesmasContract.View view, PuskesmasContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getPuskesmasList() {
        view.showLoading();
        model.getPuskesmasList(new BaseModel.OnFinishedListener<List<PuskesmasData>>() {
            @Override
            public void onSuccess(List<PuskesmasData> data) {
                view.hideLoading();
                view.setPuskesmasData(data);
            }

            @Override
            public void onFailure(String message) {
                view.hideLoading();
                view.showError(message);
            }
        });
    }

    @Override
    public void start() {
        view.initView();
    }
}
