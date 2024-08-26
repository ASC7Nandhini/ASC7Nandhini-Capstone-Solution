package ats.controller;

import ats.exception.UserNotFoundException;
import ats.model.RegistrationModel;
import ats.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService=registrationService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationModel registrationModel) {
        return registrationService.registerUser(registrationModel);
    }

    @GetMapping("/users")
    public List<RegistrationModel> getAllUsers() {
        return registrationService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public RegistrationModel getUserById(@PathVariable Long id) {
        try {
            return registrationService.getUserById(id);
        } catch (UserNotFoundException userNotFoundException) {
            return null;
        }
    }
}
