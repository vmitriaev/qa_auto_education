package ru.tinkoff.edu.controller;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.tinkoff.edu.models.TokenRequestDto;
import ru.tinkoff.edu.models.TokenResponseDto;

public interface UserJWTController {

    @POST("authenticate")
    @Headers("X-API-VERSION:1")
    Call<TokenResponseDto> getToken(@Body TokenRequestDto tokenRequestDto);

}
