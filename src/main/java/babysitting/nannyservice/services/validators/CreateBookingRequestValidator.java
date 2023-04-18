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

    //! should add validation which takes booking status, if cancelled, then no overlap logic is called

    @Autowired
    private JpaBookingRepository bookingRepository;

    public List<CoreError> validate(CreateBookingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateMessage(request).ifPresent(errors::add);
        validateStartTime(request).ifPresent(errors::add);
        validateEndTime(request).ifPresent(errors::add);
        validateOverlappingBooking(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateMessage(CreateBookingRequest request) {
        return (request.getMessage() == null || request.getMessage().isEmpty())
                ? Optional.of(new CoreError("Message", "must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEndTime(CreateBookingRequest request) {
        LocalDateTime endTime = request.getEndtime();
        LocalDateTime startTime = request.getStarttime();
        if (endTime == null) {
            return Optional.of(new CoreError("End time", "must not be empty!"));
        } else if (endTime.isBefore(LocalDateTime.now())) {
            return Optional.of(new CoreError("End time", "must be in the future!"));
        } else if (endTime.isBefore(startTime)) {
            return Optional.of(new CoreError("End time", "must be after start time!"));
        }
        return Optional.empty();
    }


    private Optional<CoreError> validateStartTime(CreateBookingRequest request) {
        LocalDateTime startTime = request.getStarttime();
        if (startTime == null) {
            return Optional.of(new CoreError("Start time", "must not be empty!"));
        } else if (startTime.isBefore(LocalDateTime.now())) {
            return Optional.of(new CoreError("Start time", "must be in the future!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateOverlappingBooking(CreateBookingRequest request) {
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
    }


}