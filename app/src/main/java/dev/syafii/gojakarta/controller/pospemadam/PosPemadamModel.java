package dev.syafii.gojakarta.controller.pospemadam;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dev.syafii.gojakarta.model.pospemadam.PosPemadamData;
import dev.syafii.gojakarta.model.pospemadam.PosPemadamResponse;
import dev.syafii.gojakarta.network.ApiService;
import dev.syafii.gojakarta.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static dev.syafii.gojakarta.util.Constant.MESSAGE_ERROR_REQUEST;
import static dev.syafii.gojakarta.util.Constant.TOKEN;

public class PosPemadamModel implements PosPemadamContract.Model {
    @Override
    public void getPemadamList(OnFinishedListener<List<PosPemadamData>> listener) {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<PosPemadamResponse> call = service.getPosPemadam(TOKEN);
        call.enqueue(new Callback<PosPemadamResponse>() {
            @Override
            public void onResponse(@NotNull Call<PosPemadamResponse> call, @NotNull Response<PosPemadamResponse> response) {
                Log.e("getPemadamList", "onResponse: " + response.body().getStatus());
                if (response.isSuccessful() && response.body() !=null){
                    if (response.body().getStatus().equals("success")){
                        List<PosPemadamData> pemadamData = response.body().getData();
                        listener.onSuccess(pemadamData);
                    }else {
                        listener.onFailure(response.body().getStatus());
                    }
                }else {
                    listener.onFailure(MESSAGE_ERROR_REQUEST);
                }
            }

            @Override
            public void onFailure(@NotNull Call<PosPemadamResponse> call, @NotNull Throwable t) {
                listener.onFailure(MESSAGE_ERROR_REQUEST);
                Log.e("getPemadamList", "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }
}
