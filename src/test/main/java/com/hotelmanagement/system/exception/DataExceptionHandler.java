package com.hotelmanagement.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 
 * @author Premala
 *
 */
@ControllerAdvice
public class DataExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleException(DataNotFoundException ex){
		ErrorResponce error=new ErrorResponce();
		error.setStatus(HttpStatus.NOT_FOUND.value());//value() returns integer like status:404
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponce> handleException(Exception ex){
		ErrorResponce error=new ErrorResponce();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponce>(error,HttpStatus.BAD_REQUEST);
	}

}
