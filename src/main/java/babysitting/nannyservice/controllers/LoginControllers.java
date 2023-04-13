package babysitting.nannyservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControllers {
    @GetMapping("/api/v1/auth/register")
    public String register() {
        return "register";
    }
    @GetMapping("/api/v1/auth/authenticate")
    public String loginPage() {
        return "login_v2";
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
