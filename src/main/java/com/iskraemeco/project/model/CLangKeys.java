package com.iskraemeco.project.model;

import java.io.Serializable;

/**
 * 
 * Composite Keys class for CountryLanguage {@link com.iskraemeco.project.model.CountryLanguage}
 * @author Anees Khan
 *
 */
public class CLangKeys implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String language;

	public CLangKeys(String countryCode, String language) {
		this.countryCode = countryCode;
		this.language = language;
	}
	
	public CLangKeys() {
		
	}
}
