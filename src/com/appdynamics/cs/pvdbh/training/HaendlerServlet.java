package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HaendlerServlet
 */
@WebServlet("/HaendlerServlet")
public class HaendlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaendlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String haendlerNummerString = request.getParameter("haendlerNummer");
		int haendlerNummer = Integer.parseInt(haendlerNummerString);
		doSomethingWithTheHaendlerNummer(haendlerNummer);
	}
	
	
	private void doSomethingWithTheHaendlerNummer(int haendlerNummer) {
		System.out.println("calling doSomethingWithTheHaendlerNummer...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
