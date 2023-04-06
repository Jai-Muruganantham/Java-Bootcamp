package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import babysitting.nannyservice.repositories.JpaBookingsRepository;
import java.util.List;

@Service
public class BookingsService {
    @Autowired
    private JpaBookingsRepository bookingsRepository;

    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    public Bookings save(Bookings bookings) {
        return bookingsRepository.save(bookings);
    }

    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        bookingsRepository.deleteById(id);
    }
}
