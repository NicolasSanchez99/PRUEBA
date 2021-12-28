package com.example.cuadrangular.cuadrangularWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.cuadrangular.cuadrangularWS.controller.MatchController;

@SpringBootApplication(exclude  = { SecurityAutoConfiguration.class })
@ComponentScan("MatchController")
public class RestCuadrangular1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestCuadrangular1Application.class, args);
	}

}
