package com.freshcart.controllers;



import com.freshcart.entities.User;
import com.freshcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show registration page
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        user.setRole(User.Role.CUSTOMER); // default role CUSTOMER
        userService.registerUser(user);
        model.addAttribute("msg", "Registration successful! Please login.");
        return "login";
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User loggedIn = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedIn != null) {
            model.addAttribute("user", loggedIn);
            
            if (loggedIn.getRole() == User.Role.ADMIN) {
                return "admin-dashboard";  // Admin ke liye
            } else {
                return "user-dashboard";   // Customer ke liye
            }
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }

}

