package com.example.sandwich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/sandwich/condiments")
    public String getSandwichCondiments() {
        return "condiment_list";
    }

    @GetMapping("/sandwich/condiments/selected")
    public String postSandwichCondiments(@RequestParam(name = "condiments", required = false ) List<String> condiments,
                                         Model model) {
        model.addAttribute("condiments", condiments);
        return "sandwichcondiments";
    }
}
