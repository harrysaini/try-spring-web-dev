package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class CreateQueryDemo {

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
	    
	    Course course = new Course("RAm BAn ILAJ");
	    Course course2 = new Course("MASTER art of pranyam");

	    instructor.addCourse(course);
	    instructor.addCourse(course2);
	    
//	    one way to sync
//	    session.merge(instructor);
	    
	    session.save(course);
	    session.save(course2);
	   
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
