package com.demo.virtualbank.dao;

import org.springframework.stereotype.Repository;

import com.demo.virtualbank.models.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{

	@Override
	public User getUserDetailsById() {
		
		return null;
	}

}
