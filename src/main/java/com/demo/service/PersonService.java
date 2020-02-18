package com.demo.service;

import java.util.List;

import com.demo.dto.PersonDto;
import com.demo.exception.ObjectNotFoundException;

/**
 * @author shahzad.hussain
 *
 */
public interface PersonService {

	PersonDto savePerson(PersonDto request);

	PersonDto getPersonById(Long id) throws ObjectNotFoundException;

	List<PersonDto> getAll() throws ObjectNotFoundException;

}
