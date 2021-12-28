package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Hosts;

public interface IHostsService {

	public String createHosts(Hosts team);
	public int count();
	public String updateHosts(Hosts team);
	public List<Hosts> findAll();	
	public String DeleteHosts(Hosts team);
	public Hosts ShowHosts(int id);
	
}
