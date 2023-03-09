package com.ajcode.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.ajcode.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	
	
	
    //define bean for sad fortune service
	@Bean
	public FortuneService sadFortune() {
		return new SadFortuneService();
	}
	
	// define for swim coach
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortune());
	}
}
