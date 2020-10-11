package com.iskraemeco.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iskraemeco.project.repository.CountryRepository;
import com.iskraemeco.project.model.Country;

/**
 * @author Anees Khan
 */
@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	/**
	 * 
	 * @author Anees Khan
	 * @return The List of the all countries
	 * @throws Exception to handle database down checked exception, Specified exception will be
	 * filter later through related adviser
	 * 
	 */
	public List<Country> getAllCountries() throws Exception {
		List<Country> countries = new ArrayList<>();
		countryRepository.findAll().forEach(c -> countries.add(c));
		return countries;
		
	}
	
	/**
	 * 
	 * @param code is unique for each country and as well as identity
	 * @return Optional of country, could be empty
	 * @throws Exception to handle database down checked exception, Specified exception will be
	 * filter later through related adviser.
	 * 
	 */
	public Optional<Country> getCountryByCode(String code) throws Exception{
		return countryRepository.findById(code);
	}
	
}