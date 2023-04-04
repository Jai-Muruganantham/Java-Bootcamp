package babysitting.nannyservice.services;

import babysitting.nannyservice.repositories.NannyRepository;
import babysitting.nannyservice.domain.Nanny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAllNanniesService {

    private final NannyRepository nannyRepository;

    @Autowired
    public ShowAllNanniesService(NannyRepository nannyRepository){
        this.nannyRepository = nannyRepository;
    }

    public List<Nanny> getNannies(){
        return nannyRepository.findAll();
    }

}
