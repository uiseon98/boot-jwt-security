package org.example.bootjwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baseball")
public class BaseballController {
    @GetMapping("/teams")
    public String findAllTeams() {
        return "All teams";
    }
}
