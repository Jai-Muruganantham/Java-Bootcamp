package babysitting.nannyservice.domain;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nannyid")
    private Nanny nanny;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookeruserid")
    private User user;

    @CreationTimestamp
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "message")
    private String message;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;



    public Booking(Nanny nanny, String message, LocalDateTime startTime, LocalDateTime endTime) {
        this.nanny = nanny;
        this.message = message;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Booking() {

    }

    public Long getNannyId() {
        return nanny.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nanny getNanny() {
        return nanny;
    }

    public void setNanny(Nanny nanny) {
        this.nanny = nanny;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", nanny=" + nanny +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}

    /*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String message;
    private LocalDateTime start_Time;
    private LocalDateTime end_Time;

    // Constructors, Getters, and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(LocalDateTime start_Time) {
        this.start_Time = start_Time;
    }

    public LocalDateTime getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(LocalDateTime end_Time) {
        this.end_Time = end_Time;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", start_Time=" + start_Time +
                ", end_Time=" + end_Time +
                '}';
    }*/

