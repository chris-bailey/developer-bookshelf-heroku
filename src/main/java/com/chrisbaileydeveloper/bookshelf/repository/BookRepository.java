package com.chrisbaileydeveloper.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chrisbaileydeveloper.bookshelf.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	 Book findOneById(Long id);
}
