package ats;

import ats.model.LoginDetailsModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class LoginDetailsModelTest {

    LoginDetailsModel loginDetails = new LoginDetailsModel("nandhu@1", "Password123!", 1L,
            "1234567890", 3, true, LocalDateTime.now());
    @Test
    public void testIdField() {
        Long actualId = loginDetails.getId();
        Assertions.assertEquals(1L, actualId);
    }

    @Test
    public void testEmailIdField() {
        String actualEmailId = loginDetails.getEmailId();
        Assertions.assertEquals("nandhu@1", actualEmailId);
    }

    @Test
    public void testPasswordField() {
        String actualPassword = loginDetails.getPassword();
        Assertions.assertEquals("Password123!", actualPassword);
    }

    @Test
    public void testPhoneNumberField() {
        String actualPhoneNumber = loginDetails.getPhoneNumber();
        Assertions.assertEquals("1234567890", actualPhoneNumber);
    }

    @Test
    public void testFailedAttemptsField() {
        int actualFailedAttempts = loginDetails.getFailedAttempts();
        Assertions.assertEquals(3, actualFailedAttempts);
    }

    @Test
    public void testIsLockedField() {
        LoginDetailsModel loginDetailsLocked = new LoginDetailsModel("pravi@12", "Hello12!", 2L,
                "1234567890", 3, true, LocalDateTime.now());
        LoginDetailsModel loginDetailsNotLocked = new LoginDetailsModel("mithu@14", "World14!", 3L,
                "1234567890", 3, false, LocalDateTime.now());

        Assertions.assertTrue(loginDetailsLocked.isLocked());
        Assertions.assertFalse(loginDetailsNotLocked.isLocked());
    }

    @Test
    public void testLockTimeField() {
        LocalDateTime expectedLockTime = LocalDateTime.now();
        LoginDetailsModel loginDetails = new LoginDetailsModel("test@example.com", "Password123!", 1L,
                "1234567890", 3, true, expectedLockTime);

        LocalDateTime actualLockTime = loginDetails.getLockTime();
        Assertions.assertEquals(expectedLockTime, actualLockTime);
    }
}
