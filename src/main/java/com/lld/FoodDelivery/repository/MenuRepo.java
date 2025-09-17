package com.lld.FoodDelivery.repository;

import com.lld.FoodDelivery.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long>
{
}
