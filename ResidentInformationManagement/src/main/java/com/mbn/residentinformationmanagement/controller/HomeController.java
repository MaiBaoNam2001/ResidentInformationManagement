package com.mbn.residentinformationmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("welcome", "Welcome to Spring Boot.");
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
