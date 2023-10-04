package com.materias.exception;

public class IdNotDeleteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotDeleteException() {
		super();
	}
	
	public IdNotDeleteException(String message) {
		super(message);
	}
}
