package com.appdynamics.cs.pvdbh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet({ "/TransactionServlet", "/start", "/start/*", "/target" })
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String[] targets = {"target1", "target2", "target3", "target4", "target5"};
	String backend1 = "appd.backend1";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<b>This is what came back from targets: <br>");
	    StringBuffer wholeMessage = new StringBuffer();
		for (String target : targets) {
			try {
				InetAddress ipAddress = InetAddress.getByName(target);
				// String targetUrl = "http://"+target+":8080/TrainingProject/target";
				String targetUrl = "http://"+ipAddress.getHostAddress()+":8080/TrainingProject/target";
				URL url = new URL( targetUrl );
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
				String line = "";
				while (true) {
				    line = in.readLine();
				    if (line == null) break;
				    wholeMessage.append(line);
				}
				in.close(); 
				/* CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet httpget = new HttpGet(targetUrl);
				ResponseHandler<String> rh = new ResponseHandler<String>() {
					@Override
					public String handleResponse(HttpResponse arg0)
							throws ClientProtocolException, IOException {
						// TODO Auto-generated method stub
						return null;
					}
				};
				String responseBody = httpclient.execute(httpget, rh); */
			} catch(UnknownHostException uhe) {
				System.out.println("Looks like there is no target " + target + " hence doing nothing.");
			}
		}
		out.println(wholeMessage.toString());
		out.println("</body>");
	    out.println("</html>");
	    Map<String, String> env = System.getenv();
	    String backend = env.get(backend1);
	    if(backend != null) {
	    	String targetUrl = "http://"+backend;
	    	URL url = new URL( targetUrl );
	    	BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
	    	String line = "";
	    	while (true) {
	    		line = in.readLine();
	    		if (line == null) break;
	    	}
	    	in.close();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
