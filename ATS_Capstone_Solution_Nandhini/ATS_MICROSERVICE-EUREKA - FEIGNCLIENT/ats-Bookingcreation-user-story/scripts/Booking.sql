-- Active: 1719376346140@@127.0.0.1@3306@atsc
USE ATSC;
CREATE TABLE Booking (
    booking_id VARCHAR(5) PRIMARY KEY,
    passenger_name VARCHAR(255) NOT NULL,
    booking_date DATETIME NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    ticket_cost DECIMAL(10, 2) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    departure_date_time VARCHAR(255) NOT NULL,
    arrival_date_time VARCHAR(255) NOT NULL
);

INSERT INTO Booking VALUES ('B0001', 'Nandhu', '2024-07-23 04:30:00', '12A', 150.00, 150.00, '2024-08-24 12:00:00', '2024-08-24 14:00:00');
SELECT * FROM Booking;
drop Table Booking;