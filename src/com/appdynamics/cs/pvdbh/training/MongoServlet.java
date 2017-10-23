package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;

/**
 * Servlet implementation class MongoServlet
 */
@WebServlet("/MongoServlet")
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mongo m = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>MongoServlet</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<b>Thank you for sending a GET request to the MongoServlet. I am going to insert something for you !</b>");
		out.println("</body>");
		out.println("</html>");
		
		String host = request.getParameter("hostname");
		String port = request.getParameter("port");
		
		if(host != null && port != null) {
			m = new Mongo( host, Integer.parseInt(port) );
			DB db = m.getDB( "test" );
			out.println("Got db");
		 
			BasicDBObject doc = new BasicDBObject();
 
			doc.put("name", "Michael");
			doc.put("surname", "Brown");
			doc.put("age", 31);
 
			DBCollection coll = null;
			if(db.collectionExists("player")) {
				coll = db.getCollection("player");
			} else {
				coll = db.createCollection("player", doc);
			}
			
 
			BasicDBObject career = new BasicDBObject();
 
			career.put("goals", 100);
			career.put("matches", 200);
 
			doc.put("career", career);
 
			coll.insert(doc);
			coll.insert(career);
 
			out.println("Inserted DBObject "+coll);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
