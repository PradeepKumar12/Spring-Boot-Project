package com.boot.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Person_details")
public class Person {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "person_id", unique = true, nullable = false)
	private int id;
	@Column(name="person_email")
	private String email;
	@Column(name="person_password")
	private String password;
	@Column(name="person_gender")
	private String gender;
	@Column(name="person_mobileNo")
	private long mobileNo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personId")
    private Set<AddressDetails> addressDetails;
}
