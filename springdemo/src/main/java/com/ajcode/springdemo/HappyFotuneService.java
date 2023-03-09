package com.ajcode.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFotuneService implements FortuneService{

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your luck day";
	}

}
