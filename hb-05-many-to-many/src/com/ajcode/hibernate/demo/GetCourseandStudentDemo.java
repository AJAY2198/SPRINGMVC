package com.ajcode.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Course;
import com.ajcode.hibernate.demo.entity.Instructor;
import com.ajcode.hibernate.demo.entity.InstructorDetail;
import com.ajcode.hibernate.demo.entity.Review;
import com.ajcode.hibernate.demo.entity.Student;


public class GetCourseandStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			
			 int theId=3;
			 Student std1 = session.get(Student.class, theId);
			
			 
			System.out.println("Student:"+ std1);
			
			
			System.out.println("Course: "+ std1.getCourses());
			

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





