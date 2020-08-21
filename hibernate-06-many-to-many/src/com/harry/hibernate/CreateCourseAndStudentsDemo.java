package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Course;
import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;
import com.harry.hibernate.entity.Review;
import com.harry.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
		.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    session.beginTransaction();

	    Course course = new Course("Hello - art to greeting 23");

	    System.out.println("Save course");
	    session.save(course);
	    System.out.println("Saved" + course);

	    Student aStudent = new Student("Ram", "Dev", "ramu@ptnjli.com");

	    Student bStudent = new Student("Mukesh", "AMbani", "amabani@jio.com");

	    course.addStudent(aStudent);
	    course.addStudent(bStudent);

	    System.out.println("Saving students");
	    session.save(aStudent);
	    session.save(bStudent);
	    System.out.println("Saved " + course.getStudents());

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
