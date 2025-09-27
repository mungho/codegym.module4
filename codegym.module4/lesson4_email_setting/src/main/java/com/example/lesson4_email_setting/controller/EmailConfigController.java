package com.example.lesson4_email_setting.controller;

import com.example.lesson4_email_setting.entity.EmailConfig;
import com.example.lesson4_email_setting.service.IEmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailConfigController {

    @Autowired
    IEmailConfigService emailConfigService;

    @GetMapping("/email-config")
    public String showEmailConfig(Model model) {
        model.addAttribute("emailConfig", emailConfigService.getEmailConfig());
        return "email-config";
    }

    @PostMapping("/email-config")
    public String saveEmailConfig(@ModelAttribute(name = "emailConfig")EmailConfig emailConfig,
                                  RedirectAttributes redirectAttributes) {
        boolean result = emailConfigService.saveEmailConfig(emailConfig);

        return "redirect:/email-config";
    }
}
