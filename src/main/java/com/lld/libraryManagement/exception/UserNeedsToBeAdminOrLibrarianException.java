package com.lld.libraryManagement.exception;

public class UserNeedsToBeAdminOrLibrarianException extends Exception
{
	public UserNeedsToBeAdminOrLibrarianException(String message)
	{
		super(message);
	}
}
