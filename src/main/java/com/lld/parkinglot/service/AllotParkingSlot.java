package com.lld.parkinglot.service;

import com.lld.parkinglot.model.*;
import com.lld.parkinglot.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllotParkingSlot
{

	ParkingSlotRepository parkingSlotRepository;

	@Autowired
	public AllotParkingSlot(ParkingSlotRepository parkingSlotRepository)
	{
		this.parkingSlotRepository = parkingSlotRepository;
	}

	public Optional<ParkingSlot> allotParkingSlot(Vehicle vehicle, Gate gate)
	{
		ParkingLot parkingLot = gate.getParkingLot();
		List<Floor> floors = parkingLot.getFloors();
		for (Floor floor : floors)
		{
			for (ParkingSlot parkingSlot : floor.getParkingSlots())
			{
				if (!parkingSlot.isOccupied() &&
						parkingSlot.getParkingSlotStatus() == ParkingSlotStatus.OPEN &&
						parkingSlot.getVehicleParkingSlotType() == vehicle.getType())
				{
					parkingSlot.setOccupied(true);
					parkingSlotRepository.save(parkingSlot);
					return Optional.of(parkingSlot);
				}
			}
		}

		return Optional.empty();
	}
}
