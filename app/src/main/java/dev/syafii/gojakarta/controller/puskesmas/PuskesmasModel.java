package dev.syafii.gojakarta.controller.puskesmas;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dev.syafii.gojakarta.model.PuskesmasData;
import dev.syafii.gojakarta.model.PuskesmasResponse;
import dev.syafii.gojakarta.network.ApiService;
import dev.syafii.gojakarta.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static dev.syafii.gojakarta.util.Constant.MESSAGE_ERROR_REQUEST;
import static dev.syafii.gojakarta.util.Constant.TOKEN;

public class PuskesmasModel implements PuskesmasContract.Model {
    @Override
    public void getPuskesmasList(final OnFinishedListener<List<PuskesmasData>> listener) {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<PuskesmasResponse> call = service.getPuskesmas(TOKEN);
        call.enqueue(new Callback<PuskesmasResponse>() {
            @Override
            public void onResponse(@NotNull Call<PuskesmasResponse> call, @NotNull Response<PuskesmasResponse> response) {
                if (response.isSuccessful() && response.body() !=null){
                    if (response.body().getStatus().equals("success")){
                        List<PuskesmasData> data = response.body().getData();
                        listener.onSuccess(data);
                    }else {
                        listener.onFailure(response.body().getStatus());
                    }
                }else {
                    listener.onFailure(MESSAGE_ERROR_REQUEST);
                }
            }

            @Override
            public void onFailure(@NotNull Call<PuskesmasResponse> call, @NotNull Throwable t) {
                listener.onFailure(MESSAGE_ERROR_REQUEST);
                Log.d("getPuskesmasList", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
