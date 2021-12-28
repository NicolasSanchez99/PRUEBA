package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Match;
import com.example.cuadrangular.cuadrangularWS.model.Team;

public interface IMatchService {
	
	public String createMatch(Match match);
	public int count();
	public String updateMatch(Match match);
	public List<Match> findAll();	
	public String DeleteMatch(Match match);
	public Match ShowMatch(int id);
	
	
}
