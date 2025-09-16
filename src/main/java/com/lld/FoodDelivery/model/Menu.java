package com.lld.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Menu extends Base
{
	@OneToMany(mappedBy = "menu")
	List<FoodItem> foodItems;
}
