package com.ticketreservation;

import com.ticketreservation.core.ReservationHandler;
import com.ticketreservation.dbutil.DbBConnector;
import com.ticketreservation.interfaces.IReservationHandler;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!");
		//DbBConnector db= new DbBConnector();
		IReservationHandler handler = new ReservationHandler();
		handler.viewBus();
		System.out.println("after connection");

	}

}
