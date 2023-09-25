package com.example.job4j_accidents.accident.service;

import com.example.job4j_accidents.accident.model.AccidentType;
import com.example.job4j_accidents.accident.repository.AccidentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private final AccidentTypeRepository accidentTypeRepository;

    public List<AccidentType> getAccidentTypes() {
        List<AccidentType> types = new ArrayList<>();
        accidentTypeRepository.findAll()
                .forEach(types::add);
        return types;
    }

    public AccidentType findById(int id) {
        return accidentTypeRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
