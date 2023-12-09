package com.bp.exception;
 
public class TitleNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TitleNotFoundException(String message) {
		super(message);
	}
 
	
}