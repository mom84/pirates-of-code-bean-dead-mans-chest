package at.refugeescode.dutchman;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dutchman")
public class DutchManEndPoint {



    @GetMapping
    String getChest(){
        return "Congrtulation you found the chest";
    }


}
