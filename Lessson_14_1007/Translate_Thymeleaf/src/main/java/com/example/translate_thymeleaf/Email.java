package com.example.translate_thymeleaf;

public class Email {
    private String emailSubject;

    public Email() {
    }

    public Email(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
}
