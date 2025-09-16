package com.lld.FoodDelivery.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	long id;

	@CreatedDate
	@Column(updatable = false, nullable = false)
	LocalDateTime created;

	@LastModifiedDate
	@Column(nullable = false)
	LocalDateTime modified;
}
