package com.uplus.eureka.book.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uplus.eureka.book.model.dto.Book;
import com.uplus.eureka.book.model.dto.PageBean;
import com.uplus.eureka.book.model.service.BookService;

/*
 * @RestController  
 *   RestFul Service를 위한 Conrtoller 
 *   모든 메서드의 응답을  @ResponseBody를 붙여주는 효과
 */
@RestController	

//RestFul에서 서비스할 자원(Domain)명을 붙인다
//@RequestMapping("/요청명")  괄호 안에 요청명 앞에 / 필수
@RequestMapping("/book") 

/*
 * @CrossOrigin
 *  - CORS 요청에 대한 승인
 *  origins = {"*"}  : 요청하는 모든 URL, 메서드를 승인 
 *     ==> 보안에 취약하므로 상용에서는 사용 안함
 *     ==> 이후에 Configuration을 통해 설정할 예정  
 * */
@CrossOrigin(origins = {"*"})
public class BookRestController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final String SUCCESS="SUCCESS";

	public BookService service;
	public BookRestController(BookService service) {
		this.service = service;
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Book> search(@PathVariable("isbn") String isbn){
		logger.debug("isbn:{}",isbn);
		
		Book book = service.search(isbn);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	/*
	 * ResponseEntity<?>
	 * ? : any Type
	 * 
	 * 
	 */
	@GetMapping
	public ResponseEntity<?> searchAll(PageBean bean){
		logger.debug("bean : {}", bean);
		
		List<Book> books = service.searchAll(bean);
		
		logger.debug("books : {}", books);
		
		if(books!=null && books.size() > 0) {
			Map<String, Object> result = new HashMap<>();
			result.put("books", books);
			result.put("page", bean);
			return new ResponseEntity<Map>(result, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);			
		}
	}
	
	
	/**
	 * ResponseEntity
	 * 응답 데이타를 담을 객체
	 */

	/**
	 * @PathVariable
	 * 요청 데이타가 url에 있는 경우 path에서 데이타를 전달 받을 때 사용하는 Annotation 
	 * Get 방식에서 범위 데이타를 요청할때와 pk를 이용한 1개의 데이타를 요청할때를 
	 * 구별하기 path로 전달된 pk를 추출할때 사용한다. 
	 */

	
	/**
	 * @RequestBody
	 * 요청 방식이 Put과 Post이면서 요청 데이타가 JOSON 형식일 때 
	 * 전달되는 요청 packet의 body를 객체로 전달 받을 때 사용하는 Annotation 
	 */
	
	// 등록은 PostMapping
	@PostMapping
	public ResponseEntity<String> regist(@RequestBody Book book){
		logger.debug("regist - book : {}", book);
		service.insert(book);
		return new ResponseEntity<String>(SUCCESS,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Book book){
		logger.debug("update-book: {}", book);
		service.update(book);
		return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
	}
	
	@DeleteMapping("/{isbn}")
	public ResponseEntity<String> remove(@PathVariable("isbn") String isbn){
		logger.debug("remove - isbn : {}", isbn);
		service.remove(isbn);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}






