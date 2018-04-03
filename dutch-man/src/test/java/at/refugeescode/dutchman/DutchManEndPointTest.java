package at.refugeescode.dutchman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class DutchManEndPointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SpyBean
    private DutchManEndPoint dutchManEndPoint;

    private String endpoint = "/dutchman";

    private String url;

    @BeforeEach
    void before() {
        // prepares the URL of our endpoint
        url = "http://localhost:" + port + endpoint;
    }


    @Test
    void getChest() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String chest = response.getBody();

        assertEquals(chest, "Congrtulation you found the chest");
        verify(dutchManEndPoint).getChest();

    }
}