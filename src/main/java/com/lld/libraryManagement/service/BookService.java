package com.lld.libraryManagement.service;

import com.lld.libraryManagement.exception.UserNeedsToBeAdminOrLibrarianException;
import com.lld.libraryManagement.model.Book;
import com.lld.libraryManagement.model.User;
import com.lld.libraryManagement.model.UserType;
import com.lld.libraryManagement.repository.BookRepository;
import com.lld.libraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService
{

	UserRepository userRepository;
	BookRepository bookRepository;

	@Autowired
	public BookService(UserRepository userRepository, BookRepository bookRepository)
	{
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
	}

	public Optional<Book> saveBook(Book book, User user) throws UserNeedsToBeAdminOrLibrarianException
	{
		if (user.getUserType() != UserType.LIBRARIAN &&
				user.getUserType() != UserType.ADMIN)
		{
			throw new UserNeedsToBeAdminOrLibrarianException("User needs to be admin or librarian to create a book");
		}
		return Optional.of(bookRepository.save(book));
	}
}
