package com.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.dto.AddressDTO;
import com.boot.dto.PersonDTO;
import com.boot.entity.Person;

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
