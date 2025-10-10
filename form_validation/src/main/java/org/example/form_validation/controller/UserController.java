package org.example.form_validation.controller;


import org.example.form_validation.entity.User;
import org.example.form_validation.service.UserService;
import org.example.form_validation.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String getUsers(Model model) {
        model.addAttribute("userList", userService.getUsers());
        model.addAttribute("user", new User());
        return "layout/list";
    }

    @GetMapping("/addUser")
    public String showForm (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.getUsers());
        model.addAttribute("openAddModal", "true");
        return "layout/list";
    }

    @PostMapping("/addUser")
    public String addUser(@Validated @ModelAttribute(name = "user") User user,
                          BindingResult bindingResult,
                          Model model, RedirectAttributes redirectAttributes) {
        UserValidation userValidation = new UserValidation();
        userValidation.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("userList", userService.getUsers());
            model.addAttribute("openAddModal", "true");
            return "layout/list";
        }
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("mess", "Add user successfully!");
        return "redirect:/";
    }
}
