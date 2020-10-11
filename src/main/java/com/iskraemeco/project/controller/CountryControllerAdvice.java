package com.iskraemeco.project.controller;

import static com.iskraemeco.project.helper.CountryHelper.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;

/**
 * 
 * Adviser will handle the Exception thrown by Controller
 * @author Anees Khan
 * 
 */
@ControllerAdvice 
public class CountryControllerAdvice {
	
	/**
	 * 
	 * {@link com.iskraemeco.project.controller.InvalidCountryException }
	 * @param InvalidCountry is a custom exception thrown by controller when country not found
	 * @return Response with 500 status with error message INVALID_COUNTRY_CODE
	 * 
	 */
	@ExceptionHandler({InvalidCountryException.class})
	public ResponseEntity<?> handleInvalidCountryException(InvalidCountryException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INVALID_COUNTRY_ERROR);
	}

	/**
	 * 
	 * This method will catch all exception and then will handle JDBCConnectionException 
	 * @param Exception 
	 * @return Response with 500 status with error message INTERNAL_ERROR otherwise UNKNOWN_ERROR
	 * 
	 */
	@ExceptionHandler({Exception.class})
	public ResponseEntity<?> test(Exception e){
		if(e.getCause() instanceof JDBCConnectionException)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INTERNAL_ERROR);
		else 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(UNKNOWN_ERROR);
	}
	
}