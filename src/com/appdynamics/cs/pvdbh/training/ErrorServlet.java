package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("ErrorServlet.class");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("logException")) {
			logger.error("Just trying the error logging a bit");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>ErrorServlet</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"white\">");
			out.println("<b>Thank you for sending a GET request to the ErrorServlet. I logged a very nice error message for you Sir !</b>");
			out.println("</body>");
			out.println("</html>");
		}
	    if(action != null && action.equals("throwException"))
	    	throw new ServletException("I am throwing a ServletException as hard as I can !!!");
	    if(action != null && action.equals("throwAndCatchException"))
	    	try {
	    		throw new Exception("I am throwing a Exception now but promise to catch it immedeatly !");
	    	} catch (Exception e) {
	    		logger.info("Everything is fine, the exception was catched. All return to their stations !");
	    	}
	    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
