package com.scm.controller;

import com.scm.dto.RegisterDto;
import com.scm.entity.User;
import com.scm.helper.Alert;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scm")
public class Welcome {

    private UserService userService;

    @Autowired
    public Welcome(UserService userService) {
        this.userService = userService;
    }

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
    public String signup(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "signup";
    } @GetMapping("/login")
    public String login() {
        return "login";
    }

    // post register endpoint
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterDto registerDto,BindingResult bindingResult, HttpSession httpSession) {
        // validate the form
        if(bindingResult.hasErrors()){
            return "signup";
        }
        // get the form details from modelAttribute
        User user = User.builder()
                .username(registerDto.getName())
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .about(registerDto.getAbout())
                .build();
        // save the user
        userService.saveUser(user);
        // redirect to login page
        Alert alert = Alert.builder()
                .message("Registered Successfully")
                .type("green")
                .build();
        httpSession.setAttribute("alert", alert);
        return "redirect:/scm/signup";
        // else redirect to signp page
//        return "register";
    }

}
