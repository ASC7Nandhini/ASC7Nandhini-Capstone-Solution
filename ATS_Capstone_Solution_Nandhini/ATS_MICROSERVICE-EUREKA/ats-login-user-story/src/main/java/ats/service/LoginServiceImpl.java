package ats.service;

import ats.entity.LoginDetails;
import ats.model.LoginDetailsModel;
import ats.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService{
    private final LoginDetailsRepository loginDetailsRepository;

    @Autowired
    public LoginServiceImpl(LoginDetailsRepository loginDetailsRepository){
        this.loginDetailsRepository=loginDetailsRepository;
    }

    @Override
    public List<LoginDetailsModel> getAllLoginDetails() {
        List<LoginDetails> allLoginDetails = loginDetailsRepository.findAll();
        List<LoginDetailsModel> loginDetailsModelList = new ArrayList<>();
        for (LoginDetails loginDetails : allLoginDetails) {
            LoginDetailsModel loginDetailsModel = new LoginDetailsModel(
                    loginDetails.getEmailId(),
                    loginDetails.getPassword(),
                    loginDetails.getId(),
                    loginDetails.getPhoneNumber(), // Added this field
                    loginDetails.getFailedAttempts(),
                    loginDetails.isLocked(),
                    loginDetails.getLockTime()
            );
            loginDetailsModelList.add(loginDetailsModel);
        }
        return loginDetailsModelList;
    }

    @Override
    public LoginDetailsModel getLoginDetailsById(Long id) {
        LoginDetails loginDetails = loginDetailsRepository.findById(id).orElse(null);
        if (loginDetails != null) {
            return new LoginDetailsModel(
                    loginDetails.getEmailId(),
                    loginDetails.getPassword(),
                    loginDetails.getId(),
                    loginDetails.getPhoneNumber(),
                    loginDetails.getFailedAttempts(),
                    loginDetails.isLocked(),
                    loginDetails.getLockTime()
            );
        }
        return null;
    }

    @Override
    public String login(LoginDetailsModel loginDetailsModel){
        validateEmail(loginDetailsModel.getEmailId());
        validatePassword(loginDetailsModel.getPassword());

        LoginDetails user = loginDetailsRepository.findByEmailId(loginDetailsModel.getEmailId());

        if(user == null){
            return "Invalid Email or Password";
        }
        // Checking if the account is locked or not
        if(user.isLocked()){
            if(user.getLockTime().plusSeconds(30).isBefore(LocalDateTime.now())){
                user.setLocked(false);
                user.setFailedAttempts(0);
                user.setLockTime(null);
                loginDetailsRepository.save(user);
            }
            else{
                return "Account is Locked. Please try again later";
            }
        }
        // Check password and update login attempts
        if(user.getPassword().equals(loginDetailsModel.getPassword())){
            user.setFailedAttempts(0);
            user.setLocked(false);
            user.setLockTime(null);
            loginDetailsRepository.save(user);
            return "Login Successful";
        }
        else {
            user.setFailedAttempts(user.getFailedAttempts() + 1);
            if(user.getFailedAttempts() >= 3){
                user.setLocked(true);
                user.setLockTime(LocalDateTime.now());
                loginDetailsRepository.save(user);
                return "Account is locked due to multiple failed login attempts";
            }
            else {
                loginDetailsRepository.save(user);
                return "Invalid Email or Password";
            }
        }
    }

    private void validateEmail(String emailId){
        if(emailId == null || emailId.isEmpty() || !emailId.matches("^[a-zA-Z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Invalid Email Address");
        }
    }

    private void validatePassword(String password){
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~]).+$";
        Pattern pattern = Pattern.compile(regex);

        if (!pattern.matcher(password).matches()) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character (e.g., !, @, #, $, %, etc.)");
        }
    }
}
