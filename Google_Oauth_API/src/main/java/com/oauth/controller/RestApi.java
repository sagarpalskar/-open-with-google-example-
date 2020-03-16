package com.oauth.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.dao.BootDAO;
import com.oauth.model.Book;

@RestController
public class RestApi 
{
	static Logger l1 = LogManager.getLogger(RestApi.class.getName());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BootDAO dao;
	
	@RequestMapping("/test")
	
	public String Student() 
	{
		l1.info("api call to /test from ADMIN   ");
		return "Welcome to oauth 2";
	}
	

	@GetMapping("/availableBook")
	@PreAuthorize("hasAuthority('user')")
	public List<Book> availableBook() 
	{
		l1.info("user asking for /availableBook api");
		List<Book> book = dao.isData();
		l1.info("responce = " + book.toString());
		return book;
	}
	
	// can not check in postman  and  not on browser because of post method

/*	@PostMapping("/insertBook")
	public int insertBook(@RequestBody Book book) 
	{
		String sql = "insert into Book values('" + book.getBookId() + "','" +book.getBookName() + "','" 
	                                          +book.getBookAuthor()+ "','"+book.getBookPrice() + "')";
		return jdbcTemplate.update(sql);
	}
	
	@PutMapping("/updateBook")
	public int updateBook(@RequestBody Book book) 
	{
		String sql = "insert into Book values('" + book.getBookId() + "','" +book.getBookName() + "','" 
	                                          +book.getBookAuthor()+ "','"+book.getBookPrice() + "')";
		return jdbcTemplate.update(sql);
	}
	*/
	
	@GetMapping("/deleteBookByName/{bookName}")
	public int deleteBookByName(@PathVariable("bookName") String bookName) 
	{
		String sql = "DELETE FROM  Book  WHERE  bookname ='"+bookName+"'";
		return jdbcTemplate.update(sql);
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
}
