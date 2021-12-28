package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.City;



public interface ICityService {
	
	public String createCity(City city);
	public int count();
	public String updateCity(City city);
	public List<City> findAll();	
	public String DeleteCity(City city);
	public City ShowCity(int id);
	
}
