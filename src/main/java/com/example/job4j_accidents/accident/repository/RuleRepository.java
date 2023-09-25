package com.example.job4j_accidents.accident.repository;


import com.example.job4j_accidents.accident.model.Rule;
import org.springframework.data.repository.CrudRepository;

public interface RuleRepository extends CrudRepository<Rule, Integer> {
}