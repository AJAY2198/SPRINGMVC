package com.ajcode.springdemo;

import org.springframework.stereotype.Component;

@Component("fortune")
public class BadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your bad day";
	}

}
