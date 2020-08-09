package com.harry.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class JSDBTestRunner {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";

		String username = "hbstudent";
		String password = "hbstudsent";

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
