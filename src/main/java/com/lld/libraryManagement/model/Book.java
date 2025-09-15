package com.lld.libraryManagement.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book extends Base
{
	String name;
	String author;
	String ISBN;
	boolean available;
}
