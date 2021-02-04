package com.example.springsecurituy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class LoginController {
	
	@GetMapping(value="/")
	public String home()
	{
		return "Hello World";
	}
	
	@GetMapping(value="/user")
	public String user()
	{
		return "Welcome user";
	}
	
	@GetMapping(value="/admin")
	public String admin()
	{
		return "Welcome admin";
	}
	
	@GetMapping(value="/hello")
	public String hello()
	{
		return "----";
	}
	

}
