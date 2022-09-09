package com.programweb.workshopmongo.services.exception;

public class ObjectNotFundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFundException(String msg) {
		super(msg);
	}

}
