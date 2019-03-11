package com.ticketreservation.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.ticketreservation.exception.ReservationException;

public class DbBConnector {
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busbooking","root","anbu123");
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ReservationException("class not found exception"+ e.getMessage(), e);
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ReservationException("Coonection error" + e.getMessage(), e);
			//e.printStackTrace();
			
		}
	
		return connection;
		
	}
	
	public static java.sql.PreparedStatement getPreparedStatement(String query, Connection connection){
		java.sql.PreparedStatement preparedStatement = null;
		try {
			preparedStatement =connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ReservationException("exception on preparedStatement"+ e.getMessage(), e);
		}
		return preparedStatement;
	}
	
	public static ResultSet getresultSet(){
		return null;
	}
}
