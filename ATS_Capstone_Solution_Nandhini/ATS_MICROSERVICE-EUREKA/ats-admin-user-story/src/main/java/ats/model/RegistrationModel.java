package ats.model;

import java.time.LocalDateTime;

public class RegistrationModel {
    private Long id;
    private String emailId;
    private String password;
    private String phoneNumber;
    private int failedAttempts;
    private boolean isLocked;
    private LocalDateTime lockTime;

    public RegistrationModel(){
    }

    public RegistrationModel(String emailId, String password, Long id, String phoneNumber, int failedAttempts, boolean isLocked, LocalDateTime lockTime){
        this.emailId=emailId;
        this.password=password;
        this.id=id;
        this.phoneNumber=phoneNumber;
        this.failedAttempts=failedAttempts;
        this.isLocked=isLocked;
        this.lockTime=lockTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

}
