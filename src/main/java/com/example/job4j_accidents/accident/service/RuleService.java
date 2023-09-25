package com.example.job4j_accidents.accident.service;

import com.example.job4j_accidents.accident.model.Rule;
import com.example.job4j_accidents.accident.repository.RuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepository;

    public List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        ruleRepository.findAll()
                .forEach(rules::add);
        return rules;
    }

    public Rule findById(int id) {
        return ruleRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}

