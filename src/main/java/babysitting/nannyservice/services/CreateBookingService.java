package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import babysitting.nannyservice.requests.CreateBookingRequest;
import babysitting.nannyservice.responses.CoreError;
import babysitting.nannyservice.responses.CreateBookingResponse;
import babysitting.nannyservice.services.validators.CreateBookingRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import babysitting.nannyservice.repositories.JpaBookingRepository;

import java.util.List;

@Service
public class CreateBookingService {
    @Autowired
    private JpaBookingRepository bookingRepository;
    @Autowired
    private JpaNannyRepository nannyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreateBookingRequestValidator validator;

    public CreateBookingResponse execute(CreateBookingRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateBookingResponse(errors);
        }

        Booking booking = new Booking();

        Nanny nanny = nannyRepository.findById(request.getNannyid())
                .orElseThrow(() -> new RuntimeException("Nanny not found"));

        // Retrieve the User object using the bookeruserid
        User user = userRepository.findById(request.getBookeruserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        booking.setNanny(nanny);
        booking.setTimestamp(request.getTimestamp());
        booking.setMessage(request.getMessage());
        booking.setStartTime(request.getStarttime());
        booking.setEndTime(request.getEndtime());
        booking.setUser(user); // Set the user field in the Booking object

        bookingRepository.save(booking);

        return new CreateBookingResponse(booking);
    }


    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }


}
