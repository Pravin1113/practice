package com.example.demo.exception;
public class Exceptionn extends RuntimeException {
	int statuscode;
	String message;
	public Exceptionn(int statuscode, String message) {
		super();
		this.statuscode = statuscode;
		this.message = message;
	}
	public Exceptionn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}

}