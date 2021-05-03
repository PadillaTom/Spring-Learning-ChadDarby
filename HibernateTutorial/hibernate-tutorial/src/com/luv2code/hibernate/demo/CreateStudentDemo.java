package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create Current Session
		Session session = factory.getCurrentSession();
		
		try {
			// *** Using our Current SESSION ***
			// Creamos Student
			// Abrimos connection between APP-DB (transaction)
			// Realizamos la accion (save)
			// Commit dicha Transaction
						
			
			//Create Student Object
			System.out.println("Creating new Student Object...");
			Student tempStudent = new Student("StudentName", "StudentLastName", "StudentEmail");
			
			// Transaction (app - db)
			session.beginTransaction();
			
			// Save
			System.out.println("Saving created Student");
			session.save(tempStudent);
			
			// Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
