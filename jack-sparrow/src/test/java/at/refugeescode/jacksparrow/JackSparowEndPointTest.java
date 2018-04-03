package at.refugeescode.jacksparrow;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class JackSparowEndPointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SpyBean
    private JackSparowEndPoint jackSparowEndPoint;

    private String endpoint1 = "/ jacksparow-url";
    private String endpoint2 = "/jacksparow-chest";

    private String url1;
    private String url2;

    @BeforeEach
    void before1() {
        // prepares the URL of our endpoint
        url1 = "http://localhost:" + port + endpoint1;
    }

    @BeforeEach
    void before2() {
        // prepares the URL of our endpoint
        url2 = "http://localhost:" + port + endpoint2;
    }


    @Test
    void getUrl() {
        ResponseEntity<String> response = restTemplate.getForEntity(url1, String.class);

        String chectUrl = response.getBody();
        System.out.println(chectUrl);
        System.out.println("-------------------");

        assertEquals("http://localhost:8082/dutchman", chectUrl);
        verify(jackSparowEndPoint).getUrl();

    }

    @Test
    void getChest() {

        ResponseEntity<String> response = restTemplate.getForEntity(url2, String.class);

        String chest = response.getBody();

        assertEquals("Congrtulation you found the chest", chest);
        verify(jackSparowEndPoint).getUrl();

    }
}