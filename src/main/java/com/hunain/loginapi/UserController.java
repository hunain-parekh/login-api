package com.hunain.loginapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserRepository userRepo;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user ){
        User login_user = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        ResponseEntity<User> response =  login_user != null ? ResponseEntity.ok(login_user) : ResponseEntity.notFound().build();
        return response;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user ){
        return userRepo.save(user);
    }

}
