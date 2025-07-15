package com.example.demo.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsersServiseImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiseImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users registerUser(String login, String password) {
        if (usersRepository.findByLogin(login).isPresent()){
            throw new IllegalArgumentException("User with this login already exists");
        }

        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

}
