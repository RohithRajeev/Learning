package com.lld.libraryManagement.service;

import com.lld.libraryManagement.exception.UserExistWithEmailException;
import com.lld.libraryManagement.model.User;
import com.lld.libraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public Optional<User> createUser(User user) throws UserExistWithEmailException
	{
		if (userRepository.findByEmail(user.getEmail())
				.isPresent())
		{
			throw new UserExistWithEmailException("User already exist with email: " + user.getEmail());
		}
		return Optional.of(userRepository.save(user));
	}
}
