package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Person;

public interface PersonRepositories extends JpaRepository<Person, Integer> {
	
	public Person findById(int id);
	

}
