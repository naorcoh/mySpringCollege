package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.UserProfile;
import com.example.SpringBootCollegeApp.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/displayProfile")
    public ModelAndView displayUserProfile(HttpSession session) {

        UserProfile userProfile = userProfileService.getUserProfile(session);
        ModelAndView modelAndView = new ModelAndView("userProfile.html");
        modelAndView.addObject("userProfile", userProfile);

        return modelAndView;
    }
}
