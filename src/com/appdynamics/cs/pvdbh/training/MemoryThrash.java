package com.appdynamics.cs.pvdbh.training;

import java.util.Vector;

public class MemoryThrash {
	
	public static void main(String[] args) throws Exception {
		Vector v = new Vector();
		int objectCounter = 0;
		while(true) {
			objectCounter++;
			System.out.println("Creating object number " + objectCounter);
			v.add(new RandomClass());
			Thread.currentThread().sleep(10);
		}
	}

}
