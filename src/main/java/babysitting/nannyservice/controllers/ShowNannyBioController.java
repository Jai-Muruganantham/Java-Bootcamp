package babysitting.nannyservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowNannyBioController {

    @GetMapping("/nannysbio")
    public String bio() {
        return "bioofnanny";
    }
}
