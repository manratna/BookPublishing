package com.bp.exception;
 
public class PublisherNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PublisherNotFoundException(String message) {
		super(message);
	}
 
	
}