package com.lld.libraryManagement.dto;

import com.lld.libraryManagement.model.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto
{
	String name;
	String email;
	int age;
	String userType;
}
