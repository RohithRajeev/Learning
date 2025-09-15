package com.lld.libraryManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Base
{
	String name;

	@Column(unique = true, nullable = false)
	String email;
	int age;
	boolean active;

	@Enumerated(EnumType.STRING)
	UserType userType;
}
