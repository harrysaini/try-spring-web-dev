package com.harry.dbTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbConn
 */
@WebServlet("/TestDbConn")
public class TestDbConn extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

	String username = "root";
	String password = "olx123";

	String driver = "com.mysql.cj.jdbc.Driver";

	try {
	    PrintWriter out = response.getWriter();

	    out.println("Connecting to db " + jdbcUrl);

	    Class.forName(driver);

	    Connection myConnection = DriverManager.getConnection(jdbcUrl, username, password);

	    out.println("Sucess!!");

	    myConnection.close();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new ServletException(e);
	}

    }

}
