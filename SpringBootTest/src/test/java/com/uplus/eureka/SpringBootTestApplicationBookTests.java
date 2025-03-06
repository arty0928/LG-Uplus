package com.uplus.eureka;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.uplus.eureka.book.model.dao.BookDao;
import com.uplus.eureka.book.model.dto.Book;


@SpringBootTest(
		properties = {"spring.config.location=classpath:application.properties"}
)

@ComponentScan(basePackages = {"com.uplus.eureka"})
class SpringBootTestApplicationBookTests {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private BookDao bookDao;
	

	@Test
	public void bookDaoTest() {
		//null인지 체크하는 단정 함수
		assertNotNull(bookDao);
	}
	
	@Test
	public void searchTest() throws Exception {
		Book book = bookDao.search("123-4561");
		assertNotNull(bookDao);
		log.debug("book : {} " , book);
	}
	
	@Test
	public void registTest() throws Exception {
		Book book = new Book();
		book.setAuthor("pes");
		book.setPrice(5000);
		book.setTitle("오늘은 내가 짱이다");
		book.setIsbn("123-4561");
		
		bookDao.insert(book);
		
		assertNotNull(bookDao.search("123-4561"));
		log.debug("book : {} " , book);
	}
	
	@Test
	public void dsTest() {
		//null인지 체크하는 단정 함수
		assertNotNull(ds);
	}
	

}
