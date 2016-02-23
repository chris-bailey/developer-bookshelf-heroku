package com.chrisbaileydeveloper.bookshelf.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chrisbaileydeveloper.bookshelf.domain.Book;
import com.chrisbaileydeveloper.bookshelf.repository.BookRepository;
import com.google.common.collect.Lists;

@Service
@Transactional
public class BookService {
	final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Inject
	private BookRepository bookRepository;

	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		return bookRepository.findOneById(id);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void delete(Book book) {
		bookRepository.delete(book);
	}

	/**
	 * Removes all Book entities from database.
	 */
	public void deleteAll() {
		bookRepository.deleteAll();
	}

	/**
	 * Restore the original set of books to the database.
	 */
	public void restoreDefaultBooks() {
		ClassPathResource resource = new ClassPathResource("/config/liquibase/books.csv");

		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(
					resource.getInputStream()));

			// Skip first line that only holds headers.
			br.readLine();

			String line;

			while ((line = br.readLine()) != null) {
				String[] words = line.split("~");

				Integer version = Integer.valueOf(words[0]);
				String name = words[1];
				String publisher = words[2];

				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
				DateTime dateOfPublication = formatter.parseDateTime(words[3]);

				String description = words[4];
				String photo = words[5];

				Book b = new Book(version, name, publisher, dateOfPublication,
						description, photo);

				bookRepository.save(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Release resources.
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
