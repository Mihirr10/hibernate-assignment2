package com.hibernate.assignment2.service.implementation;

import com.hibernate.assignment2.entities.Team;
import com.hibernate.assignment2.exception.TeamNotFound;
import com.hibernate.assignment2.repository.PlayerRepository;
import com.hibernate.assignment2.repository.TeamRepository;
import com.hibernate.assignment2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImplementation implements TeamService {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  PlayerRepository playerRepository;

  @Override
  public List<Team> getAllTeams() {
    return teamRepository.findAll();
  }

//  public Team getTeamByTeamName(String teamName){
//    return teamRepository.getTeamByTeamName(teamName);
//  }

  @Override
  public Team getTeamWithId(int id) {
    Optional<Team> team = teamRepository.findById(id);

    if (team.isPresent()) {
      return teamRepository.save(team.get());
    } else {
      throw new TeamNotFound("Please enter valid team id");
    }
  }

  @Override
  public Team createTeam(Team team) {

    if (team != null) {
       team.getPlayers().forEach(player -> player.setTeam(team));
      return teamRepository.save(team);
    } else {
      throw new TeamNotFound("failed to create team please enter valid details");
    }
  }

  @Override
  public Team updateTeam(Team team, int id) {

    Team team1 = teamRepository.findById(id).orElse(null);
    if (team1 == null) {
      throw new TeamNotFound("team not found");
    } else {
//      team.getPlayers().forEach(player -> player.setTeam(team));
      team.setTeamId(id);
    }
    return teamRepository.save(team);
  }

  @Override
  public void deleteTeam(int id) {
    Optional<Team> team = teamRepository.findById(id);

    if (team.isPresent()) {
      teamRepository.delete(team.get());
    } else {
      throw new TeamNotFound("failed to delete student please enter valid id");
    }
  }
}
