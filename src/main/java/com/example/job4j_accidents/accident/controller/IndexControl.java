package com.example.job4j_accidents.accident.controller;

import com.example.job4j_accidents.accident.model.Accident;
import com.example.job4j_accidents.accident.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class IndexControl {
    private final AccidentService accidentService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Accident> accidentList = accidentService.findAll();
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidentList);
        return "index";
    }
}