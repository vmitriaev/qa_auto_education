package ru.tinkoff.edu;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.tinkoff.edu.controller.UserJWTController;
import ru.tinkoff.edu.domain.Region;
import ru.tinkoff.edu.models.TokenRequestDto;
import ru.tinkoff.edu.models.TokenResponseDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.tinkoff.edu.Dictionary.BASE_URL;
import static ru.tinkoff.edu.Dictionary.PATH;
import static ru.tinkoff.edu.Dictionary.PORT;
import static ru.tinkoff.edu.Dictionary.clientLogin;
import static ru.tinkoff.edu.Dictionary.clientPassword;
import static ru.tinkoff.edu.Dictionary.clientRememberFlag;

public class getClientTokenTests {

    private static EntityManagerFactory entityManagerFactory;
    TokenResponseDto token;
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(BASE_URL + PORT + PATH)
            .build();
    UserJWTController service = retrofit.create(UserJWTController.class);

    @BeforeAll
    public static void setUpDB(){

        entityManagerFactory = Persistence.createEntityManagerFactory("dboNew");
        final EntityManager em = entityManagerFactory.createEntityManager();
        System.out.println("Hello world!");
        System.out.println(em.createQuery("SELECT r FROM Region r", Region.class).getResultList());
//        System.out.println(em.find(Region.class, 1));
        em.close();
    }


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
