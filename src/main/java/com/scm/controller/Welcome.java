package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
