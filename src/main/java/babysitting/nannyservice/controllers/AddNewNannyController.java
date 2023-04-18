package babysitting.nannyservice.controllers;

import babysitting.nannyservice.requests.AddNewNannyRequest;
import babysitting.nannyservice.responses.AddNewNannyResponse;
import babysitting.nannyservice.services.AddNewNannyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AddNewNannyController {


    @Autowired
    private AddNewNannyService service;

    @GetMapping(value = "/home/apply_as_nanny")
    public String showAddNannyForm(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddNewNannyRequest());
        modelMap.addAttribute("numbers", IntStream.rangeClosed(0, 30).boxed().collect(Collectors.toList()));
        return "apply_as_nanny";
    }

    @PostMapping("/home/apply_as_nanny")
    public String processAddNannyProfileRequest(@ModelAttribute(value = "request") AddNewNannyRequest request, ModelMap modelMap) {
        AddNewNannyResponse response = service.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "apply_as_nanny";
        } else {
            return "redirect:/success_add_nanny";
        }
    }

    @GetMapping("/success_add_nanny")
    public String testimonials() {
        return "success_add_nanny";
    }
}
