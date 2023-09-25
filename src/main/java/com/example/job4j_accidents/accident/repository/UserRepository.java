package com.example.job4j_accidents.accident.repository;


import com.example.job4j_accidents.accident.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}