package com.lld.FoodDelivery.repository;

import com.lld.FoodDelivery.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long>
{
}
