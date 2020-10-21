package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionService cs = new ConnectionService();
		
		
		System.out.println(cs.generateBill(250,130, "Commercial"));

		System.out.println(cs.generateBill(-250,130, "Commercial"));
		System.out.println(cs.generateBill(250,130, "domestic"));
		
		System.out.println(cs.generateBill(250,130, "Domestic"));
	}

}
