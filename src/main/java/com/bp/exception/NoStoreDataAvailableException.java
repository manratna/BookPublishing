package com.bp.exception;

public class NoStoreDataAvailableException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NoStoreDataAvailableException(String message) {
		super(message);
	}

}
