package babysitting.nannyservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class WelcomeController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/about_us")
    public String about_us() {
        return "about_us";
    }

    @GetMapping("/testimonials")
    public String testimonials() {
        return "testimonials";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contact_us")
    public String contact_us() {
        return "contact_us";
    }


    @GetMapping("/find_a_nanny")
    public String fina_a_nanny() {
        return "find_a_nanny";
    }


}

