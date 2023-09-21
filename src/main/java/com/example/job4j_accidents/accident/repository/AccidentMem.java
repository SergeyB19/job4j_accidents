package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.Accident;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private final AtomicInteger id = new AtomicInteger(0);

    public void save(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(id.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

    public Optional<Accident> findById(int id) {
        return Optional.ofNullable(accidents.get(id));
    }
}