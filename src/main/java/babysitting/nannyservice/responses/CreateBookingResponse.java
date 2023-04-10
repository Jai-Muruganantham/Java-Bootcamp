package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Booking;

import java.util.List;

public class CreateBookingResponse extends CoreResponse {

    private Booking newBooking;

    public CreateBookingResponse (List<CoreError> errors){
        super(errors);
    }

    public CreateBookingResponse (Booking newBooking){
        this.newBooking = newBooking;
    }

    public Booking getNewBooking() {
        return newBooking;
    }
}
