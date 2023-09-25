package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.Authority;
import org.springframework.data.repository.CrudRepository;


public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}