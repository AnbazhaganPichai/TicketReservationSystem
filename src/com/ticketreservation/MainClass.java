package com.ticketreservation;

import com.ticketreservation.dbutil.DbBConnector;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!");
		DbBConnector db= new DbBConnector();
		db.getConnection();
		System.out.println("after connection");

	}

}
