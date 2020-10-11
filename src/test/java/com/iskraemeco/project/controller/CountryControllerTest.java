package com.iskraemeco.project.controller;

import java.sql.SQLException;
import java.util.Optional;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.iskraemeco.project.service.CountryService;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * Test cases to verify the endpoints, mainly for CountryController
 * @author Anees Khan
 *
 */
@WebMvcTest(controllers = CountryController.class)
@ActiveProfiles("test")
class CountryControllerTest {
   
    @Autowired                           
    private MockMvc mockMvc;  
                                                 
    @MockBean                           
    private CountryService countryService; 
    
    /**
     * 
     * This test will verify HTTP end-point for status code 500 and error message as INVALID_COUNTRY_CODE,
     * if country not found against provided country code
     * 
     */
    @Test
    void shouldReturn500WhenFindCountryByCode() throws Exception {
        final String countryCode = "WRONG";
        
        given(countryService.getCountryByCode(countryCode))
        		.willReturn(Optional.empty());
        
        this.mockMvc.perform(get("/{code}", countryCode))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error_message", is("INVALID_COUNTRY_CODE")));
    
    }
    
    /**
     * 
     * Test case will verify for database down, Which response 500 as HTTP status along with
     * INTERNAL_ERROR as error message
     * 
     */
    @Test
    void shouldReturn500WhenDatabaseDown() throws Exception {
        final String countryCode = "ANY";
        
        given(countryService.getCountryByCode(countryCode))
        		.willThrow(new Exception(new JDBCConnectionException("", new SQLException())));
        
        this.mockMvc.perform(get("/{code}", countryCode))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error_message", is("INTERNAL_ERROR")));
    }
    
}