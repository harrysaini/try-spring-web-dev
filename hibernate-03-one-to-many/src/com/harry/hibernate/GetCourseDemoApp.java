package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class GetCourseDemoApp {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class)
		.addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class)
		.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    session.beginTransaction();
	    
	    System.out.println("Getting instructor");
	    Instructor instructor = session.get(Instructor.class, 1);
	    
	    System.out.println("INSTRUCTor: " + instructor);
	    
	    System.out.println(instructor.getCourses());
	   
	    session.getTransaction().commit();

	    System.out.println("Done");

	} catch (Exception e) {
	    e.printStackTrace();
	    session.close();
	} finally {
	    sessionFactory.close();
	}
    }

}
