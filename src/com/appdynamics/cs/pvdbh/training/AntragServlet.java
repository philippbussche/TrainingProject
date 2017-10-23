package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AntragServlet
 */
@WebServlet("/AntragServlet")
public class AntragServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AntragServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String antragNummerString = request.getParameter("antragNummer");
		String heandlerNummerString = request.getParameter("haendlerNummer");
		int antragNummer = Integer.parseInt(antragNummerString);
		int haendlerNummer = Integer.parseInt(heandlerNummerString);
		AntragDO an = new AntragDO(antragNummer, haendlerNummer);
		this.submitAntrag(an);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void submitAntrag(AntragDO antrag) {
		// Not really doing anything with the Antrag
	}

}
