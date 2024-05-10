package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/scm")
public class Welcome {

    @GetMapping("")
    public String home() {
        return "home";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    } @GetMapping("/service")
    public String service() {
        return "service";
    } @GetMapping("/contact")
    public String contact() {
        return "contact";
    } @GetMapping("/signup")
    public String signup() {
        return "signup";
    } @GetMapping("/login")
    public String login() {
        return "login";
    }

}
