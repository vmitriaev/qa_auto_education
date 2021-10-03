package ru.tinkoff.edu;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.tinkoff.edu.controller.RegionController;
import ru.tinkoff.edu.controller.UserJWTController;
import ru.tinkoff.edu.domain.Region;
import ru.tinkoff.edu.models.TokenRequestDto;
import ru.tinkoff.edu.models.TokenResponseDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.tinkoff.edu.Dictionary.BASE_URL;
import static ru.tinkoff.edu.Dictionary.PATH;
import static ru.tinkoff.edu.Dictionary.PORT;
import static ru.tinkoff.edu.Dictionary.clientLogin;
import static ru.tinkoff.edu.Dictionary.clientPassword;
import static ru.tinkoff.edu.Dictionary.clientRememberFlag;

public class GetRegionByIdTests {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager em;
    private TokenResponseDto token;
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(BASE_URL + PORT + PATH)
            .build();
    private UserJWTController service = retrofit.create(UserJWTController.class);
    private RegionController regionService = retrofit.create(RegionController.class);
    private static String regionName = "RegionNamee";
    Region region;

    @BeforeEach
    public void setUpDB() throws IOException {


        region = new Region()
                .setRegionName(regionName);
        entityManagerFactory = Persistence.createEntityManagerFactory("dboNew");
        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        token = service.getToken(new TokenRequestDto()
                .setPassword(clientPassword)
                .setRememberMe(clientRememberFlag)
                .setUsername(clientLogin)).execute().body();
    }

    @AfterEach
    public void cleanUp() {
        em.getTransaction().begin();
        final Region savedRegion = em.find(Region.class, region.getId());
        em.remove(savedRegion);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void checkCreatingClient() throws IOException {
        Region newRegion = regionService
                .getRegion(region.getId(), "Bearer " + token.getIdToken()).execute().body();
        checkRegion(newRegion);

    }

    public void checkRegion(Region newRegion) {
        assertEquals(region.getId(), newRegion.getId());
        assertEquals(regionName, newRegion.getRegionName());
    }

}
