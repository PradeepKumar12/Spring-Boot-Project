package com.boot.dto;

import java.util.Set;

import com.boot.entity.AddressDetails;

import lombok.Data;

@Data
public class PersonDTO {
	
	private int personId;
	private Set<AddressDetails> address;
	

}
