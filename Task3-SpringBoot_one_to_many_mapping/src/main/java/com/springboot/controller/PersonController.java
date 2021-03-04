package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Person> saveEmployee(@RequestBody Person person) {
		try {
			return ResponseEntity.of(Optional.of(personService.addNewPerson(person)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

// Get All person Handler
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> list = personService.getAllPerson();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

// Get Single Person handler
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable("id") int id) {
		Person p1 = personService.getPerson(id);
		if (p1 == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(p1));
	}

//Update Single Person Handler
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
		try {
			personService.updatePerson(id, person);
			return ResponseEntity.ok().body(person);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

//Delete Single Person Handler
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
		try {
			personService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

//Delete All Person Handler
	@DeleteMapping("/person")
	public ResponseEntity<Void> deleteAllPerson() {
		try {
			personService.deleteAlPerson();;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}

// Get Person_id and address(address,id) handler
	@GetMapping("/personaddress")
	public ResponseEntity<List<PersonDTO>> getAddressPerson() {
		List<PersonDTO>list= personService.getAddressPerson();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		

	}

//Get Person_id and address
	@GetMapping("/address")
	public ResponseEntity<List<AddressDTO>> getAddress() {
		List<AddressDTO>list= personService.getAddress();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}

}
