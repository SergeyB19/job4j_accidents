package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.AccidentType;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AccidentTypeJdbcTemplate {

    private final JdbcTemplate jdbc;

    public List<AccidentType> getAccidentTypes() {
        return jdbc.query("select * from accident_type",
                (rs, row) -> {
                    var accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
    }
}
