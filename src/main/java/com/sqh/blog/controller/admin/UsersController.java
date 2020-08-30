package com.sqh.blog.controller.admin;

import com.sqh.blog.controller.form.RegistrationForm;
import com.sqh.blog.controller.mapper.UserViewDataMapper;
import com.sqh.blog.service.UserService;
import com.sqh.blog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserViewDataMapper mapper;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("bloggers", mapper.map(userService.getBloggers()));
        model.addAttribute("admins", mapper.map(userService.getAdmins()));

        return "admin/users";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "admin/user-create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute RegistrationForm registrationForm, BindingResult bindingResult) {
        userValidator.validate(registrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/user-create";
        }
        userService.createAdmin(registrationForm.getFullName(), registrationForm.getUsername(), registrationForm.getPassword());
        return "redirect:/users";
    }

    @GetMapping("/users/enabled/{id}")
    public String toggleEnabledUser(@PathVariable Long id) {
        userService.findById(id)
                .ifPresent(user -> userService.toggleEnabledUser(user));
        return "redirect:/users";
    }
}
