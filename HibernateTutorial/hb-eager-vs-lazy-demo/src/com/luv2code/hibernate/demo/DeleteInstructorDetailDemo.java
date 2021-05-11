package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class DeleteInstructorDetailDemo {

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
					

			
			//*** Transaction ***
			session.beginTransaction();
			
			//*** ACTION ***
			// ---- GET InstructorDetail Object by ID ----
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetails: \nID: " + theId + "\nDetails: " + tempInstructorDetail);
			
			//-- PRINT the associated Instructor
			System.out.println("The ASSOCIATED Instructor: " + tempInstructorDetail.getInstructor());
			
			
			
			// ---- BREAK BI DIRECTIONAL REFERENCE -----
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			//---- DELETE InstructorDetails and KEEP INSTRUCTOR
			System.out.println("Deleting Instructor: \nID: " +theId + "\nDetails: " + tempInstructorDetail);
			System.out.println("*****");
			session.delete(tempInstructorDetail);
			
			
			
			
			//*** Commit ***
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// Close Session in case of EXCEPTION:
			session.close();
			
			factory.close();
		}
	}

}
