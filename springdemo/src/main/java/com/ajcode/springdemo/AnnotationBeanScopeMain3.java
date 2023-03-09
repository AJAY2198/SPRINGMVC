package com.ajcode.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationBeanScopeMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		
		
		// call a method on the bean
		
		
		System.out.println( theCoach.getDailyWorkout()+"\n"+
		theCoach.getFortune()+"\n"+ theCoach.getEmail() +"\n" + theCoach.getTeam());
		
		
				
		// close the context
		context.close();
		

	}

}
