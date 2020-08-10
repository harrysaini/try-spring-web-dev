package com.harry.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Student;

public class DeleteQueryRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Student student = session.get(Student.class, 6);

			System.out.println("Deleting student" + student);

			session.delete(student);

			session.createQuery("delete from Student where id = 8").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			sessionFactory.close();
		}
	}

}
