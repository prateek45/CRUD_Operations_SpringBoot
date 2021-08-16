package com.example.CRUD.User.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController

public class CrudUserManagementApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CrudUserManagementApplication.class, args);
	}


	@GetMapping("/users")
	/***
	 *  To get all the users info
	 */
	public List<UserProfile> getAllUserInfo(){
		return userService.getAllUsers();
	}

	@GetMapping("/users/{name}")
	/***
	 *  To get specific user info
	 */
	public UserProfile getUser(@PathVariable String name){
		return userService.getUser(name);
	}

	@PostMapping(value = "/users")
	/**
	 * Posting details of new user
	 */
	public void addUser(@RequestBody UserProfile user){
		userService.addUser(user);
	}

	@PutMapping(value = "/users/{name}")
	/**
	 * Updating details of User
	 */
	public void updateUser(@RequestBody UserProfile user,
						   @PathVariable String name) {
		userService.updateUser(user,name);
	}

	@DeleteMapping(value = "/users/{name}")
	/**
	 * Deleting details of User
	 */
	public void deleteUser(@PathVariable String name) {
		userService.deleteUser(name);
	}

}
