package babysitting.nannyservice.services;

import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.requests.ListAllNanniesRequest;
import babysitting.nannyservice.responses.ListAllNanniesResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListAllNanniesService {


    private final JpaNannyRepository nannyRepository;

    @Autowired
    public ListAllNanniesService(JpaNannyRepository nannyRepository) {
        this.nannyRepository = nannyRepository;
    }

    public ListAllNanniesResponse execute(ListAllNanniesRequest request) {
        List<Nanny> nannies = nannyRepository.findAll();
        return new ListAllNanniesResponse(nannies);
    }


}
