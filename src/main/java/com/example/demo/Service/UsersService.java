package com.example.demo.Service;

import com.example.demo.model.Users;

import java.util.Optional;

public interface UsersService {
    Users registerUser(String login, String password);
    Optional<Users> findByLogin(String login);
}
