use nannyservice;
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    start_Time TIMESTAMP NOT NULL,
    end_Time TIMESTAMP NOT NULL

);

