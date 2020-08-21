package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class FetchJOINDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    session.beginTransaction();

	    Query<Instructor> query = session.createQuery(
		    "select i from Instructor i JOIN FETCH i.courses WHERE i.id=:instructorId", Instructor.class);

	    query.setParameter("instructorId", 1);

	    System.out.println("Getting instructor");

	    Instructor instructor = query.getSingleResult();

	    System.out.println("myAPP:    INSTRUCTOR: " + instructor);

	    session.getTransaction().commit();

	    session.close();

	    System.out.println("myAPP:   " + instructor.getCourses());

	    System.out.println("myAPP:   Done");

	} catch (Exception e) {
	    e.printStackTrace();
	    session.close();
	} finally {
	    sessionFactory.close();
	}
    }

}
