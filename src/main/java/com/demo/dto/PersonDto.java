/**
 * 
 */
package com.demo.dto;

import java.io.Serializable;

/**
 * @author shahzad.hussain
 *
 */
public class PersonDto implements Serializable {

	private static final long serialVersionUID = -6800625987888633906L;

	private Long id;
	private String firstName;
	private String lastName;
	private String createdOn;
	private String modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
