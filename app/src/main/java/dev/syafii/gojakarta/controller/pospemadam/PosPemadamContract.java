package dev.syafii.gojakarta.controller.pospemadam;

import java.util.List;

import dev.syafii.gojakarta.base.BaseModel;
import dev.syafii.gojakarta.base.BasePresenter;
import dev.syafii.gojakarta.base.BaseView;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;

public interface PosPemadamContract {
    interface View extends BaseView<Presenter> {
        void initView();
        void showLoading();
        void hideLoading();
        void setPemadamData(List<PosPemadamData> pemadamDataList);
        void showError(String message);
    }

    interface Presenter extends BasePresenter {
        void getPemadamList();
    }

    interface Model extends BaseModel {
        void getPemadamList(OnFinishedListener<List<PosPemadamData>> listener);
    }
}
