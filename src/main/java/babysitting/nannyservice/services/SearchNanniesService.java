package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.requests.SearchNanniesRequest;
import babysitting.nannyservice.responses.CoreError;
import babysitting.nannyservice.responses.SearchNannyResponse;
import babysitting.nannyservice.services.validators.SearchNanniesRequestValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchNanniesService {

    @Autowired
    private JpaNannyRepository repository;
    @Autowired
    private SearchNanniesRequestValidator validator;

    public SearchNannyResponse execute(SearchNanniesRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchNannyResponse(null, errors);
        }
        List<Nanny> nannies = search(request);
        return new SearchNannyResponse(nannies, null);
    }

    private List<Nanny> search(SearchNanniesRequest request) { // is it possible to pass id as parameter or only request instance??
        List<Nanny> nannies = new ArrayList<>();
        if (request.isCityProvided() && !request.isNameProvided()) {
            nannies = repository.findByCity(request.getCity());
        }
        if (!request.isCityProvided() && request.isNameProvided()) {
            nannies = repository.findByName(request.getName());
        }
        if (request.isCityProvided() && request.isNameProvided()) {
            nannies = repository.findByNameAndCity(request.getName(), request.getCity());
        }
        return nannies;
    }

    //using search by name as didnt managed to do it with id.


}
