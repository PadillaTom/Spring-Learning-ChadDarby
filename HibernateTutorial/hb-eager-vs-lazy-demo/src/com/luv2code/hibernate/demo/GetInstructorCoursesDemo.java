package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class GetInstructorCoursesDemo {

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
			
			// ---- Get Instructor by ID ----
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor is: \n" + tempInstructor );
			System.out.println("***");
			
			// --- Get Courses ---
			System.out.println("Courses: " + tempInstructor.getCourses());

			
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
