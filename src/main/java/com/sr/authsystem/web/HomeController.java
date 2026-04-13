package com.sr.authsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    // Public Landing Page
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Dashboard (after login)
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}