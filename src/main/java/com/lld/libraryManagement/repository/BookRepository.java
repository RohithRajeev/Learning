package com.lld.libraryManagement.repository;

import com.lld.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
	public Optional<Book> findByISBN(String ISBN);
}
