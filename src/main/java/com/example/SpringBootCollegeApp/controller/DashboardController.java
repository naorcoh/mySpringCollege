package com.example.SpringBootCollegeApp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dash")
    public String displayDashboard(Model model, Authentication authentication) {

        return "dash.html";

    }
}
