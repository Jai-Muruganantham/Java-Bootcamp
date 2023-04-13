package babysitting.nannyservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/api/v1/auth/register")
    public String register() {
        return "register";
    }
    @GetMapping("/api/v1/auth/authenticate")
    public String loginPage() {
        return "login_v2";
    }
    @GetMapping("/home")
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
/*    @GetMapping("/apply_as_nanny")
    public String apply_as_nanny() {
        return "apply_as_nanny";
    }*/
    @GetMapping("/find_a_nanny")
    public String fina_a_nanny() {
        return "find_a_nanny";
    }

    @GetMapping("/demonannyaddedtext")
    public String demonannyaddedtext() {
        return "demonannyaddedtext";
    }

}
