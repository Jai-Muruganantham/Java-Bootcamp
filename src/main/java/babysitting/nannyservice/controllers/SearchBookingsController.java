package babysitting.nannyservice.controllers;

import babysitting.nannyservice.requests.SearchBookingRequest;
import babysitting.nannyservice.responses.SearchBookingResponse;
import babysitting.nannyservice.services.SearchBookingService;
import babysitting.nannyservice.services.CancelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class SearchBookingsController {

    @Autowired
    private final SearchBookingService service;

    public SearchBookingsController(SearchBookingService service) {
        this.service = service;
    }

    @Autowired
    CancelBookingService cancelBookingService;

    @GetMapping("/showBookingsForUser")
    public String showFilteredBookingRequest(@RequestParam(defaultValue = "6") Integer bookeruserid,
                                             @RequestParam(required = false) boolean cancelled,
                                             ModelMap modelMap) {
        SearchBookingRequest request = new SearchBookingRequest();
        request.setId(bookeruserid);
        SearchBookingResponse response = service.execute(request);
        modelMap.addAttribute("bookings", response.getBookings());

        if (cancelled) {
            modelMap.addAttribute("message", "Booking was cancelled.");
        }

        return "list_filtered_bookings";
    }

    @PostMapping("/showBookingsForUser")
    public String cancelBooking(@RequestParam("id") Integer id, ModelMap modelMap) {
        cancelBookingService.cancelBooking(id);
        modelMap.addAttribute("message", "Booking was cancelled.");
        return "redirect:/showBookingsForUser?cancelled=true";
    }

}
