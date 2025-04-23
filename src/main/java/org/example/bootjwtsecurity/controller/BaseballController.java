package org.example.bootjwtsecurity.controller;

import org.example.bootjwtsecurity.model.entity.Team;
import org.example.bootjwtsecurity.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baseball")
public class BaseballController {
    private final TeamService teamService;

    public BaseballController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> findAllTeams() {
        return ResponseEntity.ok(teamService.findAllTeams());
    }

}
