package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {

			//*** Transaction ***
			session.beginTransaction();
			
			//*** ACTION ***
			
			// Get Course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
						
			// Delete Course
			System.out.println("Deleting Course \nID: " + theId + "\nDetails: " + tempCourse);
			session.delete(tempCourse);			

			
			//*** Commit ***
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			// Clean-up:
			session.close();
			
			factory.close();
		}
	}

}
