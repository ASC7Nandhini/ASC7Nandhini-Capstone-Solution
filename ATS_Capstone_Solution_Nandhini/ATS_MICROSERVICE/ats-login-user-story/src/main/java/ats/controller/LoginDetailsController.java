package ats.controller;

import ats.exception.UserNotFoundException;
import ats.model.LoginDetailsModel;
import ats.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginDetailsController {
    private final LoginService loginService;

    @Autowired
    public LoginDetailsController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/logindetails")
    public List<LoginDetailsModel> getAllLoginDetails(){
        return loginService.getAllLoginDetails();
    }

    @GetMapping("/{id}")
    public LoginDetailsModel getLoginDetailsById(@PathVariable Long id) {
        try {
            return loginService.getLoginDetailsById(id);
        } catch (UserNotFoundException userNotFoundException) {
            return null;
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDetailsModel loginRequest) {
        return loginService.login(loginRequest);
    }
}
