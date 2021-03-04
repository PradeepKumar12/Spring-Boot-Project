package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.AddressDTO;
import com.springboot.dto.PersonDTO;
import com.springboot.model.Person;
import com.springboot.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
//Add new Person Handler
	@PostMapping("/person")
    public Person saveEmployee(@RequestBody Person person) {
        return personService.addNewPerson(person);

    }
	
// Get All person Handler
	@GetMapping("/person")
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
// Get Single Person handler
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		Person p1=personService.getPerson(id);
		return p1;
	}
	
//Update Single Person Handler
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable("id") int id,@RequestBody Person person) {
		return personService.updatePerson(id,person);
	}
	
//Delete Single Person Handler
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		 personService.deleteById(id);
	}

//Delete All Person Handler
	@DeleteMapping("/person")
	public void deleteAllPerson() {
		personService.deleteAlPerson();
	}
	
// Get Person_id and address(address,id) handler
	@GetMapping("/personaddress")
	public List<PersonDTO> getAddressPerson() {
		return personService.getAddressPerson();
	
	}
	
//Get Person_id and address
	@GetMapping("/address")
	public List<AddressDTO> getAddress(){
		return personService.getAddress();
	}
	
}
