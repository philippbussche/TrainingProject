package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HaendlerNummerToNameServlet
 */
@WebServlet("/HaendlerNummerToNameServlet")
public class HaendlerNummerToNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap haendlerNummerToNamenMap;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaendlerNummerToNameServlet() {
        super();
        haendlerNummerToNamenMap = new HashMap<String, Integer>();
        haendlerNummerToNamenMap.put(1, "Mueller");
        haendlerNummerToNamenMap.put(2, "Meier");
        haendlerNummerToNamenMap.put(3, "Schmidt");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String haendlerNummerString = request.getParameter("haendlerNummer");
		int haendlerNummer = Integer.parseInt(haendlerNummerString);
		String haendlerName = (String) haendlerNummerToNamenMap.get(haendlerNummer);
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    out.println(haendlerName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
