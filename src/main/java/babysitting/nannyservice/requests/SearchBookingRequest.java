package babysitting.nannyservice.requests;

public class SearchBookingRequest {

    private Integer id;

    public SearchBookingRequest(Integer bookerId) {
        this.id = bookerId;
    }

    public SearchBookingRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
