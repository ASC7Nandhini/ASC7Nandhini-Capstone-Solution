package ats.repository;

import ats.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, String> {
    @Query(value = "SELECT a.airport_id FROM Airport a ORDER BY a.airport_id DESC limit 1", nativeQuery = true)
    String findTopId();
}
