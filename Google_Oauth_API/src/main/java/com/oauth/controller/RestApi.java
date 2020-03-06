package com.oauth.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.dao.BootDAO;
import com.oauth.model.Book;

@RestController
public class RestApi 
{
	static Logger l1 = LogManager.getLogger(RestApi.class.getName());
	
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
	
	
}
