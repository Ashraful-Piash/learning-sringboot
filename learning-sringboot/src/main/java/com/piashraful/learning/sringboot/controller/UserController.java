package com.piashraful.learning.sringboot.controller;


import com.piashraful.learning.sringboot.entity.User;
import com.piashraful.learning.sringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User added successfully").toString();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()).toString();
        }

    }

    @GetMapping("/test")
    public String test() {
        return "This is a test for security";
    }

    @GetMapping("/test")
    public String testOne() {
        return "This is a test for security";
    }
}
