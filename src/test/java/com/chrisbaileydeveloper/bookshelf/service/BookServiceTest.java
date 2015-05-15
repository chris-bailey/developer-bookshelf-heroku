package com.chrisbaileydeveloper.bookshelf.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.chrisbaileydeveloper.bookshelf.Application;
import com.chrisbaileydeveloper.bookshelf.repository.BookRepository;
import com.chrisbaileydeveloper.bookshelf.service.BookService;

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
    
	
	@Inject
	private BookRepository bookRepository;

    @Inject
    private BookService bookService;
	
    
    @Test
    public void testFindBook() {
    	// Book with id=1L is Effective Java by Addison-Wesley
        assertThat(bookRepository.findOneById(1L).getName()).isEqualTo(expectedName);
        assertThat(bookRepository.findOneById(1L).getPublisher()).isEqualTo(expectedPublisher);
    }
    
	/*private static final String NAME_FIELD = "name";
	private static final String BOOKS_RESOURCE = "/";
	
	
	
	@Value("${local.server.port}")
	private int serverPort;
	
	private Book firstBook;
	private Book secondBook;
	
	
	  @Before
	  public void setUp() {
	    bookRepository.deleteAll();
	    
	    firstBook = new Book();
	    firstBook.setId(998L);
	    firstBook.setName("Bob Johnson");
	    firstBook.setPublisher("Temp pub");
	    
	    secondBook = new Book();
	    secondBook.setId(999L);
	    secondBook.setName("John Doe");
	    secondBook.setPublisher("Sparrow agency");
	    
	    bookRepository.save(firstBook);
	    bookRepository.save(secondBook);
	    
	    RestAssured.port = serverPort;
	  }*/

	
   /* @Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }*/

   /* @Test
    public void verifiesHomePageLoads() throws Exception {
    	 mockMvc.perform(get("/"))
         .andDo(print());
    	
    	 mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/
		
		
		/*try {
			standaloneSetup(new BookController()).build()
			  .perform(get("/"))
			  .andExpect(status().isOk())
			  .andExpect(content().contentType("text/plain;charset=UTF-8"))
			  .andExpect(content().string("books/list"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*when()
	    .get(BOOKS_RESOURCE)
	  .then()
	    .statusCode(HttpStatus.SC_OK);
	    */
	    /*.body("name", hasItems("Bob Johnson", "John Doe"))
	    .body("publisher", hasItems("Temp pub", "Sparrow agency"))*/
}
