package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Student;

public class UpdateStudentQueryRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Student student = session.get(Student.class, 4);

			System.out.println("Updating");
			student.setFirstName("BABA sd RAM");
			System.out.println("After updating");

			session.getTransaction().commit();

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			int executeUpdate = session.createQuery("update Student SET email='test@gmail.com'").executeUpdate();

			System.out.println(executeUpdate);

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			sessionFactory.close();
		}
	}

}
