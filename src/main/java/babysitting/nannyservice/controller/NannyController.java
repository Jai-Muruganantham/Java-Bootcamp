package babysitting.nannyservice.controller;

import babysitting.nannyservice.model.Nanny;
import babysitting.nannyservice.service.NannyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/nannies")
public class NannyController {
    @Autowired
    private NannyService nannyService;

    @GetMapping
    public String listNannies(Model model) {
        List<Nanny> nannies = nannyService.findAll();
        model.addAttribute("nannies", nannies);
        return "nanny_list";
    }

    @GetMapping("/add")
    public String showAddNannyForm(Model model) {
        model.addAttribute("nanny", new Nanny());
        return "nanny_add";
    }

    @PostMapping("/add")
    public String saveNanny(@ModelAttribute("nanny") Nanny nanny) {
        nannyService.save(nanny);
        return "redirect:/nannies";
    }
}
