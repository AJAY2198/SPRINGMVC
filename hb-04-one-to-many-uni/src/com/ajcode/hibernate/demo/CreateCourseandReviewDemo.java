package com.ajcode.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Course;
import com.ajcode.hibernate.demo.entity.Instructor;
import com.ajcode.hibernate.demo.entity.InstructorDetail;
import com.ajcode.hibernate.demo.entity.Review;


public class CreateCourseandReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			Course tempCourse = new Course("Pacman -Sore more");
			
			
			
			tempCourse.addReview(new Review("Great"));
			tempCourse.addReview(new Review("Bad"));
			tempCourse.addReview(new Review("Okay"));
			
			 session.save(tempCourse);
			
			
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





