package com.ticketreservation.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ticketreservation.dbutil.DbBConnector;
import com.ticketreservation.exception.ReservationException;
import com.ticketreservation.interfaces.BusDetail;
import com.ticketreservation.interfaces.IReservationHandler;
import com.ticketreservation.interfaces.PassengerDetail;

public class ReservationHandler implements IReservationHandler {

	@Override
	public List<BusDetail> viewBus() {
		Connection connection = null;
		List<BusDetail> busList =new ArrayList<>();
		try{
		connection = DbBConnector.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from bus_table");
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			BusDetail bus = new BusDetail();
			bus.setbId(result.getInt(1));
			bus.setbName(result.getString(2));
			bus.setBfrom(result.getString(3));
			bus.setbTo(result.getString(4));
			bus.settDate(String.valueOf(result.getDate(5)));
			bus.settAvailable(result.getString(6));
			busList.add(bus);
		}
		
		Iterator<BusDetail> iterator = busList.iterator();
		while (iterator.hasNext()) {
			BusDetail bus = iterator.next();
			System.out.println(bus.getbId());
			System.out.println(bus.getbName());
			System.out.println(bus.getBfrom());
			System.out.println(bus.getbTo());
			System.out.println(bus.gettAvailable());
			System.out.println(bus.gettDate());
		}
		}catch (ReservationException e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "" +e);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return busList;
	}

	@Override
	public PassengerDetail getPassenger(String ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PassengerDetail removePassenger(String ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bookTicket(PassengerDetail passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBus(BusDetail bus) {
		// TODO Auto-generated method stub
		
	}

}
