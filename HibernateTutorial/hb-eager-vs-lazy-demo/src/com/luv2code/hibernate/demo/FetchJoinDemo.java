package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class FetchJoinDemo {

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
			// *** SOLUTION 2 TO LAZY LAODING WHEN SESSION CLOSED ***
			// QUERY with HQL
			
			
			
			// ---- Get Instructor by ID ----
			int theId = 1;
			
//			Query HQL
			// Get Instructor by ID:
			Query<Instructor> query = session.createQuery("select i from Instructor i " 
															+ "JOIN FETCH i.courses " 
															+ "where i.id=:theInstructorId"
															, Instructor.class);
			// Set Parameter to be Fetched:
			query.setParameter("theInstructorId", theId);
			// Execute and Get Instructor by parameter:
			Instructor tempInstructor = query.getSingleResult();
			
			
			
			System.out.println("luv2code: Instructor is: \n" + tempInstructor );
			System.out.println("***");
			
			

			
			//*** CLOSING SESSION ON PURPOSE ***
			session.getTransaction().commit();
			session.close();// Since courses are LAZY Loading...this should bring error
			System.out.println("***");
			System.out.println("Session Is Closed");
			System.out.println("***");
						
			
			// --- Get Courses ---
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

			
//			//*** Commit ***
//			session.getTransaction().commit();
//			
//			System.out.println("luv2code: Done!");
			
		} finally {
			// Clean-up:
			session.close();
			
			factory.close();
		}
	}

}
