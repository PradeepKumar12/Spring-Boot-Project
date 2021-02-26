package com.restapi.controller;

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

import com.restapi.model.Books;
import com.restapi.service.BooksService;


@RestController
public class BooksController {
	
	@Autowired
	private BooksService bookService;
	
//New Book handler
	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		Books b = null;
		try {
			b = bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
//Get Single Book Handler
	@GetMapping("/book/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") int bid) {
		Books book= bookService.getBookById(bid);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	
//Get All Book Handler
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> list=bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));	
	}
	
//Update Book Handler
	@PutMapping("/book/{id}")
	public ResponseEntity<Books> updateBook(@RequestBody Books book ,@PathVariable("id") int bid){
		try {
			bookService.updateBookById(book, bid);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Delete Single Book handler
		@DeleteMapping("/book/{id}")
		public ResponseEntity<Void> deleteBook(@PathVariable("id") int bid) {
			try {
				bookService.deleteBookById(bid);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
}
