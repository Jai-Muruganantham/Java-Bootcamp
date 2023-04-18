package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingEmailService {

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
        String nannyEmail = getEmailById(nannyId.getId());
        User user = userRepository.findById(nannyId.getId()).orElseThrow(() -> new RuntimeException("User not found with ID: " + nannyId.getId()));// Convert Long to Integer
        String bookerEmail = getEmailById(bookerUser.getId());
        String bookername= bookerUser.getFirstname();


        System.out.println("The nanny Id is ="+nannyEmail);
        System.out.println("The Parent Id is ="+bookerEmail);
        // Send email to nanny
        //emailService.sendSimpleEmail(nannyEmail, "New booking", "You have a new booking! From "+booking.getStartTime()+" To:"+booking.getEndTime());
        emailService.sendSimpleEmail(nannyEmail, "New booking", "Hello "+user.getFirstname()+",\n\nWe wanted to let you know that you have a new booking! The details are as follows:\n\nDay: "+booking.getStartTime().getDayOfWeek()+"\nStart Time: "+booking.getStartTime().getHour()+":"+booking.getStartTime().getMinute()+"\nEnd Time: "+booking.getEndTime().getHour()+":"+booking.getEndTime().getMinute()+"\nParent's Name: "+bookername+"\nPlease let us know if you have any questions or concerns.\n\nThank you,\nBest Regards,\nNanny Service Team");

        // Send email to booker
        //emailService.sendSimpleEmail(bookerEmail, "Booking confirmation", "Your booking has been confirmed!");
        emailService.sendSimpleEmail(bookerEmail, "Booking confirmation", "Hello "+bookerUser.getFirstname()+",\n\nWe are happy to confirm your booking with "+user.getFirstname()+". The details are as follows:\n\nDay: "+booking.getStartTime().getDayOfWeek()+"\nStart Time: "+booking.getEndTime().getHour()+":"+booking.getEndTime().getMinute()+"\nEnd Time:"+booking.getEndTime().getHour()+":"+booking.getEndTime().getMinute()+"\nNanny's Name: "+user.getFirstname()+"\n\nIf you have any questions or concerns, please don't hesitate to contact us.\n\nThank you for choosing our nanny service!\nBest Regards,\nNanny Service Team");

        // Perform any additional processing, like updating the booking status, etc.
    }
}
