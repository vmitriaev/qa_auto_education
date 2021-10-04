package ru.tinkoff.edu.controller;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import ru.tinkoff.edu.domain.Region;

public interface RegionController {

    @GET("regions/{id}")
    @Headers("X-API-VERSION:1")
    Call<Region> getRegion(@Path("id") Integer id, @Header("Authorization") String authorization);

}
