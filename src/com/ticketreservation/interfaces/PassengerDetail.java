package com.ticketreservation.interfaces;

import java.util.Date;

public class PassengerDetail {
	private int pId;
	private String pName;
	private String tFrom;
	private String tTo;
	private String dDate;
	private Date dBooking;
	private int tCount;
	private int tId;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String gettFrom() {
		return tFrom;
	}
	public void settFrom(String tFrom) {
		this.tFrom = tFrom;
	}
	public String gettTo() {
		return tTo;
	}
	public void settTo(String tTo) {
		this.tTo = tTo;
	}
	public String getdTravel() {
		return dDate;
	}
	public void setdTravel(String dTravel) {
		this.dDate = dTravel;
	}
	public Date getdBooking() {
		return dBooking;
	}
	public void setdBooking(Date dBooking) {
		this.dBooking = dBooking;
	}
	public int gettCount() {
		return tCount;
	}
	public void settCount(int tCount) {
		this.tCount = tCount;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	

}
