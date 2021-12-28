package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.repository.ITeamRepository;







@Service
public class TeamService implements ITeamService{

	@Autowired
	private ITeamRepository teamRP;

	@Override
	public String createTeam(Team team) {
		try {
			teamRP.save(team);
			return "SAVED TEAM";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=teamRP.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateTeam(Team team) {
		try {
        	int busqueda= team.getIdteam();
            if(teamRP.getOne(busqueda)!=null) {
                teamRP.delete(team);
                teamRP.save(team);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<Team> findAll() {
		try {
			List<Team> encontrado=teamRP.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteTeam(Team team) {
		try {
			if(teamRP.getOne(team.getIdteam())!=null) {
				teamRP.delete(team);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public Team ShowTeam(int id) {
		Team team= new Team();
		try {
			if(teamRP.getOne(id)!=null) {
				team=teamRP.getOne(id);
				return team;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	
	
}
