package com.appdynamics.cs.pvdbh.training;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpRequest;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.util.InputStreamResponseListener;

/**
 * Servlet implementation class JettyClientServlet
 */
@WebServlet("/JettyClientServlet")
public class JettyClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JettyClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpClient jettyclient = new HttpClient();
		try {
			jettyclient.start();
			HttpRequest httpRequest = (HttpRequest) jettyclient.newRequest("http://controller:8001/TrainingProject/Whatever");
			InputStreamResponseListener listener = new InputStreamResponseListener();
			httpRequest.send(listener);
			 
            // Wait for the response headers to arrive
            Response r = listener.get(10000l, TimeUnit.SECONDS);
			
			
			 int status = r.getStatus();
			 
			 System.out.println("Status = " + status);
		} catch (Exception e) {
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
