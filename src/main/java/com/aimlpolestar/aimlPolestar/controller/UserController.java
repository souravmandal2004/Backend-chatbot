package com.aimlpolestar.aimlPolestar.controller;

import com.aimlpolestar.aimlPolestar.model.UserDetails;
import com.aimlpolestar.aimlPolestar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
     private final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/signup")
    public ResponseEntity<String> saveDetails (@RequestBody UserDetails userDetails) {
        return userService.signUpUser(userDetails);
    }

    @GetMapping ("/allusers")
    public List<UserDetails> allUsers () {
        return userService.findAllUserDetails();
    }
}

