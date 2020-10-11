package com.iskraemeco.project.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Country a POJO model and JPA entity 
 * @author Anees Khan
 *
 */
@Entity
@Table
public class Country  implements Serializable{

	@Id
	@Column
	@JsonIgnore
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String continent;
	
	@Column
	private Long population;
	
	@Column
	@JsonProperty("life_expectancy")
	private Integer lifeExpectancy;
	
	@Transient
	@JsonProperty("country_language")
	private String language;

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CountryLanguage> countryLanguageList;
	
	public Country() {
		
	}
	
	public Country(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public Long getPopulation() {
		return population;
	}
	
	public void setPopulation(Long population) {
		this.population = population;
	}
	
	public Integer getLifeExpectancy() {
		return lifeExpectancy;
	}
	
	public void setLifeExpectancy(Integer lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	
	public List<CountryLanguage> getCountryLanguageList() {
		return countryLanguageList;
	}

	public void setCountryLanguageList(List<CountryLanguage> countryLanguageList) {
		this.countryLanguageList = countryLanguageList;
	}

	public String getLanguage() {
		if(countryLanguageList != null && countryLanguageList.size() > 0 )
			return this.countryLanguageList.get(0).getLanguage();
		else
			return null;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", continent=" + continent + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + "]";
	}
	
}