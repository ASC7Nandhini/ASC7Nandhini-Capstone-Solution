package ats.repository;

import ats.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository <LoginDetails, Long> {
    LoginDetails findByEmailId(String emailId);
}
