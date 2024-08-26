package ats.repository;

import ats.entity.PlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity, String> {
    @Query(value = "SELECT p.registration_number FROM Plane p ORDER BY p.registration_number DESC limit 1",nativeQuery = true)
    String findTopId();
}
