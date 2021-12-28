package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Team;



public interface ITeamService {

	public String createTeam(Team team);
	public int count();
	public String updateTeam(Team team);
	public List<Team> findAll();	
	public String DeleteTeam(Team team);
	public Team ShowTeam(int id);
	
	
}
