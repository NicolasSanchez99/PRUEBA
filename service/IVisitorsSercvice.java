package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import com.example.cuadrangular.cuadrangularWS.model.Visitors;

public interface IVisitorsSercvice {
 
	public String createVisitors(Visitors team);
	public int count();
	public String updateVisitors(Visitors team);
	public List<Visitors> findAll();	
	public String DeleteVisitors(Visitors team);
	public Visitors ShowVisitors(int id);
	
}
