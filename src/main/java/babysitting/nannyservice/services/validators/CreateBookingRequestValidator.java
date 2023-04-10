package babysitting.nannyservice.services.validators;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.repositories.JpaBookingRepository;
import babysitting.nannyservice.requests.CreateBookingRequest;
import babysitting.nannyservice.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateBookingRequestValidator {

    @Autowired
    private JpaBookingRepository bookingRepository;

    public List<CoreError> validate(CreateBookingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateMessage(request).ifPresent(errors::add);
        validateStartTime(request).ifPresent(errors::add);
        validateEndTime(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateMessage(CreateBookingRequest request) {
        return (request.getMessage() == null || request.getMessage().isEmpty())
                ? Optional.of(new CoreError("Message", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateStartTime(CreateBookingRequest request) {
        LocalDateTime startTime = request.getStarttime();
        if (startTime == null) {
            return Optional.of(new CoreError("Start time", "must not be empty!"));
        } else if (startTime.isBefore(LocalDateTime.now())) {
            return Optional.of(new CoreError("Start time", "must be in the future!"));
        }

        /*List<Booking> bookings = bookingRepository.findByNannyid(request.getNannyid());
        Optional<Booking> overlappingBooking = bookings.stream()
                .filter(booking -> booking.getEndTime().isAfter(request.getStarttime()) && booking.getStartTime().isBefore(request.getEndtime()))
                .findFirst();
        if (overlappingBooking.isPresent()) {
            LocalDateTime overlappingStartTime = overlappingBooking.get().getStartTime();
            LocalDateTime overlappingEndTime = overlappingBooking.get().getEndTime();
            String message = String.format("must not overlap with existing booking for this nanny (ID %d) from %s to %s",
                    overlappingBooking.get().getNannyId(), overlappingStartTime, overlappingEndTime);
            return Optional.of(new CoreError("Start time", message));
        }*/

        return Optional.empty();
    }

    private Optional<CoreError> validateEndTime(CreateBookingRequest request) {
        LocalDateTime endTime = request.getEndtime();
        if (endTime == null) {
            return Optional.of(new CoreError("End time", "must not be empty!"));
        } else if (endTime.isBefore(LocalDateTime.now())) {
            return Optional.of(new CoreError("End time", "must be in the future!"));
        }
        return Optional.empty();
    }
   /* private Optional<CoreError> validateEndTime(CreateBookingRequest request) {
        LocalDateTime endTime = request.getEndtime();
        if (endTime == null) {
            return Optional.of(new CoreError("End time", "must not be empty!"));
        } else if (endTime.isAfter(LocalDateTime.now())) {
            return Optional.of(new CoreError("End time", "must be in the past!"));
        }
        return Optional.empty();
    }*/

}
