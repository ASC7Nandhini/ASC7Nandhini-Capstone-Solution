package ats;

import ats.model.BookingModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class BookingModelTestCase {

    BookingModel bookingModel = new BookingModel("B0001", "Mithune", LocalDateTime.of(2024, 8, 25, 10, 30),
            "14A", 150.0, 300.0, "2024-08-25T15:00", "2024-08-25T18:00");

    @Test
    public void testBookingIdField() {
        String actualBookingId = bookingModel.getBookingId();
        Assertions.assertEquals("B0001", actualBookingId);
    }

    @Test
    public void testPassengerNameField() {
        String actualPassengerName = bookingModel.getPassengerName();
        Assertions.assertEquals("Mithune", actualPassengerName);
    }

    @Test
    public void testBookingDateField() {
        LocalDateTime actualBookingDate = bookingModel.getBookingDate();
        Assertions.assertEquals(LocalDateTime.of(2024, 8, 25, 10, 30), actualBookingDate);
    }

    @Test
    public void testSeatNumberField() {
        String actualSeatNumber = bookingModel.getSeatNumber();
        Assertions.assertEquals("14A", actualSeatNumber);
    }

    @Test
    public void testTicketCostField() {
        double actualTicketCost = bookingModel.getTicketCost();
        Assertions.assertEquals(150.0, actualTicketCost);
    }

    @Test
    public void testTotalAmountField() {
        double actualTotalAmount = bookingModel.getTotalAmount();
        Assertions.assertEquals(300.0, actualTotalAmount);
    }

    @Test
    public void testDepartureDateTimeField() {
        String actualDepartureDateTime = bookingModel.getDepartureDateTime();
        Assertions.assertEquals("2024-08-25T15:00", actualDepartureDateTime);
    }

    @Test
    public void testArrivalDateTimeField() {
        String actualArrivalDateTime = bookingModel.getArrivalDateTime();
        Assertions.assertEquals("2024-08-25T18:00", actualArrivalDateTime);
    }
}

