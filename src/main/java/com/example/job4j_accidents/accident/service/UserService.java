package com.example.job4j_accidents.accident.service;

import com.example.job4j_accidents.accident.model.User;
import com.example.job4j_accidents.accident.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
