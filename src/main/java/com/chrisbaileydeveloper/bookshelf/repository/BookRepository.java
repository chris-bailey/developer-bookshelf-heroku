package com.chrisbaileydeveloper.bookshelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chrisbaileydeveloper.bookshelf.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	 Book findOneById(Long id);
	 
	 List<Book> findAll();
	 
	 void delete(Book b);
	 
	 void deleteAll();
	 
}
