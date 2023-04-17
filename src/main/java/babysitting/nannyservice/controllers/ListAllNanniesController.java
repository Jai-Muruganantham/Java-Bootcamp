package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.requests.ListAllNanniesRequest;
import babysitting.nannyservice.responses.ListAllNanniesResponse;
import babysitting.nannyservice.services.ListAllNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListAllNanniesController {

    private final ListAllNanniesService listAllNanniesService;

    @Autowired
    public ListAllNanniesController(ListAllNanniesService listAllNanniesService) {
        this.listAllNanniesService = listAllNanniesService;
    }

    @GetMapping("/showAllNannies")
    public String getListAllNannies(ModelMap modelMap) {
        ListAllNanniesResponse response = listAllNanniesService.execute(new ListAllNanniesRequest());
        modelMap.addAttribute("nannies", response.getNannies());
        return "nanniesList";
    }

}
