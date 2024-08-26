package ats.service;

import ats.entity.RegistrationEntity;
import ats.model.RegistrationModel;
import ats.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository){
        this.registrationRepository=registrationRepository;
    }

    @Override
    public String registerUser(RegistrationModel registrationModel) {
        try{
            validateRegistrationDetails(registrationModel);
            //Alrdy exists or not
            if(registrationRepository.findByEmailId(registrationModel.getEmailId())!=null){
                return "Email already in use";
            }
            if (registrationRepository.findByPhoneNumber(registrationModel.getPhoneNumber()) != null) {
                return "Phone number already in use";
            }
            // Create and save new user
            RegistrationEntity newUser = new RegistrationEntity();
            newUser.setId(registrationModel.getId());
            newUser.setEmailId(registrationModel.getEmailId());
            newUser.setPassword(registrationModel.getPassword());
            newUser.setPhoneNumber(registrationModel.getPhoneNumber());
            newUser.setFailedAttempts(0);
            newUser.setLocked(false);
            newUser.setLockTime(null);

            registrationRepository.save(newUser);

            return "Registration Successful";
        }
        catch (Exception e){
            return "Registration Failed: " + e.getMessage();
        }
    }

    private void validateRegistrationDetails(RegistrationModel registrationModel) {
        if (registrationModel.getEmailId() == null || registrationModel.getEmailId().isEmpty()) {
            throw new IllegalArgumentException("Email ID is required");
        }

        if (registrationModel.getPassword() == null || registrationModel.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (registrationModel.getPhoneNumber() == null || registrationModel.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number is required");
        }

        if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@(.+)$", registrationModel.getEmailId())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~]).+$";
        if (!Pattern.matches(passwordRegex, registrationModel.getPassword())) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
        }

        if (!Pattern.matches("^\\d{10}$", registrationModel.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
    }

    @Override
    public List<RegistrationModel> getAllUsers() {
        List<RegistrationEntity> allUsers = registrationRepository.findAll();
        List<RegistrationModel> registrationModelList = new ArrayList<>();
        for (RegistrationEntity registrationEntity : allUsers) {
            RegistrationModel registrationModel = new RegistrationModel(
                    registrationEntity.getEmailId(),
                    registrationEntity.getPassword(),
                    registrationEntity.getId(),
                    registrationEntity.getPhoneNumber(),
                    registrationEntity.getFailedAttempts(),
                    registrationEntity.isLocked(),
                    registrationEntity.getLockTime()
            );
            registrationModelList.add(registrationModel);
        }
        return registrationModelList;
    }

    @Override
    public RegistrationModel getUserById(Long id) {
        RegistrationEntity registrationEntity = registrationRepository.findById(id).orElse(null);
        if (registrationEntity != null) {
            return new RegistrationModel(
                    registrationEntity.getEmailId(),
                    registrationEntity.getPassword(),
                    registrationEntity.getId(),
                    registrationEntity.getPhoneNumber(),
                    registrationEntity.getFailedAttempts(),
                    registrationEntity.isLocked(),
                    registrationEntity.getLockTime()
            );
        }
        return null;
    }
}
