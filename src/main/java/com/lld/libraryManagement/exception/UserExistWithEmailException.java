package com.lld.libraryManagement.exception;

public class UserExistWithEmailException extends Exception
{
	public UserExistWithEmailException(String message)
	{
		super(message);
	}
}
