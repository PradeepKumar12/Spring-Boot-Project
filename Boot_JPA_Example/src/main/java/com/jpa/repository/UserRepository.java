package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.model.User;

public interface UserRepository  extends CrudRepository<User, Integer>{

}
