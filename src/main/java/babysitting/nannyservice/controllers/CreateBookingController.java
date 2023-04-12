package babysitting.nannyservice.controllers;

import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.requests.CreateBookingRequest;
import babysitting.nannyservice.responses.CreateBookingResponse;
import babysitting.nannyservice.services.CreateBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateBookingController {
    @Autowired
    private CreateBookingService bookingsService;
    @Autowired
    private JpaNannyRepository nannyRepository;

    @GetMapping("/success")
    public String welcome() {
        return "success";
    }
    @GetMapping("/createBooking")
    public String showBookingRequestForm(@RequestParam Long nannyid, ModelMap modelMap) {
        CreateBookingRequest request = new CreateBookingRequest();
        request.setNannyid(nannyid);
        modelMap.addAttribute("request", request);
        return "bookingform";
    }

    @PostMapping("/createBooking")
    public String processCreateBookingRequest(@ModelAttribute(value = "request") CreateBookingRequest request, ModelMap modelMap) {
        CreateBookingResponse response = bookingsService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "bookingform";  // amend html template according to new postmapping
        } else {
            return "redirect:/success";
        }
    }



  /*  @PostMapping("/createBooking")
    public String submitBookingRequestForm(@ModelAttribute("booking") Booking booking) { //, RedirectAttributes redirectAttributes
        //redirectAttributes.addFlashAttribute("message")//, "Booking request is sent");
        bookingsService.createAndSaveBooking(booking);
        return "redirect:/searchNannies";
    }
*/
       /* @GetMapping
    public String listNannies(Model model) {
        List<Bookings> booking = bookingsService.findAll();
        model.addAttribute("bookings", booking);
        return "nanny_list";
    }*/

    //@GetMapping("/bookings/add/{nannyId}")
    // public String createBooking(@PathVariable Long nannyId, Model model)...... return "bookingrequest"; {}


/*    @Controller
    @RequestMapping("/bookings")
    public class BookingController {

        @Autowired
        private BookingService bookingService;

        @PostMapping
        public String createBooking(@ModelAttribute("booking") Booking booking) {
            bookingService.createBooking(booking);
            return "redirect:/nannieslist";  // or message booking created?
        }

    }*/

 /*   @PostMapping("/createBooking") // amended name
    public String submitBookingRequestForm (@ModelAttribute("bookings") Booking booking) {
        bookingsService.save(booking);
        return "redirect:/searchNannies";  //????
    }*/


}
