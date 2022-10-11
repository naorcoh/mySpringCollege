package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.User;
import com.example.SpringBootCollegeApp.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dash")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {

        User currentUser = dashboardService.storeUserInfoPerSession(authentication, session);

        model.addAttribute("username",currentUser.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());

        return "dashboard.html";

    }
}
