package com.lld.elevator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ElevatorButton extends Button
{
	@ManyToOne
	Elevator elevator;
}
