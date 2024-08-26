package ats.controller;

import ats.entity.BookingEntity;
import ats.exceptions.BookingNotFoundException;
import ats.model.BookingModel;
import ats.repository.BookingRepository;
import ats.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @GetMapping("/Bookings")
    public List<BookingModel> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/Bookings/{id}")
    public BookingModel getBookingById(@PathVariable("id") String bookingId) {
        try {
            BookingEntity bookingDetails = bookingRepository.findById(bookingId).get();
            return new BookingModel(
                    bookingDetails.getBookingId(),
                    bookingDetails.getPassengerName(),
                    bookingDetails.getBookingDate(),
                    bookingDetails.getSeatNumber(),
                    bookingDetails.getTicketCost(),
                    bookingDetails.getTotalAmount(),
                    bookingDetails.getDepartureDateTime(),
                    bookingDetails.getArrivalDateTime()
            );
        } catch (BookingNotFoundException bookingNotFoundException) {
            return null;
        }
    }

    @PostMapping("/Bookings")
    public String createBooking(@RequestBody BookingModel bookingModelFromClient) {
        validateBookingModel(bookingModelFromClient);
        String bookingId = bookingService.generateId();
        BookingEntity bookingDetails = new BookingEntity(
                bookingId,
                bookingModelFromClient.getPassengerName(),
                bookingModelFromClient.getBookingDate(),
                bookingModelFromClient.getSeatNumber(),
                bookingModelFromClient.getTicketCost(),
                bookingModelFromClient.getTotalAmount(),
                bookingModelFromClient.getDepartureDateTime(),
                bookingModelFromClient.getArrivalDateTime()
        );
        bookingRepository.save(bookingDetails);
        return "Booking Details inserted successfully";
    }

    @DeleteMapping("/Bookings/{id}")
    public String deleteBooking(@PathVariable("id") String bookingId) {
        try {
            BookingEntity bookingDetailsToBeDeleted = bookingRepository.findById(bookingId).get();
            bookingRepository.delete(bookingDetailsToBeDeleted);
            return "Booking Details deleted successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Booking Details are not available";
        }
    }

    @PutMapping("/Bookings")
    public String updateBooking(@RequestBody BookingModel bookingModelFromClient) {
        validateBookingModel(bookingModelFromClient);
        try {
            BookingEntity bookingDetailsToBeUpdated = bookingRepository.findById(bookingModelFromClient.getBookingId()).get();
            if (bookingModelFromClient.getPassengerName() != null && !bookingModelFromClient.getPassengerName().isEmpty())
                bookingDetailsToBeUpdated.setPassengerName(bookingModelFromClient.getPassengerName());
            if (bookingModelFromClient.getSeatNumber() != null && !bookingModelFromClient.getSeatNumber().isEmpty())
                bookingDetailsToBeUpdated.setSeatNumber(bookingModelFromClient.getSeatNumber());
            if (bookingModelFromClient.getTicketCost() != 0)
                bookingDetailsToBeUpdated.setTicketCost(bookingModelFromClient.getTicketCost());
            if (bookingModelFromClient.getTotalAmount() != 0)
                bookingDetailsToBeUpdated.setTotalAmount(bookingModelFromClient.getTotalAmount());
            if (bookingModelFromClient.getDepartureDateTime() != null && !bookingModelFromClient.getDepartureDateTime().isEmpty())
                bookingDetailsToBeUpdated.setDepartureDateTime(bookingModelFromClient.getDepartureDateTime());
            if (bookingModelFromClient.getArrivalDateTime() != null && !bookingModelFromClient.getArrivalDateTime().isEmpty())
                bookingDetailsToBeUpdated.setArrivalDateTime(bookingModelFromClient.getArrivalDateTime());

            bookingRepository.save(bookingDetailsToBeUpdated);
            return "Booking Details updated successfully";
        } catch (BookingNotFoundException bookingNotFoundException) {
            return "Booking Details not updated for the provided BookingId";
        }
    }

    private void validateBookingModel(BookingModel bookingModel) {
        if (bookingModel.getDepartureDateTime().compareTo(bookingModel.getArrivalDateTime()) > 0) {
            throw new IllegalArgumentException("Departure date and time must be before arrival date and time");
        }
    }
}
