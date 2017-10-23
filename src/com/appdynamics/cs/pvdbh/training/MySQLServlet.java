package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

import java.sql.Connection;


/**
 * Servlet implementation class MySQLServlet
 */
@WebServlet("/MySQLServlet")
public class MySQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host = request.getParameter("dbHostname");
		String port = request.getParameter("dbPort");
		String username = request.getParameter("dbUsername");
		String password = request.getParameter("dbPassword");
		String dbName = request.getParameter("dbName");
		Connection connect = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
			          .getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName + "?"
			              + "user=" + username + "&password=" + password);
			statement = connect.createStatement();
			String createTableSql = "CREATE TABLE IF NOT EXISTS REGISTRATION " +
	                   "(id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 
			statement.executeUpdate(createTableSql);
			
			String insertTableSql = "INSERT INTO REGISTRATION (first, last, age) values (?, ?, ?)";
			PreparedStatement prepStatement = connect.prepareStatement(insertTableSql);
			prepStatement.setString(1, "Philipp");
			prepStatement.setString(2, "Bussche");
			prepStatement.setInt(3, 34);
			prepStatement.executeUpdate();
				
			statement.close();
			prepStatement.close();
			connect.close();
			
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>MySQLServlet</title>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\">");
		    out.println("<b>Thank you for sending a request to the MySQLServlet.</b>");
		    out.println("</body>");
		    out.println("</html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		      try {
				connect.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
