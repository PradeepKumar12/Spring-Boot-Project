package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Book;
import com.api.service.BookService;

//@Controller
@RestController
public class BookController {

//	@RequestMapping(value = "/books" ,method = RequestMethod.GET)
//	@ResponseBody
//	public String getBook() {
//		return "API testing !!!";
//	}
	
//	@GetMapping("/books")
//	public Book getBook() {
//		Book book=new Book();
//		book.setId(12);
//		book.setTitle("java");
//		book.setAuthor("abc");
//		return book;
//	}
	
	@Autowired
	private BookService bookService;
	
//Get All Book Handler
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
//Get Single Book Handler	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int bid) {
		return bookService.getBookById(bid);
	}
	
//New Book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=null;
		b=bookService.addBook(book);
		return b;
	}
	
//Update Book Handler
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("id") int bookId) {
		bookService.updateBookById(book, bookId);
		return book;
	}
	
	
//Delete Single Book handler
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int bid) {
		bookService.deleteBookById(bid);
	}
	

	
}
