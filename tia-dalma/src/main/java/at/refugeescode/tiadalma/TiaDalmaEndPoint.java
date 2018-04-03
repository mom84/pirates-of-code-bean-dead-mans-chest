package at.refugeescode.tiadalma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TiaDalmaEndPoint {

//    @Value("${DutchManUrl}")
//    private String urlDutcMan;

    @GetMapping("/tiadalam")
    String getUrl(){
        return "http://localhost:8082/dutchman";
    }


}
