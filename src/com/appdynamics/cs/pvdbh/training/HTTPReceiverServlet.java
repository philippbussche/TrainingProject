package com.appdynamics.cs.pvdbh.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTTPReceiverServlet
 */
@WebServlet("/HTTPReceiverServlet")
public class HTTPReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTTPReceiverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messageText = request.getParameter("messageText");
		boolean sendJMSMessage = Boolean.parseBoolean(request.getParameter("sendJMSMessage"));
		boolean callMySQL = Boolean.parseBoolean(request.getParameter("callMySQL"));
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>HTTPTransportServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for sending a GET request to the HTTPReceiverServlet with message : " + messageText + ".</b>");
	    
	    if(sendJMSMessage) {
	    	out.println("<b>Also since you want me to I am going to call the JMSSendServlet to send a JMS message.<br>");
	    	String jmsServletHost = request.getParameter("jmsServletHostname");
	    	String jmsServletPort = request.getParameter("jmsServletPort");
	    	String jmsHost = request.getParameter("jmsHostname");
			String jmsPort = request.getParameter("jmsPort");
			String jmsUsername = request.getParameter("jmsUsername");
			String jmsPassword = request.getParameter("jmsPassword");
			String jmsQueueName = request.getParameter("jmsQueueName");
			String jmsMessageText = request.getParameter("jmsMessageText");
			URL url = new URL( "http://"+jmsServletHost+":"+jmsServletPort+"/TrainingProject/SendJMSMessageServlet?hostname=" + jmsHost + "&port=" + jmsPort + "&username=" + jmsUsername + "&password=" + jmsPassword + "&queueName=" + jmsQueueName + "&messageText=" + jmsMessageText ); 
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
	    
	    if(callMySQL) {
	    	Enumeration<String> parameterNames = request.getParameterNames();
			StringBuffer urlParameters = new StringBuffer();
	    	while(parameterNames.hasMoreElements()) {
				String paramName = parameterNames.nextElement();
				urlParameters.append(paramName).append("=").append(request.getParameterValues(paramName)[0]).append("&");
			}
	    	String receiverURL = "http://"+request.getServerName()+":"+String.valueOf(request.getServerPort())+"/TrainingProject/MySQLServlet?" + urlParameters.toString();
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
	    }
	    
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
