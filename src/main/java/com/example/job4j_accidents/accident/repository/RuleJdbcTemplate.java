package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.Rule;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RuleJdbcTemplate {

    private final JdbcTemplate jdbc;

    public List<Rule> getRules() {
        return jdbc.query("select * from rule",
                (rs, row) -> {
                    var rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

}
