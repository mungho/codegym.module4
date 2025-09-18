package com.example.lesson4_email_setting.entity;

public class EmailConfig {
    private String language;
    private int pageSize;
    private boolean isEmailEnabled;
    private String signature;

    public EmailConfig(String language, int pageSize, boolean isEmailEnabled, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.isEmailEnabled = isEmailEnabled;
        this.signature = signature;
    }

    public EmailConfig() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEmailEnabled() {
        return isEmailEnabled;
    }

    public void setEmailEnabled(boolean emailEnabled) {
        isEmailEnabled = emailEnabled;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
