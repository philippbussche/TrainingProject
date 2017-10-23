package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ByteCodeServlet
 */
@WebServlet("/ByteCodeServlet")
public class ByteCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByteCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		byte[] CDRIVES = javax.xml.bind.DatatypeConverter.parseHexBinary("e04fd020ea3a6910a2d808002b30309d");
		this.doSomethingWithAByteArray(CDRIVES, "recordName", "recordDescription", "recordType");
	}
	
	private void doSomethingWithAByteArray(final byte[] inputData, final String recordName, final String recordDescr, final String recType) {
		try {
			Thread.currentThread().sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
