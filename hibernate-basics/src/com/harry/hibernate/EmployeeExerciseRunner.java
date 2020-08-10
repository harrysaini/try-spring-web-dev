package com.harry.hibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Employee;

public class EmployeeExerciseRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		try {

			// Create
			// createEmployee(sessionFactory);

			// Create many
			createMany(sessionFactory);

			// Get
			getById(sessionFactory);

			// Query
			// getByQuery(sessionFactory);

			// update
			// update(sessionFactory);

			// Delete
			// delete(sessionFactory);

		} finally {
			sessionFactory.close();
		}

	}

	@SuppressWarnings("unused")
	private static void update(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Employee employee = session.get(Employee.class, 2);

		System.out.println("Updating" + employee);

		employee.setCompany("Facebook");

		session.getTransaction().commit();
	}

	@SuppressWarnings("unused")
	private static void delete(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Employee employee = session.get(Employee.class, 1);

		// System.out.println(employee);

		// System.out.println("Deleting" + employee);

		// session.delete(employee);

		session.createQuery("delete from Employee where id=10").executeUpdate();

		session.getTransaction().commit();
	}

	@SuppressWarnings("unused")
	private static void getByQuery(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

		displayList(employees);

		employees = session.createQuery("from Employee WHERE company='Google'", Employee.class).getResultList();

		displayList(employees);

		session.getTransaction().commit();
	}

	private static void displayList(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private static void getById(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Employee employee = session.get(Employee.class, 11);

		System.out.println(employee);

		session.getTransaction().commit();
	}

	@SuppressWarnings("unused")
	private static void createMany(SessionFactory sessionFactory) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			Employee employee = new Employee("Ram" + i, "Dev" + random.nextInt(), "Google");

			session.save(employee);

		}

		session.getTransaction().commit();
	}

	@SuppressWarnings("unused")
	private static void createEmployee(SessionFactory sessionFactory) {
		Employee employee = new Employee("Ram", "Dev", "Patanjali");

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(employee);

		session.getTransaction().commit();
	}

}
