package com.ajcode.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajcode.hibernate.demo.entity.Course;
import com.ajcode.hibernate.demo.entity.Instructor;
import com.ajcode.hibernate.demo.entity.InstructorDetail;
import com.ajcode.hibernate.demo.entity.Review;
import com.ajcode.hibernate.demo.entity.Student;


public class CreateCourseandStudentDemo {

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
			
			
			Course tempCourse = new Course("Pacman -Sore more");
			
            
			 System.out.println("Saving Course");
			 session.save(tempCourse);
			 
			 Student std1 = new Student("ajay","akole","ajay@gmail.com");
			 Student std2 = new Student("vijay","akole","vijay@gmail.com");
			 
			tempCourse.addStudent(std1);
			tempCourse.addStudent(std2);
			 
			 System.out.println("Saving Students");
			 
			 
			 session.save(std1);
			 session.save(std2);
			
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





