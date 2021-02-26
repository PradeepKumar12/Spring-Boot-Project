package com.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.model.Books;

@Service
public interface BooksService {

	public Books addBook(Books book);
	
	public Books getBookById(int bid);
	
	public List<Books> getAllBooks();

	public void updateBookById(Books book, int bid);

	public void deleteBookById(int bid);

	

	

	

}
