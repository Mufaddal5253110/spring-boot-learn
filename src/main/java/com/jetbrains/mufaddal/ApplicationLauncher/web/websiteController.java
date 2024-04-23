package com.jetbrains.mufaddal.ApplicationLauncher.web;


import com.jetbrains.mufaddal.ApplicationLauncher.web.forms.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/*
 * @RestController: for every public method’s result will (more or less) directly be written to the HTTP response body, without going through an HTML templating library.
 * @Controller: want to serve HTML instead of JSON or XML.
 * */

@Controller
public class websiteController {

    /*
     * The Model parameter is essentially a map, containing all the variables that you want to be able to access in your (Thymeleaf) templates. Spring is smart enough to automatically inject a Model into every @Controller method, if you specify it as a parameter.
     * */
    @GetMapping("/")
    public String homepage(Model model, @RequestParam(required = false, defaultValue = "stranger") String username) {
        model.addAttribute("username", username);
        model.addAttribute("currentDate", LocalDateTime.now());
        return "index.html";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login.html";
        }
        if (loginForm.getUsername().equals(loginForm.getPassword())) {
            return "redirect:/";
        }
        model.addAttribute("invalidCredentials", "true");
        return "login.html";
    }
}
