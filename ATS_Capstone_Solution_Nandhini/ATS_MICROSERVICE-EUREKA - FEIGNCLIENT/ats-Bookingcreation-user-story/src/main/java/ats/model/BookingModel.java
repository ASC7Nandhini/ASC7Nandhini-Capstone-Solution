package ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    public BookingModel(){
    }
}
