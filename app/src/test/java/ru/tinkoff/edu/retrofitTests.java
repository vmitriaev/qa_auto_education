package com.acme.dbo.retrofitTests;

import com.acme.dbo.ClientDto;
import com.acme.dbo.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.acme.dbo.ClientEndpoints.BASE_URL;
import static com.acme.dbo.ClientEndpoints.PATH;
import static com.acme.dbo.ClientEndpoints.PORT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class retrofitTests {

//    ClientDto client;
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl("http://31.131.249.140" + ':' + 8080 + "/api/authenticate")
            .build();
    ClientService service = retrofit.create(ClientService.class);
    private String clientLogin = "adminTest1234@email.com";
    private String clientSalt = "some-salt";
    private String clientSecret = "749f09bade8aca7556749f09bade8aca7556";

    @AfterEach
    public void cleanUp() throws IOException {
        service.deleteClient(client.getId()).execute();
    }

    @Test
    public void checkCreatingClient() throws IOException {
        client = service.createClient(new ClientDto()
                .setLogin(clientLogin)
                .setSalt(clientSalt)
                .setSecret(clientSecret)).execute().body();
        checkClientCreation(client);

    }

    public void checkClientCreation(ClientDto client) throws IOException {
        List<ClientDto> clients = service.getClients().execute().body();
        assertTrue(clients.stream()
                .anyMatch(clientDto -> String.valueOf(clientDto.getId()).equals(String.valueOf(client.getId()))));
        assertNotNull(client.getId());
        assertEquals(clientLogin, client.getLogin());
        assertEquals(clientSecret, client.getSecret());
        assertEquals(clientSalt, client.getSalt());
    }

}
