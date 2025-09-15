package com.lld.elevator.model;

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
public abstract class Base
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@CreatedDate
	Date createdDate;

	@LastModifiedDate
	Date modifiedDate;
}
