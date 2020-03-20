package dev.syafii.gojakarta.network;

import dev.syafii.gojakarta.model.PuskesmasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("Content-Type:application/json")
    @GET("puskesmas")
    Call<PuskesmasResponse> getPuskesmas(@Header("Authorization") String authToken);

}
