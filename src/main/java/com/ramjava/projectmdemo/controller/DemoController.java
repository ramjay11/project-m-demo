package com.ramjava.projectmdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting") 
public class DemoController {

	// By default, @RequestMapping is GET Request
	@RequestMapping("/basic")
	public String sayDemo() {
		return "<h1>hello</h1>";
	}
	
	@RequestMapping(value = "/proper", method = RequestMethod.GET)
	public String sayProperDemo() {
		return "<h1>hello there, how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return " <form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
	    "  First name:<br>\n" +
		"  <input type=\"text\" name=\"firstname\">\n" +
	    "  <br>\n" +
		"  Last name:<br>\n" +
	    "  <input type=\"text\" name=\"lastname\">\n" +
		"  <br><br>\n" +
	    "  <input type=\"submit\" value=\"Submit\">\n" +
		" </form> ";
	}
	
	// RequestParam is not part of the URL but part of the request body
	// For it to be part of URL, make it a GET request and it will become query parameter
	@RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
	public String printUserGreeting(@RequestParam String firstname,
			@RequestParam String lastname) {
		//return "Form Submitted";
		return "Hello there, " + firstname + " " + lastname;
	}
	
	// PathVariable is part of the URL path
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID: " + id;
	}
	
	
}
