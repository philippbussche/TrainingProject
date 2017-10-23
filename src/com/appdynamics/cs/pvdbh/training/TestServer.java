package com.appdynamics.cs.pvdbh.training;
import java.io.*; 
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestServer {
	
	private static Thread searcher;                       // background search thread
	private static ThreadHelper threadHelper;
	
	private static int maxThreadRuns = 5;
	private static int currentThreadRun = 1;
	
	public static ThreadHelper getThreadHelper() {
		return threadHelper;
	}

	public static void setThreadHelper(ThreadHelper th) {
		threadHelper = th;
	}

	public Thread getSearcher() {
		return searcher;
	}

	public static void setSearcher(Thread t) {
		searcher = t;
	}

	
	public int getCurrentThreadRun() {
		return currentThreadRun;
	}

	public void setCurrentThreadRun(int ctr) {
		currentThreadRun = ctr;
	}
	
	 public static void main(String argv[]) throws Exception       {  
		  String clientSentence;          
		  ServerSocket welcomeSocket = new ServerSocket(6789);          
		  while(true)          {             
			  Socket connectionSocket = welcomeSocket.accept();             
			  BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));             
			  clientSentence = inFromClient.readLine();             
			  System.out.println("Received: " + clientSentence);             
			  releaseTheKraken(clientSentence);
		  }       
	 } 
	 
	 public static void releaseTheKraken(String cs) {
		 if(cs.contains("RELEASETHEKRAKEN")) {
			    String[] params = cs.split(" ");
			    String host = params[1];
				String port = params[2];
				ExecutorService executor = Executors.newFixedThreadPool(5);
				for (int i = 0; i < 10; i++) {
		            Runnable worker = new ThreadHelper(i, host, port);
		            executor.execute(worker);
		        }
				executor.shutdown();
		        while (!executor.isTerminated()) {
		        	//TODO
		        }
		        System.out.println("Finished all threads");
		  }
	 }
} 
