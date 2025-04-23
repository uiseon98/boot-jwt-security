package org.example.bootjwtsecurity.service;

import org.example.bootjwtsecurity.model.entity.Team;
import org.example.bootjwtsecurity.model.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }
}
