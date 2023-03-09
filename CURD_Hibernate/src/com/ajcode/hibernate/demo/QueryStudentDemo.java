package com.ajcode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			//begin transaction
			session.beginTransaction();
			
			//query students
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Student> theStds= session.createQuery("from Student").list();	
			
			displayStudents(theStds);
			
			theStds = session.createQuery("from Student s where s.lastName ='Duck' or s.firstName ='ajay1'").list();
			
			displayStudents(theStds);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			}finally{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStds) {
		theStds.forEach(System.out::println);
	}

}


