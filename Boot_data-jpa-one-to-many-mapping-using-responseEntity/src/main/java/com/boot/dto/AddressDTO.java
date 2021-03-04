package com.boot.dto;

import java.util.HashSet;
import java.util.Set;

import com.boot.entity.AddressDetails;
import com.boot.entity.Person;

import lombok.Data;

@Data
public class AddressDTO {
	
	private int personId;
	private Set<String> address = new HashSet<>();
	
	public AddressDTO(Person person) {
		this.personId = person.getId();
		for(AddressDetails address : person.getAddressDetails()) {
				this.address.add(address.getAddress());
			
		}
	}
	
	

}
