package com.lld.parkinglot.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass

public class Base
{
	@CreatedDate
	Date createdDate;
	@LastModifiedDate
	Date modifiedDate;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
}
