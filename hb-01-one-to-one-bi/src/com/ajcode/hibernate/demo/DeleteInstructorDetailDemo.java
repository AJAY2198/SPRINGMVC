package com.ajcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Instructor;
import com.ajcode.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			

			
			// start a transaction
			session.beginTransaction();
			
			//get primary id
			int id =3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println(instructorDetail);
			System.out.println("the associated instructor :"+ instructorDetail.getInstructor() );
			
			
			
			//remove asotiated obj link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
				System.out.println("Deleting...");
				
				//details obj also get deleted not instructor
				session.delete(instructorDetail);
		
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(Exception exc) {
			exc.printStackTrace();
			session.close();
		}
		finally {
			factory.close();
		}
	}

}





