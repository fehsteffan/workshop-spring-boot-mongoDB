package com.programweb.workshopmongo.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.programweb.workshopmongo.services.exception.ObjectNotFundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFundException e, HttpServletRequest request) {
		
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(status).body(err);
	}
}
