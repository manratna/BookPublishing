package com.bp.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler({InValidDataException.class})
	public ResponseEntity<Object> handleStudentNotFoundExection(InValidDataException nda) {
		LocalDate dateTime=LocalDate.now();
		ErrorDetails details=new ErrorDetails(dateTime, nda.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}

	@ExceptionHandler({WrongInputException.class})
	public ResponseEntity<Object> handleWrongInputException(WrongInputException nda) {
		LocalDate dateTime=LocalDate.now();
		ErrorDetails details=new ErrorDetails(dateTime, nda.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
	
    @ExceptionHandler({ PublisherNotFoundException.class })
    public ResponseEntity<Object> handleNoDataAvailableException(PublisherNotFoundException nda) {
        LocalDate dateTime = LocalDate.now();
        ErrorDetails details = new ErrorDetails(dateTime, nda.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }
    
    @ExceptionHandler({ TitleNotFoundException.class })
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException nda) {
        LocalDate dateTime = LocalDate.now();
        ErrorDetails details = new ErrorDetails(dateTime, nda.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        LocalDate dateTime = LocalDate.now();
        ErrorDetails details = new ErrorDetails(dateTime, "Validation Error");
        BindingResult result = ex.getBindingResult();
        List<String> errors = new ArrayList<>();
        result.getFieldErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        
        details.setErrors(errors);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }
    
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(DataAccessException dae) {
        LocalDate dateTime = LocalDate.now();
        ErrorDetails details = new ErrorDetails(dateTime, "Data Access Error: " + dae.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    	LocalDate dateTime = LocalDate.now();
        ErrorDetails errorDetails = new ErrorDetails(dateTime, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(JwtException.class)
	protected ResponseEntity<Object> handleJwtException(JwtException nb){
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("errorCode", 301);
		error.put("timestamp", LocalDateTime.now());
		error.put("errorMessage", nb.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
}
