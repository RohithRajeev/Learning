package com.lld.parkinglot.model;

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
public class ParkingLot extends Base
{
	@OneToMany(mappedBy = "parkingLot")
	List<Gate> gates;
	@OneToMany(mappedBy = "parkingLot")
	List<Floor> floors;
	@Enumerated(EnumType.STRING)
	ParkingLotStatus status;
}