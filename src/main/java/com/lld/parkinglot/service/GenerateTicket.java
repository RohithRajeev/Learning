package com.lld.parkinglot.service;

import com.lld.parkinglot.model.Gate;
import com.lld.parkinglot.model.ParkingSlot;
import com.lld.parkinglot.model.Ticket;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GenerateTicket
{
	TicketRepository ticketRepository;

	@Autowired
	public GenerateTicket(TicketRepository ticketRepository)
	{
		this.ticketRepository = ticketRepository;
	}

	public Optional<Ticket> generateTicket(Vehicle vehicle, ParkingSlot parkingSlot, Gate gate)
	{
		Ticket ticket = Ticket.builder()
				.entryTime(new Date())
				.vehicle(vehicle)
				.parkingSlot(parkingSlot)
				.ticketGeneratedAtGate(gate)
				.build();
		ticketRepository.save(ticket);
		return Optional.of(ticket);
	}
}
