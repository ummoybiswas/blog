package com.sqh.blog.controller;

import com.sqh.blog.controller.form.RegistrationForm;
import com.sqh.blog.model.User;
import com.sqh.blog.service.UserService;
import com.sqh.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute RegistrationForm registrationForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        userValidator.validate(registrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User blogger = userService.createBlogger(registrationForm.getFullName(), registrationForm.getUsername(), registrationForm.getPassword());
        if (blogger != null) {
            redirectAttributes.addFlashAttribute("message", "Your account is created. You can login, once the admin approve your account.");
        }
        return "redirect:login";
    }
}
