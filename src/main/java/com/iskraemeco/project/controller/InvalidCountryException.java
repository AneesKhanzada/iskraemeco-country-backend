package com.iskraemeco.project.controller;

/**
 * 
 * A customer exception which will being thrown during country not found
 * @author Anees Khan
 *
 */
public class InvalidCountryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCountryException() {}
	
	public InvalidCountryException(String msg) {
		super(msg);
	}
	
}
