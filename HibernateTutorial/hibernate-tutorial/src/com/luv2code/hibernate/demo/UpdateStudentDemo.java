package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {	
	 
			int studentId = 1;	 // Student to be updated
	
			// New Session and Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();	
			
			// Retrieve Student based on ID
			System.out.println("\nGetting Student with ID of: " + studentId);
			
			// QUERY get(class, primaryKey)
			Student myStudent = session.get(Student.class, studentId); 
			
	// ***** UPDATING STUDENT *****
			System.out.println("Updating student ...");	
			myStudent.setFirstName("Updated Name :D");
			// Commit
			session.getTransaction().commit();	
			
	// ***** UPDATING ALL EMAILS *****	
			session = factory.getCurrentSession();
			session.beginTransaction();	
			
			System.out.println("Updating EMAIL for ALL students...");
			session.createQuery("update Student set email='updated@email.com'").executeUpdate();
			
			
			// Commit
			session.getTransaction().commit();	
			
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
