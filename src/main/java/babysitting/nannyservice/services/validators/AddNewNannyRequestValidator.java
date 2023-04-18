package babysitting.nannyservice.services.validators;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.repositories.JpaBookingRepository;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.requests.AddNewNannyRequest;
import babysitting.nannyservice.requests.CreateBookingRequest;
import babysitting.nannyservice.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddNewNannyRequestValidator {

    @Autowired
    private JpaNannyRepository nannyRepository;

    public List<CoreError> validate(AddNewNannyRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateCity(request).ifPresent(errors::add);
        validateBio(request).ifPresent(errors::add);
        validateQualification(request).ifPresent(errors::add);
        validateYearsExperience(request).ifPresent(errors::add);
        validateUserId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateCity(AddNewNannyRequest request) {
        return (request.getCity() == null || request.getCity().isEmpty())
                ? Optional.of(new CoreError("City", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateBio(AddNewNannyRequest request) {
        return (request.getBio() == null || request.getBio().isEmpty())
                ? Optional.of(new CoreError("Bio", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateQualification(AddNewNannyRequest request) {
        return (request.getQualification() == null || request.getQualification().isEmpty())
                ? Optional.of(new CoreError("Bio", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateYearsExperience(AddNewNannyRequest request) {
        if (request.getExperience() == null) {
            return Optional.of(new CoreError("Years of experience", "must not be empty!"));
        } else if (request.getExperience() <= 0 || request.getExperience() >= 30) {
            return Optional.of(new CoreError("Years of experience", "must be in range from 0 to 30!"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validateUserId(AddNewNannyRequest request) {
        if (request.getUserid() == null) {
            return Optional.of(new CoreError("User id", "must not be empty!"));
        } else if (request.getUserid() < 0) {
            return Optional.of(new CoreError("User id", "must be positive number!"));
        }

        if (nannyRepository.existsByUserId(request.getUserid())) {
            return Optional.of(new CoreError("User with this ID", "is already registered as nanny"));
        }
        return Optional.empty();
    }


}
