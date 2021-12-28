package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.model.Versus;

public interface IVersusService {

	public String createVersus(Versus match);
	public int count();
	public String updateVersus(Versus match);
	public List<Versus> findAll();	
	public String DeleteVersus(Versus match);
	public Versus ShowMatch(int id);
	public String[] fixture(List<Team> lista);
	
}
