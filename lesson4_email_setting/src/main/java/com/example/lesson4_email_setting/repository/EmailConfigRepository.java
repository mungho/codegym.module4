package com.example.lesson4_email_setting.repository;

import com.example.lesson4_email_setting.entity.EmailConfig;

public class EmailConfigRepository implements IEmailConfigRepository{
    private static EmailConfig emailConfig;
    static {
        emailConfig = new EmailConfig("en", 10, true, "Hello,");
    }
    @Override
    public EmailConfig getEmailConfig() {
        return emailConfig;
    }
}
