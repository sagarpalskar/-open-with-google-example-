package com.oauth.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.oauth.dao","com.oauth.security","com.oauth.model","com.oauth.controller"})
@SpringBootApplication
public class GoogleOauthAPIApplication
{
	 public static void main(String[] args) 
	 {
	      SpringApplication.run(GoogleOauthAPIApplication.class, args);
	}

}
