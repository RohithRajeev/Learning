package com.lld.elevator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FloorButton extends Button
{
	@OneToOne
	Floor floor;
}
