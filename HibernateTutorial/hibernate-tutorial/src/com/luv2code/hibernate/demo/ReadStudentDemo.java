package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {			
	// ***** SAVING A NEW STUDENT *****			
			//Create Student Object			
			Student tempStudent = new Student("Tomas", "Padilla", "padilla@email.com");
			
			// Transaction (app - db)
			session.beginTransaction();
			
			// Save
			System.out.println("Saving created Student from Constructor...");
			session.save(tempStudent);
			
			// Commit Transaction
			session.getTransaction().commit();
						
			System.out.println("Student Succesfully saved. Generated id is: " + tempStudent.getId());
			System.out.println("******");
			
	//***** READING THE SAVED STUDENT *****
			// New Session and Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();			
			// Retrieve Student based on ID
			System.out.println("\nGetting Student with ID of: " + tempStudent.getId());
			
			// QUERY get(class, primaryKey)
			Student myStudent = session.get(Student.class, tempStudent.getId()); 
			System.out.println("GET Complete: \n " + myStudent);			
			
			// Commit
			session.getTransaction().commit();	
			
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
