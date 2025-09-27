package com.example.lesson4_email_setting.service;

import com.example.lesson4_email_setting.entity.EmailConfig;
import com.example.lesson4_email_setting.repository.EmailConfigRepository;
import com.example.lesson4_email_setting.repository.IEmailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigService implements IEmailConfigService {
    @Autowired
    IEmailConfigRepository emailConfigRepository;

    @Override
    public EmailConfig getEmailConfig() {
        return emailConfigRepository.getEmailConfig();
    }

    @Override
    public boolean saveEmailConfig(EmailConfig emailConfig) {
        return emailConfigRepository.saveEmailConfig(emailConfig);
    }
}
