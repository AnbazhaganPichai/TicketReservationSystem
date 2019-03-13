package com.ticketreservation.core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
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
		result.close();
		statement.close();
		connection.close();
		}catch (ReservationException e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "" +e);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return busList;
	}

	@Override
	public PassengerDetail getPassenger() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		try{
			connection= DbBConnector.getConnection();
			PreparedStatement statement = connection.prepareStatement("select a.T_ID, b.b_name, a.t_from, a.t_to, a.t_count, a.p_name, a.t_Date from ticket_table a inner join bus_table b on a.B_ID = b.B_ID where t_id=? ");
			statement.setInt(1, sc.nextInt());
			statement.executeUpdate();
			ResultSet result = statement.executeQuery();
			if(result.next()){
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println(result.getString(4));
				System.out.println(result.getInt(5));
				System.out.println(result.getString(6));
				System.out.println(result.getString(7));
				
			}
			throw new ReservationException("ticket id is invalid");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public PassengerDetail removePassenger() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Connection connection = null;
		try{
			connection =DbBConnector.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from ticket_table where t_id = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println(result.getString(4));
				System.out.println(result.getString(5));
				System.out.println(result.getDate(6));
				System.out.println(result.getInt(7));
				System.out.println(result.getDate(8));
				PreparedStatement statement2 = connection.prepareStatement("delete from ticket_table t_id =?");
				statement2.setInt(1, id);
				
			}else{
				throw new ReservationException("ticket id is not avilable");
			}
			result.close();
			statement.close();
	
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String bookTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBus() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		try{
			DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
            Date d=new Date(0, 0, 0);
            df.format(d);
			connection = DbBConnector.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into bus_table(b_name, b_from, b_to, t_date, t_seat, a_seat) values (?,?,?,?,?,?)");
			System.out.println("enter bus name;");
			statement.setString(1, sc.next());
			System.out.println("enter bus starts from :");
			statement.setString(2, sc.next());
			System.out.println("enter bus destination :");
			statement.setString(3, sc.next());
			System.out.println("enter travel date  :");
			statement.setDate(4, Date.valueOf(sc.next()));
			System.out.println("enter total number of seat :");
			statement.setInt(5, sc.nextInt());
			System.out.println("enter available seats  :");
			statement.setInt(6, sc.nextInt());
			statement.executeUpdate();
			System.out.println("your bus added successfully");
			
			statement.close();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	public void searchBus() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try{
			connection = DbBConnector.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from bus_table where b_t_from =?, b_t_to = ?, b_t_date = ?");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter starts from  :");
			statement.setString(1, sc.next());
			System.out.println("enter destination   :");
			statement.setString(2, sc.next());
			System.out.println("enter date of travel   :");
			statement.setDate(3, Date.valueOf(sc.next()));
			statement.executeUpdate();
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				System.out.println(" "+result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getDate(5)+" "+result.getInt(6)+" "+result.getInt(7));
			}
			
			result.close();
			statement.close();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
