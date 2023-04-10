package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.services.ListNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListNanniesController {

    private final ListNanniesService listAllNanniesService;

    @Autowired
    public ListNanniesController(ListNanniesService listAllNanniesService) {
        this.listAllNanniesService = listAllNanniesService;
    }

    @GetMapping("/showAllNannies")
    public String getListAllNannies(Model model) {
        List<Nanny> nannies = listAllNanniesService.getNannies();
        model.addAttribute("nannies", nannies);
        return "nanniesList";
    }


}
