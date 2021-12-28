package com.example.cuadrangular.cuadrangularWS.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuadrangular.cuadrangularWS.model.Match;
import com.example.cuadrangular.cuadrangularWS.service.IMatchService;

@RestController
public class MatchController {

	@Autowired
	private IMatchService matchS;
	
	
	@PostMapping("/matchC")
	public String cMatch(@RequestBody Match match) {
		JSONObject respuesta= new JSONObject();
		if(matchS.createMatch(match).equals("SAVED")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/l")
	public String countM() {
		JSONObject respuesta= new JSONObject();
			int aux=matchS.count();
			respuesta.put("Count", aux);
			return respuesta.toString();
		
		
	}
	
	
	
	
}
