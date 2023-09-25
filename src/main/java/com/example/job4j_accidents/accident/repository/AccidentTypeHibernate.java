package com.example.job4j_accidents.accident.repository;

import com.example.job4j_accidents.accident.model.AccidentType;
import com.example.job4j_accidents.accident.util.TransactionService;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AccidentTypeHibernate implements TransactionService {

    private static final String QUERY_GET_ALL_TYPES = "select a from AccidentType a";
    private final SessionFactory sf;

    public List<AccidentType> getAccidentTypes() {
        return this.tx(
                session -> session.createQuery(QUERY_GET_ALL_TYPES, AccidentType.class)
                        .list(),
                sf
        );
    }
}

