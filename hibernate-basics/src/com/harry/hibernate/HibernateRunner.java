package com.harry.hibernate;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harry.hibernate.entity.Student;
import com.harry.hibernate.utils.DateUtils;

public class HibernateRunner {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session session;

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String theDateOfBirthStr = "31/12/1998";

			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

			Student tempStudent = new Student("Pauly", "Doe", "paul1@luv.com", theDateOfBirth);

			session.save(tempStudent);

			session.getTransaction().commit();

			System.out.println(tempStudent);

			System.out.println("Saved");

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Student student2 = session.createQuery("from Student where email='paul1@luv.com'", Student.class)
					.getSingleResult();

			System.out.println(student2);

			session.getTransaction().commit();

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
