package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
						
			
			//Create Student Objects
			System.out.println("Creating new Student Objects...");
			Student tempStudent = new Student("Tom", "Padilla", "tom@gmail.com");
			Student tempStudent2 = new Student("Katy", "Torres", "katy@gmail.com");
			Student tempStudent3 = new Student("July", "Padilla", "july@gmail.com");
			
			// Transaction (app - db)
			session.beginTransaction();
			
			// Save
			System.out.println("Saving created Students...");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}
}
