package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.dto.AddressDTO;
import com.springboot.dto.PersonDTO;
import com.springboot.model.Person;
import com.springboot.repositories.PersonRepositories;


@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepositories personRepositories;

//add New Person
	public Person addNewPerson(Person person) {
		Person p=null;
		p=personRepositories.save(person);
		return p;
	}

//get All personn
	public List<Person> getAllPerson() {
		List<Person>list=(List<Person>) personRepositories.findAll();
		return list;
	}

//get Single Person
	public Person getPerson(int id) {
		Person p=null;
		p=personRepositories.findById(id);
		return p;
	}

// Update Single Person
	public Person updatePerson(int id, Person person) {
		person.setId(id);
		return personRepositories.save(person);
	}

// Delete Single Person
	public void deleteById(int id) {
		 personRepositories.deleteById(id);;
	}

//Delete All Person
	public void deleteAlPerson() {
		personRepositories.deleteAll();
	}

//get personId ,addressId,And address
	public List<PersonDTO> getAddressPerson() {	
		List<Person> list=personRepositories.findAll();
		List<PersonDTO> personDTO=new ArrayList<>();
		for(Person pe:list) {
			PersonDTO person=new PersonDTO();
			person.setAddress(pe.getAddressDetails());
			person.setPersonId(pe.getId());
			personDTO.add(person);
		}
		return personDTO;
	}

// get personId and address
	public List<AddressDTO> getAddress() {
		List<Person> list=personRepositories.findAll();
		List<AddressDTO> addressList=new ArrayList<>();
		for(Person person:list) {
			AddressDTO personDTO=new AddressDTO(person);
			addressList.add(personDTO);
			
		}
		return addressList;
	}


	
	
	
	
}
