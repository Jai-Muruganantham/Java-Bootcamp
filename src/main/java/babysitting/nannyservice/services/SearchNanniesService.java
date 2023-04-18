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
import java.util.Optional;

@Service
@Transactional
public class SearchNanniesService {

    @Autowired
    private JpaNannyRepository repository;
    @Autowired
    private SearchNanniesRequestValidator validator;

    public SearchNanniesService(JpaNannyRepository repository, SearchNanniesRequestValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public SearchNannyResponse execute(SearchNanniesRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchNannyResponse(errors);
        }
        List<Nanny> nannies = search(request);
        return new SearchNannyResponse(nannies, true);
    }

    private List<Nanny> search(SearchNanniesRequest request) {
        List<Nanny> nannies = new ArrayList<>();

        if (request.isCityProvided()) {
            nannies = repository.findByCity(request.getCity());
        }
        if (request.isIdProvided()) {
            Optional<Nanny> nannyOptional = repository.findById(request.getId());
            nannyOptional.ifPresent(nannies::add);
        }
        return nannies;
    }


}
