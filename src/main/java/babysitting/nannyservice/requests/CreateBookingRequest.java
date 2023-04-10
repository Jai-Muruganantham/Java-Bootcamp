package babysitting.nannyservice.requests;

import java.time.LocalDateTime;

public class CreateBookingRequest {

    private Long nannyid;
    private LocalDateTime timestamp;
    private String message;
    private LocalDateTime starttime;
    private LocalDateTime endtime;

    public CreateBookingRequest(Long nannyid) {
        this.nannyid = nannyid;
    }

    public CreateBookingRequest(Long nannyid, LocalDateTime timestamp, String message, LocalDateTime starttime, LocalDateTime endtime) {
        this.nannyid = nannyid;
        this.timestamp = timestamp;
        this.message = message;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public CreateBookingRequest() {
    }

    public Long getNannyid() {
        return nannyid;
    }

    public void setNannyid(Long nannyid) {
        this.nannyid = nannyid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }
}
