package com.hotelmanagement.system.exception;
/**
 * 
 * @author Premala
 *
 */
public class ErrorResponce {

	private int status;
	private String message;
	private long timeStamp;
	public ErrorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponce(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
