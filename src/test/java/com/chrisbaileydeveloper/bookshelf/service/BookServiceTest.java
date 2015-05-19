package com.chrisbaileydeveloper.bookshelf.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.chrisbaileydeveloper.bookshelf.Application;
import com.chrisbaileydeveloper.bookshelf.domain.Book;

/**
 * Test class for the BookServiceImpl service.
 *
 * @see BookService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class BookServiceTest {
	private final String expectedName = "Effective Java";
    private final String expectedPublisher = "Addison-Wesley";
    private int totalBooks;
    private Book testBook = new Book(1, "Name test", "Publisher test", null, "Description test", "iVBORw0KGgoA");
	
    @Inject
    private BookService bookService;
	
    @Before
	public void setup() {
		totalBooks = bookService.findAll().size();
	}
    
    @Test
	public void testFindAll() {
    	assertThat(bookService.findAll()).hasSize(totalBooks);
	}

	@Test
	public void testFindById() {
		// Book with id=1L is Effective Java by Addison-Wesley
        assertThat(bookService.findById(1L).getName()).isEqualTo(expectedName);
        assertThat(bookService.findById(1L).getPublisher()).isEqualTo(expectedPublisher);
	}

	@Test
	public void testSave() {
		bookService.save(testBook);
		assertThat(bookService.findAll()).hasSize(totalBooks + 1);
	}

	@Test
	public void testDelete() {
		Book book = bookService.findById(1L);
		bookService.delete(book);
		assertThat(bookService.findAll()).hasSize(totalBooks - 1);
	}

	@Test
	public void testDeleteAll() {
		bookService.deleteAll();
		assertThat(bookService.findAll()).isEmpty();
	}

	@Test
	public void testRestoreDefaultBooks() {
		bookService.deleteAll();
		assertThat(bookService.findAll()).isEmpty();
		bookService.restoreDefaultBooks();
		assertThat(bookService.findAll()).hasSize(totalBooks);
	}
}
