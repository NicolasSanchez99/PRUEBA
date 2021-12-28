package com.example.cuadrangular.cuadrangularWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuadrangular.cuadrangularWS.model.Match;
import com.example.cuadrangular.cuadrangularWS.model.Team;



public interface IMatchRepository extends JpaRepository<Match, Integer>{
	
	
		
	
}
