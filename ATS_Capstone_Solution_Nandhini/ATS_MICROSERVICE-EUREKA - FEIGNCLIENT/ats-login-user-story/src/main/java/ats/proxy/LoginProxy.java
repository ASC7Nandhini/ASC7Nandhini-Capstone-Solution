package ats.proxy;

import ats.model.BookingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="booking-microservice")
public interface LoginProxy {
    @GetMapping("/api/Bookings")
    public List<BookingModel> getAllBookings();
}

