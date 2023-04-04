package babysitting.nannyservice.controller;

import babysitting.nannyservice.domain.Bookings;
import babysitting.nannyservice.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingsController {
    @Autowired
    private BookingsService bookingsService;

    @GetMapping
    public String listNannies(Model model) {
        List<Bookings> booking = bookingsService.findAll();
        model.addAttribute("bookings", booking);
        return "nanny_list";
    }

    @GetMapping("/add")
    public String showAddNannyForm(Model model) {
        model.addAttribute("bookings", new Bookings());
        return "nanny_add";
    }

    @PostMapping("/add")
    public String saveNanny(@ModelAttribute("bookings") Bookings bookings) {
        bookingsService.save(bookings);
        return "redirect:/bookings";
    }
}
