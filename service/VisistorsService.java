package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.model.Tournament;
import com.example.cuadrangular.cuadrangularWS.model.Visitors;
import com.example.cuadrangular.cuadrangularWS.repository.ITeamRepository;
import com.example.cuadrangular.cuadrangularWS.repository.IVersusRepository;
import com.example.cuadrangular.cuadrangularWS.repository.IVisistorsRepository;

public class VisistorsService implements IVisitorsSercvice{

	@Autowired
	private IVisistorsRepository vr;
	
	@Override
	public String createVisitors(Visitors team) {
		try {
			vr.save(team);
			return "SAVED TEAM";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=vr.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateVisitors(Visitors team) {
		try {
        	int busqueda= team.getIdVisistors();
            if(vr.getOne(busqueda)!=null) {
                vr.delete(team);
                vr.save(team);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<Visitors> findAll() {
		try {
			List<Visitors> encontrado=vr.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteVisitors(Visitors team) {
		try {
			if(vr.getOne(team.getIdVisistors())!=null) {
				vr.delete(team);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public Visitors ShowVisitors(int id) {
		Visitors vi = new Visitors();
		try {
			if(vr.getOne(id)!=null) {
				vi=vr.getOne(id);
				return vi;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	}
	

