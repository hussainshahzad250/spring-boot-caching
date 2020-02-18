package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.demo.assembler.PersonAssembler;
import com.demo.dto.PersonDto;
import com.demo.entity.Person;
import com.demo.exception.ObjectNotFoundException;
import com.demo.repository.PersonRepository;

/**
 * @author shahzad.hussain
 *
 */
@Service
class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonAssembler personAssembler;

	@Autowired
	private PersonRepository personRepository;

	@Override
	public PersonDto savePerson(PersonDto request) {
		try {
			Person entity = personAssembler.entity(request);
			personRepository.save(entity);
			return personAssembler.toDto(entity);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public PersonDto getPersonById(Long id) throws ObjectNotFoundException {
		Optional<Person> findById = personRepository.findById(id);
		if (!findById.isPresent())
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		return personAssembler.toDto(findById.get());

	}

	@Override
	@Cacheable(value = "personDetails")
	public List<PersonDto> getAll() throws ObjectNotFoundException {
		List<Person> persons = personRepository.findAll();
		if (CollectionUtils.isEmpty(persons))
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		return personAssembler.getResponseList(persons);
	}
}
