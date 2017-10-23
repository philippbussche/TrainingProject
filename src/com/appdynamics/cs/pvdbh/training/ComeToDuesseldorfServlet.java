package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComeToDuesseldorfServlet
 */
@WebServlet("/ComeToDuesseldorfServlet")
public class ComeToDuesseldorfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComeToDuesseldorfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String htmlContent = "<div style='font-family: Arial Black;text-align:center'><font size='6'><img src='http://localdocker/images/image.jpeg' width='20%' align='middle'/>Hi, this is me - Philipp (wearing an OSTRICHPILLOW &reg; )</font><br><br><div style='font-family: Arial Black;text-align:center'><font size='6'>If you search for travel destinations on the rise for 2015 you will read about places like Vietnam, Cambodia and Cyprus. I am sure these places are cool but there is something even cooler: <u>Dusseldorf, Germany !</u><br><br><img src='http://localdocker/images/image3.png' width='80%' align='middle'/><br><br><div style='font-family: Arial Black;text-align:center'><font size='6'>Dusseldorf was voted Top of Best Destinations in Germany for 2014, can you believe it ?!?<br><br><img src='http://localdocker/images/image2.png'/><br><br><div style='font-family: Arial Black;text-align:center'><font size='6'>Sounds good ? But here comes the best part: I live here ! You might think now 'Good for you buddy !!!' - then again this means if you visit I can show you all the uber-cool places and you can also crash at my place.<br><br> I am sure you are going crazy by now. But seriously, I would be delighted if you come and visit next year. Just drop me a note to philipp.bussche@gmail.com.<br><br> Looking forward to seeing you soon !'";   
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<script>window['adrum-start-time'] = new Date().getTime();</script><script src='http://localdocker/adrum.js'></script>");
	    out.println("<title>ComeToDuesseldorfServlet</title>");
	    out.println("</head>");
	    out.println(htmlContent);
	    out.println("<script> if (ADRUM) { ADRUM.command ('addUserData', 'vote', '10'); }</script>");
	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
