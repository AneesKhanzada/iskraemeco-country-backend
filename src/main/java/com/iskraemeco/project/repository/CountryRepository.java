package com.iskraemeco.project.repository;

import org.springframework.data.repository.CrudRepository;
import com.iskraemeco.project.model.Country;

/**
 * 
 * Repository to perform CRUD Operation on Country {@link com.iskraemeco.project.model.Country}
 * @author Anees Khan
 *
 */
public interface CountryRepository extends CrudRepository<Country, String> {
}
