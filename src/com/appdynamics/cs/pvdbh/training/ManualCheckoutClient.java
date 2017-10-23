package com.appdynamics.cs.pvdbh.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ManualCheckoutClient {
	
	public static void main(String argv[]) throws Exception  {  
		String host = argv[0];
		String port = argv[1];
		while(true) {
			manualCheckout(host, port);
			Thread.sleep(10000);
		}
	}
	
	public static void manualCheckout(String host, String port) throws IOException{
		String receiverURL = "http://"+host+":"+port+"/TrainingProject/Checkout?customerType=BusinessUser&manualCheckout=true";
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

}
