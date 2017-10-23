package com.appdynamics.cs.pvdbh.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTTPTransportServlet
 */
@WebServlet("/HTTPTransportServlet")
public class HTTPTransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int currentExecution = 0;
	private int sleepExecution = 10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTTPTransportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		currentExecution++;
		if(currentExecution == sleepExecution) {
				try {
					Thread.currentThread().sleep(10000);
					currentExecution = 0;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		String host = request.getParameter("hostname");
		String port = request.getParameter("port");
		Enumeration<String> parameterNames = request.getParameterNames();
		StringBuffer urlParameters = new StringBuffer();
		while(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			urlParameters.append(paramName).append("=").append(request.getParameterValues(paramName)[0]).append("&");
		}
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>HTTPTransportServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for sending a GET request to the HTTPTransportServlet</b>");
	    String receiverURL = "http://"+host+":"+port+"/TrainingProject/HTTPReceiverServlet?" + urlParameters.toString();
	    out.println("<b>URL : " + receiverURL);
	    URL url = new URL( receiverURL ); 
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
		String line = "";
		StringBuffer wholeMessage = new StringBuffer();
		while (true) {
		    line = in.readLine();
		    if (line == null) break;
		    wholeMessage.append(line);
		}
		in.close(); 
		
		out.println("<b>This is what came back: <br>");
		out.println(wholeMessage.toString());
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
