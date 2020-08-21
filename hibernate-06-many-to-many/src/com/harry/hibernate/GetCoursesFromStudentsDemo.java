package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;
import com.harry.hibernate.entity.Review;
import com.harry.hibernate.entity.Student;

public class GetCoursesFromStudentsDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
		.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    session.beginTransaction();

	    Student student = session.get(Student.class, 1);

	    System.out.println(student);
	    System.out.println(student.getCourses());

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
