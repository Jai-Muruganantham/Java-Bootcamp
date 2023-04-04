package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.services.ShowAllNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShowAllNanniesController {

    private final ShowAllNanniesService showAllNanniesService;

    @Autowired
    public ShowAllNanniesController(ShowAllNanniesService showAllNanniesService) {
        this.showAllNanniesService = showAllNanniesService;
    }

    @GetMapping("/showAllNannies")
    public String getsShowALlNannies(Model model) {
        List<Nanny> nannies = showAllNanniesService.getNannies();
        model.addAttribute("nannies", nannies);
        return "nanniesList";
    }

}
