package com.ajcode.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	
	@Value("${poo.email}")
	private String email;
	@Value("${poo.team}")
	private String team;
	
	
	
	private FortuneService fortuneService;
	
	
	public SwimCoach(FortuneService fortuneService ) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Nusta poh";
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}


	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	
}
