package babysitting.nannyservice.repositories;


import babysitting.nannyservice.domain.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookingsRepository extends JpaRepository<Bookings, Long> {
}
