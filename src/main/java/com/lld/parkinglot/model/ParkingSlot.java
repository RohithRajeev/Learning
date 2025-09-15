package com.lld.parkinglot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ParkingSlot extends Base
{
	@Enumerated(EnumType.STRING)
	VehicleType vehicleParkingSlotType;
	@Enumerated(EnumType.STRING)
	AllowedFor allowedFor;
	@Enumerated(EnumType.STRING)
	ParkingSlotStatus parkingSlotStatus;
	@ManyToOne
	Floor floor;
	boolean isOccupied;
	String parkingSlotNumber;
}