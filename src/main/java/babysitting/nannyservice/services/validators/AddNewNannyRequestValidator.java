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


     /*   private Optional<CoreError> validateOverlappingBooking(CreateBookingRequest request) {
            LocalDateTime endTime = request.getEndtime();
            LocalDateTime startTime = request.getStarttime();
            if (startTime == null || endTime == null) {
                return Optional.of(new CoreError("Booking time", "Both start time and end time are required for checking overlapping bookings"));
            }

            List<Booking> bookings = bookingRepository.findByNannyId(request.getNannyid());
            Optional<Booking> existingBooking = bookings.stream()
                    .filter(booking -> booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(startTime))
                    .findFirst();
            if (existingBooking.isPresent()) {
                LocalDateTime overlappingStartTime = existingBooking.get().getStartTime();
                LocalDateTime overlappingEndTime = existingBooking.get().getEndTime();
                String message = String.format("must not overlap with existing booking for this nanny from %s to %s",
                        overlappingStartTime, overlappingEndTime);
                return Optional.of(new CoreError("Booking time", message));
            }

            return Optional.empty();
        }*/








   /* private Optional<CoreError> validateYearsExperience(AddNewNannyRequest request) {
        return (request.getExperience() == null)
                ? Optional.of(new CoreError("Years of experience", "must not be empty!"))
                : (request.getExperience() > 0 && request.getExperience() < 30)
                ? Optional.of(new CoreError("Years of experience", "must be in range from 0 to 30!"))
                : Optional.empty();
    }*/


 /*   private Optional<CoreError> validateUserId(AddNewNannyRequest request) {
        return (request.getUserid() == null)
                ? Optional.of(new CoreError("User id", "must not be empty!"))
                : (request.getExperience() < 0)
                ? Optional.of(new CoreError("User id", "must be positive number!"))
                : Optional.empty();

            // HERE WRITE VALIDATION FOR EXISTING NANNY WITH USER ID

    }*/


}
