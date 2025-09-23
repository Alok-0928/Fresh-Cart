package com.freshcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshcart.entities.User;
import com.freshcart.repository.UserRepository;
import com.freshcart.service.UserService;
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String password) {
		Optional<User> user=userRepository.findByEmail(email);
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			return user.get();
		}
		return null;
	}

}
