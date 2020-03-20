package dev.syafii.gojakarta.controller.puskesmas;

import java.util.List;

import dev.syafii.gojakarta.base.BaseModel;
import dev.syafii.gojakarta.base.BasePresenter;
import dev.syafii.gojakarta.base.BaseView;
import dev.syafii.gojakarta.model.PuskesmasData;

public interface PuskesmasContract {
    interface View extends BaseView<Presenter> {
        void initView();
        void showLoading();
        void hideLoading();
        void setPuskesmasData(List<PuskesmasData> puskesmasDataList);
        void showError(String message);
    }

    interface Presenter extends BasePresenter{
        void getPuskesmasList();
    }

    interface Model extends BaseModel{
        void getPuskesmasList(OnFinishedListener<List<PuskesmasData>> listener);
    }
}
