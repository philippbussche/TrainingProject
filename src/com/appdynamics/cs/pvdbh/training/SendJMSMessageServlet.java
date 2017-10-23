package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Servlet implementation class SendJMSMessageServlet
 */
@WebServlet("/SendJMSMessageServlet")
public class SendJMSMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int currentExecution = 0;
	private int sleepExecution = 15;
	private boolean skipLongSleep = true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendJMSMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		currentExecution++;
		if(currentExecution == sleepExecution) {
			        skipLongSleep = false;
				    this.startSleepChainTillBrooklyn();
					skipLongSleep = true;
				    currentExecution = 0;
		} else {
			this.startSleepChainTillBrooklyn();
		}
		SecretInformationDO mySecret = letsGetASecret("I am a JMS Servlet and finally understand JMS now !!!");
		SecretInformationDO mySecondSecret = letsGetASecret("That was about it, no more secrets.");
		String host = request.getParameter("hostname");
		String port = request.getParameter("port");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String queueName = request.getParameter("queueName");
		String messageText = request.getParameter("messageText");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>SendJMSMessageServlet</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<b>Thank you for sending a GET request to the SendJMSMessageServlet</b>");
	    out.println("<b>In this version of the servlet I am sending a JMS message to " + host + ":" + port + " to queue " + queueName + " with the following text: " + messageText);
	    out.println("</body>");
	    out.println("</html>");
	    ConnectionFactory f = getConnectionFactory(host, port, username, password);
	    Connection c = getConnection(f);
	    Session s = getSession(c);
	    TextMessage txt = sendMessageToQueue(s, queueName, messageText);
	    try {
			s.close();
			c.close();
		} catch (JMSException e) {
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
	
	private SecretInformationDO letsGetASecret(String whatsTheSecret) {
		return new SecretInformationDO(whatsTheSecret);
	}
	
	private ConnectionFactory getConnectionFactory(String hostname, String port, String username, String password) {
		ConnectionFactory factory = new ActiveMQConnectionFactory(username, password, "tcp://" + hostname + ":" + port);
		return factory;
	}
	
	private Connection getConnection(ConnectionFactory factory) {
		Connection c = null;
		try {
			c = factory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	private Session getSession(Connection c) {
		Session s = null;
		try {
			s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	private TextMessage sendMessageToQueue(Session s, String queueName, String messageText) {
		TextMessage msg = null;
		try {
			Queue queue = s.createQueue(queueName);
			javax.jms.MessageProducer producer = s.createProducer(queue);
            msg = s.createTextMessage();
            msg.setText(messageText);
            producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	private void startSleepChainTillBrooklyn() {
		this.sleep1();
	}
	
	private void sleep1() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep2() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep3() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep4();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep4() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep5();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep5() {
		try {
			Thread.currentThread().sleep(5);
			if(!skipLongSleep) {
				this.sleep6();
			} else {
				this.sleep7();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep6() {
		try {
			Thread.currentThread().sleep(15000);
			this.sleep7();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep7() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep8();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep8() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep9();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep9() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep10();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep10() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep11();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep11() {
		try {
			Thread.currentThread().sleep(5);
			this.sleep12();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sleep12() {
		try {
			Thread.currentThread().sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
