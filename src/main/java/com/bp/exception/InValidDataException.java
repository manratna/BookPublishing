package com.bp.exception;

public class InValidDataException extends RuntimeException {
	public static final long serialVersionUID = 1L;
	
	public  InValidDataException(String message) {
		super(message);
	}

}
