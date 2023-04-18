package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.BookingStatus;
import babysitting.nannyservice.repositories.JpaBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelBookingService {

    @Autowired
    private JpaBookingRepository bookingRepository;

    @Transactional
    public Booking cancelBooking(Integer id) {
        Booking booking = bookingRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    // add validation not to change status if it is already "cancelled", provide error text

}
