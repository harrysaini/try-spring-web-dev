package com.harry.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Student;

public class QueryRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			List<Student> students = session.createQuery("from Student", Student.class).getResultList();

			displayStudents(students);

			students = session.createQuery("from Student WHERE id BETWEEN 1 and 5", Student.class).getResultList();

			displayStudents(students);

			students = session.createQuery("from Student s WHERE s.firstName  = 'Ram'", Student.class).getResultList();

			displayStudents(students);

			students = session.createQuery("from Student s WHERE s.firstName LIKE '%Kam'", Student.class)
					.getResultList();

			displayStudents(students);

			students = session.createQuery("from Student s WHERE s.email LIKE '%gmail.com'", Student.class)
					.getResultList();

			displayStudents(students);

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
