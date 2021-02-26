package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.model.Book;

@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	static {
		list.add(new Book(12,"java","abc"));
		list.add(new Book(13,"c","def"));
		list.add(new Book(14,"android","ghi"));
		list.add(new Book(15,"python","xyz"));
		
	}
	
//Get All Books	
	public List<Book> getAllBooks() {
		return list;
	}
	
//Get Single Book
	public Book getBookById(int bid) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==bid).findFirst().get();
		return book;
	}
// Add New Book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

//Delete Single Book
	public void deleteBookById(int bid) {
		
//		list=list.stream().filter(b->{
//			if(b.getId()==bid) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		
	}

//Update book
	public void updateBookById(Book book, int bookId) {
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
	}

	

	
}
