package com.springboot.dto;

import java.util.Set;

import com.springboot.model.AddressDetails;

import lombok.Data;

@Data
public class PersonDTO{

	private Integer personId;
	private Set<AddressDetails> address;
	
	
}
