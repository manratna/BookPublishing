package com.bp.exception;

public class JwtException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	String msg;

	public JwtException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

	
}