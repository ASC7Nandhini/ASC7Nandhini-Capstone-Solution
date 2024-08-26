package ats.repository;

import ats.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<BookingEntity, String> {
    @Query(value = "SELECT booking_id FROM Booking ORDER BY booking_id DESC LIMIT 1", nativeQuery = true)
    String findTopId();

}
