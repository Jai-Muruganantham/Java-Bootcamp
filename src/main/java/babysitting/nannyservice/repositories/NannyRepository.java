package babysitting.nannyservice.repositories;

import babysitting.nannyservice.domain.Nanny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NannyRepository extends JpaRepository<Nanny, Long> {
}
