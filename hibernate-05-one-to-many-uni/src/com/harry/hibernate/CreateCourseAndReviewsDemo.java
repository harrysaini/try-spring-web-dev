package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;
import com.harry.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    session.beginTransaction();

	    Course course = new Course("Hello - art to greeting 23");

	    course.addReview(new Review("Good course"));
	    course.addReview(new Review("Bad course .. sucks"));
	    course.addReview(new Review("Super course ... keep it up"));

	    System.out.println("Saving: " + course + "\n Reviews: " + course.getReviews());

	    session.save(course);

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
