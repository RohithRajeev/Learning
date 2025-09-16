package com.lld.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Restaurant extends Base
{
	@OneToOne
	Menu menu;

	String details;
	String Location;
}
