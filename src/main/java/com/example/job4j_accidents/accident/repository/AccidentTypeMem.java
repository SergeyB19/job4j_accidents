package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.AccidentType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentTypeMem {

    private final HashMap<Integer, AccidentType> accidentTypes = new HashMap<>();

    public AccidentTypeMem() {
        initAccidentTypes();
    }

    private void initAccidentTypes() {
        accidentTypes.put(1, new AccidentType(1, "Две машины"));
        accidentTypes.put(2, new AccidentType(2, "Машина и человек"));
        accidentTypes.put(3, new AccidentType(3, "Машина и велосипед"));
    }

    public AccidentType findAccidentTypeById(int id) {
        return accidentTypes.get(id);
    }

    public List<AccidentType> getAccidentTypes() {
        return new ArrayList<>(accidentTypes.values());
    }
}
