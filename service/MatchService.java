package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuadrangular.cuadrangularWS.model.Match;
import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.repository.IMatchRepository;

@Service
public class MatchService implements IMatchService{
	
	@Autowired
	private IMatchRepository matchRP;
	
	private TeamService ts;

	@Override
	public String createMatch(Match match) {
		try {
			matchRP.save(match);
			return "SAVED";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=matchRP.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateMatch(Match match) {
		try {
        	int busqueda= match.getIdmatch();
            if(matchRP.getOne(busqueda)!=null) {
            	matchRP.delete(match);
            	matchRP.save(match);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<Match> findAll() {
		try {
			List<Match> encontrado=matchRP.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteMatch(Match match) {
		try {
			if(matchRP.getOne(match.getIdmatch())!=null) {
				matchRP.delete(match);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public Match ShowMatch(int id) {
		Match match= new Match();
		try {
			if(matchRP.getOne(id)!=null) {
				match=matchRP.getOne(id);
				return match;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}


	}
