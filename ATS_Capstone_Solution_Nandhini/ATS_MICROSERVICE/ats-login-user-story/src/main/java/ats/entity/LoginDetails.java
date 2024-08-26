package ats.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class LoginDetails {

    @Id
    @Column (name = "id")
    private Long id;
    @Column(name = "email_id", nullable = false)
    private String emailId;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;
    @Column(name = "failed_attempts" , nullable = false)
    private int failedAttempts=0;
    @Column(name = "is_locked" , nullable = false)
    private boolean isLocked=false;
    @Column(name = "lock_time")
    private LocalDateTime lockTime;

    public LoginDetails(){
    }

    public LoginDetails(String emailId, String password, Long id, String phoneNumber, int failedAttempts, boolean isLocked, LocalDateTime lockTime){
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
