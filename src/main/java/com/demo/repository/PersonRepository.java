package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Person;

/**
 * @author shahzad.hussain
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
