package com.harry.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class JSDBTestRunner {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";

		String username = "hbstudent";
		String password = "hbstudent";

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

			System.out.println(connection.getClientInfo());

			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
