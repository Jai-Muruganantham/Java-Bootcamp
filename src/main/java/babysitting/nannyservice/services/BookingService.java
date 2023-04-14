package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JpaNannyRepository nannyRepository;
    @Autowired
    private EmailService emailService;

    public String getEmailById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        return user.getEmail();
    }
    public User getEmailById(Long userid) {
        Nanny nanny = nannyRepository.findById(userid).orElseThrow(() -> new RuntimeException("Nanny not found with ID: " + userid));
        return nanny.getUser();
    }

    public void processBooking(Booking booking) {
        Nanny nanny = booking.getNanny();
        User bookerUser = booking.getUser();

        User nannyId = getEmailById(nanny.getId());
        String nannyEmail = getEmailById(nannyId.getId()); // Convert Long to Integer
        String bookerEmail = getEmailById(bookerUser.getId());
        System.out.println("The nanny Id is ="+nannyEmail);
        System.out.println("The Parent Id is ="+bookerEmail);
        // Send email to nanny
        emailService.sendSimpleEmail(nannyEmail, "New booking", "You have a new booking!");

        // Send email to booker
        emailService.sendSimpleEmail(bookerEmail, "Booking confirmation", "Your booking has been confirmed!");

        // Perform any additional processing, like updating the booking status, etc.
    }
}
