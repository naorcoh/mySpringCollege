package com.example.SpringBootCollegeApp.service;

import com.example.SpringBootCollegeApp.model.User;
import com.example.SpringBootCollegeApp.model.enums.EUserRoles;
import com.example.SpringBootCollegeApp.repository.RolesRepository;
import com.example.SpringBootCollegeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean createNewUser(User user) {
        user.setRoles(
                rolesRepository.getByRoleName(EUserRoles.USER.toString())
        );

        user.setPwd(
                passwordEncoder.encode(user.getPwd())
        );

       user = userRepository.save(user);
        return (user != null && user.getUserId() > 0);
    }

}
