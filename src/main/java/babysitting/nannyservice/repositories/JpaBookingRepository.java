package babysitting.nannyservice.repositories;


import babysitting.nannyservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBookingRepository extends JpaRepository<Booking, Long> {

    // List<Booking> findByNannyid(Long id);

}
