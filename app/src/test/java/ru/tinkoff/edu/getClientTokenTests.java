package ru.tinkoff.edu;


import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.tinkoff.edu.controller.UserJWTController;
import ru.tinkoff.edu.models.TokenRequestDto;
import ru.tinkoff.edu.models.TokenResponseDto;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.tinkoff.edu.Dictionary.BASE_URL;
import static ru.tinkoff.edu.Dictionary.PATH;
import static ru.tinkoff.edu.Dictionary.PORT;
import static ru.tinkoff.edu.Dictionary.clientLogin;
import static ru.tinkoff.edu.Dictionary.clientPassword;
import static ru.tinkoff.edu.Dictionary.clientRememberFlag;

public class getClientTokenTests {

    TokenResponseDto token;
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(BASE_URL + PORT + PATH)
            .build();
    UserJWTController service = retrofit.create(UserJWTController.class);

    @Test
    public void checkCreatingClient() throws IOException {
        token = service.getToken(new TokenRequestDto()
                .setPassword(clientPassword)
                .setRememberMe(clientRememberFlag)
                .setUsername(clientLogin)).execute().body();
        checkClientCreation(token);

    }

    public void checkClientCreation(TokenResponseDto token) {
        assertNotNull(token.getIdToken());
    }

}
