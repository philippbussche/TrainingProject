package com.appdynamics.cs.pvdbh.training;

import java.io.*; 
import java.net.*; 

public class TestClient {
	
	public static void main(String argv[]) throws Exception  {  
		int currentRun = 1;
		int maxRun = 5;
		while(currentRun <= maxRun) {
			Socket clientSocket = new Socket("localdocker", 6790);   
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   
			outToServer.writeBytes("RELEASETHEKRAKEN controller 8002\n");   
			System.out.println("The Kraken was released !!!");   
			clientSocket.close();  
			currentRun++;
			Thread.currentThread().sleep(30000);
		}
	} 
}
