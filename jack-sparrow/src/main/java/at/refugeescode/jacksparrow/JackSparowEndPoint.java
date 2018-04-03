package at.refugeescode.jacksparrow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class JackSparowEndPoint {

    @Value("${dalmaUrl}")
    private String dalmaurl;


    @GetMapping("/jacksparow-url")
    String getUrl(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(dalmaurl, String.class);
        String dutchUrl = forEntity.getBody();

        return dutchUrl;
    }

    @GetMapping("/jacksparow-chest")
    String getChest(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity( getUrl(), String.class);
        String cheast = forEntity1.getBody();
        return cheast;
    }

}
