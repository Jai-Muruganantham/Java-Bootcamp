package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import babysitting.nannyservice.requests.CreateBookingRequest;
import babysitting.nannyservice.responses.CreateBookingResponse;
import babysitting.nannyservice.services.BookingEmailService;
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


    @Autowired
    private BookingEmailService bookingService;

    @Autowired
    UserRepository userRepository;


    public CreateBookingController(BookingEmailService bookingService, UserRepository userRepository, JpaNannyRepository nannyRepository) {
        this.bookingService = bookingService;
        this.userRepository = userRepository;
        this.nannyRepository = nannyRepository;
    }

    @GetMapping("/success")
    public String welcome() {
        return "success";
    }

    @GetMapping("/createBooking")
    public String showBookingRequestForm(@RequestParam Long nannyid, @RequestParam Integer bookeruserid, ModelMap modelMap) {
        CreateBookingRequest request = new CreateBookingRequest();
        request.setNannyid(nannyid);
        request.setBookeruserid(bookeruserid);
        System.out.println("The value in get is " + bookeruserid);
        modelMap.addAttribute("request", request);
        return "bookingform";
    }


    @PostMapping("/createBooking")
    public String processCreateBookingRequest(@ModelAttribute(value = "request") CreateBookingRequest request, ModelMap modelMap) {
        System.out.println("the value is" + request.getBookeruserid());
        CreateBookingResponse response = bookingsService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "bookingform";  // amend html template according to new postmapping
        } else {

            // Create a Booking object from the request data and call processBooking()
            Booking booking = new Booking();

            // Get Nanny and User from their respective repositories using their IDs from the request
            Nanny nanny = nannyRepository.findById(request.getNannyid())
                    .orElseThrow(() -> new RuntimeException("Nanny not found with ID: " + request.getNannyid()));
            User user = userRepository.findById(request.getBookeruserid())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getBookeruserid()));

            // Set Nanny and User to the Booking object
            booking.setNanny(nanny);
            booking.setUser(user);

            // For example, if your Booking object has a startDate and endDate, you can set them like this:
            booking.setStartTime(request.getStarttime());
            booking.setEndTime(request.getEndtime());

            // Call processBooking() with the booking object
            bookingService.processBooking(booking);
            return "redirect:/success";
        }
    }


}
