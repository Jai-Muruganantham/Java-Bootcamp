package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.services.ShowAllNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "showAllNannies")
public class ShowAllNanniesController {


    private final ShowAllNanniesService showAllNanniesService;

    @Autowired
    public ShowAllNanniesController(ShowAllNanniesService showAllNanniesService) {
        this.showAllNanniesService = showAllNanniesService;
    }

    @GetMapping
    public List<Nanny> getNannyMapping() {
        return showAllNanniesService.getNannies();
    }

    @GetMapping("/showAllNannies")
    public String getNannyTable (Model model) {
        List<Nanny> nannies = showAllNanniesService.getNannies();
        model.addAttribute("nannies", nannies);
        return "showAllNannies";
    }

}


