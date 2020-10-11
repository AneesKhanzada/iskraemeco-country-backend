package com.iskraemeco.project.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * CountryLanguage which will be used for Country's Language 
 * @author Anees Khan
 *
 */
@Entity
@Table
@IdClass(CLangKeys.class)
public class CountryLanguage implements Serializable{

	@Id
	@Column
	private String countryCode;
	
	@Column
	private String language;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "countryCode",  insertable = false, updatable = false)
	@JsonIgnore
	private Country country;
	
	private static final long serialVersionUID = 1L;
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ContryLanguage [countryCode=" + countryCode + ", language=" + language + "]";
	}
	
}
