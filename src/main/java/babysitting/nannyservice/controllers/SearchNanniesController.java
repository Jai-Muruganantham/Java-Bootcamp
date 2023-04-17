package babysitting.nannyservice.controllers;

import babysitting.nannyservice.requests.SearchNanniesRequest;
import babysitting.nannyservice.responses.SearchNannyResponse;
import babysitting.nannyservice.services.SearchNanniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchNanniesController {

    @Autowired
    private final SearchNanniesService service;

    public SearchNanniesController(SearchNanniesService service) {
        this.service = service;
    }

    @GetMapping(value = "/searchNannies")
    public String showListNanniesByCityPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new SearchNanniesRequest());
        return "find_a_nanny_v2";
    }

    @PostMapping("/searchNannies")
    public String processSearchNanniesRequest(@ModelAttribute(value = "request")
                                                  SearchNanniesRequest request, ModelMap modelMap) {
        SearchNannyResponse response = service.execute(request);
        if (response.hasErrors()){
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("nannies", response.getNannies()); //"nannies" is the reference in html template
        }
        return "find_a_nanny_v2";
    }

     /* @GetMapping("/listNanniesByCity")
    public String showNanniesByCity(@RequestParam("city") String city, Model model) {
        List<Nanny> nannies = listAllNanniesService.getNanniesByCity(city);
        model.addAttribute("nannies", nannies);
        return "nannies";
    }*/



   /* @GetMapping("/showListNanniesByCity")
    public String showListNanniesByCity(Model model) {
        List<Nanny> nannies = listAllNanniesService.getNannies();
        model.addAttribute("nannies", nannies);
        return "showlistnanniesbycity";
    }*/


/*


    @PostMapping("/addStudent")
    public String processAddStudentRequest(@ModelAttribute(value = "request") AddStudentRequest request, ModelMap modelMap) {
        AddStudentResponse response = addStudentService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "addStudent";
        } else {
            return "redirect:/welcome";
        }
    }*/




}
