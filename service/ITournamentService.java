package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Tournament;

public interface ITournamentService {
	
	public String createTor(Tournament tor);
	public int count();
	public String updateTor(Tournament tor);
	public List<Tournament> findAll();	
	public String DeleteTor(Tournament tor);
	public Tournament ShowTor(int id);
	
	
}
