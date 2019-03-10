package com.ticketreservation.interfaces;

public class BusDetail {
private int bId;
private String bName;
private String bfrom;
private String bTo;
private String tDate;
private String tAvailable;
public int getbId() {
	return bId;
}
public void setbId(int bId) {
	this.bId = bId;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getBfrom() {
	return bfrom;
}
public void setBfrom(String bfrom) {
	this.bfrom = bfrom;
}
public String getbTo() {
	return bTo;
}
public void setbTo(String bTo) {
	this.bTo = bTo;
}
public String gettDate() {
	return tDate;
}
public void settDate(String tDate) {
	this.tDate = tDate;
}
public String gettAvailable() {
	return tAvailable;
}
public void settAvailable(String tAvailable) {
	this.tAvailable = tAvailable;
}

}
