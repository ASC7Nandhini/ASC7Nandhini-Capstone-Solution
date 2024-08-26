package ats.service;

import ats.model.BookingModel;

import java.util.List;

public interface BookingService {
    String generateId();
    List<BookingModel> getAllBookings();
}
