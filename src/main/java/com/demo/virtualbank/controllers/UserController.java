package com.demo.virtualbank.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.virtualbank.models.User;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping(value = "/getUserDetails/{userId}")
	
	public List<User> getUserDetails(@PathVariable Integer userId) {
		
		User user1 = new User(1, "Supriyo1", new BigDecimal(1000));
		/*User user2 = new User(2, "Supriyo2", new BigDecimal(2000));
		User user3 = new User(3, "Supriyo3", new BigDecimal(3000));
		User user4 = new User(4, "Supriyo4", new BigDecimal(4000));*/
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		
		return userList;

	}

}
