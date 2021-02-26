package com.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.restapi.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer>{
	 
	public Books findById(int id);

}
