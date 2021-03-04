package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dto.AddressDTO;
import com.springboot.dto.PersonDTO;
import com.springboot.model.Person;

@Service
public interface PersonService {

	public Person addNewPerson(Person person);

	public List<Person> getAllPerson();

	public Person getPerson(int id);

	public Person updatePerson(int id, Person person);

	public void deleteById(int id);

	public void deleteAlPerson();

	public List<PersonDTO> getAddressPerson();

	public List<AddressDTO> getAddress();

	
	




}
