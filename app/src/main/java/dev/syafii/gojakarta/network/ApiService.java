package dev.syafii.gojakarta.network;

import dev.syafii.gojakarta.model.pospemadam.PosPemadamResponse;
import dev.syafii.gojakarta.model.puskesmas.PuskesmasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("Content-Type:application/json")
    @GET("puskesmas")
    Call<PuskesmasResponse> getPuskesmas(@Header("Authorization") String authToken);

    @Headers("Content-Type:application/json")
    @GET("emergency/pospemadam/")
    Call<PosPemadamResponse> getPosPemadam(@Header("Authorization") String authToken);

}
