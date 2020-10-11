package com.iskraemeco.project.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Anees Khan 
 * 
 */
public class CountryHelper {
	/**
	 * 
	 * Common error messages used for HTTP response
	 * 
	 */
	public static Map<String, String> INVALID_COUNTRY_ERROR = new HashMap<>();
	public static Map<String, String> INTERNAL_ERROR = new HashMap<>();
	public static Map<String, String> UNKNOWN_ERROR = new HashMap<>();
	
	static {
		INVALID_COUNTRY_ERROR.put("error_message", "INVALID_COUNTRY_CODE");
		INTERNAL_ERROR.put("error_message", "INTERNAL_ERROR");
		UNKNOWN_ERROR.put("error_message", "UNKNOWN_ERROR");
	}

}
