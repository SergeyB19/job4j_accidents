package com.example.job4j_accidents.accident.controller;

import com.example.job4j_accidents.accident.model.User;
import com.example.job4j_accidents.accident.repository.AuthorityRepository;
import com.example.job4j_accidents.accident.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService users;
    private final AuthorityRepository authorities;

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        if (users.findByName(user.getUsername()).isPresent()) {
            return "redirect:/reg?error=true";
        }
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage(@RequestParam(value = "error", required = false) String error, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "The user with this name is exist !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "reg";
    }
}