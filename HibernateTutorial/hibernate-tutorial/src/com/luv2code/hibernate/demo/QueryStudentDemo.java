package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

import antlr.collections.List;
import java.util.*;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {						
		
			// Transaction (app - db)
			session.beginTransaction();
			
		// ***** ALL STUDENTS *****
			java.util.List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Displaying
			System.out.println("All Students:");
			displayStudents(theStudents);
			System.out.println("*****");
			
		// ***** LAST NAME =  *****	
			theStudents = session.createQuery("from Student item where item.lastName='Torres'").getResultList();
			// Displaying
			System.out.println("\nStudents with lastName of Torres:");
			displayStudents(theStudents);
			System.out.println("*****");
			
			
		// ***** LAST NAME = "" OR FIRST NAME = "" *****	
			theStudents = session.createQuery("from Student s where s.lastName='Torres' OR s.firstName='July'").getResultList();
			// Displaying
			System.out.println("\nStudents with lastName=Torres OR firstName=July");
			displayStudents(theStudents);
			System.out.println("*****");
			
		// ***** EMAIL LIKE " "  *****	
			theStudents = session.createQuery("from Student s where s.email LIKE '%@email.com'").getResultList();
			// Displaying
			System.out.println("\nStudents with email LIKE '@email.com'");
			displayStudents(theStudents);
			System.out.println("*****");			
			
			
			
			// Commit Transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(java.util.List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
