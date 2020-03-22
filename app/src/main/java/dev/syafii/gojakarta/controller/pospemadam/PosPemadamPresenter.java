package dev.syafii.gojakarta.controller.pospemadam;

import java.util.List;

import dev.syafii.gojakarta.base.BaseModel;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;

public class PosPemadamPresenter implements PosPemadamContract.Presenter {

    private PosPemadamContract.View view;
    private PosPemadamContract.Model model;

    public PosPemadamPresenter(PosPemadamContract.View view, PosPemadamContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getPemadamList() {
        view.showLoading();
        model.getPemadamList(new BaseModel.OnFinishedListener<List<PosPemadamData>>() {
            @Override
            public void onSuccess(List<PosPemadamData> data) {
                view.hideLoading();
                view.setPemadamData(data);
            }

            @Override
            public void onFailure(String message) {
                view.showError(message);
            }
        });
    }

    @Override
    public void start() {
        view.initView();
    }
}
