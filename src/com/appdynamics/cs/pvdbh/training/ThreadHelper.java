package com.appdynamics.cs.pvdbh.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class ThreadHelper implements Runnable {
	
	private boolean webserverDetailsSet = false;
	private String hostname = "";
	private String port = "";
	private int workerThreadNumber = 0;
	
	public ThreadHelper(int i,String host, String port) {
		super();
		this.hostname = host;
		this.port = port;
		this.webserverDetailsSet = true;
		this.workerThreadNumber = i;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
       
    public boolean isWebserverDetailsSet() {
		return webserverDetailsSet;
	}

	public void setWebserverDetailsSet(boolean webserverDetailsSet) {
		this.webserverDetailsSet = webserverDetailsSet;
	}
	
	public void run() {
	        if(isWebserverDetailsSet()) {
	          //also I will make an HTTP call to another tomcat server, sorry this example will be a bit static
	          String receiverURL = "http://" + getHostname() + ":" + getPort() + "/TrainingProject/CatchAllServlet/BT1";
	          URL url;
			  try {
				url = new URL( receiverURL );
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
				System.out.println("Worker-Thread-" + workerThreadNumber + ": HTTP Call executed to: " + receiverURL + ".");
				String line = "";
				StringBuffer wholeMessage = new StringBuffer();
				while (true) {
				    line = in.readLine();
				    if (line == null) break;
				    wholeMessage.append(line);
				}
				in.close(); 
				System.out.println("This is what came back: " + wholeMessage.toString());
				System.out.println("Worker-Thread-" + workerThreadNumber + ": Done.");
			  } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } 
	        }		
	      try {
	        Thread.sleep(5000);
	      } 
	      catch (InterruptedException ignored) { 
	    	  // TODO
	      }
	  }


}
