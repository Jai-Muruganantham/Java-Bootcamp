package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.repositories.JpaBookingRepository;
import babysitting.nannyservice.requests.SearchBookingRequest;
import babysitting.nannyservice.responses.SearchBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service public class SearchBookingService {

    private final JpaBookingRepository bookingRepository;

    @Autowired
    public SearchBookingService(JpaBookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public SearchBookingResponse execute(SearchBookingRequest request) {

        List<Booking> bookings = bookingRepository.findAll();

        List<Booking> filteredByIdBookings = bookings.stream()
                .filter(b -> b.getUser().getId() == request.getId())
                .collect(Collectors.toList());

        return new SearchBookingResponse(filteredByIdBookings);
    }



}
