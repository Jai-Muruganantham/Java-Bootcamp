package babysitting.nannyservice.services;

import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.domain.Nanny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllNanniesService {

    private final JpaNannyRepository nannyRepository;

    @Autowired
    public ListAllNanniesService(JpaNannyRepository nannyRepository){
        this.nannyRepository = nannyRepository;
    }

    public List<Nanny> getNannies(){
        return nannyRepository.findAll();
    }

    public List<Nanny> getNanniesByCity(String city){
        return nannyRepository.findByCity(city);
    }


}
