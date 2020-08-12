package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class BIGetDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		Session session;

		session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);

			System.out.println("instruction details" + instructorDetail);

			System.out.println("instrictor: " + instructorDetail.getInstructor());

			System.out.println(instructorDetail.getInstructor().getInstructorDetail().getInstructor()
					.getInstructorDetail().getInstructor());

			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
