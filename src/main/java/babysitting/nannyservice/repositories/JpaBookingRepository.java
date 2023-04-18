package babysitting.nannyservice.repositories;


import babysitting.nannyservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.nanny.id = :nannyid")
    List<Booking> findByNannyId(@Param("nannyid") Long nannyid);

}
