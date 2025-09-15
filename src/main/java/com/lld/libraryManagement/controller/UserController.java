package com.lld.libraryManagement.controller;

import com.lld.libraryManagement.dto.UserDto;
import com.lld.libraryManagement.exception.UserExistWithEmailException;
import com.lld.libraryManagement.model.User;
import com.lld.libraryManagement.model.UserType;
import com.lld.libraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class UserController
{

	UserService userService;

	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@PostMapping("/createUser")
	UserDto createUser(@RequestBody UserDto userDto)
	{
		User user = User.builder()
				.name(userDto.getName())
				.userType(getUserTypeFromString(userDto.getUserType()))
				.email(userDto.getEmail())
				.age(userDto.getAge())
				.active(true)
				.build();
		try
		{
			user = userService.createUser(user)
					.orElseThrow();
		}
		catch (UserExistWithEmailException e)
		{
			throw new RuntimeException(e);
		}
		return userDto;
	}

	private UserType getUserTypeFromString(String type)
	{
		return switch (type.toLowerCase())
		{
			case "admin" -> UserType.ADMIN;
			case "member" -> UserType.MEMBER;
			case "librarian" -> UserType.LIBRARIAN;
			default -> throw new IllegalArgumentException("Invalid user type: " + type);
		};
	}
}
