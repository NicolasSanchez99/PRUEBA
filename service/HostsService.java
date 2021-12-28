package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cuadrangular.cuadrangularWS.model.Hosts;
import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.model.Visitors;
import com.example.cuadrangular.cuadrangularWS.repository.IHostsRepository;
import com.example.cuadrangular.cuadrangularWS.repository.ITeamRepository;

public class HostsService implements IHostsService{

	@Autowired
	private IHostsRepository hr;
	
	@Override
	public String createHosts(Hosts team) {
		try {
			hr.save(team);
			return "SAVED TEAM";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=hr.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateHosts(Hosts team) {
		try {
        	int busqueda= team.getIdHosts();
            if(hr.getOne(busqueda)!=null) {
                hr.delete(team);
                hr.save(team);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<Hosts> findAll() {
		try {
			List<Hosts> encontrado=hr.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteHosts(Hosts team) {
		try {
			if(hr.getOne(team.getIdHosts())!=null) {
				hr.delete(team);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public Hosts ShowHosts(int id) {
		Hosts ho = new Hosts();
		try {
			if(hr.getOne(id)!=null) {
				ho=hr.getOne(id);
				return ho;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	}
	

