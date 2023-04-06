package babysitting.nannyservice.repositories;

import babysitting.nannyservice.domain.Nanny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaNannyRepository extends JpaRepository<Nanny, Long> {

    //List<Nanny> findById (Long id); - seems to be overlap with standard crud functionality?
    List<Nanny> findByName (String name);
    List<Nanny> findByCity (String city);

    List<Nanny> findByNameAndCity (String name, String city);

}
