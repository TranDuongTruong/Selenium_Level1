package com.Railway.model;

public class Email {
    private String inboxId;
    private String emailAddress;
    private String expiresAt;

    public Email(String inboxId, String emailAddress, String expiresAt) {
        this.inboxId = inboxId;
        this.emailAddress = emailAddress;
        this.expiresAt = expiresAt;
    }

    public String getInboxId() {
        return inboxId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getExpiresAt() {
        return expiresAt;
    }
}
