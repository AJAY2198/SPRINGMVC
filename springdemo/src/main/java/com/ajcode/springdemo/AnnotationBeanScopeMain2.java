package com.ajcode.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationBeanScopeMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach thealphaCoach = context.getBean("tennisCoach", Coach.class);
		
		
		
		// call a method on the bean
		System.out.println(theCoach == thealphaCoach);
		
		System.out.println("Memory location theCoach" +theCoach);
		
		System.out.println("Memory location theaplhaCoach" +thealphaCoach);
				
		// close the context
		context.close();
		

	}

}
