package com.gitkeys.rest.webservices.restfulwebservices.user;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public static List<User> users = new ArrayList<>();
	static int count = 3;
	
	static {
		users.add(new User(1, "Ashar", new Date()));
		users.add(new User(2, "Afia", new Date()));
		users.add(new User(3, "Eshaan", new Date()));
	}
	
	public User save(User user) {
		if(user.getId()== null) 
			user.setId(++count);
		users.add(user);
		return user;
	}
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId()==id) return user;
			
				
		}
		
		
		return null;
	}
	public User deleteById(Integer id) {
		Iterator<User> itr = users.iterator();
		
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
	
}
