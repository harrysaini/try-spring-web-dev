package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Student;

public class HibernateRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			for (int i = 0; i < 10; i++) {

				Student student = new Student("John" + i, "Doe", "JOHN@gmail.com");

				System.out.println("Saving " + i);
				session.save(student);
				System.out.println("Saving2 " + i);

			}

			session.getTransaction().commit();

			System.out.println("Saved");

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Student student2 = session.get(Student.class, 1);

			System.out.println(student2);

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
