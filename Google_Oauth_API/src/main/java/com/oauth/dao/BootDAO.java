package com.oauth.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oauth.model.Book;

@Repository
public class BootDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 private static final String SQL = "select * from Book";

     public List<Book> isData() {

          List<Book> student = new ArrayList<Book>();
          List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

          for (Map<String, Object> row : rows) 
          {
        	  Book s = new Book();
               s.setBookId((int)row.get("bookId"));
               s.setBookName((String)row.get("bookName"));
               s.setBookAuthor((String)row.get("bookAuthor"));
               s.setBookPrice((int)row.get("bookPrice"));
               student.add(s);
           }

         return student;
     }

}
