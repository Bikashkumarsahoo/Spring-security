package com.example.springsecurityjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping(value="/")
	public String home(){
		return ("<h1>Hello Wordl</h1>");
	}
	
	@GetMapping(value="/user")
	public String user(){
		return ("<h1>Welcome user</h1>");
	}
	
	@GetMapping(value="/admin")
	public String admin(){
		return ("<h1>Welcome admin</h1>");
	}
}
