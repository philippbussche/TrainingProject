package com.appdynamics.cs.pvdbh.training;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
	
	public static void main(String[] args) throws Exception {
		String host = args[0];
		String port = args[1];
		String username = args[2];
		String password = args[3];
		String queueName = args[4];
		listenQueue(host, port, username, password, queueName);
	}
	
	public static void listenQueue(String host, String port, String username, String password, String queueName){
		  try {
		    Properties props=new Properties();
		    ConnectionFactory factory = getConnectionFactory(host, port, username, password); 
		    Connection conn = getConnection(factory);
		    QueueSession session = (QueueSession) getSession(conn);
		    Queue queue = session.createQueue(queueName);
		    QueueReceiver receiver =session.createReceiver(queue);
		    System.out.println("Message Selector: " + receiver.getMessageSelector());
		    receiver.setMessageListener(new MessageListener(){
		      public void onMessage(      Message message){
		        try {
		          if (message instanceof TextMessage) {
		            TextMessage txtMsg=(TextMessage)message;
		            String msg=txtMsg.getText();
		            System.out.println("Queue Message Received: " + msg);
		          }
		          message.acknowledge();
		        }
		 catch (        Throwable e) {
		          e.printStackTrace();
		        }
		      }
		    }
		);
		    conn.start();
		  }
		 catch (  Exception e) {
		    e.printStackTrace();
		  }
		}
	
	private static ConnectionFactory getConnectionFactory(String hostname, String port, String username, String password) {
		ConnectionFactory factory = new ActiveMQConnectionFactory(username, password, "tcp://" + hostname + ":" + port);
		return factory;
	}
	
	private static Connection getConnection(ConnectionFactory factory) {
		Connection c = null;
		try {
			c = factory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	private static Session getSession(Connection c) {
		Session s = null;
		try {
			s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
