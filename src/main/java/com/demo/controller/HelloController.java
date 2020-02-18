package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shahzad.hussain
 *
 */
@RestController
public class HelloController {

	@GetMapping(value = "/")
	public String hello() {
		return "Server is up and running....";
	}
}
