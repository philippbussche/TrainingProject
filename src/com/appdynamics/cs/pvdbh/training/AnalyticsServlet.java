package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnalyticsServlet
 */
@WebServlet({ "/AnalyticsServlet" , "/Checkout" })
public class AnalyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String[] customerBase = new String[]{"Philipp:5:1000:10", "Stefan:1:100:20", "Stefano:15:100:30", "Laurent:25:10000:40", "Chris:1:10000:50"};
	
	private int counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		counter++;
		Random rand = new Random();
		int customerNo = rand.nextInt((customerBase.length - 1 - 0) + 1) + 0;
		String customerString = customerBase[customerNo];
		String[] customerDetails = customerString.split(":");
		CustomerDO customer = new CustomerDO(customerDetails[0], Integer.parseInt(customerDetails[1]),Integer.parseInt(customerDetails[2]), Long.parseLong((customerDetails[3])));
		String returnMesg = handleCustomer(customer, 1000L);
		if(counter == 10 && !action.equals("quickquick")) {
			try {
				// Let's make every 10th request a bit slower
				if(action == null || action.equals("slow")) {
					Thread.currentThread().sleep(500);
				} else if(action.equals("veryslow")) {
					Thread.currentThread().sleep(5000);
				} else if(action.equals("stall")) {
					Thread.currentThread().sleep(90000);
				} 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter = 0;
		} 
		if(counter == 10 && action.equals("quickquick")) {
			counter = 0;
		}
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
	    out.println("<title>AnalyticsServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for contacting the AnalyticsServlet</b><br>");
	    out.println(returnMesg);
	    out.println("</body>");
	    out.println("</html>");
		// TODO Auto-generated method stub
	}
	
	/* private String handleCustomer(CustomerDO customer) {
		return("Handling customer '" + customer.getUsername() + "'. Customer has " + customer.getNumberOfProductsInCart() + " product(s) in cart and is spending " + customer.getValueOfGoodsBought() + " Euros with us.");
	} */
	
	private String handleCustomer(CustomerDO customer, long randomValue) {
		return("Handling customer '" + customer.getUsername() + "'. Customer has " + customer.getNumberOfProductsInCart() + " product(s) in cart and is spending " + customer.getValueOfGoodsBought() + " Euros with us.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
