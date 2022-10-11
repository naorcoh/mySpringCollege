package com.example.SpringBootCollegeApp.service;

import com.example.SpringBootCollegeApp.model.User;
import com.example.SpringBootCollegeApp.model.UserProfile;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserProfileService {

    public UserProfile getUserProfile(HttpSession session) {

        UserProfile userProfile = new UserProfile();

        User user = (User) session.getAttribute("loggedInUser");

        userProfile.setName(user.getName());
        userProfile.setMobileNumber(user.getMobileNumber());
        userProfile.setEmail(user.getEmail());

        if (user.getAddress() != null && user.getAddress().getAddressId() > 0) {
            userProfile.setAddress1(user.getAddress().getAddress1());
            userProfile.setAddress2(user.getAddress().getAddress2());
            userProfile.setCity(user.getAddress().getCity());
            userProfile.setState(user.getAddress().getState());
            userProfile.setZipCode(user.getAddress().getZipCode());

        }

        return userProfile;

    }
}
