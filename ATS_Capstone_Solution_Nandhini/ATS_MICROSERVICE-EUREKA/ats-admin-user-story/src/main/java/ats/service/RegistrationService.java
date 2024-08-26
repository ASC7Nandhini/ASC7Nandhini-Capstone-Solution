package ats.service;

import ats.model.RegistrationModel;

import java.util.List;

public interface RegistrationService {
    String registerUser(RegistrationModel registrationModel);
    List<RegistrationModel> getAllUsers();
    RegistrationModel getUserById(Long id);
}
