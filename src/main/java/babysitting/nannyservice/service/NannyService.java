package babysitting.nannyservice.service;

import babysitting.nannyservice.model.Nanny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import babysitting.nannyservice.repository.NannyRepository;
import java.util.List;

@Service
public class NannyService {
    @Autowired
    private NannyRepository nannyRepository;

    public List<Nanny> findAll() {
        return nannyRepository.findAll();
    }

    public Nanny save(Nanny nanny) {
        return nannyRepository.save(nanny);
    }

    public Nanny findById(Long id) {
        return nannyRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        nannyRepository.deleteById(id);
    }
}
