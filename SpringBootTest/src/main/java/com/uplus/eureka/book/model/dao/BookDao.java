package com.uplus.eureka.book.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.uplus.eureka.book.model.dto.Book;
import com.uplus.eureka.book.model.dto.PageBean;

/*
 * @Mapper
 * Spring Container 를 통해 mybatis와 연동될 interface로 인식해서 구현체를 생성한다.
 */
@Mapper
public interface BookDao {
	public List<Book> searchAll(PageBean bean) throws SQLException;
	public int totalCount(PageBean bean) throws SQLException;
	public Book search(String isbn)	throws SQLException;
	public void remove(String isbn)	throws SQLException;
	public void update(Book book)	throws SQLException;
	public void insert(Book book)	throws SQLException;
}
