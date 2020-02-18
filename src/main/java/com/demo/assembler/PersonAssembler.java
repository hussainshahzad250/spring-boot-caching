/**
 * 
 */
package com.demo.assembler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.constants.Constants;
import com.demo.dto.PersonDto;
import com.demo.entity.Person;
import com.demo.utils.DateUtil;

/**
 * @author shahzad.hussain
 *
 */
@Component
public class PersonAssembler extends Constants {

	public Person entity(PersonDto request) {
		Person response = new Person();
		response.setId(request.getId());
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());
		response.setCreatedOn(new Date());
		response.setModifiedOn(new Date());
		return response;
	}

	public PersonDto toDto(Person request) {
		PersonDto response = new PersonDto();
		response.setId(request.getId());
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());
		if (request.getCreatedOn() != null)
			response.setCreatedOn(DateUtil.format(request.getCreatedOn(), DD_MM_YYYY));
		if (request.getModifiedOn() != null)
			response.setModifiedOn(DateUtil.format(request.getModifiedOn(), DD_MM_YYYY));
		return response;
	}

	public List<PersonDto> getResponseList(List<Person> persons) {
		return persons.parallelStream().map(person -> toDto(person)).collect(Collectors.toList());
	}

}
