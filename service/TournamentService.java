package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.model.Tournament;
import com.example.cuadrangular.cuadrangularWS.repository.ITeamRepository;
import com.example.cuadrangular.cuadrangularWS.repository.ITournamentRepository;

public class TournamentService implements ITournamentService{

	@Autowired
	private ITournamentRepository tr;

	@Override
	public String createTor(Tournament tor) {
		try {
			tr.save(tor);
			return "SAVED TEAM";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=tr.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateTor(Tournament tor) {
		try {
        	int busqueda= tor.getIdtournament();
            if(tr.getOne(busqueda)!=null) {
                tr.delete(tor);
                tr.save(tor);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<Tournament> findAll() {
		try {
			List<Tournament> encontrado=tr.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteTor(Tournament tor) {
		try {
			if(tr.getOne(tor.getIdtournament())!=null) {
				tr.delete(tor);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public Tournament ShowTor(int id) {
		Tournament tor = new Tournament();
		try {
			if(tr.getOne(id)!=null) {
				tor=tr.getOne(id);
				return tor;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	}
	
	
	
	

