package com.lld.parkinglot.controller;

import com.lld.parkinglot.dto.GateRequestDto;
import com.lld.parkinglot.dto.GenerateTicketDto;
import com.lld.parkinglot.dto.TicketResponseDto;
import com.lld.parkinglot.dto.VehicleRequestDto;
import com.lld.parkinglot.dto.VehicleType;
import com.lld.parkinglot.exceptions.GateNotFoundException;
import com.lld.parkinglot.model.Gate;
import com.lld.parkinglot.model.ParkingSlot;
import com.lld.parkinglot.model.Ticket;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.service.AllotParkingSlot;
import com.lld.parkinglot.service.GateService;
import com.lld.parkinglot.service.GenerateTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateTicketController
{

	AllotParkingSlot allotParkingSlot;
	GenerateTicket generateTicket;
	GateService gateService;

	@Autowired
	public GenerateTicketController(GenerateTicket generateTicket, AllotParkingSlot allotParkingSlot, GateService gateService)
	{
		this.generateTicket = generateTicket;
		this.allotParkingSlot = allotParkingSlot;
		this.gateService = gateService;
	}

	@PostMapping("/generateTicket")
	public TicketResponseDto generateTicket(@RequestBody GenerateTicketDto generateTicketDto) throws GateNotFoundException
	{
		VehicleRequestDto vehicleRequestDto = generateTicketDto.getVehicleRequestDto();
		GateRequestDto gateRequestDto = generateTicketDto.getGateRequestDto();

		Vehicle vehicle = Vehicle.builder()
				.vehicleNo(vehicleRequestDto.getVehicleNumber())
				.type(vehicleRequestDto.getVehicleType() == VehicleType.CAR
						? com.lld.parkinglot.model.VehicleType.CAR
						: com.lld.parkinglot.model.VehicleType.BIKE)
				.build();
		Gate gate = gateService.getGateById(gateRequestDto.getGateId())
				.orElseThrow(()->new GateNotFoundException("Gate with the ID doesnt exist."));
		ParkingSlot parkingSlot = allotParkingSlot.allotParkingSlot(vehicle, gate)
				.orElse(null);
		Ticket ticket = generateTicket.generateTicket(vehicle, parkingSlot, gate)
				.orElse(null);

		return TicketResponseDto.builder()
				.ticketId(ticket.getId())
				.parkingSlotNumber(ticket.getParkingSlot()
						.getParkingSlotNumber())
				.vehicleType(ticket.getVehicle()
						.getType() == com.lld.parkinglot.model.VehicleType.CAR ? VehicleType.CAR : VehicleType.BIKE)
				.vehicleNumber(ticket.getVehicle()
						.getVehicleNo())
				.build();
	}
}
