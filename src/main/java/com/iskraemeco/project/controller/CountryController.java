package com.iskraemeco.project.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iskraemeco.project.model.Country;
import com.iskraemeco.project.service.CountryService;

/**
 * 
 * CountryController will handle all the incomming request for Country APIs
 * @author Anees Khan
 *
 */
@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/**
	 * 
	 * @return List of all countries
	 * @throws Exception to handle database down checked exception, Specified exception will be
	 * filter in CountryControllerAdviser.
	 */
	@RequestMapping("/")
	public List<Country> getAllCountries()throws Exception {
		return countryService.getAllCountries();
	
	}
	
	/**
	 * 
	 * @param code is unique for each country and as well as identity
	 * @return 200 HTTP response if country found other wise it will throw InvalidCountryException,
	 * which will be handle by CountryControllerAdvice
	 * @throws Exception to handle database down checked exception, Specified exception will be
	 * filter in CountryControllerAdviser.
	 * 
	 */
	@RequestMapping("/{code}")
	public ResponseEntity<?> getCountry(@PathVariable String code) throws Exception{
		Optional<Country> country = countryService.getCountryByCode(code);
		if(country.isPresent())
			return ResponseEntity.ok().body(country.get());
		else
			throw new InvalidCountryException();
			
	}
	
}
