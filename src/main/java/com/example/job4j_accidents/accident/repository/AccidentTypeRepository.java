package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.AccidentType;
import org.springframework.data.repository.CrudRepository;

public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}