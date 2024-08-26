package ats;

import ats.model.RegistrationModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RegistrationModelTest {

    RegistrationModel registrationModel = new RegistrationModel("nandhu@1", "Password123!", 1L,
            "1234567890", 3, true, LocalDateTime.now());
    @Test
    public void testIdField() {
        Long actualId = registrationModel.getId();
        Assertions.assertEquals(1L, actualId);
    }

    @Test
    public void testEmailIdField() {
        String actualEmailId = registrationModel.getEmailId();
        Assertions.assertEquals("nandhu@1", actualEmailId);
    }

    @Test
    public void testPasswordField() {
        String actualPassword = registrationModel.getPassword();
        Assertions.assertEquals("Password123!", actualPassword);
    }

    @Test
    public void testPhoneNumberField() {
        String actualPhoneNumber = registrationModel.getPhoneNumber();
        Assertions.assertEquals("1234567890", actualPhoneNumber);
    }

    @Test
    public void testFailedAttemptsField() {
        int actualFailedAttempts = registrationModel.getFailedAttempts();
        Assertions.assertEquals(3, actualFailedAttempts);
    }

    @Test
    public void testIsLockedField() {
        RegistrationModel loginDetailsLocked = new RegistrationModel("pravi@12", "Hello12!", 2L,
                "1234567890", 3, true, LocalDateTime.now());
        RegistrationModel loginDetailsNotLocked = new RegistrationModel("mithu@14", "World14!", 3L,
                "1234567890", 3, false, LocalDateTime.now());

        Assertions.assertTrue(loginDetailsLocked.isLocked());
        Assertions.assertFalse(loginDetailsNotLocked.isLocked());
    }

    @Test
    public void testLockTimeField() {
        LocalDateTime expectedLockTime = LocalDateTime.now();
        RegistrationModel loginDetails = new RegistrationModel("test@example.com", "Password123!", 1L,
                "1234567890", 3, true, expectedLockTime);

        LocalDateTime actualLockTime = loginDetails.getLockTime();
        Assertions.assertEquals(expectedLockTime, actualLockTime);
    }
}
