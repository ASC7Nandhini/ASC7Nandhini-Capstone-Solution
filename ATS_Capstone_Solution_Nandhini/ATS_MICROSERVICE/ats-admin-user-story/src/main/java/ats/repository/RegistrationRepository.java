package ats.repository;

import ats.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository <RegistrationEntity, Long> {
    RegistrationEntity findByEmailId(String emailId);
    RegistrationEntity findByPhoneNumber(String phoneNumber);
}
