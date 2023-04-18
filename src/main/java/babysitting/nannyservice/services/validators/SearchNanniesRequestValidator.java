package babysitting.nannyservice.services.validators;

import babysitting.nannyservice.requests.SearchNanniesRequest;
import babysitting.nannyservice.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SearchNanniesRequestValidator {


    public List<CoreError> validate(SearchNanniesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateCity(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateCity(SearchNanniesRequest request) {
        return (request.getCity() == null || request.getCity().isEmpty())
                ? Optional.of(new CoreError("City", "must not be empty!"))
                : Optional.empty();
    }

}
