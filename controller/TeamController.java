package com.example.cuadrangular.cuadrangularWS.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuadrangular.cuadrangularWS.model.Match;
import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.service.ITeamService;
@RestController
public class TeamController {
	@Autowired
	private ITeamService ts;
	
	@PostMapping("/TeamC")
	public String cMatch(@RequestBody Team team) {
		JSONObject respuesta= new JSONObject();
		if(ts.createTeam(team).equals("SAVED")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
}
