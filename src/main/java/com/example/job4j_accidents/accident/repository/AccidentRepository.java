package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.Accident;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @EntityGraph(attributePaths = { "rules", "type"})
    Iterable<Accident> findAll();

    @EntityGraph(attributePaths = { "rules" })
    Optional<Accident> findById(int id);
}