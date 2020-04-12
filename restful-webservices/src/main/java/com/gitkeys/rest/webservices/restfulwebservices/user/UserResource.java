package com.gitkeys.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable Integer id){
		
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}

	@DeleteMapping("/users/{id}")
	public User deleteById(@PathVariable Integer id){
		User user = service.deleteById(id);
		if(user == null)
			 throw new UserNotFoundException("id-"+id);
		return user;
	}

	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = service.save(user);
		
		// generating uri from current url and saved user 
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
