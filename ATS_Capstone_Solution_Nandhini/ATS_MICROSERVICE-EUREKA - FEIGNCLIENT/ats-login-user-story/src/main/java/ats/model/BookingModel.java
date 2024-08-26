package ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingModel {
    private String bookingId;
    private String passengerName;
    private LocalDateTime bookingDate;
    private String seatNumber;
    private double ticketCost;
    private double totalAmount;
    private String departureDateTime;
    private String arrivalDateTime;


}