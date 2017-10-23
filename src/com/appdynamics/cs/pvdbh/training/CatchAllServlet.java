package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatchAllServlet
 */
@WebServlet({ "/CatchAllServlet", "/CatchAllServlet/*", "/*" })
public class CatchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatchAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>CatchAllServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for sending a GET request to the CatchAllServlet</b>");
	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>CatchAllServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for sending a POST request to the CatchAllServlet</b>");
	    out.println("</body>");
	    out.println("</html>");
	}

}
