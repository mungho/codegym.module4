//package com.example.demo.controller;
//
//import com.example.demo.service.IExchangeMoneyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ExchangeMoney {
//    @Autowired
//    IExchangeMoneyService exchangeMoneyService;
//
//    @PostMapping("/exchange")
//    public String exchangeMoney(@RequestParam(name = "usd") double usd, Model model) {
//        model.addAttribute("vnd", exchangeMoneyService.exchangeMoney(usd));
//        return"/exchange";
//    }
//}


package com.example.demo.controller;

import com.example.demo.service.IExchangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoney {

    @Autowired
    private IExchangeMoneyService exchangeMoneyService;

    @GetMapping("/exchange")
    public String showForm() {
        return "exchange";
    }

    @PostMapping("/exchange")
    public String exchangeMoney(@RequestParam("usd") double usd, Model model) {
        double vnd = exchangeMoneyService.exchangeMoney(usd);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "exchange";
    }

}
