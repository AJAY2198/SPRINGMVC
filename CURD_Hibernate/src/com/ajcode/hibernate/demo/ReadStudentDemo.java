package com.ajcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						                .configure("hibernate.cfg.xml")
						                .addAnnotatedClass(Student.class)
						                .buildSessionFactory();
				

				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					System.out.println("Creating new Student Obj");
					Student std = new Student("Daffy","Duck","daffy@gmail.com");
					
					//begin transaction
					session.beginTransaction();
					
					//save obj
					System.out.println("Saving the student...");
					session.save(std);
					
					
					//commit transaction
					session.getTransaction().commit();
					
					
					//reading id from std
					System.out.println("getId of saved student "+std.getId());
					
					//getting seesion and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction();					
					
					//retrive std based on id
					Student myStd = session.get(Student.class, std.getId());
					System.out.println(myStd);
					
					//commit trans
					session.getTransaction().commit();
					
					
					System.out.println("Done!");
					
					}finally{
					factory.close();
				}

	}

}
