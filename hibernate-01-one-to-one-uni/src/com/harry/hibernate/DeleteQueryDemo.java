package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Instructor;
import com.harry.hibernate.entity.InstructorDetail;

public class DeleteQueryDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 1);

			System.out.println("Found: " + instructor);

			if (instructor != null) {

				System.out.println("Deleting instructor +  " + instructor);
				session.delete(instructor);
			}

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			sessionFactory.close();
		}
	}

}
