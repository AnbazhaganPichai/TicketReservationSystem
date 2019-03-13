package com.ticketreservation.interfaces;

import java.util.List;

public interface IReservationHandler {
	List<BusDetail> viewBus();
	PassengerDetail getPassenger();
	PassengerDetail removePassenger();
	String bookTicket();
	void addBus();
	void searchBus();

}
