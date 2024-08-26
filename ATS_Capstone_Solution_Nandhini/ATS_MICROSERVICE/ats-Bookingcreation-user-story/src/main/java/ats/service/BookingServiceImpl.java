package ats.service;

import ats.entity.BookingEntity;
import ats.model.BookingModel;
import ats.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public String generateId() {
        String bookingId = bookingRepository.findTopId();
        if (bookingId == null || bookingId.isEmpty()) {
            bookingId = "B0000";
        }
        String id = "B";
        int number = Integer.parseInt(bookingId.substring(1, 5));
        number++;
        String digit = Integer.toString(number);
        switch (4 - digit.length()) {
            case 1:
                id += "0";
                break;
            case 2:
                id += "00";
                break;
            case 3:
                id += "000";
                break;
            default:
                break;
        }
        id += digit;
        return id;
    }

    @Override
    public List<BookingModel> getAllBookings() {
        List<BookingEntity> allBookings = bookingRepository.findAll();
        List<BookingModel> bookingModelList = new ArrayList<>();
        for (BookingEntity bookingEntity : allBookings) {
            BookingModel bookingModel = new BookingModel(
                    bookingEntity.getBookingId(),
                    bookingEntity.getPassengerName(),
                    bookingEntity.getBookingDate(),
                    bookingEntity.getSeatNumber(),
                    bookingEntity.getTicketCost(),
                    bookingEntity.getTotalAmount(),
                    bookingEntity.getDepartureDateTime(),
                    bookingEntity.getArrivalDateTime()
            );
            bookingModelList.add(bookingModel);
        }
        return bookingModelList;
    }
}
