package com.example.demo.controller;

import com.example.demo.Service.UsersService;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final UsersService userService;

    @Autowired
    public UsersController(UsersService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(
            @RequestParam String login,
            @RequestParam String password
    ){
        Users user = userService.registerUser(login, password);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{login}")
    public ResponseEntity<Users> getUserByLogin(@PathVariable String login){
        return userService.findByLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
