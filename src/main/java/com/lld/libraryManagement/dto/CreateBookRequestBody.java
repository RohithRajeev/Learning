package com.lld.libraryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestBody
{
	BookDto dto;
	long userId;
}
