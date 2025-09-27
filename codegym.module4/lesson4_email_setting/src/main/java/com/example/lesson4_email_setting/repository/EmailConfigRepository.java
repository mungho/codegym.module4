package com.example.lesson4_email_setting.repository;

import com.example.lesson4_email_setting.entity.EmailConfig;
import org.springframework.stereotype.Controller;

@Controller
public class EmailConfigRepository implements IEmailConfigRepository{
    private static EmailConfig emailConfig;
    static {
        emailConfig = new EmailConfig("en", 10, true, "Hello,");
    }
    @Override
    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    @Override
    public boolean saveEmailConfig(EmailConfig newEmailConfig) {
        emailConfig = newEmailConfig;
        return true;
    }
}
