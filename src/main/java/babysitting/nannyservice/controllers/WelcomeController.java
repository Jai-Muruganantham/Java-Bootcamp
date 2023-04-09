package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.services.ShowAllNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
        return "login";
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

}
