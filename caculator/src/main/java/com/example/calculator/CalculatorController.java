package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value="number1") String number1,
                             @RequestParam(value="number2") String number2,
                             @RequestParam(value="operation") String operation,
                             Model model) {
        if (operation.equals("+")) {
            model.addAttribute("result", Integer.parseInt(number1) + Integer.parseInt(number2));
        } else if (operation.equals("-")) {
            model.addAttribute("result", Integer.parseInt(number1) - Integer.parseInt(number2));
        } else if (operation.equals("*")) {
            model.addAttribute("result", Integer.parseInt(number1) * Integer.parseInt(number2));
        } else if (operation.equals("/")) {
            model.addAttribute("result", Integer.parseInt(number1) / Integer.parseInt(number2));
        }
        return "index";
    }

}
