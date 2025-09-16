package com.lld.FoodDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FoodDeliverySystem
{
	public static void main(String[] args)
	{
		SpringApplication.run(FoodDeliverySystem.class, args);
	}
}
