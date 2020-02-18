/**
 * 
 */
package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.PersonDto;
import com.demo.exception.ObjectNotFoundException;
import com.demo.exception.Response;
import com.demo.service.PersonService;

/**
 * @author shahzad.hussain
 *
 */
@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<Object> savePerson(@RequestBody PersonDto request) {
		PersonDto response = personService.savePerson(request);
		if (response != null)
			return new ResponseEntity<>(new Response("Person saved successfully", response, HttpStatus.OK),
					HttpStatus.OK);
		return new ResponseEntity<>(new Response("Something went wrong", HttpStatus.BAD_REQUEST),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getPersonById(@PathVariable("id") Long id) throws Exception {
		PersonDto person = personService.getPersonById(id);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Object> getAll() throws ObjectNotFoundException {
		List<PersonDto> persons = personService.getAll();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

}
