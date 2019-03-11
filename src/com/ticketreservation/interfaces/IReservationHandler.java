package com.ticketreservation.interfaces;

import java.util.List;

public interface IReservationHandler {
	List<BusDetail> viewBus();
	PassengerDetail getPassenger(String ticketId);
	PassengerDetail removePassenger(String ticketId);
	String bookTicket(PassengerDetail passenger);
	void addBus(BusDetail bus);

}
