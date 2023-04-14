package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public String getEmailById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        return user.getEmail();
    }

    public void processBooking(Booking booking) {
        Nanny nanny = booking.getNanny();
        User bookerUser = booking.getUser();

        String nannyEmail = getEmailById(nanny.getId().intValue()); // Convert Long to Integer
        String bookerEmail = getEmailById(bookerUser.getId());
        System.out.println("The nanny Id is ="+nannyEmail);
        System.out.println("The nanny Id is ="+bookerEmail);
        // Send email to nanny
        emailService.sendSimpleEmail("childcareservice.nanny@gmail.com", "New booking", "You have a new booking!");

        // Send email to booker
        emailService.sendSimpleEmail("childcareservice.nanny@gmail.com", "Booking confirmation", "Your booking has been confirmed!");

        // Perform any additional processing, like updating the booking status, etc.
    }
}
