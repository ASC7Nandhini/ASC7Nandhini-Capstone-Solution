package ats.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @Column(name = "booking_id", updatable = false, nullable = false)
    private String bookingId;
    @Column(name = "passenger_name", nullable = false)
    private String passengerName;
    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;
    @Column(name = "seat_number", nullable = false)
    private String seatNumber;
    @Column(name = "ticket_cost", nullable = false)
    private double ticketCost;
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
    @Column(name = "departure_date_time", nullable = false)
    private String departureDateTime;
    @Column(name = "arrival_date_time", nullable = false)
    private String arrivalDateTime;

    public BookingEntity(){
    }


}
