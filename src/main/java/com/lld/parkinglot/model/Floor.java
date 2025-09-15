package com.lld.parkinglot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Floor extends Base
{
	@OneToMany(mappedBy = "floor")
	List<ParkingSlot> parkingSlots;
	@Enumerated(EnumType.STRING)
	FloorStatus status;
	@ManyToOne
	ParkingLot parkingLot;
}
