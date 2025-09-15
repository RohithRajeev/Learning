package com.lld.elevator.model;

import com.lld.parkinglot.model.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Elevator extends Base
{
	int crrFloor;
	int capacity;
	@Enumerated(EnumType.STRING)
	State doorState;
	@Enumerated(EnumType.STRING)
	Direction elevatorDirection;
	@OneToMany(mappedBy = "elevator")
	List<ElevatorButton> buttons;
}
