package com.akihito.cursoSpring.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseException> handleAllExceptions
  (Exception ex, WebRequest request){
	  
	  ResponseException responseException = new ResponseException(
			  new Date(),
			  ex.getMessage(),
			  request.getDescription(false));
	  
	  return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
	  
  }
  
  @ExceptionHandler(UnsupportedMathOperationException.class)
  public ResponseEntity<ResponseException> handleBadRequest
  (Exception ex, WebRequest request){
	  
	  ResponseException responseException = new ResponseException(
			  new Date(),
			  ex.getMessage(),
			  request.getDescription(false));
	  
	  return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
	  
  }
}
