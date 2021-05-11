package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {
			// *** Using our Current SESSION ***
			// Create Object
			// Open Transaction (Connection between APP and DB)
			// ACTION to be performed (CRUD)
			// Commit transaction				
	
			
			//*** Create Objects ***
//			Instructor tempInstructor = new Instructor("Tom", "Padilla", "padilla@email.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.padillatomas.com", "Web Developer");
			
			Instructor tempInstructor = new Instructor("Katy", "Torres", "Torres@email.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.LaKaty.com", "Romper las Bolas");
			
			// Associate Objects:
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//*** Transaction ***
			session.beginTransaction();
			
			//*** ACTION ***
			// ---- Save Instructor ----
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor); // CascadeType.ALL (Will Save BOTH)
			
			
			//*** Commit ***
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
