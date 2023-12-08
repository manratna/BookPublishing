package com.bp.exception;
 
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class GlobalExceptionHandler {
 
	@ExceptionHandler({NoDataAvailableException.class})
	public ResponseEntity<Object> handleStudentNotFoundExection(NoDataAvailableException nda) {
		LocalDate dateTime=LocalDate.now();
		ErrorDetails details=new ErrorDetails(dateTime, nda.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}


}