package com.gitkeys.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;


@RestController // initialize Controller
public class HelloWorldController {
	
	//@RequestMapping(method =RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hw")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hw/{message}")
		public HelloWorldBean hellowoldBean(@PathVariable String message) {
		return (new HelloWorldBean(message));
	}
}
