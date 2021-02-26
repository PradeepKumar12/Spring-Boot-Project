package com.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.model.Books;
import com.restapi.repositories.BooksRepository;

@Component
public class BooksServiceImpl implements BooksService  {

	@Autowired
	private BooksRepository repository;
	
// Add New Book
	public Books addBook(Books book) {
		Books results = repository.save(book);
		return results;
	}

//Get Single book
	public Books getBookById(int bid) {
		Books book=null;
		try {
			book=repository.findById(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
//Get All Books	
	public List<Books> getAllBooks() {
		List<Books>list= (List<Books>) repository.findAll();
		return list;
	}

//Update Book
	public void updateBookById(Books book, int bid) {
		
		book.setId(bid);
		repository.save(book);
		
	}

//Delete Single Book
	public void deleteBookById(int bid) {
		repository.deleteById(bid);

	}

	
}
