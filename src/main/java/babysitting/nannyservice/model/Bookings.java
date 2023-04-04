package babysitting.nannyservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Bookings {
    @Id
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
    }
}
