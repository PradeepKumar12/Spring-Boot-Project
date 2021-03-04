package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.dto.AddressDTO;
import com.boot.dto.PersonDTO;
import com.boot.entity.Person;
import com.boot.repositories.PersonRepositories;


@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepositories personRepositories;

// add New Person
	public Person addNewPerson(Person person) {
		Person p = null;
		p = personRepositories.save(person);
		return p;
	}

// get All personn
	public List<Person> getAllPerson() {
		List<Person> list = (List<Person>) personRepositories.findAll();
		return list;
	}

// get Single Person
	public Person getPerson(int id) {
		Person p = null;
		p = personRepositories.findById(id);
		return p;
	}

// Update Single Person
	public Person updatePerson(int id, Person person) {
		person.setId(id);
		return personRepositories.save(person);
	}

// Delete Single Person
	public void deleteById(int id) {
		personRepositories.deleteById(id);
		
	}

// Delete All Person
	public void deleteAlPerson() {
		personRepositories.deleteAll();
	}

// Get Person_id and address(address,id) 
	public List<PersonDTO> getAddressPerson() {
		List<PersonDTO> dto=new ArrayList<>();
		List<Person> list=personRepositories.findAll();
		for(Person person:list) {
			PersonDTO  personDTO=new PersonDTO();
			personDTO.setPersonId(person.getId());
			personDTO.setAddress(person.getAddressDetails());
			dto.add(personDTO);
		}
		return dto;
	}

//Get Person_id and address
	public List<AddressDTO> getAddress() {
		List<AddressDTO> dto=new ArrayList<>();
		List<Person> list=personRepositories.findAll();
		for(Person person:list) {
			AddressDTO addressDTO=new AddressDTO(person);
			dto.add(addressDTO);
		}
		return dto;
	}

}
