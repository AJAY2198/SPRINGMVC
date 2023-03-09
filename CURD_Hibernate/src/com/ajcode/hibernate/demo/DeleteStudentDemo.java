package com.ajcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						                .configure("hibernate.cfg.xml")
						                .addAnnotatedClass(Student.class)
						                .buildSessionFactory();
				

				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					int id = 4;
					
					
					//begin transaction
					session.beginTransaction();
					
					Student std = session.get(Student.class,id);
					
					System.out.println(std);
					
					//session.delete(std);
					session.createQuery("delete from Student where id=4").executeUpdate();
					
								
					//commit transaction
					session.getTransaction().commit();
					
					
					
					
					
					System.out.println("Done!");
					
					}finally{
					factory.close();
				}

	}

}
