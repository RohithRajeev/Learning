package com.lld.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FoodItem extends Base
{
	String ingredients;
	String name;
	String price;

	@Enumerated(EnumType.STRING)
	FoodType foodtype;

	boolean isVegetarian;

	@ManyToOne
	Menu menu;
}
