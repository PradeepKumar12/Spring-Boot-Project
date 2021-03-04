package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Person;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Integer> {
	
	public Person findById(int id);
	

}
