package com.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Person;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Integer> {
	
	public Person findById(int id);
	

}