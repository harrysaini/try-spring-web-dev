package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class AddCourseDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class)
		.addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class)
		.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    Instructor instructor = new Instructor("Ram", "dev", "Ram.dev@ptnjli.com");

	    InstructorDetail instructorDetail = new InstructorDetail("Dwai bnana", "http:www.youtube.com");

	    instructor.setInstructorDetail(instructorDetail);

	    session.beginTransaction();

	    System.out.println("Saving instructor +  " + instructor);
	    session.save(instructor);

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
