package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Booking;

import java.util.List;

public class SearchBookingResponse {

    private List<Booking> bookings;

    public SearchBookingResponse(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
