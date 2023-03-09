package com.ajcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						                .configure("hibernate.cfg.xml")
						                .addAnnotatedClass(Student.class)
						                .buildSessionFactory();
				

				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					System.out.println("Creating 3 new Student Obj");
					Student std1= new Student("ajay1","akole","ajay@gmail.com");
					Student std2 = new Student("ajay2","akole","ajay@gmail.com");
					Student std3= new Student("ajay3","akole","ajay@gmail.com");
					//begin transaction
					session.beginTransaction();
					
					//save obj
					System.out.println("Saving the student...");
					session.save(std1);
					session.save(std2);
					session.save(std3);
					
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
					
					}finally{
					factory.close();
				}

	}

}
