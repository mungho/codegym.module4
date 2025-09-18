package com.example.lesson4_email_setting.service;

import com.example.lesson4_email_setting.entity.EmailConfig;

public interface IEmailConfigService {
    EmailConfig getEmailConfig();
    boolean saveEmailConfig(EmailConfig emailConfig);
}
