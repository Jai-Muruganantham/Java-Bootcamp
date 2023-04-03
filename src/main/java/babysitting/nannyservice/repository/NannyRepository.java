package babysitting.nannyservice.repository;


import babysitting.nannyservice.model.Nanny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NannyRepository extends JpaRepository<Nanny, Long> {
}
