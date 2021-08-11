package com.vitaliy.demo.control;

import com.vitaliy.demo.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getProfile() {

        if(userService.getCurrentLoggedUser() == null) {
            return "/login";
        }

        return "profile";
    }
}
